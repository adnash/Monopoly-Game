// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Player.java

import java.util.ArrayList;

public class Player {

	// Global variables
	private int playerID;
	private String name;
	private String icon;


	private int balance;
	private int currentSquare;
	private ArrayList<Integer> propertiesOwned;

	public Player(int playerID, String name, String icon) {
		this.playerID = playerID;
		this.name = name;
		this.icon = icon;
		// Every player starts with $1500
		balance = 1500;
		// Every player starts on "Go" square with ID "0"
		currentSquare = 0;
		// No player starts with property
		propertiesOwned = null;
	}

	public int getPlayerID() {
		return playerID;
	}

	public String getName() {
		return name;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void increaseBalance(int balance) {
		this.balance += balance;
	}

	public void decreaseBalance(int balance) {
		this.balance -= balance;

		// TODO Need to check the rules, but pretty sure you can't have a negative balance. Maybe you have to borrow from the bank? Maybe you have to sell property?
		// I think this also might be a game over/loss scenario for a player. Bankruptcy? I guess they could still have property...
		if (this.balance < 0) {
			this.balance = 0;
		}
	}

	public int getCurrentSquare() {
		return currentSquare;
	}

	public void setCurrentSquare(int currentSquare) {
		this.currentSquare = currentSquare;
	}

	public ArrayList<Integer> getPropertiesOwned() {
		return propertiesOwned;
	}

	public void addProperty(int propertyID) {
		this.propertiesOwned.add(propertyID);
	}

	public void removeProperty(int propertyID) {
		this.propertiesOwned.remove(propertyID);
	}
}
