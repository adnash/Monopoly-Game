package monopolySrc;
// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Monopoly.java

import java.util.Timer;
import java.util.TimerTask;

//There is no test class for Monopoly because its useful methods are private

public class Monopoly {
	
	// Global variables
	//private static int numPlayers;
	
	public static void main(String[] args) {
		// TODO Create instance of UI
		// TODO Get duration, numPlayers and playerNames from UI events from Monopoly start window instead of hard-coding them in
		
		// TODO Depending on what GRASP says, we may want to move the timer into the Board class...
		// This timer will set "timeUp" flag to "true" after the duration (in minutes) has passed
		// We will want to check timeUp after every player turn to see if the game has ended.		
		
		// Call start() method that will create Board and pass it all the relevant details
		startGame();
	}
	
	
	private static void startGame() {
		InitialGUI initialGameGUI = new InitialGUI();
		initialGameGUI.setVisible(true);

	}
	
/*	public int getTimeLeft() {
		return timeLeft;
	}*/
	
}

// Credits:
// Monopoly board image: http://collider.com/monopoly-origins-movie-early-development/ 
// Monopoly logo image: http://logo-share.blogspot.com/2014/11/monopoly-logo.html
// Monopoly icon images: http://coolmaterial.com/feature/the-story-behind-monopoly-pieces/
// Monopoly deed cards: http://monopoly.wikia.com/wiki/Property






