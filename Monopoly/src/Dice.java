// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Dice.java

import java.util.Random;

public class Dice {
	
	// global variables
	private int face1;
	private int face2;
	private int numberOfDoublesRolled;
	
	public void Dice(){
		numberOfDoublesRolled = 0;
	}
	
	public void Roll(){
		Random rand = new Random();

		face1 = rand.nextInt(6) + 1;
		face2 = rand.nextInt(6) + 1;
		
		// prepares the number of doubles rolled for next turn
		if(!isDouble()){
			numberOfDoublesRolled = 0;
		}else{
			numberOfDoublesRolled++;
		}
	}
	
	public int getSum(){
		return face1 + face2;
	}
	
	public boolean isDouble(){
		if(face1 == face2){
			return true;
		}
		return false;
	}
	
	public void resetDoubles(){
		numberOfDoublesRolled = 0;
	}

	public int getNumberOfDoublesRolled() {
		return numberOfDoublesRolled;
	}
	
}
