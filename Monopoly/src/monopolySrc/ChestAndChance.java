package monopolySrc;

import java.util.ArrayList;
import java.util.Random;

public class ChestAndChance {

	private ArrayList<Integer> chestDeck;
	private ArrayList<Integer> chanceDeck;
	private Player[] players;
	private Jail jail;
	private Board b;

	public ChestAndChance(Jail j, Player[] pl, Board b) {
		chestDeck = new ArrayList<Integer>();
		chanceDeck = new ArrayList<Integer>();
		players = pl;
		shuffle();
		//We need a reference to the Jail square and the Board
		this.jail = j;
		//When passing the Board in the constructor use the "this" keyword
		//ex: ChestAndChance(jail, players, this);
		this.b = b;
	}

	private void shuffle(){
		Random rand = new Random();
		int num = 0;
		//Shuffle the chestDeck
		//Fill the deck with all 16 cards
		//Cards taken from http://monopoly.wikia.com/wiki/Community_Chest
		//IGNORING BIRTHDAY CARD! This card isn't in original game.
		while(chestDeck.size() != 16){
			num = rand.nextInt(16) + 1;
			if(!chestDeck.contains(num)){
				chestDeck.add(num);
			}
		}

		//Shuffle the chanceDeck
		//Fill the deck with all 16 cards
		//Cards taken from http://monopoly.wikia.com/wiki/Chance
		while(chanceDeck.size() != 16){
			num = rand.nextInt(16) + 1;
			if(!chanceDeck.contains(num)){
				chanceDeck.add(num);
			}
		}
	}

	public void draw(Player p, int space){
		if(space == 2 || space == 17 || space == 33){
			//Community Chest space
			getChestCard(p);
		}
		else{
			//Chance space
			getChanceCard(p);
		}
	}

	//These next methods are going to be gross af, I'm sorry

	private void getChestCard(Player p){
		int card = chestDeck.get(0);
		int count = 0;
		//Put the card at the bottom of the deck
		chestDeck.remove(0);
		chestDeck.add(card);
		switch(card){
		case 1:
			System.out.println("Advance to Go and collect $200!");
			p.increaseBalance(200);
			p.setCurrentSquare(0);
		case 2:
			System.out.println("Bank error in your favor! You receive $200.");
			p.increaseBalance(200);
		case 3:
			System.out.println("Doctor's fees. Pay $50.");
			p.decreaseBalance(50);
		case 4:
			System.out.println("From the sale of a stock you get $50!");
			p.increaseBalance(50);
		case 5:
			System.out.println("Get out of jail free! This card may be kept until needed or sold.");
			//Implement this
			p.receiveJCard();
			//Removes this card from the list
			chestDeck.remove(chestDeck.size() - 1);
		case 6:
			System.out.println("Go to jail.");
			p.setCurrentSquare(40);
			jail.addPlayer(p);
		case 7:
			System.out.println("Grand Opera night! Collect $50 from every player for opening night seats.");
			count = 0;
			//Calculates correct amount to give to the player that drew this card
			//and removes $50 from every other player.
			for(int i = 0; i < players.length; i++){
				if(players[i] != null){
					if(players[i].getPlayerID() != p.getPlayerID()){
						count++;
						players[i].decreaseBalance(50);
					}
				}
			}
			p.increaseBalance((count * 50));
		case 8:
			System.out.println("Holiday fund matures! Collect $100");
			p.increaseBalance(100);
		case 9:
			System.out.println("Income tax refund! Collect $20.");
			p.increaseBalance(20);
		case 10:
			System.out.println("Life insurance matures! Collect $100.");
			p.increaseBalance(100);
		case 11:
			System.out.println("Pay hospital fees of $100.");
			p.decreaseBalance(100);
		case 12:
			System.out.println("Pay school fees of $150.");
			p.decreaseBalance(150);
		case 13:
			System.out.println("Receive $25 consultancy fee!");
			p.increaseBalance(25);
		case 14:
			System.out.println("Happy birthday! Collect $10 from each player.");
			count = 0;
			//Calculates correct amount to give to the player that drew this card
			//and removes $10 from every other player.
			for(int i = 0; i < players.length; i++){
				if(players[i] != null){
					if(players[i].getPlayerID() != p.getPlayerID()){
						count++;
						players[i].decreaseBalance(10);
					}
				}
			}
			p.increaseBalance((count * 10));
		case 15:
			System.out.println("You have won second prize in a beauty contest and win $10!");
			p.increaseBalance(10);
		case 16:
			System.out.println("You inherit $100");
			p.increaseBalance(100);
		default:
			System.out.println("You shouldn't have come here.");
		}
	}

