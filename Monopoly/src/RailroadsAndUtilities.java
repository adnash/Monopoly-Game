
public class RailroadsAndUtilities extends Square {

	int ownerID;
	int price;
	int mortgagePrice;
	
	public RailroadsAndUtilities(int ID, String name, int price, int mortgagePrice) {
		super(ID, name);
		ownerID = -1;
		this.price = price;
		this.mortgagePrice = mortgagePrice;
	}
	
	void mortgage(){
		
	}
	
	void unmortgage(){
		
	}
	
	int calculateRent(){
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
		return mortgagePrice;
	}

	
}
