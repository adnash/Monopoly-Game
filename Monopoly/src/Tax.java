// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Tax.java


public class Tax extends Square {

	public Tax(int ID, String name) {
		super(ID, name);
	}
	
	// With Income_Tax a player must pay either 10% of their cash or $200.
	// In our case the system will automatically choose the best (lowest) amount to pay.
	// The Luxury_Tax is always $100.
	public int payTax(Player player) {
		if (name.equals("Income Tax")) {
			if (player.getBalance() > 2000) {
				// TODO We should use the decreaseBalance() method here as it will account for if the balance becomes negative
				player.setBalance(player.getBalance() - 200);
				// Returning their new balance(not the shoes) --- Hah!
				return player.getBalance();
			} else {
				// Easier to use setBalance() than decreaseBalance() here
				player.setBalance((int)(player.getBalance() * .9));
				// Returning their new balance(not the shoes)
				return player.getBalance();
			}
		}
		
		// TODO We might want to specifically check for the square's name instead of leaving it to an else statement. Could prevent a weird bug.
		//Luxury Tax
		else {
			// TODO Should probably use decreaseBalance() method
			player.setBalance(player.getBalance() - 100);
			return player.getBalance();
		}
	}
}
