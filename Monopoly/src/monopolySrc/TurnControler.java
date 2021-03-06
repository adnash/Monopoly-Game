package monopolySrc;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TurnControler {



	private JPanel contentPane;

	protected Dice dice = new Dice();	

	private int answer;

	private Board brd;
	private ChestAndChance CandC;

	public TurnControler(Board brd, ChestAndChance CandC){
		this.brd = brd;
		this.CandC = CandC;
	}


	public void playerTurnProcess(Player Curr_Play) {
		//Do once then only repeat for doubles.
		do {
			dice.Roll();
			//Check for 3 doubles. If 3 go to jail and end turn.
			//Think this causes to store doubles to much.
			if (dice.getNumberOfDoublesRolled() == 3) {
				dice.resetDoubles();
				Curr_Play.setCurrentSquare(40);
				return;
			}

			//Yes Probably as a refactor
			int oldSquare = Curr_Play.getCurrentSquare();
			int newSquare = oldSquare + dice.getSum();
			if (newSquare >= 40) {
				Curr_Play.increaseBalance(200);
				newSquare = newSquare%40;
			}

			Curr_Play.setCurrentSquare(newSquare);

			//Returned false so player goes to jail. need to reset double count.
			if(!resolveSquare(Curr_Play, newSquare)) {
				dice.resetDoubles();
				Curr_Play.setCurrentSquare(40);
				return;
			}
		} while(dice.isDouble());
		postTurn(Curr_Play);
	}

	//The turn a player takes if they are in jail
	public void playerJailTurnProcess(Player Curr_Play) {
		//Give option to pay 50 dollars
		if(Curr_Play.getJCard() >0){
			
			if (Curr_Play.getAI()) {
				JOptionPane.showMessageDialog(contentPane, "AI used Get Out of Jail Free Card");
//				System.out.println("AI used Get Out of Jail Free Card");
				Curr_Play.removeJCard();
				Jail jail = (Jail) brd.getSquare(40);
				jail.freePlayer(Curr_Play);
				playerTurnProcess(Curr_Play);
				return;
			}
			
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Play.getName() + ", use 'Get out of jail free' card to get out of jail?", "Get out of jail?", JOptionPane.YES_NO_OPTION);
			switch (answer) {
			case 0:
				Curr_Play.removeJCard();	
				Jail jail = (Jail) brd.getSquare(40);
				jail.freePlayer(Curr_Play);
				playerTurnProcess(Curr_Play);
				return;
			default:	

			}
		}
		if (!Curr_Play.getAI()) {
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Play.getName() + ", pay $50 to get out of jail?", "Get out of jail?", JOptionPane.YES_NO_OPTION);
		}
		
		if (Curr_Play.getAI()) {
			if (Curr_Play.getBalance() >= 50) {
				JOptionPane.showMessageDialog(contentPane, "AI will pay $50 to get out of jail");
//				System.out.println("AI will pay $50 to get out of jail");
				Curr_Play.decreaseBalance(50);
				Jail jail = (Jail) brd.getSquare(40);
				jail.freePlayer(Curr_Play);
				playerTurnProcess(Curr_Play);
				return;
			}else{
				if(Curr_Play.getBalance()<50){
					JOptionPane.showMessageDialog(contentPane, "AI will sell houses and property in order to pay $50 to get out of jail");
//					System.out.println("AI will sell houses and property in order to pay $50 to get out of jail");
					brd.sellSequence(Curr_Play, 50 - Curr_Play.getBalance());
					Curr_Play.decreaseBalance(50);
					Jail jail = (Jail) brd.getSquare(40);
					jail.freePlayer(Curr_Play);
					playerTurnProcess(Curr_Play);
					return;
				}
			}
		}
		
		switch (answer) {
		case 0:	// debit player $50 and call player turn process
			if (Curr_Play.getBalance() >= 50) {
				Curr_Play.decreaseBalance(50);
				Jail jail = (Jail) brd.getSquare(40);
				jail.freePlayer(Curr_Play);
				playerTurnProcess(Curr_Play);
				return;
			}else{
				if(Curr_Play.getBalance()<50){
					brd.sellSequence(Curr_Play, 50 - Curr_Play.getBalance());
					Curr_Play.decreaseBalance(50);
					Jail jail = (Jail) brd.getSquare(40);
					jail.freePlayer(Curr_Play);
					playerTurnProcess(Curr_Play);
					return;
				}
			}
		case 1:	// let player roll for doubles
			JOptionPane.showMessageDialog(contentPane, "You will now roll for doubles");
			dice.Roll();
			if (dice.getNumberOfDoublesRolled() > 0) {
				// Move player by dice amount and end turn
				Jail jail = (Jail) brd.getSquare(40);
				jail.freePlayer(Curr_Play);
				int oldSquare = Curr_Play.getCurrentSquare();
				int newSquare = oldSquare + dice.getSum();
				if (newSquare >= 40) {
					Curr_Play.increaseBalance(200);
					newSquare = (newSquare % 40);
				}
				Curr_Play.setCurrentSquare(newSquare);
				if (!resolveSquare(Curr_Play, newSquare)) {
					dice.resetDoubles();
					Curr_Play.setCurrentSquare(40);
					return;
				}
				postTurn(Curr_Play);
			} else {
				Jail jail = (Jail) brd.getSquare(40);
				jail.reduceJailTurns(Curr_Play);

				if (jail.checkTurnsLeft(Curr_Play) == 0){
					jail.freePlayer(Curr_Play);
					Curr_Play.decreaseBalance(50);

					int oldSquare = Curr_Play.getCurrentSquare();
					int newSquare = oldSquare + dice.getSum();
					if (newSquare >= 40) {
						Curr_Play.increaseBalance(200);
						newSquare = (newSquare % 40);
					}

					Curr_Play.setCurrentSquare(newSquare);
					if (!resolveSquare(Curr_Play, newSquare)) {
						dice.resetDoubles();
						Curr_Play.setCurrentSquare(40);
						return;
					}
					postTurn(Curr_Play);
				} else {
					postTurn(Curr_Play);
				}
			}
		default:	

		}
		//if not third turn end turn.
	}

	public void postTurn(Player Curr_Player){

		String[] array = new String[Curr_Player.getPropertiesOwned().size()];
		Square sq = new Square(1, "blah");

		// Get the names of the squares that the player owns and store them in array for displaying
		for (int i = 0; i < Curr_Player.getPropertiesOwned().size(); i++) {
			sq = brd.getSquare(Curr_Player.getPropertiesOwned().get(i));
			array[i] = sq.getID() + "";			
		}

		if (!Curr_Player.getAI()) {
			PostTurn post = new PostTurn(brd, Curr_Player);
			post.setVisible(true);
		}
	}

	//random change for commit

	//when a player lands on a square this method will resolve all actions.
	//return false if player goes to jail.
	public boolean resolveSquare(Player Curr_Player, int squareID) {
		JOptionPane.showMessageDialog(contentPane, Curr_Player.getName() + " just landed on square \"" + squareID + " " + brd.getSquare(squareID).getName() + "\" by rolling a " + dice.getFace1() + " and a " + dice.getFace2() + " for a total of " + dice.getSum());
		//		System.out.println(Curr_Player.getName() + " just landed on square " + squareID + " by rolling a " + dice.getFace1() + " and a " + dice.getFace2() + " for a total of " + dice.getSum());
		Square Curr_Square = brd.getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Estate =(RealEstate) Curr_Square; 
			if ((Curr_Estate.getOwnerID())!=-1 && (Curr_Estate.getOwnerID()) != Curr_Player.getPlayerID()) {
				brd.payRent_RealEstate(Curr_Estate, Curr_Player);
				return true;
			} else if(Curr_Estate.getOwnerID() == -1){

				//AI Logic will always attempt to buy a property
				if (Curr_Player.getAI()) {
//					System.out.println("Player is AI and will try to buy property");
					if(brd.purchaseProperty(squareID, Curr_Player)){
						return true;
					}else{
						brd.auction(squareID);
						return true;
					}

				} else {
					answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to buy " + Curr_Estate.getName(), "Buy square?", JOptionPane.YES_NO_OPTION);
					switch (answer) {
					case 0:	
						if(brd.purchaseProperty(squareID, Curr_Player)){
							return true;
						}else{
							brd.auction(squareID);
							return true;
						}
					case 1:
						brd.auction(squareID);
						return true;
					default:	
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again");
						return true;
					}
				}
			}else{
				return true;
			}
		} else if (Curr_Square.getID() == 30) {
			Jail jail =(Jail) brd.getSquare(40);
			jail.addPlayer(Curr_Player);
			Curr_Player.setCurrentSquare(40);
			return false;
		} else if (Curr_Square instanceof Tax) {
			Tax tax = (Tax) Curr_Square;
			tax.payTax(Curr_Player);
			return true;
		} else if (Curr_Square instanceof RailroadsAndUtilities) {
			RailroadsAndUtilities Curr_RU =(RailroadsAndUtilities) Curr_Square; 
			if ((Curr_RU.getOwnerID())!=-1 && (Curr_RU.getOwnerID()) != Curr_Player.getPlayerID()) {
				brd.payRent_Utilities_RailRoads(Curr_RU, Curr_Player, dice.getSum());
				return true;
			} else if(Curr_RU.getOwnerID() == -1){

				//AI logic will always attempt to buy a utility
				if (Curr_Player.getAI()) {
//					System.out.println("Player is AI and will try to buy utility");
					if(brd.purchaseProperty(squareID, Curr_Player)){
						brd.update();
						return true;
					}else{
						brd.auction(squareID);
						brd.update();
						return true;
					}

				} else {

					answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to buy " + Curr_RU.getName(), "Buy?", JOptionPane.YES_NO_OPTION);
					switch (answer) {
					case 0:	
						if(brd.purchaseProperty(squareID, Curr_Player)){
							return true;
						}else{
							brd.auction(squareID);
							return true;
						}
					case 1:
						brd.auction(squareID);
						return true;
					default:	
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again");
						return true;
					}
				}
			}else{
				return true;
			}
		}else if(squareID == 2 || squareID == 17 || squareID == 33 || squareID == 7 || squareID == 22 || squareID == 36 ){
			CandC.draw(Curr_Player, squareID);
			return true;
		} else {
			return true;
		}
	}



}
