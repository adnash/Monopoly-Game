// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Dice.java

public class Dice {
	
	// global variables
	private int face1;
	private int face2;
	private int numberOfDoublesRolled;
	
	public void Roll(){
		
	}
	
	public int getSum(){
		return face1 + face2;
	}
	
	private boolean isDouble(){
		if(face1 == face2){
			numberOfDoublesRolled++;
			return true;
		}
		return false;
	}

	public int getNumberOfDoublesRolled() {
		return numberOfDoublesRolled;
	}
	
}
