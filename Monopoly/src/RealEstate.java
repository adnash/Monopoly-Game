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

	//TODO implement how to find monopoly
	public boolean isMonopoly(){
		return true;

	}
	
	//random change note

	public int calcRent(){
		if(isMonopoly()){
			if(numBuildings == 0){
				return rentArray[1];
			}else if(numBuildings == 1){
				return rentArray[2];
			}else if(numBuildings == 2){
				return rentArray[3];
			}else if(numBuildings == 3){
				return rentArray[4];
			}else if(numBuildings == 4){
				return rentArray[5];
			}else if(numBuildings == 5){
				return rentArray[6];
			}else{
				return 0;
			}
		}else{
			return rentArray[0];
		}
	}

	public void build(Player p){
		numBuildings++;
		p.setBalance(p.getBalance() - buildingPrice);
	}

	
	//TODO SELL
	public void sell(){

	}

	//TODO need to add monopoly check to can build
	public boolean canBuild(Player p){
		if(ownerID == p.getPlayerID() && !isMortgaged && (p.getBalance() >= buildingPrice) && (numBuildings < 5)){
			return true;
		}else{
			return false;
		}
	}

	public boolean canSell(Player p){
		if(numBuildings == 0 && !isMortgaged && ownerID == p.getPlayerID()){
			return true;
		}else{
			return false;
		}
	}

	public boolean mortgage(Player p){
		if(getOwnerID() == p.getPlayerID() && !isMortgaged){
			p.setBalance((int) (p.getBalance() + (getMortgagePrice())));
			isMortgaged = true;
			return true;
		}else{
			return false;
		}
	}

	public boolean canMortgage(Player p){
		if(numBuildings == 0 && !isMortgaged && ownerID == p.getPlayerID()){
			return true;
		}else{
			return false;
		}
	}

	public boolean unMortgage(Player p){
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
