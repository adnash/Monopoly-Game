package monopolySrc;
// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// BoardGUI.java

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BoardGUI extends JFrame{
	
	private Board board;
	private JFrame frame;
	
	// movable player icon
	private JLabel player1, player2, player3, player4;
	
	// dice
	private JLabel die1, die2;
	
	// number of houses on each property
	private JButton houses1, houses3, houses6, houses8, houses9, houses11, houses13, houses14, houses16, houses18, houses19, houses21, houses23, houses24, houses26, houses27, houses29, houses31, houses32, houses34, houses37, houses39;
	
	private JButton RR1, RR2, RR3, RR4;
	
	private JButton util1, util2;
	
	private int newSpace;
	
	private int numplayers;
	
	private int player_turn = 0;
		
	private ScoreboardGUI scoreboard;
	
	private static int tempduration = 1;
	
	Font font = new Font("Verdana", Font.BOLD, 20);
	
	public static void main(String[] args) {
		Board temp = new Board(new String[]{"bob","joe","shannon","beth"},new String[]{"Cat","Shoe","Battleship","Thimble"}, new Object[]{"", null, "", null}, tempduration);
        BoardGUI tempGUI = new BoardGUI(null, 4, temp, new String[]{"Cat","Shoe","Battleship","Thimble"});
        temp.setGUI(tempGUI);
    }
	
	private int x(){
		return 80 * ((newSpace - 1) % 10);
	}
	
	public Board getBoard(){
		return board;
	}

    public BoardGUI(ScoreboardGUI scoreboard, int numPlayers, Board board, String[] playericons) {
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	
    	//temp scoreboard
    	scoreboard = new ScoreboardGUI(this, board, playericons, tempduration);
    	this.scoreboard = scoreboard;
    	this.numplayers = numPlayers;	
    	this.board = board;
    	    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                	JFrame.setDefaultLookAndFeelDecorated(true);
                	
                    // Load the background image
                    BufferedImage monopolyImage = ImageIO.read(new File("monopoly-board.png"));
                    
                    // Create the frame...
                    frame = new JFrame("The Game Of Monopoly");
                    frame.setBounds(0, 0, 1000, 1000);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Set the frames content pane to use a JLabel
                    // whose icon property has been set to use the image
                    // we just loaded                        
                    frame.setContentPane(new JLabel(new ImageIcon(monopolyImage)));

                    // Supply a layout manager for the body of the content
                    frame.setLayout(null);
                    
                    // Sets up the board and all of the initial values
                    // Very important method
                    preBoardSetup(numplayers, playericons, font);
                    
                    
                    JButton roll = new JButton("ROLL");
            		roll.setFont(new Font("Verdana", Font.BOLD, 50));
            		roll.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				
            				// Calls the turn controller in board. Runs basically the whole game
            				board.gamePlay(player_turn);
            				
            				// Gets the new space that the player is one and moves them there
            				newSpace = board.getPlayers()[player_turn].getCurrentSquare();
            				
            				// This is the dynamic update method
            				// Anytime it is called it will update the board with fresh information
            				// It is public because any method outside this class needs to call it in order to update the board.
            				// Just call this method FUCKING EVERYWHERE and we should be good
            				update();
            				
            				
            				// update the players turn
            				updatePlayerTurn();
            				
            				frame.revalidate();
            				frame.repaint();
            			}
            		});
            		roll.setBounds(400, 750, 200, 100);
            		frame.add(roll);
            		
            		ArrayList<Integer> spaces = new ArrayList<Integer>();
            		for (int i = 0; i < 40; i++) {
						spaces.add(i);
					}
            		
            		// creates the hidden button on Start that can be used to specify where you want the player to move
            		JButton hidden = new JButton();
            		hidden.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				Object s = JOptionPane.showInputDialog(frame, "Hello " + board.getPlayers()[player_turn].getName() + ", where would you like to move?", "SECRET MOVE", JOptionPane.PLAIN_MESSAGE, null, spaces.toArray(), "no");
            				int tempSpace = Integer.parseInt(s.toString());
            				
            				board.getPlayers()[player_turn].setCurrentSquare(tempSpace);
            				board.resolveSquare(board.getPlayers()[player_turn], tempSpace);
            				
            				newSpace = board.getPlayers()[player_turn].getCurrentSquare();
            				
            				update();
            			}
            		});
            		hidden.setOpaque(false);
            		hidden.setContentAreaFilled(false);
            		hidden.setBorderPainted(false);
            		hidden.setBounds(870, 870, 130, 130);
            		frame.add(hidden);
            		
            		
            		
                  frame.pack();
                  frame.setVisible(true);
              } catch (IOException exp) {
                  exp.printStackTrace();
              }
            }
        });
    }
    
    private void updatePlayerTurn(){
    	player_turn = (player_turn+1)%numplayers;
    }
    
    private void updateDice(){
    	die1.setText("Die 1:    " + board.dicegetFace1());
        die2.setText("Die 2:    " + board.dicegetFace2());
		frame.add(die1);
		frame.add(die2);
    }
    
    private void updateHouses(){
    	if(((RealEstate)board.getSquare(1)).getOwnerID() == 0)
    	      houses1.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(1)).getOwnerID() == 1)
    	      houses1.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(1)).getOwnerID() == 2)
    	      houses1.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(1)).getOwnerID() == 3)
    	      houses1.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(1)).getIsMortgaged())
    	    houses1.setText("M");
    	else
    	    houses1.setText(((RealEstate)board.getSquare(1)).getNumBuildings() + "");
    	houses1.setFont(font);
    	houses1.setBounds(815, 870, 30, 30);
    	frame.add(houses1);

    	if(((RealEstate)board.getSquare(3)).getOwnerID() == 0)
    	      houses3.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(3)).getOwnerID() == 1)
    	      houses3.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(3)).getOwnerID() == 2)
    	      houses3.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(3)).getOwnerID() == 3)
    	      houses3.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(3)).getIsMortgaged())
    	    houses1.setText("M");
    	else
    	    houses1.setText(((RealEstate)board.getSquare(3)).getNumBuildings() + "");
    	houses3.setFont(font);
    	houses3.setBounds(655, 870, 30, 30);
    	frame.add(houses3);

    	if(((RailroadsAndUtilities)board.getSquare(5)).getOwnerID() == 0)
    	    RR1.setForeground(Color.BLUE);
    	else if(((RailroadsAndUtilities)board.getSquare(5)).getOwnerID() == 1)
    		RR1.setForeground(Color.RED);
    	else if(((RailroadsAndUtilities)board.getSquare(5)).getOwnerID() == 2)
    		RR1.setForeground(Color.GREEN);
    	else if(((RailroadsAndUtilities)board.getSquare(5)).getOwnerID() == 3)
    		RR1.setForeground(Color.ORANGE);
    	if(((RailroadsAndUtilities)board.getSquare(5)).isMortgaged())
    	    RR1.setText("M");
    	else
    	    RR1.setText("*");
    	RR1.setFont(font);
    	RR1.setBounds(500, 870, 30, 30);
    	frame.add(RR1);

    	if(((RealEstate)board.getSquare(6)).getOwnerID() == 0)
    	      houses6.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(6)).getOwnerID() == 1)
    	      houses6.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(6)).getOwnerID() == 2)
    	      houses6.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(6)).getOwnerID() == 3)
    	      houses6.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(6)).getIsMortgaged())
    	    houses6.setText("M");
    	else
    	    houses6.setText(((RealEstate)board.getSquare(6)).getNumBuildings() + "");
    	houses6.setFont(font);
    	houses6.setBounds(415, 870, 30, 30);
    	frame.add(houses6);

    	if(((RealEstate)board.getSquare(8)).getOwnerID() == 0)
    	      houses8.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(8)).getOwnerID() == 1)
    	      houses8.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(8)).getOwnerID() == 2)
    	      houses8.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(8)).getOwnerID() == 3)
    	      houses8.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(8)).getIsMortgaged())
    	    houses8.setText("M");
    	else
    	    houses8.setText(((RealEstate)board.getSquare(8)).getNumBuildings() + "");
    	houses8.setFont(font);
    	houses8.setBounds(255, 870, 30, 30);
    	frame.add(houses8);

    	if(((RealEstate)board.getSquare(9)).getOwnerID() == 0)
    	      houses9.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(9)).getOwnerID() == 1)
    	      houses9.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(9)).getOwnerID() == 2)
    	      houses9.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(9)).getOwnerID() == 3)
    	      houses9.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(9)).getIsMortgaged())
    	    houses9.setText("M");
    	else
    	    houses9.setText(((RealEstate)board.getSquare(9)).getNumBuildings() + "");
    	houses9.setFont(font);
    	houses9.setBounds(175, 870, 30, 30);
    	frame.add(houses9);

    	if(((RealEstate)board.getSquare(11)).getOwnerID() == 0)
    	      houses11.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(11)).getOwnerID() == 1)
    	      houses11.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(11)).getOwnerID() == 2)
    	      houses11.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(11)).getOwnerID() == 3)
    	      houses11.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(11)).getIsMortgaged())
    	    houses11.setText("M");
    	else
    	    houses11.setText(((RealEstate)board.getSquare(11)).getNumBuildings() + "");
    	houses11.setFont(font);
    	houses11.setBounds(100, 800, 30, 30);
    	frame.add(houses11);

    	if(((RailroadsAndUtilities)board.getSquare(12)).getOwnerID() == 0)
    	    util1.setForeground(Color.BLUE);
    	else if(((RailroadsAndUtilities)board.getSquare(12)).getOwnerID() == 1)
    		util1.setForeground(Color.RED);
    	else if(((RailroadsAndUtilities)board.getSquare(12)).getOwnerID() == 2)
    		util1.setForeground(Color.GREEN);
    	else if(((RailroadsAndUtilities)board.getSquare(12)).getOwnerID() == 3)
    		util1.setForeground(Color.ORANGE);
    	if(((RailroadsAndUtilities)board.getSquare(12)).isMortgaged())
    	    util1.setText("M");
    	else
    	    util1.setText("*");
    	util1.setFont(font);
    	util1.setBounds(100, 725, 30, 30);
    	frame.add(util1);

    	if(((RealEstate)board.getSquare(13)).getOwnerID() == 0)
    	      houses13.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(13)).getOwnerID() == 1)
    	      houses13.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(13)).getOwnerID() == 2)
    	      houses13.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(13)).getOwnerID() == 3)
    	      houses13.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(13)).getIsMortgaged())
    	    houses13.setText("M");
    	else
    	    houses13.setText(((RealEstate)board.getSquare(13)).getNumBuildings() + "");
    	houses13.setFont(font);
    	houses13.setBounds(100, 640, 30, 30);
    	frame.add(houses13);

    	if(((RealEstate)board.getSquare(14)).getOwnerID() == 0)
    	      houses14.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(14)).getOwnerID() == 1)
    	      houses14.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(14)).getOwnerID() == 2)
    	      houses14.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(14)).getOwnerID() == 3)
    	      houses14.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(14)).getIsMortgaged())
    	    houses14.setText("M");
    	else
    	    houses14.setText(((RealEstate)board.getSquare(14)).getNumBuildings() + "");
    	houses14.setFont(font);
    	houses14.setBounds(100, 560, 30, 30);
    	frame.add(houses14);

    	if(((RailroadsAndUtilities)board.getSquare(15)).getOwnerID() == 0)
    	    RR2.setForeground(Color.BLUE);
    	else if(((RailroadsAndUtilities)board.getSquare(15)).getOwnerID() == 1)
    		RR2.setForeground(Color.RED);
    	else if(((RailroadsAndUtilities)board.getSquare(15)).getOwnerID() == 2)
    		RR2.setForeground(Color.GREEN);
    	else if(((RailroadsAndUtilities)board.getSquare(15)).getOwnerID() == 3)
    		RR2.setForeground(Color.ORANGE);
    	if(((RailroadsAndUtilities)board.getSquare(15)).isMortgaged())
    	    RR2.setText("M");
    	else
    	    RR2.setText("*");
    	RR2.setFont(font);
    	RR2.setBounds(100, 475, 30, 30);
    	frame.add(RR2);

    	if(((RealEstate)board.getSquare(16)).getOwnerID() == 0)
    	      houses16.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(16)).getOwnerID() == 1)
    	      houses16.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(16)).getOwnerID() == 2)
    	      houses16.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(16)).getOwnerID() == 3)
    	      houses16.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(16)).getIsMortgaged())
    	    houses16.setText("M");
    	else
    	    houses16.setText(((RealEstate)board.getSquare(16)).getNumBuildings() + "");
    	houses16.setFont(font);
    	houses16.setBounds(100, 400, 30, 30);
    	frame.add(houses16);

    	if(((RealEstate)board.getSquare(18)).getOwnerID() == 0)
    	      houses18.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(18)).getOwnerID() == 1)
    	      houses18.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(18)).getOwnerID() == 2)
    	      houses18.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(18)).getOwnerID() == 3)
    	      houses18.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(18)).getIsMortgaged())
    	    houses18.setText("M");
    	else
    	    houses18.setText(((RealEstate)board.getSquare(18)).getNumBuildings() + "");
    	houses18.setFont(font);
    	houses18.setBounds(100, 240, 30, 30);
    	frame.add(houses18);

    	if(((RealEstate)board.getSquare(19)).getOwnerID() == 0)
    	      houses19.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(19)).getOwnerID() == 1)
    	      houses19.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(19)).getOwnerID() == 2)
    	      houses19.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(19)).getOwnerID() == 3)
    	      houses19.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(19)).getIsMortgaged())
    	    houses19.setText("M");
    	else
    	    houses19.setText(((RealEstate)board.getSquare(19)).getNumBuildings() + "");
    	houses19.setFont(font);
    	houses19.setBounds(100, 160, 30, 30);
    	frame.add(houses19);

    	if(((RealEstate)board.getSquare(21)).getOwnerID() == 0)
    	      houses21.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(21)).getOwnerID() == 1)
    	      houses21.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(21)).getOwnerID() == 2)
    	      houses21.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(21)).getOwnerID() == 3)
    	      houses21.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(21)).getIsMortgaged())
    	    houses21.setText("M");
    	else
    	    houses21.setText(((RealEstate)board.getSquare(21)).getNumBuildings() + "");
    	houses21.setFont(font);
    	houses21.setBounds(160, 100, 30, 30);
    	frame.add(houses21);

    	if(((RealEstate)board.getSquare(23)).getOwnerID() == 0)
    	      houses23.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(23)).getOwnerID() == 1)
    	      houses23.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(23)).getOwnerID() == 2)
    	      houses23.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(23)).getOwnerID() == 3)
    	      houses23.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(23)).getIsMortgaged())
    	    houses23.setText("M");
    	else
    	    houses23.setText(((RealEstate)board.getSquare(23)).getNumBuildings() + "");
    	houses23.setFont(font);
    	houses23.setBounds(320, 100, 30, 30);
    	frame.add(houses23);

    	if(((RealEstate)board.getSquare(24)).getOwnerID() == 0)
    	      houses24.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(24)).getOwnerID() == 1)
    	      houses24.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(24)).getOwnerID() == 2)
    	      houses24.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(24)).getOwnerID() == 3)
    	      houses24.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(24)).getIsMortgaged())
    	    houses24.setText("M");
    	else
    	    houses24.setText(((RealEstate)board.getSquare(24)).getNumBuildings() + "");
    	houses24.setFont(font);
    	houses24.setBounds(400, 100, 30, 30);
    	frame.add(houses24);

    	if(((RailroadsAndUtilities)board.getSquare(25)).getOwnerID() == 0)
    	    RR3.setForeground(Color.BLUE);
    	else if(((RailroadsAndUtilities)board.getSquare(25)).getOwnerID() == 1)
    		RR3.setForeground(Color.RED);
    	else if(((RailroadsAndUtilities)board.getSquare(25)).getOwnerID() == 2)
    		RR3.setForeground(Color.GREEN);
    	else if(((RailroadsAndUtilities)board.getSquare(25)).getOwnerID() == 3)
    		RR3.setForeground(Color.ORANGE);
    	if(((RailroadsAndUtilities)board.getSquare(25)).isMortgaged())
    	    RR3.setText("M");
    	else
    	    RR3.setText("*");
    	RR3.setFont(font);
    	RR3.setBounds(475, 100, 30, 30);
    	frame.add(RR3);

    	if(((RealEstate)board.getSquare(26)).getOwnerID() == 0)
    	      houses26.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(26)).getOwnerID() == 1)
    	      houses26.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(26)).getOwnerID() == 2)
    	      houses26.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(26)).getOwnerID() == 3)
    	      houses26.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(26)).getIsMortgaged())
    	    houses26.setText("M");
    	else
    	    houses26.setText(((RealEstate)board.getSquare(26)).getNumBuildings() + "");
    	houses26.setFont(font);
    	houses26.setBounds(560, 100, 30, 30);
    	frame.add(houses26);

    	if(((RealEstate)board.getSquare(27)).getOwnerID() == 0)
    	      houses27.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(27)).getOwnerID() == 1)
    	      houses27.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(27)).getOwnerID() == 2)
    	      houses27.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(27)).getOwnerID() == 3)
    	      houses27.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(27)).getIsMortgaged())
    	    houses27.setText("M");
    	else
    	    houses27.setText(((RealEstate)board.getSquare(27)).getNumBuildings() + "");
    	houses27.setFont(font);
    	houses27.setBounds(640, 100, 30, 30);
    	frame.add(houses27);

    	if(((RailroadsAndUtilities)board.getSquare(28)).getOwnerID() == 0)
    	    util2.setForeground(Color.BLUE);
    	else if(((RailroadsAndUtilities)board.getSquare(28)).getOwnerID() == 1)
    		util2.setForeground(Color.RED);
    	else if(((RailroadsAndUtilities)board.getSquare(28)).getOwnerID() == 2)
    		util2.setForeground(Color.GREEN);
    	else if(((RailroadsAndUtilities)board.getSquare(28)).getOwnerID() == 3)
    		util2.setForeground(Color.ORANGE);
    	if(((RailroadsAndUtilities)board.getSquare(28)).isMortgaged())
    	    util2.setText("M");
    	else
    	    util2.setText("*");
    	util2.setFont(font);
    	util2.setBounds(725, 100, 30, 30);
    	frame.add(util2);

    	if(((RealEstate)board.getSquare(29)).getOwnerID() == 0)
    	      houses29.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(29)).getOwnerID() == 1)
    	      houses29.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(29)).getOwnerID() == 2)
    	      houses29.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(29)).getOwnerID() == 3)
    	      houses29.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(29)).getIsMortgaged())
    	    houses29.setText("M");
    	else
    	    houses29.setText(((RealEstate)board.getSquare(29)).getNumBuildings() + "");
    	houses29.setFont(font);
    	houses29.setBounds(800, 100, 30, 30);
    	frame.add(houses29);

    	if(((RealEstate)board.getSquare(31)).getOwnerID() == 0)
    	      houses31.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(31)).getOwnerID() == 1)
    	      houses31.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(31)).getOwnerID() == 2)
    	      houses31.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(31)).getOwnerID() == 3)
    	      houses31.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(31)).getIsMortgaged())
    	    houses31.setText("M");
    	else
    	    houses31.setText(((RealEstate)board.getSquare(31)).getNumBuildings() + "");
    	houses31.setFont(font);
    	houses31.setBounds(870, 160, 30, 30);
    	frame.add(houses31);

    	if(((RealEstate)board.getSquare(32)).getOwnerID() == 0)
    	      houses32.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(32)).getOwnerID() == 1)
    	      houses32.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(32)).getOwnerID() == 2)
    	      houses32.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(32)).getOwnerID() == 3)
    	      houses32.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(32)).getIsMortgaged())
    	    houses32.setText("M");
    	else
    	    houses32.setText(((RealEstate)board.getSquare(32)).getNumBuildings() + "");
    	houses32.setFont(font);
    	houses32.setBounds(870, 240, 30, 30);
    	frame.add(houses32);

    	if(((RealEstate)board.getSquare(34)).getOwnerID() == 0)
    	      houses34.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(34)).getOwnerID() == 1)
    	      houses34.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(34)).getOwnerID() == 2)
    	      houses34.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(34)).getOwnerID() == 3)
    	      houses34.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(34)).getIsMortgaged())
    	    houses34.setText("M");
    	else
    	    houses34.setText(((RealEstate)board.getSquare(34)).getNumBuildings() + "");
    	houses34.setFont(font);
    	houses34.setBounds(870, 400, 30, 30);
    	frame.add(houses34);

    	if(((RailroadsAndUtilities)board.getSquare(35)).getOwnerID() == 0)
    	    RR4.setForeground(Color.BLUE);
    	else if(((RailroadsAndUtilities)board.getSquare(35)).getOwnerID() == 1)
    		RR4.setForeground(Color.RED);
    	else if(((RailroadsAndUtilities)board.getSquare(35)).getOwnerID() == 2)
    		RR4.setForeground(Color.GREEN);
    	else if(((RailroadsAndUtilities)board.getSquare(35)).getOwnerID() == 3)
    		RR4.setForeground(Color.ORANGE);
    	if(((RailroadsAndUtilities)board.getSquare(35)).isMortgaged())
    	    RR4.setText("M");
    	else
    	    RR4.setText("*");
    	RR4.setFont(font);
    	RR4.setBounds(870, 475, 30, 30);
    	frame.add(RR4);

    	if(((RealEstate)board.getSquare(37)).getOwnerID() == 0)
    	      houses37.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(37)).getOwnerID() == 1)
    	      houses37.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(37)).getOwnerID() == 2)
    	      houses37.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(37)).getOwnerID() == 3)
    	      houses37.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(37)).getIsMortgaged())
    	    houses37.setText("M");
    	else
    	    houses37.setText(((RealEstate)board.getSquare(37)).getNumBuildings() + "");
    	houses37.setFont(font);
    	houses37.setBounds(870, 640, 30, 30);
    	frame.add(houses37);

    	if(((RealEstate)board.getSquare(39)).getOwnerID() == 0)
    	      houses39.setForeground(Color.BLUE);
    	else if(((RealEstate)board.getSquare(39)).getOwnerID() == 1)
    	      houses39.setForeground(Color.RED);
    	else if(((RealEstate)board.getSquare(39)).getOwnerID() == 2)
    	      houses39.setForeground(Color.GREEN);
    	else if(((RealEstate)board.getSquare(39)).getOwnerID() == 3)
    	      houses39.setForeground(Color.ORANGE);
    	if(((RealEstate)board.getSquare(39)).getIsMortgaged())
    	    houses39.setText("M");
    	else
    	    houses39.setText(((RealEstate)board.getSquare(39)).getNumBuildings() + "");
    	houses39.setFont(font);
    	houses39.setBounds(870, 800, 30, 30);
    	frame.add(houses39);

    }
    
    private void updatePlayer1Location(){
    	System.out.println("in here");
    	if(newSpace == 0){
    		player1.setBounds(870, 870, 50, 50);            
    	}else if(newSpace >= 1 && newSpace <= 9){
    		player1.setBounds(775 - x(), 900, 50, 50);
    	}else if(newSpace == 10){
    		player1.setBounds(0, 870, 50, 50);
    	}else if(newSpace >= 11 && newSpace <= 19){
    		player1.setBounds(0, 780 - x(), 50, 50);
    	}else if(newSpace == 20){
    		player1.setBounds(0, 0, 50, 50);
    	}else if(newSpace >= 21 && newSpace <= 29){
    		player1.setBounds(130 + x(), 0, 50, 50);
    	}else if(newSpace == 30){
    		player1.setBounds(870, 0, 50, 50);
    	}else if(newSpace >= 31 && newSpace <= 39){
    		player1.setBounds(900, 130 + x(), 50, 50);
    	}else if(newSpace == 40){
    		player1.setBounds(35, 870, 50, 50);
    	}
    	frame.add(player1);
    }

    private void updatePlayer2Location(){
    	if(newSpace == 0){
    		player2.setBounds(950, 870, 50, 50);;
    	}else if(newSpace >= 1 && newSpace <= 9){
    		player2.setBounds(810 - x(), 900, 50, 50);;
    	}else if(newSpace == 10){
    		player2.setBounds(0, 920, 50, 50);;
    	}else if(newSpace >= 11 && newSpace <= 19){
    		player2.setBounds(50, 780 - x(), 50, 50);;
    	}else if(newSpace == 20){
    		player2.setBounds(80, 0, 50, 50);;
    	}else if(newSpace >= 21 && newSpace <= 29){
    		player2.setBounds(160 + x(), 0, 50, 50);;
    	}else if(newSpace == 30){
    		player2.setBounds(950, 0, 50, 50);;
    	}else if(newSpace >= 31 && newSpace <= 39){
    		player2.setBounds(950, 130 + x(), 50, 50);;
    	}else if(newSpace == 40){
    		player2.setBounds(85, 870, 50, 50);;
    	}
    	frame.add(player2);
    }

    private void updatePlayer3Location(){
    	if(newSpace == 0){
    		player3.setBounds(870, 950, 50, 50);;
    	}else if(newSpace >= 1 && newSpace <= 9){
    		player3.setBounds(775 - x(), 950, 50, 50);;
    	}else if(newSpace == 10){
    		player3.setBounds(30, 950, 50, 50);;
    	}else if(newSpace >= 11 && newSpace <= 19){
    		player3.setBounds(0, 810 - x(), 50, 50);;
    	}else if(newSpace == 20){
    		player3.setBounds(0, 80, 50, 50);;
    	}else if(newSpace >= 21 && newSpace <= 29){
    		player3.setBounds(130 + x(), 50, 50, 50);;
    	}else if(newSpace == 30){
    		player3.setBounds(870, 80, 50, 50);;
    	}else if(newSpace >= 31 && newSpace <= 39){
    		player3.setBounds(900, 160 + x(), 50, 50);;
    	}else if(newSpace == 40){
    		player3.setBounds(30, 915, 50, 50);;
    	}
    	frame.add(player3);
    }

    private void updatePlayer4Location(){
    	if(newSpace == 0){
    		player4.setBounds(950, 950, 50, 50);;
    	}else if(newSpace >= 1 && newSpace <= 9){
    		player4.setBounds(810 - x(), 950, 50, 50);;
    	}else if(newSpace == 10){
    		player4.setBounds(80, 950, 50, 50);;
    	}else if(newSpace >= 11 && newSpace <= 19){
    		player4.setBounds(50, 810 - x(), 50, 50);;
    	}else if(newSpace == 20){
    		player4.setBounds(80, 80, 50, 50);;
    	}else if(newSpace >= 21 && newSpace <= 29){
    		player4.setBounds(160 + x(), 50, 50, 50);;
    	}else if(newSpace == 30){
    		player4.setBounds(950, 80, 50, 50);;
    	}else if(newSpace >= 31 && newSpace <= 39){
    		player4.setBounds(950, 160 + x(), 50, 50);;
    	}else if(newSpace == 40){
    		player4.setBounds(80, 915, 50, 50);;
    	}
    	frame.add(player4);
    }
    
    private void preBoardSetup(int numPlayers, String[] playericons, Font font){
    	switch (numPlayers) {
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
    	 
    	preSquareSetup(font);
    	
    	preDiceSetup(font);
    }
    
    private void preDiceSetup(Font font){
    	die1 = new JLabel("Die 1:    " + board.dicegetFace1());
        die2 = new JLabel("Die 2:    " + board.dicegetFace2());
        die1.setFont(font);
        die2.setFont(font);
        die1.setBounds(400, 675, 125, 50);
		die2.setBounds(400, 700, 125, 50);
		frame.add(die1);
		frame.add(die2);
    }
    
    private void preSquareSetup(Font font){
    	// adding counters for the number of houses on spaces with default 0
    	houses1 = new JButton("0");
    	houses1.setFont(font);
    	houses1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			JDialog dialog = new JDialog();
    			JLabel label = new JLabel( new ImageIcon("deeds/1.png") );
    			dialog.setBounds(1000, 500, 100, 100);
    			dialog.add(label);
    			dialog.pack();
    			dialog.setVisible(true);
    		}
    	});
    	houses1.setBorder(null);
    	houses1.setBounds(815, 870, 30, 30);
    	frame.add(houses1);

    	houses3 = new JButton("0");
    	houses3.setFont(font);
    	houses3.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/3.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses3.setBorder(null);
    	houses3.setBounds(655, 870, 30, 30);
    	frame.add(houses3);

    	RR1 = new JButton("*");
    	RR1.setFont(font);
    	RR1.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/5.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	RR1.setBorder(null);
    	RR1.setBounds(500, 870, 30, 30);
    	frame.add(RR1);

    	houses6 = new JButton("0");
    	houses6.setFont(font);
    	houses6.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/6.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses6.setBorder(null);
    	houses6.setBounds(415, 870, 30, 30);
    	frame.add(houses6);

    	houses8 = new JButton("0");
    	houses8.setFont(font);
    	houses8.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/8.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses8.setBorder(null);
    	houses8.setBounds(255, 870, 30, 30);
    	frame.add(houses8);

    	houses9 = new JButton("0");
    	houses9.setFont(font);
    	houses9.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/9.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses9.setBorder(null);
    	houses9.setBounds(175, 870, 30, 30);
    	frame.add(houses9);

    	houses11 = new JButton("0");
    	houses11.setFont(font);
    	houses11.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/11.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses11.setBorder(null);
    	houses11.setBounds(100, 800, 30, 30);
    	frame.add(houses11);

    	util1 = new JButton("*");
    	util1.setFont(font);
    	util1.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/12.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	util1.setBorder(null);
    	util1.setBounds(100, 725, 30, 30);
    	frame.add(util1);        

    	houses13 = new JButton("0");
    	houses13.setFont(font);
    	houses13.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/13.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses13.setBorder(null);
    	houses13.setBounds(100, 640, 30, 30);
    	frame.add(houses13);

    	houses14 = new JButton("0");
    	houses14.setFont(font);
    	houses14.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/14.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses14.setBorder(null);
    	houses14.setBounds(100, 560, 30, 30);
    	frame.add(houses14);

    	RR2 = new JButton("*");
    	RR2.setFont(font);
    	RR2.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/15.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	RR2.setBorder(null);
    	RR2.setBounds(100, 475, 30, 30);
    	frame.add(RR2);

    	houses16 = new JButton("0");
    	houses16.setFont(font);
    	houses16.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/16.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses16.setBorder(null);
    	houses16.setBounds(100, 400, 30, 30);
    	frame.add(houses16);

    	houses18 = new JButton("0");
    	houses18.setFont(font);
    	houses18.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/18.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses18.setBorder(null);
    	houses18.setBounds(100, 240, 30, 30);
    	frame.add(houses18);

    	houses19 = new JButton("0");
    	houses19.setFont(font);
    	houses19.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/19.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses19.setBorder(null);
    	houses19.setBounds(100, 160, 30, 30);
    	frame.add(houses19);

    	houses21 = new JButton("0");
    	houses21.setFont(font);
    	houses21.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/21.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses21.setBorder(null);
    	houses21.setBounds(160, 100, 30, 30);
    	frame.add(houses21);

    	houses23 = new JButton("0");
    	houses23.setFont(font);
    	houses23.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/23.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses23.setBorder(null);
    	houses23.setBounds(320, 100, 30, 30);
    	frame.add(houses23);

    	houses24 = new JButton("0");
    	houses24.setFont(font);
    	houses24.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/24.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses24.setBorder(null);
    	houses24.setBounds(400, 100, 30, 30);
    	frame.add(houses24);

    	RR3 = new JButton("*");
    	RR3.setFont(font);
    	RR3.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/25.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	RR3.setBorder(null);
    	RR3.setBounds(475, 100, 30, 30);
    	frame.add(RR3);

    	houses26 = new JButton("0");
    	houses26.setFont(font);
    	houses26.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/26.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses26.setBorder(null);
    	houses26.setBounds(560, 100, 30, 30);
    	frame.add(houses26);

    	houses27 = new JButton("0");
    	houses27.setFont(font);
    	houses27.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/27.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses27.setBorder(null);
    	houses27.setBounds(640, 100, 30, 30);
    	frame.add(houses27);

    	util2 = new JButton("*");
    	util2.setFont(font);
    	util2.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/28.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	util2.setBorder(null);
    	util2.setBounds(725, 100, 30, 30);
    	frame.add(util2);

    	houses29 = new JButton("0");
    	houses29.setFont(font);
    	houses29.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/29.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses29.setBorder(null);
    	houses29.setBounds(800, 100, 30, 30);
    	frame.add(houses29);

    	houses31 = new JButton("0");
    	houses31.setFont(font);
    	houses31.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/31.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses31.setBorder(null);
    	houses31.setBounds(870, 160, 30, 30);
    	frame.add(houses31);

    	houses32 = new JButton("0");
    	houses32.setFont(font);
    	houses32.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/32.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses32.setBorder(null);
    	houses32.setBounds(870, 240, 30, 30);
    	frame.add(houses32);

    	houses34 = new JButton("0");
    	houses34.setFont(font);
    	houses34.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/34.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses34.setBorder(null);
    	houses34.setBounds(870, 400, 30, 30);
    	frame.add(houses34);

    	RR4 = new JButton("*");
    	RR4.setFont(font);
    	RR4.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/35.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	RR4.setBorder(null);
    	RR4.setBounds(870, 475, 30, 30);
    	frame.add(RR4);

    	houses37 = new JButton("0");
    	houses37.setFont(font);
    	houses37.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/37.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses37.setBorder(null);
    	houses37.setBounds(870, 640, 30, 30);
    	frame.add(houses37);

    	houses39 = new JButton("0");
    	houses39.setFont(font);
    	houses39.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        JDialog dialog = new JDialog();
    	        JLabel label = new JLabel( new ImageIcon("deeds/39.png") );
    	        dialog.setBounds(1000, 500, 100, 100);
    	        dialog.add(label);
    	        dialog.pack();
    	        dialog.setVisible(true);
    	    }
    	});
    	houses39.setBorder(null);
    	houses39.setBounds(870, 800, 30, 30);
    	frame.add(houses39);

    }
    
    private void pre2Players(String[] playericons, Font font){
    	try {
			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		player1.setBounds(870, 870, 50, 50);
        frame.add(player1);
        player2.setBounds(950, 870, 50, 50);
        frame.add(player2);
    }
    
    private void pre3Players(String[] playericons, Font font){
    	try {
			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
			player3 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[2] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player1.setBounds(870, 870, 50, 50);;
        frame.add(player1);
        player2.setBounds(950, 870, 50, 50);;
        frame.add(player2);
        player3.setBounds(870, 950, 50, 50);;
        frame.add(player3);
    }
    
    private void pre4Players(String[] playericons, Font font){
    	try {
			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[0] + ".png")))));
			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[1] + ".png")))));
			player3 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[2] + ".png")))));
			player4 = new JLabel(new ImageIcon(ImageIO.read((new File("logos/monopoly-" + playericons[3] + ".png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player1.setBounds(870, 870, 50, 50);;
        frame.add(player1);
        player2.setBounds(950, 870, 50, 50);;
        frame.add(player2);
        player3.setBounds(870, 950, 50, 50);;
        frame.add(player3);
        player4.setBounds(950, 950, 50, 50);;
        frame.add(player4);
    }
    
    
    
    public void update(){
    	
    	scoreboard.update();
    	
    	// Updating the location of the players
    	switch(player_turn){
		case 0:
			updatePlayer1Location();
			break;
		case 1:
			updatePlayer2Location();
			break;
		case 2:
			updatePlayer3Location();
			break;
		case 3:
			updatePlayer4Location();
			break;
		}
    	
    	updateHouses();
    	
    	updateDice();
    	
    	
    }
    public void setGUI(ScoreboardGUI GUI){
		this.scoreboard = GUI;
	}
    
    
    
    
    
    
    
    
    
}
