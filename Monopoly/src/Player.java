// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Player.java

public class Player {

	// global variables
	private int balance;
	private String name;
	private int playerID;
	
	private int propertiesOwned[];
	private int currentSquare;
	
	
	public int[] getPropertiesOwned() {
		return propertiesOwned;
	}
	public void setPropertiesOwned(int[] propertiesOwned) {
		this.propertiesOwned = propertiesOwned;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public int getCurrentSquare() {
		return currentSquare;
	}
	public void setCurrentSquare(int currentSquare) {
		this.currentSquare = currentSquare;
	}
}
