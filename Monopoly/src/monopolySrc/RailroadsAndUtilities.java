package monopolySrc;
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
	
	public int calculateRent(int numOwned, int dieRoll) {
		if(isMortgaged)
			return 0;
		//Utilities
		if(this.ID == 12 || this.ID == 28){
			if(numOwned == 1)
				return 4 * dieRoll;
			else
				return 10 * dieRoll;
		}else{
			//Railroads
			switch(numOwned){
			case 1: return 25;
			case 2: return 50;
			case 3: return 100;
			case 4: return 200;
			default: return 0;
			}
		}
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
