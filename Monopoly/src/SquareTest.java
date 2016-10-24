import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

	@Test
	public void getIDTest() {
		Square s = new Square(1, "test");
		
		assertEquals(1, s.getID());
	}
	
	@Test
	public void getNameTest() {
		Square s = new Square(1, "test");
		
		assertEquals("test", s.getName());
	}

}
