
public class Go extends Square {

	public Go(int ID, String name) {
		super(ID, name);
		
	}
	
	//Give the player $200.
	void give(Player p){
		p.setBalance(p.getBalance() + 200);
	}

}
