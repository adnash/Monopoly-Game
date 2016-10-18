
public class Tax extends Square {

	public Tax(int ID, String name) {
		super(ID, name);
	}
	
	//In the income tax a player must pay either 10% of their cash or $200.
	//In our case the system will automatically choose the best amount to pay.
	//The luxury tax is always $100.
	public int payTax(Player p){
		if(name.equals("Income Tax")){
			if(p.getBalance() > 2000){
				p.setBalance(p.getBalance() - 200);
				//returning their new balance(not the shoes)
				return p.getBalance();
			}
			else{
				p.setBalance((int)(p.getBalance() * .9));
				//returning their new balance(not the shoes)
				return p.getBalance();
			}
		}
		//Luxury Tax
		else{
			p.setBalance(p.getBalance() - 100);
			//returning their new balance(not the shoes)
			return p.getBalance();
		}
	}

}
