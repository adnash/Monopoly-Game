package monopolySrc;
// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// ScoreboardGIO.java

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

public class ScoreboardGUI extends JFrame {

	private JFrame frame;
	
	private BoardGUI boardGUI;
	private Board board;
	
	private int numplayers;
	
	JLabel time;
	JLabel timesec;
	
	private int duration;
		
	// player balance
	private JLabel player1bal, player2bal, player3bal, player4bal;
	
	// player static icon on the scoreboard
	private JLabel player1icon, player2icon, player3icon, player4icon;
	
	private JLabel player1name, player2name, player3name, player4name;
	
	private JLabel player1properties, player2properties, player3properties, player4properties;
	
	public static void main(String[] args) {
		new ScoreboardGUI(null, null, null, 1);
	}
	

	/**
	 * Create the frame.
	 */
	public ScoreboardGUI(BoardGUI boardGUI, Board board, String[] playericons, int duration) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		this.numplayers = board.getNumPlayers();
		this.board = board;
		this.duration = duration;
		System.out.println(this.duration);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("monopoly-scoreboard.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame("Scoreboard");
		
		frame.setBounds(1000, 0, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setContentPane(new JLabel(new ImageIcon(image)));
		
		frame.setLayout(null);
		
		
		Font font = new Font("Verdana", Font.BOLD, 20);
		
		JLabel label = new JLabel("Current scores");
		label.setBounds(150, 0, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 40));
		frame.add(label);
		
		preScoreboardSetup(playericons, font);
		
		
		frame.pack();
        frame.setVisible(true);
    }	
	
	private void preScoreboardSetup(String[] playericons, Font font){
		
		preStatics();
		
		switch(board.getNumPlayers()){
		case 2:
			pre2Players(playericons, font);
			break;
		case 3:
			pre3Players(playericons, font);
			break;
		case 4:
			pre4Players(playericons, font);
			break;
		}
	}
	
	private void preStatics(){
		JLabel label = new JLabel("Current scores");
		label.setBounds(150, 0, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 40));
		frame.add(label);
		