	private void getChanceCard(Player p){
		int card = chanceDeck.get(0);
		int count = 0;
		int spot = 0;
		int amount = 0;
		//Put the card at the bottom of the deck
		chanceDeck.remove(0);
		chanceDeck.add(card);
		switch(card){
		case 1:
			System.out.println("Advance to Go and collect $200!");
			p.increaseBalance(200);
			p.setCurrentSquare(0);
		case 2:
			System.out.println("Advance to Illinois Ave. If you pass Go, collect $200");
			if(p.getCurrentSquare() > 24){
				//Passed Go
				p.increaseBalance(200);
			}
			p.setCurrentSquare(24);
			b.resolveSquare(p, 24);
		case 3:
			System.out.println("Advance to St. Charles Place. If you pass Go, collect $200");
			if(p.getCurrentSquare() > 11){
				//Passed Go
				p.increaseBalance(200);
			}
			p.setCurrentSquare(11);
			b.resolveSquare(p, 11);
		case 4:
			System.out.println("Advance token to nearest utility and pay 10 times die roll.");
			spot = p.getCurrentSquare();
			if(spot == 22){
				//Water Works
				p.setCurrentSquare(28);
			}
			else{
				//Electric Company
				p.setCurrentSquare(12);
			}	
			int cost = b.dicegetFace1() + b.dicegetFace2();
			RailroadsAndUtilities u = (RailroadsAndUtilities)b.getSquare(spot);
			if(u.getOwnerID() == -1){
				b.resolveSquare(p, spot);
			}
			else{
				p.decreaseBalance(cost);
				int owner = u.getOwnerID();
				Player[] array = b.getPlayers();
				//This finds the correct player to pay
				for(int i = 0; i < array.length; i++){
					if(owner == array[i].getPlayerID()){
						array[i].increaseBalance(cost);
					}
				}
			}
		case 5:
			System.out.println("Advance to the nearest railroad. Pay owner twice the rent.");
			spot = p.getCurrentSquare();
			if(spot == 7){
				//Pennsylvania Railroad
				p.setCurrentSquare(15);
			}
			else if(spot == 22){
				//B & O Railroad
				p.setCurrentSquare(25);
			}
			else{
				//Short Line
				p.setCurrentSquare(5);
			}
			b.resolveSquare(p, spot);
			RailroadsAndUtilities rr = (RailroadsAndUtilities)b.getSquare(spot);
			//This pays the rent a second time to fulfill the requirements for this card if rent is owed
			if(rr.getOwnerID() != -1 && rr.getOwnerID() != p.getPlayerID()){
				b.resolveSquare(p, spot);
			}
		case 6:
			System.out.println("Bank pays you dividend of $50");
			p.increaseBalance(50);
		case 7:
			System.out.println("Get out of jail free! This card may be kept until needed or sold.");
			//Implement this
			p.receiveJCard();
			//Removes this card from the list
			chestDeck.remove(chestDeck.size() - 1);
		case 8:
			System.out.println("Go back 3 spaces.");
			p.setCurrentSquare(p.getCurrentSquare() - 3);
			b.resolveSquare(p, p.getCurrentSquare());
		case 9:
			System.out.println("Go to jail.");
			p.setCurrentSquare(40);
			jail.addPlayer(p);
		case 10:
			System.out.println("Make repairs on all your property. You paid $25/house and $100/hotel for a total of " + amount);
			ArrayList<Integer> prop = p.getPropertiesOwned();
			for(int i = 0; i < prop.size(); i++){
				if(b.getSquare(i) instanceof RealEstate){
					RealEstate r = (RealEstate)b.getSquare(i);
					count = r.getNumBuildings();
					if(count == 5){
						//Price of hotel and 4 houses
						amount += 100;
					}
					else{
						//Price of amount of houses
						amount += (25 * count);
					}
				}
			}
			p.decreaseBalance(amount);
		case 11:
			System.out.println("Pay poor tax of $15.");
			p.decreaseBalance(15);
		case 12:
			System.out.println("Take a trip to Reading Railroad. If you pass Go, collect $200");
			if(p.getCurrentSquare() > 5){
				//Passed Go
				p.increaseBalance(200);
			}
			p.setCurrentSquare(5);
			b.resolveSquare(p, 5);
		case 13:
			System.out.println("Take a walk on the Boardwalk. Advance token to Boardwalk.");
			p.setCurrentSquare(39);
			b.resolveSquare(p, 39);
		case 14:
			System.out.println("You have been elected Chairman of the Board. Pay each player $50");
			count = 0;
			//Calculates correct amount to remove to the player that drew this card
			//and adds $50 to every other player.
			for(int i = 0; i < players.length; i++){
				if(players[i] != null){
					if(players[i].getPlayerID() != p.getPlayerID()){
						count++;
						players[i].increaseBalance(50);
					}
				}
			}
			p.increaseBalance((count * 50));
		case 15:
			System.out.println("Your building loan matures! Collect $150.");
			p.increaseBalance(150);
		case 16:
			System.out.println("You have won a crossword competition. Collect $100.");
			p.increaseBalance(100);
		default:
			System.out.println("You shouldn't have come here.");
		}
	}

	public void restoreJailCard(){
		//By default the card will be put back into CC
		if(chestDeck.size() < 16){
			chestDeck.add(5);
		}
		else{
			chanceDeck.add(7);
		}
	}
}
