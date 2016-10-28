package monopolyTests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import monopolySrc.Player;
import monopolySrc.RealEstate;

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
		rentArray = new int[] {10,20,50,150,450,625,750};
		monopoly = new int [] {11,13,14};
		// TODO Implement or remove group as it is currently not used
		group = -1;
		
		// realEstate_A and realEstate_B are initialized with the same variables. They are equal, but not the same.
		realEstate_A = new RealEstate(ownerID, name, buyPrice, buildingPrice, rentArray, monopoly);
		realEstate_B = new RealEstate(ownerID, name, buyPrice, buildingPrice, rentArray, monopoly);
		realEstate_A.setOwnerID(1);
		realEstate_B.setOwnerID(1);
		
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
	}

	@Test
	public void testCalcRent() {	
		assertEquals("fail - calcRent() is not returing correct value for a non-monopoly", realEstate_A.calcRent(false), rentArray[0]);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 0 buildings", realEstate_A.calcRent(true), rentArray[1]);
		realEstate_A.build(player_B);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 1 building", realEstate_A.calcRent(true), rentArray[2]);
		realEstate_A.build(player_B);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 2 buildings", realEstate_A.calcRent(true), rentArray[3]);
		realEstate_A.build(player_B);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 3 buildings", realEstate_A.calcRent(true), rentArray[4]);
		realEstate_A.build(player_B);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 4 buildings", realEstate_A.calcRent(true), rentArray[5]);
		realEstate_A.build(player_B);
		assertEquals("fail - calcRent() is not returning correct value for a monopoly with 5 buildings (a hotel)", realEstate_A.calcRent(true), rentArray[6]);
		realEstate_A.build(player_B);
		//assertEquals("fail - calcRent() is not returning correct value for a monopoly with 6+ buildings (a hotel + houses. Not allowed?)", realEstate_A.calcRent(true), rentArray[6]);
	}

	@Test
	public void testBuild() {
		
		realEstate_A.build(player_B);
		assertEquals("fail - player was not able to build a house", realEstate_A.getNumBuildings(), 1);
		assertEquals("fail - player was not charged for house", player_B.getBalance(), 1450);
	}

	@Test
	public void testSell() {
		assertEquals("fail - realEstate_A did not initialize with 0 houses", numBuildings, 0);
		
		realEstate_A.build(player_B);
		realEstate_A.sell(player_B);
		assertEquals("fail - the numBuildings did not decrement correctly", numBuildings, 0);
		assertEquals("fail - the player's balance was not decreased correctly", player_B.getBalance(), 1475);
		player_B.setBalance(1500);
		
	}

	@Test
	public void testCanBuild() {
		
		assertFalse("fail - a player who is not the owner is able to build a house", realEstate_A.canBuild(player_A));
		
		player_B.setBalance(1);
		assertFalse("fail - owner who does not have enough money is able to build a house", realEstate_A.canBuild(player_B));
		player_B.setBalance(1500);
		
		realEstate_A.build(player_B);realEstate_A.build(player_B);realEstate_A.build(player_B);realEstate_A.build(player_B);realEstate_A.build(player_B);
		numBuildings = 5;
		assertFalse("fail - owner is able to build more than 5 houses", realEstate_A.canBuild(player_B));
		numBuildings = 0;
	}

	@Test
	public void testCanSell() {
		
		assertFalse("fail - a player who is not the owner is able to sell a house", realEstate_A.canSell(player_A));
		realEstate_A.build(player_B);
		assertFalse("fail - owner is able to sell houses when there aren't any", realEstate_A.canSell(player_B));
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
		assertTrue("fail - owner is not able to unmortgage a property", realEstate_A.getIsMortgaged());
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


}
