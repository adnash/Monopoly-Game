// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// ScoreboardGIO.java

package monopolySrc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class ScoreboardGUI extends JFrame {

	private JFrame frame;
	
	private BoardGUI boardGUI;
	private Board board;
		
	// player balance
	private JLabel player1bal, player2bal, player3bal, player4bal;
	
	// player static icon on the scoreboard
	private JLabel player1icon, player2icon, player3icon, player4icon;
	
	public static void main(String[] args) {
		new ScoreboardGUI(null, null, null);
	}
		

	/**
	 * Create the frame.
	 */
	public ScoreboardGUI(BoardGUI boardGUI, Board board, String[] playericons) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		this.board = board;
		this.boardGUI = boardGUI;
		
		frame = new JFrame("Scoreboard");
		
		frame.setBounds(1000, 0, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);
		
		
		Font font = new Font("Verdana", Font.BOLD, 20);
		
		JLabel label = new JLabel("test");
		label.setBounds(50, 50, 50, 50);
		frame.add(label);
		
		preScoreboardSetup(playericons, font);
		
		
		frame.pack();
        frame.setVisible(true);
    }	
	
	private void preScoreboardSetup(String[] playericons, Font font){
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
	
	private void pre2Players(String[] playericons, Font font){
    	try {			
			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		player1bal = new JLabel(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
		player2bal = new JLabel(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
        
        player1icon.setBounds(450, 125, 50, 50);
        frame.add(player1icon);
        player2icon.setBounds(400, 150, 50, 50);
        frame.add(player2icon);
        
        player1bal.setBounds(500, 125, 400, 50);
        player1bal.setFont(font);
        player2bal.setBounds(500, 150, 400, 50);
        player2bal.setFont(font);
        
        player1bal.setForeground(Color.BLUE);
		player2bal.setForeground(Color.RED);
		
        frame.add(player1bal);
        frame.add(player2bal);
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
		
		player1bal = new JLabel(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
		player2bal = new JLabel(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
		player3bal = new JLabel(board.getPlayers()[2].getName() + "'s balance: " + board.getPlayers()[2].getBalance());
		
        player1icon.setBounds(450, 125, 50, 50);
        frame.add(player1icon);
        player2icon.setBounds(400, 150, 50, 50);
        frame.add(player2icon);
        player3icon.setBounds(450, 175, 50, 50);
        frame.add(player3icon);
        
        player1bal.setBounds(500, 125, 400, 50);
        player1bal.setFont(font);
        player2bal.setBounds(500, 150, 400, 50);
        player2bal.setFont(font);
        player3bal.setBounds(500, 175, 400, 50);
        player3bal.setFont(font);
        
        player1bal.setForeground(Color.BLUE);
		player2bal.setForeground(Color.RED);
		player3bal.setForeground(Color.GREEN);
		
        frame.add(player1bal);
        frame.add(player2bal);
        frame.add(player3bal);
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
    	
    	player1bal = new JLabel(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
		player2bal = new JLabel(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
		player3bal = new JLabel(board.getPlayers()[2].getName() + "'s balance: " + board.getPlayers()[2].getBalance());
		player4bal = new JLabel(board.getPlayers()[3].getName() + "'s balance: " + board.getPlayers()[3].getBalance());
		
        player1icon.setBounds(450, 125, 50, 50);
        frame.add(player1icon);
        player2icon.setBounds(400, 150, 50, 50);
        frame.add(player2icon);
        player3icon.setBounds(450, 175, 50, 50);
        frame.add(player3icon);
        player4icon.setBounds(400, 200, 50, 50);
        frame.add(player4icon);
        
        player1bal.setBounds(500, 125, 400, 50);
        player1bal.setFont(font);
        
        player2bal.setBounds(500, 150, 400, 50);
        player2bal.setFont(font);
        
        player3bal.setBounds(500, 175, 400, 50);
        player3bal.setFont(font);
        
        player4bal.setBounds(500, 200, 400, 50);
        player4bal.setFont(font);
        
        player1bal.setForeground(Color.BLUE);
		player2bal.setForeground(Color.RED);
		player3bal.setForeground(Color.GREEN);
		player4bal.setForeground(Color.GRAY);
		
        frame.add(player1bal);
        frame.add(player2bal);
        frame.add(player3bal);
        frame.add(player4bal);
    }
}









