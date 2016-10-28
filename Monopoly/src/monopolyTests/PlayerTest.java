package monopolyTests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import monopolySrc.Player;

public class PlayerTest {

	@Test
	public void testGetPlayerID() {
		Player p = new Player(1, "Dan", "Cat");
		
		assertEquals(1, p.getPlayerID());
	}
	
	@Test
	public void testGetName() {
		Player p = new Player(1, "Dan", "Cat");
		
		assertEquals("Dan", p.getName());
	}
	
	@Test
	public void testGetIcon() {
		Player p = new Player(1, "Dan", "Cat");
		
		assertEquals("Cat", p.getIcon());
	}
	
	@Test
	public void testSetIcon() {
		Player p = new Player(1, "Dan", "Cat");
		p.setIcon("Shoe");
		
		assertEquals("Shoe", p.getIcon());
	}
	
	@Test
	public void testGetBalance() {
		Player p = new Player(1, "Dan", "Cat");
		
		assertEquals(1500, p.getBalance());
	}
	
	@Test
	public void testSetBalance() {
		Player p = new Player(1, "Dan", "Cat");
		p.setBalance(2000);
		
		assertEquals(2000, p.getBalance());
	}
	
	@Test
	public void testIncreaseBalance() {
		Player p = new Player(1, "Dan", "Cat");
		p.increaseBalance(500);
		
		assertEquals(2000, p.getBalance());
	}
	
	@Test
	public void testDecreaseBalance() {
		Player p = new Player(1, "Dan", "Cat");
		p.decreaseBalance(500);
		
		assertEquals(1000, p.getBalance());
	}
	
	@Test
	public void testGetCurrentSquare() {
		Player p = new Player(1, "Dan", "Cat");
		
		assertEquals(0, p.getCurrentSquare());
	}
	
	@Test
	public void testSetCurrentSquare() {
		Player p = new Player(1, "Dan", "Cat");
		p.setCurrentSquare(10);
		
		assertEquals(10, p.getCurrentSquare());
	}
	
	@Test
	public void testGetPropertiesOwned() {
		Player p = new Player(1, "Dan", "Cat");
		ArrayList<Integer> temp = new ArrayList<>();
		
		assertEquals(temp, p.getPropertiesOwned());
	}
	
	@Test
	public void addPropertyTest() {
		Player p = new Player(1, "Dan", "Cat");
		p.addProperty(1);
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);
		
		assertEquals(temp, p.getPropertiesOwned());
	}
	
	@Test
	public void removeExistingProperty() {
		Player p = new Player(1, "Dan", "Cat");
		p.addProperty(1);
		p.removeProperty(1);
		ArrayList<Integer> temp = new ArrayList<>();
		
		assertEquals(temp, p.getPropertiesOwned());
	}
	
	@Test
	public void removeNonexistantPropertyTest() {
		Player p = new Player(1, "Dan", "Cat");
		p.removeProperty(1);
		ArrayList<Integer> temp = new ArrayList<>();
		
		assertEquals(temp, p.getPropertiesOwned());
	}

}
