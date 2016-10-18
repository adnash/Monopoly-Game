// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Jail.java

import java.util.Arrays;

public class Jail extends Square {

	private Player[] players;
	private int[] turnsLeft;
	
	public Jail(int ID, String name) {
		super(ID, name);
		
		//4 because that's the max players
		Player[] players = new Player[4];
		int[] turnsLeft = new int[4];
		Arrays.fill(players, null);
		Arrays.fill(turnsLeft, 0);
	}

	//Reduce the amount of turns each player has left in jail.
	//If the value reaches 0, free the player from jail.
	public void reduceJailTurns(){
		for(int i = 0; i < turnsLeft.length; i++){
			if(turnsLeft[i] > 0){
				turnsLeft[i]--;
			}
			if(turnsLeft[i] == 0){
				freePlayer(players[i]);
				players[i] = null;
			}
		}
	}

	//Set the player's currentSquare to the visiting space.
	private void freePlayer(Player p){
		p.setCurrentSquare(10);
	}

	//Spaces with value null in players[i] means it is an open space for jail.
	//Players sent to jail will replace the null values.
	//The turnsLeft array tells how many turns they have left in jail.
	//A value of zero means a player should be freed.
	public void addPlayer(Player p){
		for(int i = 0; i < players.length; i++){
			if(players[i] == null){
				players[i] = p;
				turnsLeft[i] = 2;
				return;
			}
		}
	}

}
