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

		// 4 because that's the max players Monopoly can have
		players = new Player[4];
		turnsLeft = new int[4];
		Arrays.fill(players, null);
		Arrays.fill(turnsLeft, 0);
	}

	// Spaces with value null in players[i] means it is an open space for jail.
	// Players sent to jail will replace the null values.
	// The turnsLeft array tells how many turns they have left in jail.
	// A value of zero means a player should be freed.
	public void addPlayer(Player player) {
		for (int i = 0; i < players.length; i++) {
			if (players[i] == null) {
				players[i] = player;
				turnsLeft[i] = 2;
				return;
			}
		}
	}

	// Reduce the amount of turns a player has left in jail
	public void reduceJailTurns(Player player) {
		for (int i = 0; i < players.length; i++) {
			if(players[i] != null){
				if (players[i].getPlayerID() == player.getPlayerID()) {
					turnsLeft[i] -= 1;
					return;
				}
			}
		}
	}

	public boolean isPlayerJailed(Player player) {
		for (int i = 0; i < players.length; i++)  {
			if(players[i] != null){
				if (players[i].getPlayerID() == player.getPlayerID()) {
					return true;
				}
			}
		}
		return false;
	}

	public int checkTurnsLeft(Player player) {
		for (int i = 0; i < players.length; i++) {
			if(players[i] != null){
				if (players[i].getPlayerID() == player.getPlayerID()) {
					return turnsLeft[i];
				}
			}
		}
		// Player isn't in jail!
		return -1;
	}

	// Removes the player from "Jail" and sets the player's currentSquare to "Just_Visiting"
	public void freePlayer(Player player) {
		for (int i = 0; i < players.length; i++) {
			if(players[i] != null){
				if (players[i].getPlayerID() == player.getPlayerID()) {
					player.setCurrentSquare(10);
					players[i] = null;
					turnsLeft[i] = 0;
					return;
				}
			}
		}
	}

	//This method has been added for testing
	public Player[] getPlayers(){
		return players;
	}

	//This method has been added for testing
	public int[] getTurnsLeft(){
		return turnsLeft;
	}
}
