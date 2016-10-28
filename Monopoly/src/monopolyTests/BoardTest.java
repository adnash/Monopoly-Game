package monopolyTests;
import static org.junit.Assert.*;

import org.junit.Test;

import monopolySrc.Board;
import monopolySrc.Jail;
import monopolySrc.Player;
import monopolySrc.RailroadsAndUtilities;
import monopolySrc.RealEstate;
import monopolySrc.Square;

public class BoardTest {

	//We aren't (can't) testing private methods.
	
	@Test
	public void constructorAndSetupBoardTest() {
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		int [] costs = new int[] {14,28,70,200,550,750,950};
		Player p1 = new Player(0, "Dan", "Cat");
		Player p2 = new Player(1, "Conor", "Dog");
		Board b = new Board(players, icons, 21);
		RealEstate r = (RealEstate)b.getSquare(16);
		RailroadsAndUtilities u = (RailroadsAndUtilities)b.getSquare(25);
		Jail j = (Jail)b.getSquare(40);
		
		//Check if players were initialized correctly
		assertEquals(b.getPlayers()[0].getName(), p1.getName());
		assertEquals(b.getPlayers()[0].getIcon(), p1.getIcon());
		assertEquals(b.getPlayers()[0].getPlayerID(), p1.getPlayerID());
		assertEquals(b.getPlayers()[1].getName(), p2.getName());
		assertEquals(b.getPlayers()[1].getIcon(), p2.getIcon());
		assertEquals(b.getPlayers()[1].getPlayerID(), p2.getPlayerID());
		
		//Check if a square of each type is initialized correctly
		//Square
		assertEquals(b.getSquare(0).getName(), "Go");
		assertEquals(b.getSquare(0).getID(), 0);
		//RealEstate
		assertEquals(r.getName(), "St. James Place");
		assertEquals(r.getID(), 16);
		assertEquals(r.getBuyPrice(), 180);
		assertEquals(r.getBuildingPrice(), 100);
		assertEquals(r.getRentArray()[0], costs[0]);
		assertEquals(r.getRentArray()[1], costs[1]);
		assertEquals(r.getRentArray()[2], costs[2]);
		assertEquals(r.getRentArray()[3], costs[3]);
		assertEquals(r.getRentArray()[4], costs[4]);
		assertEquals(r.getRentArray()[5], costs[5]);
		assertEquals(r.getRentArray()[6], costs[6]);
		assertEquals(r.getMonopoly()[0], 16);
		assertEquals(r.getMonopoly()[1], 18);
		assertEquals(r.getMonopoly()[2], 19);
		//Jail
		assertEquals(j.getName(), "Jail");
		assertEquals(j.getID(), 40);
		assertTrue(j.getPlayers()[0] == null);
		assertTrue(j.getPlayers()[1] == null);
		assertTrue(j.getPlayers()[2] == null);
		assertTrue(j.getPlayers()[3] == null);
		assertTrue(j.getTurnsLeft()[0] == 0);
		assertTrue(j.getTurnsLeft()[1] == 0);
		assertTrue(j.getTurnsLeft()[2] == 0);
		assertTrue(j.getTurnsLeft()[3] == 0);
		//RailroadsAndUtilities
		assertEquals(u.getID(), 25);
		assertEquals(u.getName(), "B. & O. Railroad");
		assertEquals(u.getPrice(), 200);
	}
	
	@Test
	public void getSquareOnSquare(){
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		Board b = new Board(players, icons, 1);
		
		Square s = b.getSquare(0);
		
		assertTrue(s.getName() == "Go");
		assertTrue(s.getID() == 0);
	}
	
	@Test
	public void getSquareOnJail(){
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		Board b = new Board(players, icons, 1);
		
		Jail j = (Jail)b.getSquare(40);
		
		assertTrue(j.getName() == "Jail");
		assertTrue(j.getID() == 40);
		assertTrue(j.getPlayers()[0] == null);
		assertTrue(j.getPlayers()[1] == null);
		assertTrue(j.getPlayers()[2] == null);
		assertTrue(j.getPlayers()[3] == null);
		assertTrue(j.getTurnsLeft()[0] == 0);
		assertTrue(j.getTurnsLeft()[1] == 0);
		assertTrue(j.getTurnsLeft()[2] == 0);
		assertTrue(j.getTurnsLeft()[3] == 0);
	}
	
	@Test
	public void getSquareOnRealEstate(){
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		int [] costs = new int[] {14,28,70,200,550,750,950};
		Board b = new Board(players, icons, 1);
		
		RealEstate r = (RealEstate)b.getSquare(16);
		
		assertEquals(r.getName(), "St. James Place");
		assertEquals(r.getID(), 16);
		assertEquals(r.getBuyPrice(), 180);
		assertEquals(r.getBuildingPrice(), 100);
		assertEquals(r.getRentArray()[0], costs[0]);
		assertEquals(r.getRentArray()[1], costs[1]);
		assertEquals(r.getRentArray()[2], costs[2]);
		assertEquals(r.getRentArray()[3], costs[3]);
		assertEquals(r.getRentArray()[4], costs[4]);
		assertEquals(r.getRentArray()[5], costs[5]);
		assertEquals(r.getRentArray()[6], costs[6]);
		assertEquals(r.getMonopoly()[0], 16);
		assertEquals(r.getMonopoly()[1], 18);
		assertEquals(r.getMonopoly()[2], 19);
	}
	
	@Test
	public void getSquareOnRailroadsAndUtilities(){
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		Board b = new Board(players, icons, 1);
		
		RailroadsAndUtilities u = (RailroadsAndUtilities)b.getSquare(25);
		
		assertEquals(u.getID(), 25);
		assertEquals(u.getName(), "B. & O. Railroad");
		assertEquals(u.getPrice(), 200);
	}
	
	@Test
	public void getNumPlayersTest(){
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		Board b = new Board(players, icons, 1);
		
		assertEquals(b.getNumPlayers(), 2);
	}
	
	@Test
	public void getPlayersTest(){
		String [] players = new String[] {"Dan", "Conor"};
		String [] icons = new  String[] {"Cat", "Dog"};
		Board b = new Board(players, icons, 1);
		
		assertEquals(b.getPlayers()[0].getName(), "Dan");
		assertEquals(b.getPlayers()[0].getPlayerID(), 0);
		assertEquals(b.getPlayers()[0].getIcon(), "Cat");
		assertEquals(b.getPlayers()[1].getName(), "Conor");
		assertEquals(b.getPlayers()[1].getPlayerID(), 1);
		assertEquals(b.getPlayers()[1].getIcon(), "Dog");
	}
	

}
