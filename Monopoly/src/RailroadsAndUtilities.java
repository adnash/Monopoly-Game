
public class RailroadsAndUtilities extends Square {

	int ownerID;
	int price;
	
	public RailroadsAndUtilities(int ID, String name, int price) {
		super(ID, name);
		ownerID = -1;
		this.price = price;
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
		return price/2;
	}

	
}
