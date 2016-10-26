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
	private int monopoly[];
	// TODO Implement or remove group as it is currently not used
	int group;

	public RealEstate(int ID, String name, int buyPrice, int buildingPrice, int[] rentArray, int[] monopoly) {
		super(ID, name);
		this.ownerID = -1;
		this.buyPrice = buyPrice;
		this.buildingPrice = buildingPrice;
		this.numBuildings = 0;
		this.isMortgaged = false;
		this.rentArray = rentArray;
		this.monopoly = monopoly;
	}

	// Pass boolean that says is monopoly
	public int calcRent(boolean isMonopoly) {
		if (isMonopoly) {
			if (numBuildings == 0) {
				return rentArray[1];
			} else if (numBuildings == 1) {
				return rentArray[2];
			} else if (numBuildings == 2) {
				return rentArray[3];
			} else if (numBuildings == 3) {
				return rentArray[4];
			} else if (numBuildings == 4) {
				return rentArray[5];
			} else if (numBuildings == 5) {
				return rentArray[6];
			}
			// TODO Not sure if this else statement make sense here. Could result in a bug.
			else {
				return 0;
			}
		} else {
			return rentArray[0];
		}
	}

	public void build(Player player) {
		// TODO need to check that player is owner
		numBuildings++;
		// TODO Should use decreaseBalance() method
		player.setBalance(player.getBalance() - buildingPrice);
	}

	public void sell(Player player) {
		// TODO need to add check that there are houses to actually sell?
		numBuildings--;
		// TODO Should use decreaseBalance() method?
		player.setBalance(player.getBalance() + (buildingPrice/2));
	}

	// TODO Need to add monopoly check to see if possible to build
	public boolean canBuild(Player player) {
		if (ownerID == player.getPlayerID() && !isMortgaged && (player.getBalance() >= buildingPrice) && (numBuildings < 5)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canSell(Player player){
		if (numBuildings == 0 && !isMortgaged && ownerID == player.getPlayerID()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean mortgage(Player player){
		if (canMortgage(player)) {
			// TODO Could use increaseBalance() method here. Should check to see if casting float to int gives correcnt amount
			player.setBalance((int) (player.getBalance() + getMortgagePrice()));
			isMortgaged = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean canMortgage(Player player){
		if (numBuildings == 0 && !isMortgaged && ownerID == player.getPlayerID()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean unMortgage(Player player) {
		// Unmortgaging allows you get get a balance of $0
		if (getOwnerID() == player.getPlayerID() && isMortgaged) {
			// TODO Double-check if this is really unmortgaging is handled
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

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ID) {
		ownerID = ID;
	}

	public int getBuyPrice() {
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
	
	public int[] getRentArray() {
		return rentArray;
	}
	
	public int[] getMonopoly() {
		return monopoly;
	}
	
	public int getGroup() {
		return group;
	}
	
	// TODO Double-check that this is actually the value of all mortgages
	public int getMortgagePrice() {
		return (buyPrice/2);
	}
}
