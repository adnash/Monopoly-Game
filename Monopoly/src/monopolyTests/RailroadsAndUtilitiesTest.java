package monopolyTests;
import static org.junit.Assert.*;

import org.junit.Test;

import monopolySrc.Player;
import monopolySrc.RailroadsAndUtilities;

public class RailroadsAndUtilitiesTest {

	@Test
	public void correctConstructionTest() {
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		
		assertEquals(1, r.getID());
		assertEquals("test", r.getName());
		assertEquals(100, r.getPrice());
		assertEquals(-1, r.getOwnerID());
	}
	
	@Test
	public void getOwnerIDTest(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);

		assertEquals(1, r.getID());
	}
	
	//This doesn't work for some reason???
	@Test
	public void setOwnerIDTest(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		
		r.setOwnerID(2);

		assertEquals(2, r.getOwnerID());
	}
	
	@Test
	public void getPriceTest(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);

		assertEquals(100, r.getPrice());
	}
	
	@Test
	public void getMortgagePriceTest(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);

		assertEquals(50, r.getMortgagePrice());
	}
	
	@Test
	public void isMortgagedOnAMortgagedProperty(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		Player p = new Player(1, "Dan", "Cat");

		r.setOwnerID(1);
		r.mortgage(p);
		
		assertTrue(r.isMortgaged());
	}
	
	@Test
	public void CalculateRentWithOneUtility(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(12, "test", 100);
		
		int result = r.calculateRent(1, 5);
		
		assertEquals(25, result);
	}
	
	@Test
	public void CalculateRentWithTwoUtilities(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(12, "test", 100);
		
		int result = r.calculateRent(2, 5);
		
		assertEquals(50, result);
	}
	
	@Test
	public void CalculateRentWithOneRailroad(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		
		int result = r.calculateRent(1, 5);
		
		assertEquals(25, result);
	}
	
	@Test
	public void CalculateRentWithTwoRailroads(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		
		int result = r.calculateRent(2, 5);
		
		assertEquals(50, result);
	}
	
	@Test
	public void CalculateRentWithThreeRailroads(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		
		int result = r.calculateRent(3, 5);
		
		assertEquals(100, result);
	}
	
	@Test
	public void CalculateRentWithFourRailroads(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		
		int result = r.calculateRent(4, 5);
		
		assertEquals(200, result);
	}
	
	@Test
	public void mortgagingAnOwnedProperty(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		Player p = new Player(1, "Dan", "Cat");

		r.setOwnerID(1);
		r.mortgage(p);
		
		assertEquals(1, r.getOwnerID());
		assertEquals(1550, p.getBalance());
		assertTrue(r.isMortgaged());
	}
	
	@Test
	public void mortgagingAnUnownedProperty(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		Player p = new Player(1, "Dan", "Cat");

		r.setOwnerID(2);
		r.mortgage(p);
		
		assertEquals(2, r.getOwnerID());
		assertEquals(1500, p.getBalance());
		assertFalse(r.isMortgaged());
	}
	
	@Test
	public void unmortgagingAnOwnedProperty(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		Player p = new Player(1, "Dan", "Cat");

		r.setOwnerID(1);
		r.mortgage(p);
		r.unmortgage(p);

		assertEquals(1, r.getOwnerID());
		assertEquals(1495, p.getBalance());
		assertFalse(r.isMortgaged());
	}
	
	@Test
	public void unmortgagingAnUnownedProperty(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		Player p = new Player(1, "Dan", "Cat");
		Player q = new Player(2, "Conor", "Cat");


		r.setOwnerID(2);
		r.mortgage(q);
		r.unmortgage(p);

		assertEquals(2, r.getOwnerID());
		assertEquals(1500, p.getBalance());
		assertTrue(r.isMortgaged());
	}
	
	@Test
	public void insufficientFundsToUnmortgage(){
		RailroadsAndUtilities r = new RailroadsAndUtilities(1, "test", 100);
		Player p = new Player(1, "Dan", "Cat");

		r.setOwnerID(1);
		r.mortgage(p);
		p.setBalance(0);
		r.unmortgage(p);

		assertEquals(1, r.getOwnerID());
		assertEquals(0, p.getBalance());
		assertTrue(r.isMortgaged());
	}
	

}
