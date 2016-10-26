import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RealEstateTest {

	private int ownerID;
	private String name;
	private int buyPrice;
	private int buildingPrice;
	private int numBuildings;
	private boolean isMortgaged;
	private int rentArray[];
	private int monopoly[];
	// TODO Implement or remove group as it is currently not used
	int group;
	
	// realEstate_A and realEstate_B are initialized with the same variables. They are equal, but not the same.
	RealEstate realEstate_A;
	RealEstate realEstate_B;
	
	Player player_A;
	Player player_B;
	
	@Before
	public void setUp() throws Exception {
		ownerID = 1;
		name = "Arbuckle Avenue";
		buyPrice = 200;
		buildingPrice = 50;
		numBuildings = 0;
		isMortgaged = false;
		int[] rentArray = {10,20,50,150,450,625,750};
		int[] monopoly = {11,13,14};
		// TODO Implement or remove group as it is currently not used
		group = -1;
		
		// realEstate_A and realEstate_B are initialized with the same variables. They are equal, but not the same.
		realEstate_A = new RealEstate(ownerID, name, buyPrice, buildingPrice, rentArray, monopoly);
		realEstate_B = new RealEstate(ownerID, name, buyPrice, buildingPrice, rentArray, monopoly);
		
		player_A = new Player(0, "Alexander", "Android");
		player_B = new Player(1, "Alex", "Delta-T");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRealEstate() {
		assertEquals("fail - realEstate_A.getOwnerID() and ownerID do not match", realEstate_A.getOwnerID(), ownerID);
		assertEquals("fail - realEstate_A.getName and name do not match", realEstate_A.getName(), name);
		assertEquals("fail - realEstate_A.getBuyPrice() and buyPrice do not match", realEstate_A.getBuyPrice(), buyPrice);
		assertEquals("fail - realEstate_A.getRentArray() and rentArray do not match", realEstate_A.getRentArray(), rentArray);
		assertEquals("fail - realEstate_A.getMonopoly() and monopoly do not match", realEstate_A.getMonopoly(), monopoly);
		assertEquals("fail - realEstate_A does not equal realEstate_B - check equals() method override for RealEstate class", realEstate_A, realEstate_B);
	}

	@Test
	public void testCalcRent() {	
		assertEquals("fail - calcRent() is not returing correct value for a non-monopoly", realEstate_A.calcRent(false), rentArray[0]);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 0 buildings", realEstate_A.calcRent(true), rentArray[1]);
		numBuildings = 1;
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 1 building", realEstate_A.calcRent(true), rentArray[2]);
		numBuildings = 2;
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 2 buildings", realEstate_A.calcRent(true), rentArray[3]);
		numBuildings = 3;
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 3 buildings", realEstate_A.calcRent(true), rentArray[4]);
		numBuildings = 4;
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 4 buildings", realEstate_A.calcRent(true), rentArray[5]);
		numBuildings = 5;
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 5 buildings (a hotel)", realEstate_A.calcRent(true), rentArray[6]);
		numBuildings = 6;
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 6+ buildings (a hotel + houses. Not allowed?)", realEstate_A.calcRent(true), rentArray[6]);
	}

	@Test
	public void testBuild() {

		// This shouldn't work as player_A is not the owner of the real estate property
		realEstate_A.build(player_A);
		assertNotEquals("fail - a player who is not the owner of the property was able to buy a house", player_A.getBalance(), 1200);
		assertNotEquals("fail - a player who is not the owner of the property was able to buy a house", realEstate_A.getNumBuildings(), 0);
		
		realEstate_A.build(player_B);
		assertEquals("fail - player was not able to build a house", realEstate_A.getNumBuildings(), 1);
		assertEquals("fail - player was not charged for house", player_B.getBalance(), 1200);
		
		// This shouldn't work as a player that has a hotel shouldn't be able to build more houses or hotels
		numBuildings = 5;
		realEstate_A.build(player_B);
		assertNotEquals("fail - player was able to build a house on a property with a hotel", numBuildings, 6);
	}

	@Test
	public void testSell() {
		assertEquals("fail - realEstate_A did not initialize with 0 houses", numBuildings, 0);
		
		numBuildings = 1;
		realEstate_A.sell(player_B);
		assertEquals("fail - the numBuildings did not decrement correctly", numBuildings, 0);
		assertEquals("fail - the player's balance was not decreased correctly", player_B.getBalance(), 1525);
		player_B.setBalance(1500);
		
		realEstate_A.sell(player_B);
		assertFalse("fail - realEstate_A should not be able to have negative houses", numBuildings < 0);
		assertNotEquals("fail - the player's balance was still increased even though there were no houses to sell", player_B.getBalance(), 1525);
	}

	@Test
	public void testCanBuild() {
		
		assertFalse("fail - a player who is not the owner is able to build a house", realEstate_A.canBuild(player_A));
		
		player_B.setBalance(1);
		assertFalse("fail - owner who does not have enough money is able to build a house", realEstate_A.canBuild(player_B));
		player_B.setBalance(1500);
		
		isMortgaged = true;
		assertFalse("fail - owner who mortaged the property is able to build a house", realEstate_A.canBuild(player_B));
		isMortgaged = false;
		
		numBuildings = 5;
		assertFalse("fail - owner is able to build more than 5 houses", realEstate_A.canBuild(player_B));
		numBuildings = 0;
		
		assertTrue("fail - eligible owner on eligible property is not able to build a house", realEstate_A.canBuild(player_B));
	}

	@Test
	public void testCanSell() {
		numBuildings = 1;
		assertFalse("fail - a player who is not the owner is able to sell a house", realEstate_A.canSell(player_A));
		
		numBuildings = 1;
		isMortgaged = true;
		assertFalse("fail - owner who mortgaged the property is able to sell a hosue", realEstate_A.canSell(player_B));
		isMortgaged = false;
		
		numBuildings = 0;
		assertFalse("fail - owner is able to sell houses when there aren't any", realEstate_A.canSell(player_B));
		
		numBuildings = 1;
		assertTrue("fail - eligible owner on eligible property is not able to sell a house", realEstate_A.canSell(player_B));
	}

	@Test
	public void testMortgage() {
		realEstate_A.mortgage(player_B);
		assertTrue("fail - owner was not able to mortgage property", realEstate_A.getIsMortgaged());
	}

	@Test
	public void testCanMortgage() {
		assertTrue("fail - owner is not able to mortgage property", realEstate_A.canMortgage(player_B));
	}

	@Test
	public void testUnMortgage() {
		realEstate_A.mortgage(player_B);
		assertFalse("fail - owner is not able to unmortgage a property", realEstate_A.getIsMortgaged());
	}

	@Test
	public void testGetOwnerID() {
		assertEquals("fail - realEstate_A returned incorrect ownerID", realEstate_A.getOwnerID(), 1);
	}

	@Test
	public void testSetOwnerID() {
		realEstate_A.setOwnerID(0);
		assertEquals("fail - realEstate_A is not able to set ownerID", realEstate_A.getOwnerID(), 0);
	}

	@Test
	public void testGetBuyPrice() {
		assertEquals("fail - buyPrice returned by getBuyPrice() is incorrect", realEstate_A.getBuyPrice(), 200);
	}

	@Test
	public void testGetBuildingPrice() {
		assertEquals("fail - buildingPrice returned by getBuildingPrice() is incorrect", realEstate_A.getBuildingPrice(), 50);
	}

	@Test
	public void testGetNumBuildings() {
		assertEquals("fail - numBuildings returned by getNumBuildings() is incorrect", realEstate_A.getNumBuildings(), 0);
	}
	
	@Test
	public void testGetIsMortgaged() {
		assertFalse("fail - isMortgaged returned by getIsMortgaged() is incorrect", realEstate_A.getIsMortgaged());
	}

	@Test
	public void testGetBaseRent() {
		assertEquals("fail - baseRent returned by getBaseRent() is incorrect", realEstate_A.getBaseRent(), 10);
	}
	
	@Test
	public void testGetRentArray() {
		int[] intArray = {10,20,50,150,450,625,750};
		assertEquals("fail - rentArray returned by getRentArray() is incorrect", realEstate_A.getRentArray(), intArray);
	}
	
	@Test
	public void testGetMonopoly() {
		int[] intArray = {11,13,14};
		assertEquals("fail - monopoly returned by getMonopoly() isn incorrect", realEstate_A.getMonopoly(), intArray);
	}

	@Test
	public void testGetGroup() {
		assertEquals("fail - group returned by getGroup() is incorrect", realEstate_A.getGroup(), -1);
	}

	@Test
	public void testGetMortgagePrice() {
		assertEquals("fail - mortgagePrice returned by getMortgagePrice() is incorrect", realEstate_A.getMortgagePrice());
	}

}
