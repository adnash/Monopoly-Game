// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Square.java



public class Square {

	protected int ID;
	protected String name;
	
	public Square(int ID, String name){
		this.ID = ID;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getID(){
		return ID;
	}
}
