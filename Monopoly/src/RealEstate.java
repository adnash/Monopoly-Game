
public class RealEstate extends Square {

	int ownerID;
	int price;
	int buildingPrice;
	int numBuildings;
	boolean isMortgaged;
	int baseRent;
	int group;
	
	public RealEstate(int ID, String name, int price, int bPrice, int bRent, int group) {
		super(ID, name);
		ownerID = -1;
		this.buildingPrice = price;
		this.buildingPrice = bPrice;
		numBuildings = 0;
		isMortgaged = false;
		this.baseRent = bRent;
		this.group = group;
	}
	
	int calcrent(){
		return -1;
	}
	
	void build(){
		
	}
	
	void sell(){
		
	}
	
	boolean canBuild(){
		return false;
	}
	
	boolean canSell(){
		return false;
	}
	
	void mortgage(){
		
	}
	
	void canMortgage(){
		
	}

	public int getOwnerID() {
		return ownerID;
	}
	
	public void setOwnerID(int ID) {
		ownerID = ID;
	}

	public int getPrice() {
		return price;
	}

	public int getBuildingPrice() {
		return buildingPrice;
	}

	public int getNumBuildings() {
		return numBuildings;
	}

	public int getBaseRent() {
		return baseRent;
	}

	public int getGroup() {
		return group;
	}

}
