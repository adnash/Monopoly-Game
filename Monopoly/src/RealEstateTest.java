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
		int rentArray[] = {10,20,50,150,450,625,750};
		int monopoly[] = {11,13,14};
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
		
	}

	@Test
	public void testCanBuild() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanSell() {
		fail("Not yet implemented");
	}

	@Test
	public void testMortgage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanMortgage() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnMortgage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOwnerID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOwnerID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBuyPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBuildingPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumBuildings() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBaseRent() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetRentArray() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetMonopoly() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGroup() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMortgagePrice() {
		fail("Not yet implemented");
	}

}
