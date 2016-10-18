
public class RealEstate extends Square {

	int ownerID;
	int buyPrice;
	int buildingPrice;
	int numBuildings;
	boolean isMortgaged;
	int baseRent;
	int group;
	
	public RealEstate(int ID, String name, int buyPrice, int buildingPrice, int baseRent, int group) {
		super(ID, name);
		ownerID = -1;
		this.buyPrice = buyPrice;
		this.buildingPrice = buildingPrice;
		numBuildings = 0;
		isMortgaged = false;
		this.baseRent = baseRent;
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
		return buyPrice;
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
