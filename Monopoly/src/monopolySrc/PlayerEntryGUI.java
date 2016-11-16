package monopolySrc;
// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// PlayerEntryGUI.java

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class PlayerEntryGUI extends JFrame {

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	
	private JComboBox time;
	
	private int duration;
		
	private JComboBox<String> player1icon;
	private JComboBox<String> player2icon;
	private JComboBox<String> player3icon;
	private JComboBox<String> player4icon;
		
	private JPanel contentPane;
	private JButton start;	
	
	private String[] playernames;
	private String[] playericons;
	
	private Board board;
	private TurnControler TC;
	private BoardGUI boardGUI;
	private ScoreboardGUI scoreboard;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerEntryGUI frame = new PlayerEntryGUI(4);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerEntryGUI(int numPlayers) {
		start(numPlayers, this);
	}		
	
	public void start(int numPlayers, PlayerEntryGUI gui){
		this.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setTitle("Player Entry!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 500);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout GridBagLayout = new GridBagLayout();
		GridBagLayout.columnWeights = new double[]{0.0, 1.0};
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(GridBagLayout);
		
		c.ipadx = 0;
		c.ipady = 0;
		
		// Creates the username fields
		text1 = new JTextField();
		text1.setText("Player 1 Name");
		text1.setColumns(10);
		c.gridx = 0;
		c.gridy = 0;
		GridBagLayout.setConstraints(text1, c);
		
		text2 = new JTextField();
		text2.setText("Player 2 Name");
		text2.setColumns(10);
		c.gridx = 0;
		c.gridy = 1;
		GridBagLayout.setConstraints(text2, c);
		
		text3 = new JTextField();
		text3.setText("Player 3 Name");
		text3.setColumns(10);
		c.gridx = 0;
		c.gridy = 2;
		GridBagLayout.setConstraints(text3, c);
		
		text4 = new JTextField();
		text4.setText("Player 4 Name");
		text4.setColumns(10);
		c.gridx = 0;
		c.gridy = 3;
		GridBagLayout.setConstraints(text4, c);
		
		
		String[] iconList = new String[]{"Battleship","Cat","Race-Car","Scottie-Dog","Shoe","Thimble","Top-Hat","Wheelbarrow"};
		
		// Creates the icon fields
		player1icon = new JComboBox(iconList);
		c.gridx = 1;
		c.gridy = 0;
		GridBagLayout.setConstraints(player1icon, c);
		
		player2icon = new JComboBox(iconList);
		c.gridx = 1;
		c.gridy = 1;
		GridBagLayout.setConstraints(player2icon, c);
		
		player3icon = new JComboBox(iconList);
		c.gridx = 1;
		c.gridy = 2;
		GridBagLayout.setConstraints(player3icon, c);
		
		player4icon = new JComboBox(iconList);
		c.gridx = 1;
		c.gridy = 3;
		GridBagLayout.setConstraints(player4icon, c);
		
		String[] timeList = new String[]{"5","10","15","20","30","45","60","120"};
		
	    JLabel label1 = new JLabel("Select game duration(minutes):");
	    c.gridx = 2;
	    c.gridy = 3;
	    GridBagLayout.setConstraints(label1, c);
	    
		time = new JComboBox(timeList);
		c.gridx = 3;
		c.gridy = 3;
		GridBagLayout.setConstraints(time, c);
	    

		contentPane.add(label1);
		contentPane.add(time);
		
		switch (numPlayers) {
		case 2:
			contentPane.add(text1);
			contentPane.add(text2);
			contentPane.add(player1icon);
			contentPane.add(player2icon);
			break;
		case 3:
			contentPane.add(text1);
			contentPane.add(text2);
			contentPane.add(text3);
			contentPane.add(player1icon);
			contentPane.add(player2icon);
			contentPane.add(player3icon);
			break;
		case 4:
			contentPane.add(text1);
			contentPane.add(text2);
			contentPane.add(text3);
			contentPane.add(text4);
			contentPane.add(player1icon);
			contentPane.add(player2icon);
			contentPane.add(player3icon);
			contentPane.add(player4icon);
			break;
		}
		
		playernames = new String[numPlayers];
		playericons = new String[numPlayers];

		// creates the go button
		start = new JButton("Start Game!");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
				switch (numPlayers) {
				case 2:
					if(!player1icon.getSelectedItem().equals(player2icon.getSelectedItem())){
						playernames[0] = text1.getText();
						playernames[1] = text2.getText();
						playericons[0] = player1icon.getSelectedItem().toString();
						playericons[1] = player2icon.getSelectedItem().toString();
						String temp = time.getSelectedItem().toString();
						duration = Integer.parseInt(temp);
						if(duration > 0){
							board = new Board(playernames, playericons, duration);
							TC = new TurnControler(board);
							boardGUI = new BoardGUI(scoreboard, numPlayers, board, playericons, TC);
							scoreboard = new ScoreboardGUI(boardGUI, board, playericons, duration);
							
							boardGUI.setGUI(scoreboard);
							scoreboard.setGUI(boardGUI);
							board.setGUI(boardGUI);
						}
						gui.dispose();
					}else{
						JOptionPane.showMessageDialog(contentPane, "Every player must choose an icon and all user icons must be unique");
					}
					break;
				case 3:
					if(!player1icon.getSelectedItem().equals(player2icon.getSelectedItem()) && !player1icon.getSelectedItem().equals(player3icon.getSelectedItem()) && !player2icon.getSelectedItem().equals(player3icon.getSelectedItem())){
						playernames[0] = text1.getText();
						playernames[1] = text2.getText();
						playernames[2] = text3.getText();
						playericons[0] = player1icon.getSelectedItem().toString();
						playericons[1] = player2icon.getSelectedItem().toString();
						playericons[2] = player3icon.getSelectedItem().toString();
						String temp = time.getSelectedItem().toString();
						duration = Integer.parseInt(temp);
						if(duration > 0){
							board = new Board(playernames, playericons, duration);
							TC = new TurnControler(board);
							boardGUI = new BoardGUI(scoreboard, numPlayers, board, playericons, TC);
							scoreboard = new ScoreboardGUI(boardGUI, board, playericons, duration);
							
							boardGUI.setGUI(scoreboard);
							scoreboard.setGUI(boardGUI);
							board.setGUI(boardGUI);
						}
						gui.dispose();
					}else{
						JOptionPane.showMessageDialog(contentPane, "Every player must choose an icon and all user icons must be unique");
					}
					break;
				case 4:
					if(!player1icon.getSelectedItem().equals(player2icon.getSelectedItem()) && !player1icon.getSelectedItem().equals(player3icon.getSelectedItem()) && !player2icon.getSelectedItem().equals(player3icon.getSelectedItem()) && !player1icon.getSelectedItem().equals(player4icon.getSelectedItem()) && !player2icon.getSelectedItem().equals(player4icon.getSelectedItem()) && !player3icon.getSelectedItem().equals(player4icon.getSelectedItem())){
						playernames[0] = text1.getText();
						playernames[1] = text2.getText();
						playernames[2] = text3.getText();
						playernames[3] = text4.getText();
						playericons[0] = player1icon.getSelectedItem().toString();
						playericons[1] = player2icon.getSelectedItem().toString();
						playericons[2] = player3icon.getSelectedItem().toString();
						playericons[3] = player4icon.getSelectedItem().toString();
						String temp = time.getSelectedItem().toString();
						duration = Integer.parseInt(temp);
						if(duration > 0){
							board = new Board(playernames, playericons, duration);
							TC = new TurnControler(board);
							boardGUI = new BoardGUI(scoreboard, numPlayers, board, playericons, TC);
							scoreboard = new ScoreboardGUI(boardGUI, board, playericons, duration);
							
							boardGUI.setGUI(scoreboard);
							scoreboard.setGUI(boardGUI);
							board.setGUI(boardGUI);
						}
						gui.dispose();
					}else{
						JOptionPane.showMessageDialog(contentPane, "Every player must choose an icon and all user icons must be unique");
					}
					break;
				}				
			}
		});
		c.gridx = 0;
		c.gridy = 5;
		c.ipadx = 50;
		c.ipady = 50;
		contentPane.add(start, c);	
	}
	
	
}