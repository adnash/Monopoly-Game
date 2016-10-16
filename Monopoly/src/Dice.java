// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Dice.java

public class Dice {
	
	// global variables
	int face1;
	int face2;
	int numberOfDoublesRolled;
	
	
	
	public void Roll(){
		
	}
	
	private int getSum(){
		return face1 + face2;
	}
	
	private boolean isDouble(){
		return face1 == face2;
	}
}
