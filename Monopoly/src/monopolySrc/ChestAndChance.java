package monopolySrc;

import java.util.ArrayList;
import java.util.Random;

public class ChestAndChance {

	private ArrayList<Integer> chestDeck;
	private ArrayList<Integer> chanceDeck;
	private ArrayList<Player> players;
	private Jail jail;
	private Board b;

	public ChestAndChance(Jail j, ArrayList<Player> pl, Board b) {
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
		while(chestDeck.size() != 17){
			num = rand.nextInt(17) + 1;
			if(!chestDeck.contains(num)){
				chestDeck.add(num);
			}
		}

		//Shuffle the chanceDeck
		//Fill the deck with all 16 cards
		//Cards taken from http://monopoly.wikia.com/wiki/Chance
		while(chanceDeck.size() != 17){
			num = rand.nextInt(17) + 1;
			if(!chanceDeck.contains(num)){
				chanceDeck.add(num);
			}
		}
	}

	public String draw(Player p, int space){
		if(space == 2 || space == 17 || space == 33){
			//Community Chest space
			return getChestCard(p);
		}
		else{
			//Chance space
			return getChanceCard(p);
		}
	}

	//These next methods are going to be gross af, I'm sorry

	private String getChestCard(Player p){
		int card = chestDeck.get(0);
		int count = 0;
		//Put the card at the bottom of the deck
		chestDeck.remove(0);
		chestDeck.add(card);
		switch(card){
		case 1:
			p.increaseBalance(200);
			p.setCurrentSquare(0);
			return "Advance to Go and collect $200!";
		case 2:
			p.increaseBalance(200);
			return "Bank error in your favor! You receive $200.";
		case 3:
			p.decreaseBalance(50);
			return "Doctor's fees. Pay $50.";
		case 4:
			p.increaseBalance(50);
			return "From the sale of a stock you get $50!";
		case 5:
			//Implement this
			p.receiveJCard();
			//Removes this card from the list
			chestDeck.remove(chestDeck.size() - 1);
			return "Get out of jail free! This card may be kept until needed or sold.";
		case 6:
			p.setCurrentSquare(40);
			jail.addPlayer(p);
			return "Go to jail.";
		case 7:
			count = 0;
			//Calculates correct amount to give to the player that drew this card
			//and removes $50 from every other player.
			for(int i = 0; i < players.size(); i++){
				if(players.get(i).getPlayerID() != p.getPlayerID()){
					count++;
					players.get(i).decreaseBalance(50);
				}
			}
			p.increaseBalance((count * 50));
			return "Grand Opera night! Collect $50 from every player for opening night seats.";
		case 8:
			p.increaseBalance(100);
			return "Holiday fund matures! Collect $100";
		case 9:
			p.increaseBalance(20);
			return "Income tax refund! Collect $20.";
		case 10:
			p.increaseBalance(100);
			return "Life insurance matures! Collect $100.";
		case 11:
			p.decreaseBalance(100);
			return "Pay hospital fees of $100.";
		case 12:
			p.decreaseBalance(150);
			return "Pay school fees of $150.";
		case 13:
			p.increaseBalance(25);
			return "Receive $25 consultancy fee!";
		case 14:
			count = 0;
			//Calculates correct amount to give to the player that drew this card
			//and removes $10 from every other player.
			for(int i = 0; i < players.size(); i++){
				if(players.get(i).getPlayerID() != p.getPlayerID()){
					count++;
					players.get(i).decreaseBalance(10);
				}
			}
			p.increaseBalance((count * 10));
			return "Happy birthday! Collect $10 from each player.";
		case 15:
			p.increaseBalance(10);
			return "You have won second prize in a beauty contest";
		case 16:
			p.increaseBalance(100);
			return "You inherit $100";
		default:
			System.out.println("You shouldn't have come here.");
		}
		return "ERROR! Didn't draw a Chest card correctly?";
	}

	private String getChanceCard(Player p){
		int card = chanceDeck.get(0);
		int count = 0;
		int spot = 0;
		int amount = 0;
		//Put the card at the bottom of the deck
		chanceDeck.remove(0);
		chanceDeck.add(card);
		switch(card){
		case 1:
			p.increaseBalance(200);
			p.setCurrentSquare(0);
			return "Advance to Go and collect $200!";
		case 2:
			if(p.getCurrentSquare() > 24){
				//Passed Go
				p.increaseBalance(200);
			}
			p.setCurrentSquare(24);
			return "Advance to Illinois Ave. If you pass Go, collect $200";
		case 3:
			if(p.getCurrentSquare() > 11){
				//Passed Go
				p.increaseBalance(200);
			}
			p.setCurrentSquare(11);
			return "Advance to St. Charles Place. If you pass Go, collect $200";
		case 4:
			spot = p.getCurrentSquare();
			if(spot == 22){
				//Water Works
				p.setCurrentSquare(28);
			}
			else{
				//Electric Company
				p.setCurrentSquare(12);
			}	
			//WE NEED TO HANDLE THIS OUTSIDE THIS CLASS
			return "Advance token to nearest utility.";
		case 5:
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
			//WE NEED TO HANDLE THIS OUTSIDE THIS CLASS W/A UNIQUE METHOD
			return "Advance to the nearest railroad. Pay owner twice the rent.";
		case 6:
			p.increaseBalance(50);
			return "Bank pays you dividend of $50";
		case 7:
			//Implement this
			p.receiveJCard();
			//Removes this card from the list
			chestDeck.remove(chestDeck.size() - 1);
			return "Get out of jail free! This card may be kept until needed or sold.";
		case 8:
			p.setCurrentSquare(p.getCurrentSquare() - 3);
			return "Go back 3 spaces.";
		case 9:
			p.setCurrentSquare(40);
			jail.addPlayer(p);
			return "Go to jail.";
		case 10:
			ArrayList<Integer> prop = p.getPropertiesOwned();
			for(int i = 0; i < prop.size(); i++){
				if(b.getSquare(i) instanceof RealEstate){
					RealEstate r = (RealEstate)b.getSquare(i);
					count = r.getNumBuildings();
					if(count == 5){
						//Price of hotel and 4 houses
						amount += 200;
					}
					else{
						//Price of amount of houses
						amount += (25 * count);
					}
				}
			}
			p.decreaseBalance(amount);
			return "Make repairs on all your property. You paid $25/house and $100/hotel for a total of " + amount;
		case 11:
			p.decreaseBalance(15);
			return "Pay poor tax of $15.";
		case 12:
			if(p.getCurrentSquare() > 5){
				//Passed Go
				p.increaseBalance(200);
			}
			p.setCurrentSquare(5);
			return "Take a trip to Reading Railroad. If you pass Go, collect $200";
		case 13:
			p.setCurrentSquare(39);
			return "Take a walk on the Boardwalk. Advance token to Boardwalk.";
		case 14:
			count = 0;
			//Calculates correct amount to remove to the player that drew this card
			//and adds $50 to every other player.
			for(int i = 0; i < players.size(); i++){
				if(players.get(i).getPlayerID() != p.getPlayerID()){
					count++;
					players.get(i).increaseBalance(50);
				}
			}
			p.increaseBalance((count * 50));
			return "You have been elected Chairman of the Board. Pay each player $50";
		case 15:
			p.increaseBalance(150);
			return "Your building loan matures! Collect $150.";
		case 16:
			p.increaseBalance(100);
			return "You have won a crossword competition. Collect $100.";
		default:
			System.out.println("You shouldn't have come here.");
		}
		return "ERROR! Didn't draw a Chance card correctly?";
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