		label = new JLabel("<html><u>Icons</u></html>");
		label.setBounds(25, 85, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.add(label);
		
		label = new JLabel("<html><u>Name</u></html>");
		label.setBounds(125, 85, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.add(label);
		
		label = new JLabel("<html><u>Balance</u></html>");
		label.setBounds(350, 85, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.add(label);
		
		label = new JLabel("<html><u># of properties</u></html>");
		label.setBounds(500, 85, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.add(label);
		
		label = new JLabel("Minutes remaining:");
		label.setBounds(300, 350, 500, 50);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.add(label);	
		
		time = new JLabel(duration + "");
		time.setBounds(525, 350, 500, 50);
        time.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.add(time);
		
		mintimer.start();
	}
	
	private void updateMinTime(){
        time.setText(duration + "");
        time.setBounds(525, 350, 500, 50);
        time.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.add(time);
	}
	

	
	Timer mintimer = new Timer(1000, new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (duration <= 0) {
	        	//TODO END GAME HERE
	        	System.out.println("if");
	            ((Timer)e.getSource()).stop();
	        } else {
	        	System.out.println("else");
	        	updateMinTime();
	            duration--;
	        }
	        
	    }
	});

	
	private void pre2Players(String[] playericons, Font font){
    	try {			
			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	player1icon.setBounds(20, 125, 50, 50);
        player2icon.setBounds(20, 175, 50, 50);
        frame.add(player1icon);
		frame.add(player2icon);
    	
		if(board.getPlayers()[0].getAI())
			player1name = new JLabel("AI " + board.getPlayers()[0].getName());
		else
			player1name = new JLabel(board.getPlayers()[0].getName());
		
		if(board.getPlayers()[1].getAI())
			player2name = new JLabel("AI " + board.getPlayers()[1].getName());
		else 
			player2name = new JLabel(board.getPlayers()[1].getName());
		
		player1name.setBounds(110, 125, 225, 50);
        player2name.setBounds(110, 175, 225, 50);
        player1name.setForeground(Color.BLUE);
		player2name.setForeground(Color.RED);
		player1name.setFont(font);
		player2name.setFont(font);
        frame.add(player1name);
		frame.add(player2name);
			
		player1bal = new JLabel(board.getPlayers()[0].getBalance() + "");
		player2bal = new JLabel(board.getPlayers()[1].getBalance() + "");
		player1bal.setBounds(350, 125, 100, 50);
        player2bal.setBounds(350, 175, 100, 50);
        player1bal.setFont(font);
		player2bal.setFont(font);
        frame.add(player1bal);
        frame.add(player2bal);
		
		player1properties = new JLabel(board.getPlayers()[0].getPropertiesOwned().size() + "");
		player2properties = new JLabel(board.getPlayers()[1].getPropertiesOwned().size() + "");
		player1properties.setBounds(550, 125, 50, 50);
        player2properties.setBounds(550, 175, 50, 50);
        player1properties.setFont(font);
		player2properties.setFont(font);
        frame.add(player1properties);
        frame.add(player2properties);
    }
    
    private void pre3Players(String[] playericons, Font font){
    	try {			
			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
			player3icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[2] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	player1icon.setBounds(20, 125, 50, 50);
        player2icon.setBounds(20, 175, 50, 50);
        player3icon.setBounds(20, 225, 50, 50);
        frame.add(player1icon);
		frame.add(player2icon);
		frame.add(player3icon);
		
		if(board.getPlayers()[0].getAI())
			player1name = new JLabel("AI " + board.getPlayers()[0].getName());
		else
			player1name = new JLabel(board.getPlayers()[0].getName());
		
		if(board.getPlayers()[1].getAI())
			player2name = new JLabel("AI " + board.getPlayers()[1].getName());
		else 
			player2name = new JLabel(board.getPlayers()[1].getName());
		
		if(board.getPlayers()[2].getAI())
			player3name = new JLabel("AI " + board.getPlayers()[2].getName());
		else
			player3name = new JLabel(board.getPlayers()[2].getName());
		
    	player1name.setBounds(110, 125, 225, 50);
        player2name.setBounds(110, 175, 225, 50);
        player3name.setBounds(110, 225, 225, 50);
        player1name.setForeground(Color.BLUE);
		player2name.setForeground(Color.RED);
		player3name.setForeground(Color.GREEN);
		player1name.setFont(font);
		player2name.setFont(font);
		player3name.setFont(font);
        frame.add(player1name);
		frame.add(player2name);
		frame.add(player3name);
			
		player1bal = new JLabel(board.getPlayers()[0].getBalance() + "");
		player2bal = new JLabel(board.getPlayers()[1].getBalance() + "");
		player3bal = new JLabel(board.getPlayers()[2].getBalance() + "");
		player1bal.setBounds(350, 125, 100, 50);
        player2bal.setBounds(350, 175, 100, 50);
        player3bal.setBounds(350, 225, 100, 50);
        player1bal.setFont(font);
		player2bal.setFont(font);
		player3bal.setFont(font);
        frame.add(player1bal);
        frame.add(player2bal);
        frame.add(player3bal);
		
		player1properties = new JLabel(board.getPlayers()[0].getPropertiesOwned().size() + "");
		player2properties = new JLabel(board.getPlayers()[1].getPropertiesOwned().size() + "");
		player3properties = new JLabel(board.getPlayers()[2].getPropertiesOwned().size() + "");
		player1properties.setBounds(550, 125, 50, 50);
        player2properties.setBounds(550, 175, 50, 50);
        player3properties.setBounds(550, 225, 50, 50);
        player1properties.setFont(font);
		player2properties.setFont(font);
		player3properties.setFont(font);
        frame.add(player1properties);
        frame.add(player2properties);
        frame.add(player3properties);
    }
    
    private void pre4Players(String[] playericons, Font font){
    	try {			
			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
			player3icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[2] + ".png")))));
			player4icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[3] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	player1icon.setBounds(20, 125, 50, 50);
        player2icon.setBounds(20, 175, 50, 50);
        player3icon.setBounds(20, 225, 50, 50);
        player4icon.setBounds(20, 275, 50, 50);
        frame.add(player1icon);
		frame.add(player2icon);
		frame.add(player3icon);
		frame.add(player4icon);
		
		if(board.getPlayers()[0].getAI())
			player1name = new JLabel("AI " + board.getPlayers()[0].getName());
		else
			player1name = new JLabel(board.getPlayers()[0].getName());
		
		if(board.getPlayers()[1].getAI())
			player2name = new JLabel("AI " + board.getPlayers()[1].getName());
		else 
			player2name = new JLabel(board.getPlayers()[1].getName());
		
		if(board.getPlayers()[2].getAI())
			player3name = new JLabel("AI " + board.getPlayers()[2].getName());
		else
			player3name = new JLabel(board.getPlayers()[2].getName());
		
		if(board.getPlayers()[3].getAI())
			player4name = new JLabel("AI " + board.getPlayers()[3].getName());
		else
			player4name = new JLabel(board.getPlayers()[3].getName());
    	
