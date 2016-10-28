package monopolySrc;
// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Board.java

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board {

	// Global variables
	private Square[] squares = new Square[41];
	private Player[] players;
	protected Dice dice = new Dice();	
	private int numPlayers;
	private JPanel contentPane;
	
	private int answer;
	
	private int duration;
	private static Timer timer = new Timer();
	private static boolean timeUp = false;

	// Board constructor called once and only once by Monopoly class to initialize certain variables and objects
	public Board(String[] playerNames, String[] playericons, int duration) {
		this.duration = duration;
		numPlayers = playerNames.length;
		// Initialize each player
		players = new Player[numPlayers];
		for (int i=0; i<numPlayers; i++) {
			players[i] = new Player(i, playerNames[i], playericons[i]);
		}

		setupBoard();
	}


	// TODO Do we even need this in its own method? These are hard-coded anyways and could belong in the global space. Just thinking out loud.
	// Setting up squares
	private void setupBoard() {
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				timeUp = true;
				
			}
		}, duration*60*1000);
		
		Square go = new Square(0, "Go");
		squares[0] = go;
		RealEstate Mediterranean_Avenue = new RealEstate(1, "Mediterranean Avenue", 60, 50, new int [] {2,4,10,30,90,160,250}, new int [] {1,3});
		squares[1] = Mediterranean_Avenue;
		Square commChest1 = new Square(2, "Community Chest");
		squares[2] = commChest1;
		RealEstate Baltic_Avenue = new RealEstate(3, "Baltic Avenue", 60, 50, new int [] {4,8,20,60,180,320,450}, new int [] {1,3});
		squares[3] = Baltic_Avenue;
		Tax Income_Tax = new Tax(4, "Income Tax");
		squares[4] = Income_Tax;
		RailroadsAndUtilities Reading_Railroad = new RailroadsAndUtilities(5, "Reading Railroad", 200);
		squares[5] = Reading_Railroad;
		RealEstate Oriental_Avenue = new RealEstate(6, "Oriental Avenue", 100, 50, new int [] {6,12,30,90,270,400,550}, new int [] {6,8,9});
		squares[6] = Oriental_Avenue;
		Square chance1 = new Square(7, "Chance");
		squares[7] = chance1;
		RealEstate Vermont_Avenue = new RealEstate(8, "Vermont Avenue", 100, 50, new int [] {6,12,30,90,270,400,550}, new int [] {6,8,9});
		squares[8] = Vermont_Avenue;
		RealEstate Connecticut_Avenue = new RealEstate(9, "Connecticut Avenue", 120, 50, new int [] {8,16,40,100,300,450,600}, new int [] {6,8,9});
		squares[9] = Connecticut_Avenue;
		Square Just_Visiting = new Square(10, "Just Visiting");
		squares[10] = Just_Visiting;
		RealEstate St_Charles_Place = new RealEstate(11, "St. Charles Place", 140, 100, new int [] {10,20,50,150,450,625,750}, new int [] {11,13,14});
		squares[11] = St_Charles_Place;
		RailroadsAndUtilities Electric_Company = new RailroadsAndUtilities(12, "Electric Company", 150);
		squares[12] = Electric_Company;
		RealEstate States_Avenue = new RealEstate(13, "States Avenue", 140, 100, new int [] {10,20,50,150,450,625,750}, new int [] {11,13,14});
		squares[13] = States_Avenue;
		RealEstate Virginia_Avenue = new RealEstate(14, "Virginia Avenue", 160, 100, new int [] {12,24,60,180,500,700,900}, new int [] {11,13,14});
		squares[14] = Virginia_Avenue;
		RailroadsAndUtilities Pennsylvania_Railroad = new RailroadsAndUtilities(15, "Pennsylvania Railroad", 200);
		squares[15] = Pennsylvania_Railroad;
		RealEstate St_James_Place = new RealEstate(16, "St. James Place", 180, 100, new int [] {14,28,70,200,550,750,950}, new int [] {16,18,19});
		squares[16] = St_James_Place;
		Square commChest2 = new Square(17, "Community Chest");
		squares[17] = commChest2;
		RealEstate Tennessee_Avenue = new RealEstate(18, "Tennessee Avenue", 180, 100, new int [] {14,28,70,200,550,750,950}, new int [] {16,18,19});
		squares[18] = Tennessee_Avenue;
		RealEstate New_York_Avenue = new RealEstate(19, "New York Avenue", 200, 100, new int [] {16,32,80,220,600,800,1000}, new int [] {16,18,19});
		squares[19] = New_York_Avenue;
		Square freePark = new Square(20, "Free Parking");
		squares[20] = freePark;
		RealEstate Kentucky_Avenue = new RealEstate(21, "Kentucky Avenue", 220, 150, new int [] {18,36,90,250,700,875,1050}, new int [] {21,23,24});
		squares[21] = Kentucky_Avenue;
		Square chance2 = new Square(22, "Chance");
		squares[22] = chance2;
		RealEstate Indiana_Avenue = new RealEstate(23, "Indiana Avenue", 220, 150, new int [] {18,36,90,250,700,875,1050}, new int [] {21,23,24});
		squares[23] = Indiana_Avenue;
		RealEstate Illinois_Avenue = new RealEstate(24, "Illinois Avenue", 240, 150, new int [] {20,40,100,300,750,925,1100}, new int [] {21,23,24});
		squares[24] = Illinois_Avenue;
		RailroadsAndUtilities B_O_Railroad = new RailroadsAndUtilities(25, "B. & O. Railroad", 200);
		squares[25] = B_O_Railroad;
		RealEstate Atlantic_Avenue = new RealEstate(26, "Atlantic Avenue", 260, 150, new int [] {22,44,110,330,800,975,1150}, new int [] {26,27,29});
		squares[26] = Atlantic_Avenue;
		RealEstate Ventnor_Avenue = new RealEstate(27, "Ventnor Avenue", 260, 150, new int [] {22,44,110,330,800,975,1150}, new int [] {26,27,29});
		squares[27] = Ventnor_Avenue;
		RailroadsAndUtilities Water_Works = new RailroadsAndUtilities(28, "Water Works", 150);
		squares[28] = Water_Works;
		RealEstate Marvin_Gardens = new RealEstate(29, "Marvin Gardens", 280, 150, new int [] {24,48,120,360,850,1025,1200}, new int [] {26,27,29});
		squares[29] = Marvin_Gardens;
		Square goToJail = new Square(30, "Go To Jail");
		squares[30] = goToJail;
		RealEstate Pacific_Avenue = new RealEstate(31, "Pacific Avenue", 300, 200, new int [] {26,52,130,390,900,1100,1275}, new int [] {31,32,34});
		squares[31] = Pacific_Avenue;
		RealEstate North_Carolina_Avenue = new RealEstate(32, "North Carolina Avenue", 300, 200, new int [] {26,52,130,390,900,1100,1275}, new int [] {31,32,34});
		squares[32] = North_Carolina_Avenue;
		Square commChest3 = new Square(33, "Community Chest");
		squares[33] = commChest3;
		RealEstate Pennsylvania_Avenue = new RealEstate(34, "Pennsylvania Avenue", 320, 200, new int [] {28,56,150,450,1000,1200,1400}, new int [] {31,32,34});
		squares[34] = Pennsylvania_Avenue;
		RailroadsAndUtilities Short_Line = new RailroadsAndUtilities(35, "Short Line", 200);
		squares[35] = Short_Line;
		Square chance3 = new Square(36, "Chance");
		squares[36] = chance3;
		RealEstate Park_Place = new RealEstate(37, "Park Place", 350, 200, new int [] {35,70,175,500,1100,1300,1500}, new int [] {37,39});
		squares[37] = Park_Place;
		Tax Luxury_Tax = new Tax(38, "Luxury Tax");
		squares[38] = Luxury_Tax;
		RealEstate Boardwalk = new RealEstate(39, "Boardwalk", 400, 200, new int [] {50,100,200,600,1400,1700,2000}, new int [] {37,39});
		squares[39] = Boardwalk;
		Jail jail = new Jail(40, "Jail");
		squares[40] = jail;

		// TODO Start game timer here?
	}


	public Square getSquare(int squareID) {
		return squares[squareID];
	}

	// Iterate through players for turns. After Each Player check timer.
	public void gamePlay(int player_turn) {
		Jail jail = (Jail) getSquare(40);
		if (getTimeUp()) {
			determineWinner();
		}
		if (jail.isPlayerJailed(players[player_turn])) {
			playerJailTurnProcess(players[player_turn]);
		} else {
			playerTurnProcess(players[player_turn]);
		}
	}

	//This turn process will be for non Jailed players. Jailed players have a different process. 
	private void playerTurnProcess(Player Curr_Play) {
		//Do once then only repeat for doubles.
		do {
			dice.Roll();
			//Check for 3 doubles. If 3 go to jail and end turn.
			//TODO We will want to keep track of doubles in Player objects, and reset after every turn
			//Think this causes to store doubles to much.
			if (dice.getNumberOfDoublesRolled() == 3) {
				dice.resetDoubles();
				Curr_Play.setCurrentSquare(40);
				return;
			}

			//TODO We should move this to a helper method called "calculateMove" since we need this logic for rolling doubles in Jail too
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
			postTurn(Curr_Play);
		} while(dice.isDouble());
	}

	//The turn a player takes if they are in jail
	private void playerJailTurnProcess(Player Curr_Play) {
		//Give option to pay 50 dollars
		//TODO This is currently implemented using the console and system IO. We will need to implement it using the JFrame window later
		answer = JOptionPane.showConfirmDialog(contentPane,Curr_Play.getName() + ", pay $50 to get out of jail?", "Get out of jail?", JOptionPane.YES_NO_OPTION);
		switch (answer) {
		case 0:	// debit player $50 and call player turn process
			if (Curr_Play.getBalance() >= 50) {
				Curr_Play.decreaseBalance(50);
				Jail jail = (Jail) getSquare(40);
				jail.freePlayer(Curr_Play);
				playerTurnProcess(Curr_Play);
			}else{
				if(Curr_Play.getBalance()<50){
					sellSequence(Curr_Play, 50 - Curr_Play.getBalance());
					Curr_Play.decreaseBalance(50);
					Jail jail = (Jail) getSquare(40);
					jail.freePlayer(Curr_Play);
					playerTurnProcess(Curr_Play);
				}
			}
		case 1:	// let player roll for doubles
			JOptionPane.showMessageDialog(contentPane, "You will now roll for doubles");
			dice.Roll();
			if (dice.getNumberOfDoublesRolled() > 0) {
				// Move player by dice amount and end turn
				Jail jail = (Jail) getSquare(40);
				jail.freePlayer(Curr_Play);
				playerTurnProcess(Curr_Play);
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
			} else {
				Jail jail = (Jail) getSquare(40);
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
	
	private void postTurn(Player Curr_Player){
		
		String[] array = new String[Curr_Player.getPropertiesOwned().size()];
		Square sq = new Square(1, "blah");

		
		for (int i = 0; i < Curr_Player.getPropertiesOwned().size(); i++) {
			sq = getSquare(Curr_Player.getPropertiesOwned().get(i));
			array[i] = sq.getID() + "";			
		}
		boolean looper = true;
		
		while(looper){
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to buy any houses?", "Buy houses?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to buy a house.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString());
					if(answer != -1)
						buyHouse(answer, Curr_Player);
					else
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
				}
			}else{
				looper = false;
			}
		}
		
		looper = true;
		while(looper){
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to sell any houses?", "Sell houses?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to sell a house.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString());
					if(answer != -1)
						sellHouse(answer, Curr_Player);
					else
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
				}
			}else{
				looper = false;
			}
		}
		
		looper = true;
		while(looper){
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to mortgage any Properties?", "Mortgage properties?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to mortgage.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString());
					if(answer != -1)
						mortgageProperty(answer, Curr_Player);
					else
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
				}
			}else{
				looper = false;
			}
		}
		
		looper = true;
		while(looper){
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to unmortgage any Properties?", "Unmortgage properties?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to unmortgage.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString());
					if(answer != -1)
						unmortgageProperty(answer, Curr_Player);
					else
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
				}
			}else{
				looper = false;
			}
		}
		
		looper = true;
		while(looper){
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to Trade/Sell any Properties?", "Trade properties?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				trade(Curr_Player);
			}else{
				looper = false;
			}
		}
		
	}

	//random change for commit

	//when a player lands on a square this method will resolve all actions.
	//return false if player goes to jail.
	private boolean resolveSquare(Player Curr_Player, int squareID) {
		JOptionPane.showMessageDialog(contentPane, Curr_Player.getName() + " just landed on square " + squareID + " by rolling a " + dice.getFace1() + " and a " + dice.getFace2() + " for a total of " + dice.getSum());
//		System.out.println(Curr_Player.getName() + " just landed on square " + squareID + " by rolling a " + dice.getFace1() + " and a " + dice.getFace2() + " for a total of " + dice.getSum());
		Square Curr_Square = getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Estate =(RealEstate) Curr_Square; 
			if ((Curr_Estate.getOwnerID())!=-1 && (Curr_Estate.getOwnerID()) != Curr_Player.getPlayerID()) {
				payRent_RealEstate(Curr_Estate, Curr_Player);
				return true;
			} else if(Curr_Estate.getOwnerID() == -1){
				answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to buy " + Curr_Estate.getName(), "Buy square?", JOptionPane.YES_NO_OPTION);
				switch (answer) {
				case 0:	
					if(purchaseProperty(squareID, Curr_Player)){
						return true;
					}else{
						auction(squareID);
						return true;
					}
				case 1:
					auction(squareID);
					return true;
				default:	
					JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again");
					return true;
				}
			}else{
				return true;
			}
		} else if (Curr_Square.getID() == 30) {
			Jail jail =(Jail) getSquare(40);
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
				payRent_Utilities_RailRoads(Curr_RU, Curr_Player);
				return true;
			} else if(Curr_RU.getOwnerID() == -1){
				answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to buy " + Curr_RU.getName(), "Buy?", JOptionPane.YES_NO_OPTION);
				switch (answer) {
				case 0:	
					if(purchaseProperty(squareID, Curr_Player)){
						return true;
					}else{
						auction(squareID);
						return true;
					}
				case 1:
					auction(squareID);
					return true;
				default:	
					JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again");
					return true;
				}
			}else{
				return true;
			}
		} else {
			return true;
		}
	}


	private boolean mortgageProperty(int squareID, Player Curr_Player) {
		Square Curr_Square = getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Estate =(RealEstate) Curr_Square; 
			if(Curr_Estate.mortgage(Curr_Player)){
				JOptionPane.showMessageDialog(contentPane, "Mortgage succesful on "+ Curr_Estate.getName());
				return true;
			}else{
				JOptionPane.showMessageDialog(contentPane, "Mortgage unsuccesful on "+ Curr_Estate.getName());
				return false;
			}

		}else if (Curr_Square instanceof RailroadsAndUtilities) {
			RailroadsAndUtilities Curr_RU =(RailroadsAndUtilities) Curr_Square;
			if(Curr_RU.mortgage(Curr_Player)){
				JOptionPane.showMessageDialog(contentPane, "Mortgage succesful on "+ Curr_RU.getName());
				return true;
			}else{
				JOptionPane.showMessageDialog(contentPane, "Mortgage unsuccesful on "+ Curr_RU.getName());
				return false;
			}
		}else{
			JOptionPane.showMessageDialog(contentPane, "Not a mortgageable property");
			return false;
		}
	}

	private void unmortgageProperty(int squareID, Player Curr_Player) {
		Square Curr_Square = getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Estate =(RealEstate) Curr_Square; 
			if(Curr_Estate.unMortgage(Curr_Player)){
				JOptionPane.showMessageDialog(contentPane, "Unmortgage succesful on "+ Curr_Estate.getName());
			}else{
				JOptionPane.showMessageDialog(contentPane, "Unmortgage unsuccesful on "+ Curr_Estate.getName());
			}

		}else if (Curr_Square instanceof RailroadsAndUtilities) {
			RailroadsAndUtilities Curr_RU =(RailroadsAndUtilities) Curr_Square;
			if(Curr_RU.unmortgage(Curr_Player)){
				JOptionPane.showMessageDialog(contentPane, "Unortgage succesful on "+ Curr_RU.getName());
			}else{
				JOptionPane.showMessageDialog(contentPane, "Unmortgage unsuccesful on "+ Curr_RU.getName());
			}
		}else{
			JOptionPane.showMessageDialog(contentPane, "Not a mortgageable property");
		}
	}

	private int findMatchingOwners(int original, int owner2, int owner3, int owner4){
		int count = 1;
		if(original == owner2)
			count++;
		if(original == owner3)
			count++;
		if(original == owner4)
			count++;
		return count;
	}

	//0 is false //1 is true for real estate. otherwise int is number owned for railroads or utilities.
	private int isMonopoly(int squareID) {
		Square Curr_Square = getSquare(squareID);
		if(Curr_Square instanceof RailroadsAndUtilities){
			if(squareID == 12 || squareID == 28){
				RailroadsAndUtilities elec =(RailroadsAndUtilities) getSquare(12);
				RailroadsAndUtilities water =(RailroadsAndUtilities) getSquare(28);
				if(water.getOwnerID() == elec.getOwnerID()){
					return 2;
				}else{
					return 1;
				}
			}else{
				RailroadsAndUtilities rail1 =(RailroadsAndUtilities) getSquare(5);
				RailroadsAndUtilities rail2 =(RailroadsAndUtilities) getSquare(15);
				RailroadsAndUtilities rail3 =(RailroadsAndUtilities) getSquare(25);
				RailroadsAndUtilities rail4 =(RailroadsAndUtilities) getSquare(35);

				switch(squareID){
				case 5:
					return findMatchingOwners(rail1.getOwnerID(),rail2.getOwnerID(),rail3.getOwnerID(),rail4.getOwnerID());
				case 15:
					return findMatchingOwners(rail2.getOwnerID(),rail1.getOwnerID(),rail3.getOwnerID(),rail4.getOwnerID());
				case 25:
					return findMatchingOwners(rail3.getOwnerID(),rail1.getOwnerID(),rail2.getOwnerID(),rail4.getOwnerID());
				case 35:
					return findMatchingOwners(rail4.getOwnerID(),rail1.getOwnerID(),rail2.getOwnerID(),rail3.getOwnerID());
				default:
					return 0;
				}
			}
		}else if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Estate =(RealEstate) Curr_Square; 
			int  monop[] = Curr_Estate.getMonopoly();
			if (monop.length == 2){
				RealEstate prop1 =(RealEstate) getSquare(monop[0]);
				RealEstate prop2 =(RealEstate) getSquare(monop[1]);
				if (prop1.getOwnerID() == prop2.getOwnerID()) {
					return 1;
				} else {
					return 0;
				}
			} else {
				RealEstate prop1 =(RealEstate) getSquare(monop[0]);
				RealEstate prop2 =(RealEstate) getSquare(monop[1]);
				RealEstate prop3 =(RealEstate) getSquare(monop[2]);
				if (prop1.getOwnerID() == prop2.getOwnerID() && prop2.getOwnerID() == prop3.getOwnerID()) {
					return 1;
				} else {
					return 0;
				}
			}
		} else {return 0;}
	}

	private boolean sellHouse(int squareID, Player Curr_Play) {
		Square Curr_Square = getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Prop =(RealEstate) Curr_Square; 

			if (Curr_Prop.getOwnerID() == Curr_Play.getPlayerID()) {
				int  monop[] = Curr_Prop.getMonopoly();
				if (monop.length == 2){
					RealEstate prop1 =(RealEstate) getSquare(monop[0]);
					RealEstate prop2 =(RealEstate) getSquare(monop[1]);
					if (prop1.getID() == Curr_Prop.getID()) {
						if (prop2.getNumBuildings()<=Curr_Prop.getNumBuildings() && Curr_Prop.getNumBuildings()>0) {
							Curr_Prop.sell(Curr_Play);
							return true;
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must sell from " + prop2.getName() + " first");
							return false;
						}
					} else {
						if (prop1.getNumBuildings()<=Curr_Prop.getNumBuildings()) {
							if (Curr_Prop.getNumBuildings()>0) {
								Curr_Prop.sell(Curr_Play);
								return true;
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't sell");
								return false;
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must sell on " + prop1.getName() + " first");
							return false;
						}
					}
				} else {
					RealEstate prop1 =(RealEstate) getSquare(monop[0]);
					RealEstate prop2 =(RealEstate) getSquare(monop[1]);
					RealEstate prop3 =(RealEstate) getSquare(monop[2]);
					if (prop1.getID() == Curr_Prop.getID()) {
						if (prop2.getNumBuildings()<=Curr_Prop.getNumBuildings() && prop3.getNumBuildings()>=Curr_Prop.getNumBuildings()) {
							if (Curr_Prop.getNumBuildings()>0){
								Curr_Prop.sell(Curr_Play);
								return true;
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't sell");
								return false;
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must sell on other properties first.");
							return false;
						}
					} else if (prop2.getID() == Curr_Prop.getID()) {
						if (prop1.getNumBuildings()<=Curr_Prop.getNumBuildings() && prop3.getNumBuildings()>=Curr_Prop.getNumBuildings()) {
							if (Curr_Prop.getNumBuildings()>0) {
								Curr_Prop.sell(Curr_Play);
								return true;
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't sell");
								return false;
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must sell on other properties first");
							return false;
						}
					} else {
						if (prop1.getNumBuildings()<=Curr_Prop.getNumBuildings() && prop2.getNumBuildings()>=Curr_Prop.getNumBuildings()) {
							if (Curr_Prop.getNumBuildings()>0) {
								Curr_Prop.sell(Curr_Play);
								return true;
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't sell");
								return false;
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must sell on other properties first");
							return false;
						}
					}
				}
			}
			return false;
		}
		return false;
	}

	private void buyHouse(int squareID, Player Curr_Play) {
		Square Curr_Square = getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Prop =(RealEstate) Curr_Square; 

			if (isMonopoly(Curr_Prop.getID()) == 1 && Curr_Prop.getOwnerID() == Curr_Play.getPlayerID()) {
				int  monop[] = Curr_Prop.getMonopoly();
				if (monop.length == 2){
					RealEstate prop1 =(RealEstate) getSquare(monop[0]);
					RealEstate prop2 =(RealEstate) getSquare(monop[1]);
					if (prop1.getID() == Curr_Prop.getID()){
						if (prop2.getNumBuildings()>=Curr_Prop.getNumBuildings()){
							if (Curr_Prop.getBuildingPrice() <= Curr_Play.getBalance() && Curr_Prop.getNumBuildings()<5){
								Curr_Prop.build(Curr_Play);
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't build");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must build on " + prop2.getName() + " first");
						}
					} else {
						if (prop1.getNumBuildings()>=Curr_Prop.getNumBuildings()){
							if (Curr_Prop.getBuildingPrice() <= Curr_Play.getBalance() && Curr_Prop.getNumBuildings()<5) {
								Curr_Prop.build(Curr_Play);
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't build");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must build on " + prop1.getName() + " first");
						}
					}
				} else {
					RealEstate prop1 =(RealEstate) getSquare(monop[0]);
					RealEstate prop2 =(RealEstate) getSquare(monop[1]);
					RealEstate prop3 =(RealEstate) getSquare(monop[2]);
					if (prop1.getID() == Curr_Prop.getID()) {
						if (prop2.getNumBuildings()>=Curr_Prop.getNumBuildings() && prop3.getNumBuildings()>=Curr_Prop.getNumBuildings()) {
							if (Curr_Prop.getBuildingPrice() <= Curr_Play.getBalance() && Curr_Prop.getNumBuildings()<5) {
								Curr_Prop.build(Curr_Play);
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't build");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must build on other properties first");
						}
					} else if (prop2.getID() == Curr_Prop.getID()) {
						if (prop1.getNumBuildings()>=Curr_Prop.getNumBuildings() && prop3.getNumBuildings()>=Curr_Prop.getNumBuildings()) {
							if (Curr_Prop.getBuildingPrice() <= Curr_Play.getBalance() && Curr_Prop.getNumBuildings()<5) {
								Curr_Prop.build(Curr_Play);
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't build");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must build on other properties first");
						}
					} else {
						if (prop1.getNumBuildings()>=Curr_Prop.getNumBuildings() && prop2.getNumBuildings()>=Curr_Prop.getNumBuildings()) {
							if(Curr_Prop.getBuildingPrice() <= Curr_Play.getBalance() && Curr_Prop.getNumBuildings()<5) {
								Curr_Prop.build(Curr_Play);
							} else {
								JOptionPane.showMessageDialog(contentPane, "Can't build");
							}
						} else {
							JOptionPane.showMessageDialog(contentPane, "Must build on other properties first");
						}
					}
				}
			}
		}
	}

	//TODO - if player trys to buy but can't afford need to relay information back and go to an auction.
	private boolean purchaseProperty(int squareID, Player Curr_Player) {
		Square Curr_Square = getSquare(squareID);
		if (Curr_Square instanceof RealEstate) {
			RealEstate Curr_Estate =(RealEstate) Curr_Square;
			if (Curr_Player.getBalance()>=Curr_Estate.getBuyPrice()) {
				Curr_Player.decreaseBalance(Curr_Estate.getBuyPrice());
				Curr_Estate.setOwnerID(Curr_Player.getPlayerID());
				Curr_Player.addProperty(squareID);
				return true;
			} else {
				JOptionPane.showMessageDialog(contentPane, "Can't afford " + Curr_Estate.getName());
				return false;
			}
		} else if (Curr_Square instanceof RailroadsAndUtilities) {
			RailroadsAndUtilities Curr_Rail_Utility =(RailroadsAndUtilities) Curr_Square;
			if (Curr_Player.getBalance()>=Curr_Rail_Utility.getPrice()) {
				Curr_Player.decreaseBalance(Curr_Rail_Utility.getPrice());
				Curr_Rail_Utility.setOwnerID(Curr_Player.getPlayerID());
				Curr_Player.addProperty(squareID);
				return true;
			} else {
				JOptionPane.showMessageDialog(contentPane, "Can't afford " + Curr_Rail_Utility.getName());
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(contentPane, "Not an ownable Square");
			return true;
		}
	}

	private void payRent_RealEstate(RealEstate Curr_Estate, Player Curr_Player) {
		//TODO check if it makes them go negative
		int rent = Curr_Estate.calcRent(isMonopoly(Curr_Estate.getID()) == 1);
		if(Curr_Player.getBalance()<rent){
			sellSequence(Curr_Player, rent - Curr_Player.getBalance());
		}
		players[(Curr_Estate.getOwnerID())].increaseBalance(rent);
		Curr_Player.decreaseBalance(rent);
	}

	private void payRent_Utilities_RailRoads(RailroadsAndUtilities Curr_Property, Player Curr_Player) {
		//TODO check if it makes them go negative
		int rent = Curr_Property.calculateRent(isMonopoly(Curr_Property.getID()), dice.getSum());
		//Makes sure the player gets enough money to pay rent.
		if(Curr_Player.getBalance()<rent){
			sellSequence(Curr_Player, rent - Curr_Player.getBalance());
		}
		players[(Curr_Property.getOwnerID())].increaseBalance(rent);
		Curr_Player.decreaseBalance(rent);
	}

	//This is called when a player doesn't have enough money to pay rent or jail escape and is forced to sell then must pay rent or jail fee
	private void sellSequence(Player Curr_Player, int negativeAmount){
		
		String[] array = new String[Curr_Player.getPropertiesOwned().size()];
		Square sq = new Square(1, "blah");

		
		for (int i = 0; i < Curr_Player.getPropertiesOwned().size(); i++) {
			sq = getSquare(Curr_Player.getPropertiesOwned().get(i));
			array[i] = sq.getID() + "";			
		}
		
		int amountSold = 0;
		RealEstate test = (RealEstate) getSquare(1);

		//TODO Need to determine what property the player is talking about. Just using test prop for now.
		int count = 0;
		while(amountSold<negativeAmount){
			if(count > 10)
				return;
			count++;
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to sell any houses?", "Sell houses?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to sell a house.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString());
					if(answer != -1){
						sellHouse(answer, Curr_Player);
						amountSold += test.getBuildingPrice()/2;
					}else{
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
					}
				}
			}
			
			answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to mortgage any Properties?", "Mortgage properties?", JOptionPane.YES_NO_OPTION);
			if(answer == 0){
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to mortgage.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString());
					if(answer != -1){
						mortgageProperty(answer, Curr_Player);
						amountSold += test.getMortgagePrice();
					}else{
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
					}
				}
			}
		}
	}



	private void auction(int squareID) {
		Square Curr_Square = getSquare(squareID);
		ArrayList<Player> temp = new ArrayList<Player>();
		ArrayList<Player> loop = new ArrayList<Player>();

		for (int i = 0; i < players.length; i++) {
			temp.add(players[i]);
		}

		loop = temp;
		Player winner = null;
		int currentBid = 0;
		int tempBid = 0;
		//When there is only one player left in the list, they are the winner
		while(loop.size() > 1) {
			//Ask each player if they want to bid, and for how much
			for(int i = 0; i < loop.size(); i++){
				answer = JOptionPane.showConfirmDialog(contentPane,loop.get(i).getName() + ", would you like to place a bid on " + Curr_Square.getName() + "?", "Place bid?", JOptionPane.YES_NO_OPTION);
				switch (answer) {
				case 0:
					tempBid = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "Enter an amount to bid. You have $" + loop.get(i).getBalance() + "\n" + "The current bid is $" + currentBid, "amount"));
					if (tempBid > loop.get(i).getBalance()) {
						JOptionPane.showMessageDialog(contentPane,loop.get(i).getName() + ", you don't have enough money!You have been removed from the bidding.");
						temp.remove(loop.get(i));
					}
					else if (tempBid <= currentBid) {
						JOptionPane.showMessageDialog(contentPane,loop.get(i).getName() + ", too bad! Your bid is too low.\nYou have been removed from the bidding.");
						temp.remove(loop.get(i));
					}
					else {
						currentBid = tempBid;
						winner = loop.get(i);
					}
					break;
				case 1:
				default:
					JOptionPane.showMessageDialog(contentPane,loop.get(i).getName() + ", you have been removed from the bidding");
					temp.remove(loop.get(i));
				}
			}
			loop = temp;
		}
		//Auction ends
		if (winner == null) {
			JOptionPane.showMessageDialog(contentPane, "Nobody bought the property");
		}else {
			JOptionPane.showMessageDialog(contentPane, winner.getName() + " is the winner of the auction!");
			//Gets type of square
			//Affordability is calculated in the auction
			if (Curr_Square instanceof RealEstate) {
				RealEstate Final_Square =(RealEstate) Curr_Square;
				winner.decreaseBalance(Final_Square.getBuyPrice());
				Final_Square.setOwnerID(winner.getPlayerID());
			} else {
				RailroadsAndUtilities Final_Square = (RailroadsAndUtilities) Curr_Square;
				winner.decreaseBalance(Final_Square.getPrice());
				Final_Square.setOwnerID(winner.getPlayerID());
			}
			winner.addProperty(Curr_Square.getID());
		}
	}

	public void trade(Player p){
		//Player has no properties to sell.
		if (p.getPropertiesOwned().size() == 0) {
			JOptionPane.showMessageDialog(contentPane, "You have no peoperties to sell");
			return;
		}

		//Player has properties to sell.
		System.out.println("You own:");
		Square sq = new Square(1, "blah");
		
		String[] array = new String[p.getPropertiesOwned().size()];

		for (int i = 0; i < p.getPropertiesOwned().size(); i++) {
			sq = getSquare(p.getPropertiesOwned().get(i));
			array[i] = sq.getID() + "";			
		}
		Object answerString = JOptionPane.showInputDialog(contentPane, p.getName() + ", you own these properties.\nSelect a property to trade.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
		if(answerString == null)
			return;
		int property = Integer.parseInt(answerString.toString());
		
		int sq_ID = sq.getID();
		if(sq_ID != 5 && sq_ID != 12 && sq_ID != 15 && sq_ID != 25 && sq_ID != 28 && sq_ID != 35){
			RealEstate re = (RealEstate) getSquare(sq_ID);
			if(re.getNumBuildings() != 0){
				answerString = JOptionPane.showInputDialog(contentPane, "You suck and can't sell this.");

				System.out.println("You suck and can't sell this.");
			}
		}

				//The player entered a property to sell
		if (p.getPropertiesOwned().contains(property)) {
			sq = getSquare(property);

			ArrayList<String> playErs = new ArrayList<String>();
			Player target = new Player(777, "blah", "Cat");
			for (int i = 0; i < players.length; i++) {
				target = players[i];
				//Make sure you're only selling to other players
				if (target.getPlayerID() != p.getPlayerID()) {
					playErs.add(target.getPlayerID() + "");
				}
			}
			answerString = JOptionPane.showInputDialog(contentPane, p.getName() + ", Select the other player number you would like to sell it to:", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, playErs.toArray(), null);
			if(answerString == null)
				return;
			int otherPlayer = Integer.parseInt(answerString.toString());
			
			answerString = JOptionPane.showInputDialog(contentPane, p.getName() + ", enter the amount you wish to sell the property for");
			if(answerString == null)
				return;
			int price = Integer.parseInt(answerString.toString());
			Player temp;
			//Get the other player
			for (int i = 0; i < players.length; i++) {
				temp = players[i];
				if (otherPlayer == temp.getPlayerID()) {
					target = temp;
				}
			}
			//See if the other player agrees to the trade
			answer = JOptionPane.showConfirmDialog(contentPane,target.getName() + ", would you like to buy " + sq.getName() + " for " + price + "?", "Agree to trade?", JOptionPane.YES_NO_OPTION);
			switch (answer) {
			case 0:
				JOptionPane.showMessageDialog(contentPane, "The trade has been accepted!");
				if (target.getBalance() <= price) {
					JOptionPane.showMessageDialog(contentPane, "But " + target.getName() + " does not have enough money...");
					return;
				}
				target.decreaseBalance(price);
				p.increaseBalance(price);
				p.removeProperty(sq.getID());
				target.addProperty(sq.getID());
				sq_ID = sq.getID();
				if(sq_ID == 5 || sq_ID == 12 || sq_ID == 15 || sq_ID == 25 || sq_ID == 28 || sq_ID == 35){
					RailroadsAndUtilities rnu = (RailroadsAndUtilities)getSquare(sq_ID);
					rnu.setOwnerID(target.getPlayerID());
				}
				else{
					RealEstate re = (RealEstate) getSquare(sq_ID);
					re.setOwnerID(target.getPlayerID());
				}
				break;
			case 1:
			default:
				JOptionPane.showMessageDialog(contentPane, "The trade has been declined.");
			}
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Trade cancelled");
		}
	}

	//TODO Need to implement by interacting with timer in Monopoly class, (or we may want to move timer into this class)
	private boolean checkTime() {
		return getTimeUp();
	}
	
	private void determineWinner(){
		Player winner = players[0];
		ArrayList<Player> candidates = new ArrayList<Player>();
		
		//Checks for ties
		for(int i = 1; i < players.length; i++){
			if(players[i].getBalance() >= winner.getBalance()){
				candidates.add(players[i]);
				winner = players[i];
			}
		}
		
		if(candidates.size() == 0){
			JOptionPane.showMessageDialog(contentPane, "The winner is " + winner.getName() + " with a balance of " + winner.getBalance() + "!");
			try {
			   Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
			   e.printStackTrace();
			}
			System.exit(0);
		}
		//One definitive winner
		if(candidates.size() == 1){
			JOptionPane.showMessageDialog(contentPane, "The winner is " + candidates.get(0).getName() + " with a balance of " + candidates.get(0).getBalance() + "!");
			try {
			   Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
			   e.printStackTrace();
			}
			System.exit(0);
		}
		//Tied game, get the guy with the most properties.
		//If there is a tie there, pick one arbitrarily.
		else{
			ArrayList<Player> trueWinners = new ArrayList<Player>();
			trueWinners = candidates;
			for(int i = 0; i < candidates.size(); i++){
				if(winner.getPropertiesOwned().size() > candidates.get(i).getPropertiesOwned().size()){
					trueWinners.remove(i);
				}
				else if(candidates.get(i).getPropertiesOwned().size() > winner.getPropertiesOwned().size()){
					trueWinners.remove(winner);
				}
			}
			
			//Determine the winner
			//If there is a tie here it picks the player with the lowest player ID
			JOptionPane.showMessageDialog(contentPane, "The winner is " + trueWinners.get(0).getName() + " with a balance of " + trueWinners.get(0).getBalance());
			try {
			   Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
			   e.printStackTrace();
			}
			System.exit(0);
		}
	}

	public int getNumPlayers() {
		return numPlayers;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public static boolean getTimeUp() {
		return timeUp;
	}

}
