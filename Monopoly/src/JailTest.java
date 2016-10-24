import static org.junit.Assert.*;

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
		Player p = new Player(1, "Dan");
		
		j.addPlayer(p);
		
		assertTrue(j.isPlayerJailed(p));
	}
	
	@Test
	public void isPlayerJailedWithEmptyJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan");
		
		assertFalse(j.isPlayerJailed(p));
	}
	
	@Test
	public void isPlayerJailedWithFullJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan");
		Player q = new Player(2, "Conor");
		Player r = new Player(3, "Alex");
		Player s = new Player(4, "Alan");
		
		j.addPlayer(p);
		j.addPlayer(q);
		j.addPlayer(r);
		j.addPlayer(s);
		
		assertTrue(j.isPlayerJailed(s));
	}
	
	@Test
	public void addPlayerToJail(){
		Jail j = new Jail(40, "Jail");
		Player p = new Player(1, "Dan");
		Player[] temp = new Player[4];
		
		j.addPlayer(p);
		temp[1] = p;
		
		System.out.println("temp: " + temp[1].getName());
		System.out.println("j: " + j.getPlayers()[1].getName());
		assertEquals(temp, j.getPlayers());
	}

}
