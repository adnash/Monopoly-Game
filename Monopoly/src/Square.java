
public class Square {

	protected int ID;
	protected String name;
	
	public Square(int ID, String name){
		this.ID = ID;
		this.name = name;
	}
	
	String getName(){
		return name;
	}
	
	int getID(){
		return ID;
	}
}
