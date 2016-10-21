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
		ownerID = -1;
		this.price = price;
		this.isMortgaged = false;
	}
	
	public boolean mortgage(Player p){
		if(getOwnerID() == p.getPlayerID() && !isMortgaged){
			p.setBalance(p.getBalance() + getMortgagePrice());
			isMortgaged = true;
			return true;
		}else{
			return false;
		}
	}
	
	public boolean unmortgage(Player p){
		// unmortgaging allows you get get a balance of $0
		if(getOwnerID() == p.getPlayerID() && isMortgaged){
			if(p.getBalance() >= (getMortgagePrice() * 1.1)){
				p.setBalance((int) (p.getBalance() - (getMortgagePrice() * 1.1)));
				isMortgaged = false;
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}		
	}
	
	//TODO implement monopoly tracking.
	public boolean isMonopoly(){
		return true;
	}
	
	public int calculateRent(){
		
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
		return price/2;
	}

	
}