		player1name.setBounds(110, 125, 225, 50);
        player2name.setBounds(110, 175, 225, 50);
        player3name.setBounds(110, 225, 225, 50);
        player4name.setBounds(110, 275, 225, 50);
        player1name.setForeground(Color.BLUE);
		player2name.setForeground(Color.RED);
		player3name.setForeground(Color.GREEN);
		player4name.setForeground(Color.ORANGE);
		player1name.setFont(font);
		player2name.setFont(font);
		player3name.setFont(font);
		player4name.setFont(font);
        frame.add(player1name);
		frame.add(player2name);
		frame.add(player3name);
		frame.add(player4name);
			
		player1bal = new JLabel(board.getPlayers()[0].getBalance() + "");
		player2bal = new JLabel(board.getPlayers()[1].getBalance() + "");
		player3bal = new JLabel(board.getPlayers()[2].getBalance() + "");
		player4bal = new JLabel(board.getPlayers()[3].getBalance() + "");
		player1bal.setBounds(350, 125, 100, 50);
        player2bal.setBounds(350, 175, 100, 50);
        player3bal.setBounds(350, 225, 100, 50);
        player4bal.setBounds(350, 275, 100, 50);
        player1bal.setFont(font);
		player2bal.setFont(font);
		player3bal.setFont(font);
		player4bal.setFont(font);
        frame.add(player1bal);
        frame.add(player2bal);
        frame.add(player3bal);
        frame.add(player4bal);
		
		player1properties = new JLabel(board.getPlayers()[0].getPropertiesOwned().size() + "");
		player2properties = new JLabel(board.getPlayers()[1].getPropertiesOwned().size() + "");
		player3properties = new JLabel(board.getPlayers()[2].getPropertiesOwned().size() + "");
		player4properties = new JLabel(board.getPlayers()[3].getPropertiesOwned().size() + "");
		player1properties.setBounds(550, 125, 50, 50);
        player2properties.setBounds(550, 175, 50, 50);
        player3properties.setBounds(550, 225, 50, 50);
        player4properties.setBounds(550, 275, 50, 50);
        player1properties.setFont(font);
		player2properties.setFont(font);
		player3properties.setFont(font);
		player4properties.setFont(font);
        frame.add(player1properties);
        frame.add(player2properties);
        frame.add(player3properties);
        frame.add(player4properties);
    }
    
    private void updatePlayer1Balance(){
    	player1bal.setText(board.getPlayers()[0].getBalance() + "");
		frame.add(player1bal);
    }
    
	private void updatePlayer2Balance(){
		player2bal.setText(board.getPlayers()[1].getBalance() + "");
		frame.add(player2bal);
	    }
	
	private void updatePlayer3Balance(){
		player3bal.setText(board.getPlayers()[2].getBalance() + "");
		frame.add(player3bal);
	}
	
	private void updatePlayer4Balance(){
		player4bal.setText(board.getPlayers()[3].getBalance() + "");
		frame.add(player4bal);
	}
	
	private void updatePlayer1Properties(){
    	player1properties.setText(board.getPlayers()[0].getPropertiesOwned().size() + "");
		frame.add(player1properties);
    }
    
	private void updatePlayer2Properties(){
		player2properties.setText(board.getPlayers()[1].getPropertiesOwned().size() + "");
		frame.add(player2properties);
	}
	
	private void updatePlayer3Properties(){
		player3properties.setText(board.getPlayers()[2].getPropertiesOwned().size() + "");
		frame.add(player3properties);
	}
	
	private void updatePlayer4Properties(){
		player4properties.setText(board.getPlayers()[3].getPropertiesOwned().size() + "");
		frame.add(player4properties);
	}
	
	public void update(){
		// Updating the players balances and properties owned
    	switch(numplayers){
    	case 2:
    		updatePlayer1Balance();
    		updatePlayer2Balance();
    		
    		updatePlayer1Properties();
    		updatePlayer2Properties();
    		break;
    	case 3:
    		updatePlayer1Balance();
    		updatePlayer2Balance();
    		updatePlayer3Balance();
    		
    		updatePlayer1Properties();
    		updatePlayer2Properties();
    		updatePlayer3Properties();
    		break;
    	case 4:
    		updatePlayer1Balance();
    		updatePlayer2Balance();
    		updatePlayer3Balance();
    		updatePlayer4Balance();
    		
    		updatePlayer1Properties();
    		updatePlayer2Properties();
    		updatePlayer3Properties();
    		updatePlayer4Properties();
    		break;
    	}
	}
	public void setGUI(BoardGUI GUI){
		this.boardGUI = GUI;
	}
}









