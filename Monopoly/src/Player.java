// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Player.java

import java.util.ArrayList;

public class Player {

	// global variables
	private int balance;
	private String name;
	private int playerID;
	
	private ArrayList<Integer> propertiesOwned;
	private int currentSquare;
	
	public Player(int playerID, String name, int balance, int currentSquare){
		this.playerID = playerID;
		this.name = name;
		
		// These take in a balance and currentSquare even tho they will be fixed for testing purposes
		this.balance = balance;
		this.currentSquare = currentSquare;
	}
	
	public ArrayList<Integer> getPropertiesOwned() {
		return propertiesOwned;
	}
	public void addProperty(int propertyID) {
		this.propertiesOwned.add(propertyID);
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
	}
	public String getName() {
		return name;
	}
	public int getPlayerID() {
		return playerID;
	}
	public int getCurrentSquare() {
		return currentSquare;
	}
	public void setCurrentSquare(int currentSquare) {
		this.currentSquare = currentSquare;
	}
}
