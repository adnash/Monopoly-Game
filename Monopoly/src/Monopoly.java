// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// Monopoly.java

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Monopoly {
	
	// global variables
	int numPlayers;
	static int duration;
	static Timer timer = new Timer();
	Time timeLeft;

	static boolean timeUp = false;
	
	public Time getTimeLeft() {
		return timeLeft;
	}

	public static void main(String[] args) {
		duration = 60;
		System.out.println("hi");
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				timeUp = true;
			}
		}, duration*60*1000);
	}
	
	private void start(){
		
	}
}
