package monopolyTests;
import static org.junit.Assert.*;

import org.junit.Test;

import monopolySrc.Player;
import monopolySrc.Tax;

public class TaxTest {

	@Test
	public void correctConstructionTest() {
		Tax t = new Tax(1, "test");
		
		assertEquals("test", t.getName());
		assertEquals(1, t.getID());
	}
	
	@Test
	public void payLuxuryTax(){
		Tax t = new Tax(1, "test");
		Player p = new Player(1, "Dan", "Cat");
		
		t.payTax(p);
		
		assertEquals(1400, p.getBalance());
	}
	
	@Test
	public void payTenPercentIncomeTax(){
		Tax t = new Tax(1, "Income Tax");
		Player p = new Player(1, "Dan", "Cat");
		
		t.payTax(p);
		
		assertEquals(1350, p.getBalance());
	}
	
	@Test
	public void payTwoHundredIncomeTax(){
		Tax t = new Tax(1, "Income Tax");
		Player p = new Player(1, "Dan", "Cat");
		
		p.setBalance(2100);
		t.payTax(p);
		
		assertEquals(1900, p.getBalance());
	}

}
