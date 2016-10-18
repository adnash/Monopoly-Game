// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// RealEstate.java



public class RealEstate extends Square {

	private int ownerID;
	private int buyPrice;
	private int buildingPrice;
	private int numBuildings;
	private boolean isMortgaged;
	private int rentArray[];
	

	int group;
	
	
	public RealEstate(int ID, String name, int buyPrice, int buildingPrice, int[] rentArray, int group) {
		super(ID, name);
		this.ownerID = -1;
		this.buyPrice = buyPrice;
		this.buildingPrice = buildingPrice;
		this.numBuildings = 0;
		this.rentArray = rentArray;
		this.isMortgaged = false;
		this.group = group;
	}
	
	public int calcRent(){
		return -1;
	}
	
	public void build(Player p){
		numBuildings++;
		p.setBalance(p.getBalance() - buildingPrice);
	}
	
	public void sell(){
		
	}
	
	public boolean canBuild(Player p){
		if(ownerID == p.getPlayerID() && !isMortgaged && (p.getBalance() >= buildingPrice) && (numBuildings < 5)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean canSell(){
		return false;
	}
	
	public void mortgage(){
		
		isMortgaged = true;
	}
	
	public void canMortgage(){
		
		
		isMortgaged = false;
	}
	
	public boolean unMortgage(Player p){
		// unmortgaging allows you get get a balance of $0
		if(getOwnerID() == p.getPlayerID()){
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
		return rentArray[0];
	}

	public int getGroup() {
		return group;
	}
	
	public int getMortgagePrice() {
		return buyPrice/2;
	}

}
