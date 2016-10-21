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

	//Reduce the amount of turns a player has left in jail.
	public void reduceJailTurns(Player p){
		for(int i = 0; i < players.length; i++){
			if(players[i].getPlayerID() == p.getPlayerID()){
				turnsLeft[i] -= 1;
				return;
			}
		}
	}
	
	public boolean isPlayerJailed(Player p){
		for(int i = 0; i < players.length; i++){
			if(players[i].getPlayerID() == p.getPlayerID()){
				return true;
			}
		}
		return false;
	}

	
	public int checkTurnsLeft(Player p){
		for(int i = 0; i < players.length; i++){
			if(players[i].getPlayerID() == p.getPlayerID()){
				return turnsLeft[i];
			}
		}
		return -1;
	}

	
	
	//Set the player's currentSquare to the visiting space.
	private void freePlayer(Player p){
		p.setCurrentSquare(10);
		for(int i = 0; i < players.length; i++){
			if(players[i].getPlayerID() == p.getPlayerID()){
				players[i] = null;
				turnsLeft[i] = 0;
				return;
			}
		}
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
