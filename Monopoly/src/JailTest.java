import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class JailTest {

	@Test
	public void correctConstructorCreation() {
		Jail j = new Jail(40, "Jail");
		assertEquals(j.getID(), 40);
		assertEquals(j.getName(), "Jail");
	}
	
	@Test
	public void isPlayerJailedWithExistingPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		
		j.addPlayer(p);
		
		assertTrue(j.isPlayerJailed(p));
	}
	
	@Test
	public void isPlayerJailedWithEmptyJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		
		assertFalse(j.isPlayerJailed(p));
	}
	
	@Test
	public void isPlayerJailedWithFullJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player q = new Player(2, "Conor", "Cat");
		Player r = new Player(3, "Alex", "Cat");
		Player s = new Player(4, "Alan", "Cat");
		
		j.addPlayer(p);
		j.addPlayer(q);
		j.addPlayer(r);
		j.addPlayer(s);
		
		assertTrue(j.isPlayerJailed(s));
	}
	
	@Test
	public void addOnePlayerToJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player[] temp = new Player[4];
		
		j.addPlayer(p);
		temp[0] = p;
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void addFourPlayersToJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player q = new Player(2, "Conor", "Cat");
		Player r = new Player(3, "Alex", "Cat");
		Player s = new Player(4, "Alan", "Cat");
		Player[] temp = new Player[4];
		
		j.addPlayer(p);
		j.addPlayer(q);
		j.addPlayer(r);
		j.addPlayer(s);
		temp[0] = p;
		temp[1] = q;
		temp[2] = r;
		temp[3] = s;
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void addFivePlayersToJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player q = new Player(2, "Conor", "Cat");
		Player r = new Player(3, "Alex", "Cat");
		Player s = new Player(4, "Alan", "Cat");
		Player t = new Player(5, "Ben", "Cat");
		Player[] temp = new Player[4];
		
		j.addPlayer(p);
		j.addPlayer(q);
		j.addPlayer(r);
		j.addPlayer(s);
		j.addPlayer(t);
		temp[0] = p;
		temp[1] = q;
		temp[2] = r;
		temp[3] = s;
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void reduceTurnsForExistingPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		
		j.addPlayer(p);
		
		j.reduceJailTurns(p);
		
		assertEquals(j.getTurnsLeft()[0], 1);
	}
	
	@Test
	public void reduceTurnsForNonexistantPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		
		j.reduceJailTurns(p);
		
		assertEquals(j.getTurnsLeft()[0], 0);
		assertEquals(j.getTurnsLeft()[1], 0);
		assertEquals(j.getTurnsLeft()[2], 0);
		assertEquals(j.getTurnsLeft()[3], 0);
		
		assertNull(j.getPlayers()[0]);
		assertNull(j.getPlayers()[1]);
		assertNull(j.getPlayers()[2]);
		assertNull(j.getPlayers()[3]);
	}
	
	@Test
	public void checkTurnsLeftOnExistingPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		
		j.addPlayer(p);
		
		assertEquals(j.checkTurnsLeft(p), 2);
	}
	
	@Test
	public void checkTurnsLeftOnNonexistantPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		
		assertEquals(j.checkTurnsLeft(p), -1);
	}
	
	@Test
	public void freeExistingPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player[] temp = new Player[4];
		
		j.addPlayer(p);
		j.freePlayer(p);
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void freeNonexistantPlayer(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player[] temp = new Player[4];
		
		j.freePlayer(p);
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void testGetPlayersWithFilledArray(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player[] temp = new Player[4];
		
		j.addPlayer(p);
		temp[0] = p;
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void testGetPlayersWithEmptyArray(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		Player[] temp = new Player[4];
		
		assertEquals(temp, j.getPlayers());
	}
	
	@Test
	public void testGetTurnsLeftWithFilledArray(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		int [] temp = new int[4];
		
		j.addPlayer(p);
		temp[0] = 2;
		
		assertEquals(temp[0], j.getTurnsLeft()[0]);
		assertEquals(temp[1], j.getTurnsLeft()[1]);
		assertEquals(temp[2], j.getTurnsLeft()[2]);
		assertEquals(temp[3], j.getTurnsLeft()[3]);
	}
	
	@Test
	public void testGetTurnsLeftWithEmptyArray(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan", "Cat");
		int [] temp = new int[4];
		
		assertEquals(temp[0], j.getTurnsLeft()[0]);
		assertEquals(temp[1], j.getTurnsLeft()[1]);
		assertEquals(temp[2], j.getTurnsLeft()[2]);
		assertEquals(temp[3], j.getTurnsLeft()[3]);
	}
	

}
