package monopolyTests;
import static org.junit.Assert.*;

import org.junit.Test;

import monopolySrc.Dice;

public class DiceTest {

	@Test
	public void correctConstructionTest(){
		Dice d = new Dice();

		assertEquals(0, d.getFace1());
		assertEquals(0, d.getFace2());
		assertEquals(0, d.getNumberOfDoublesRolled());
	}
	
	@Test
	public void rollNoDoublesTest(){
		Dice d = new Dice();

		do{
			d.Roll();
		}while(d.getFace1() == d.getFace2());
		
		assertNotEquals(0, d.getFace1());
		assertNotEquals(0, d.getFace2());
		assertNotEquals(d.getFace1(), d.getFace2());
		assertEquals(0, d.getNumberOfDoublesRolled());
	}
	
	@Test
	public void rollDoublesTest(){
		Dice d = new Dice();

		do{
			d.Roll();
		}while(d.getFace1() != d.getFace2());
		
		assertNotEquals(0, d.getFace1());
		assertNotEquals(0, d.getFace2());
		assertEquals(d.getFace1(), d.getFace2());
		assertEquals(1, d.getNumberOfDoublesRolled());
	}
	
	@Test
	public void getFace1Test() {
		Dice d = new Dice();
		
		assertEquals(0, d.getFace1());
	}
	
	@Test
	public void getFace2Test() {
		Dice d = new Dice();
		
		assertEquals(0, d.getFace2());
	}
	
	@Test
	public void getSumTest(){
		Dice d = new Dice();

		d.Roll();
		int one = d.getFace1();
		int two = d.getFace2();
		
		assertEquals((one + two), d.getSum());
	}
	
	@Test
	public void isDoubleTestOnNondoubles(){
		Dice d = new Dice();

		do{
			d.Roll();
		}while(d.getFace1() == d.getFace2());
		
		assertFalse(d.isDouble());
	}
	
	@Test
	public void isDoubleTestOnDoubles(){
		Dice d = new Dice();

		do{
			d.Roll();
		}while(d.getFace1() != d.getFace2());
		
		assertTrue(d.isDouble());
	}
	
	@Test
	public void getNumberOfDoublesRolledWithNoRolledDoubles(){
		Dice d = new Dice();

		do{
			d.Roll();
		}while(d.getFace1() == d.getFace2());
		
		assertEquals(0, d.getNumberOfDoublesRolled());
	}
	
	@Test
	public void getNumberOfDoublesRolledWithRolledDoubles(){
		Dice d = new Dice();

		do{
			d.Roll();
		}while(d.getFace1() != d.getFace2());
		
		assertEquals(1, d.getNumberOfDoublesRolled());
	}
	
	@Test
	public void resetDoublesWithNoDoubles(){
		Dice d = new Dice();
		
		d.resetDoubles();
		
		assertEquals(0, d.getNumberOfDoublesRolled());
	}
	
	@Test
	public void resetDoublesWithRolledDoubles(){
		Dice d = new Dice();
		
		do{
			d.Roll();
		}while(d.getFace1() != d.getFace2());
		d.resetDoubles();
		
		assertEquals(0, d.getNumberOfDoublesRolled());
	}

}
