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
	
	public boolean mortgage(Player player){
		if (getOwnerID() == player.getPlayerID() && !isMortgaged) {
			player.setBalance(player.getBalance() + getMortgagePrice());
			isMortgaged = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean unmortgage(Player player) {
		// Unmortgaging allows you get a balance of $0
		if (getOwnerID() == player.getPlayerID() && isMortgaged) {
			if (player.getBalance() >= (getMortgagePrice() * 1.1)) {
				player.setBalance((int) (player.getBalance() - (getMortgagePrice() * 1.1)));
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

	// TODO Is this really how a mortgage price is calculated? Always?
	public int getMortgagePrice() {
		return price/2;
	}
}
