// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// RailroadsAndUtilities.java

public class RailroadsAndUtilities extends Square {

	private int ownerID;
	private int price;
	private boolean isMortgaged;
	
	public RailroadsAndUtilities(int ID, String name, int price) {
		super(ID, name);
		ownerID = -1;	// This is to initialize ownerID when there is no owner
		this.price = price;
		isMortgaged = false;
	}
	
	public boolean mortgage(Player player) {
		if (getOwnerID() == player.getPlayerID() && !isMortgaged) {
			player.increaseBalance(getMortgagePrice());
			isMortgaged = true;
			return true;
		} else {
			return false;
		}
	}

	// TODO I want to check the game rules to make sure this is working as intended
	// Unmortgaging allows you get a balance of $0
	public boolean unmortgage(Player player) {
		if (getOwnerID() == player.getPlayerID() && isMortgaged) {
			if (player.getBalance() >= (getMortgagePrice() * 1.1)) {
				player.decreaseBalance((int)Math.floor(getMortgagePrice() * 1.1));
				isMortgaged = false;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}		
	}
	
	// TODO Implement Monopoly tracking
	public boolean isMonopoly() {
		return true;
	}
	
	// TODO Implement
	public int calculateRent() {
		return -1;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getPrice() {
		return price;
	}

	public int getMortgagePrice() {
		return (price/2);
	}
	
	public boolean isMortgaged(){
		return isMortgaged;
	}
}
