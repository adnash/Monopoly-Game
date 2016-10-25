// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// BoardGUI.java

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoardGUI extends JFrame{
	
	private Board board;
	private JLabel player1;
	private JLabel player2;
	private JLabel player3;
	private JLabel player4;
	private int player_turn = 0;
	
	public static void main(String[] args) {
        new BoardGUI(2, new String[]{"bob","joe"},new String[]{"Cat","Shoe"});
    }

    public BoardGUI(int numPlayers, String[] playernames, String[] playericons) {
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	
    	board = new Board(playernames, playericons);
    	
//    	ScoreboardGUI scoreboard = new ScoreboardGUI(board);
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                	JFrame.setDefaultLookAndFeelDecorated(true);
                    // Load the background image
                    BufferedImage monopolyImage = ImageIO.read(new File("monopoly.png"));
                    
                    // Create the frame...
                    JFrame frame = new JFrame("The Game Of Monopoly");
                    frame.setBounds(0, 0, 1000, 1000);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Set the frames content pane to use a JLabel
                    // whose icon property has been set to use the image
                    // we just loaded                        
                    frame.setContentPane(new JLabel(new ImageIcon(monopolyImage)));

                    // Supply a layout manager for the body of the content
                    frame.setLayout(null);
                    
                    // setting the player icons
                    switch (numPlayers) {
            		case 2:
            			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			break;
            		case 3:
            			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			player3 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[2] + ".png")))));

            			break;
            		case 4:
            			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			player3 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[2] + ".png")))));
            			player4 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[3] + ".png")))));
            			break;
            		}
                    
                    JButton roll = new JButton("ROLL");
            		roll.setFont(new Font("PT Sans", Font.BOLD, 50));
            		roll.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				board.gamePlay(player_turn);
            				player_turn = (player_turn+1)%numPlayers;
            				
            				
            				
            				//TODO figure out how to update GUI after resolvesquare
            				
            				
            			}
            		});
            		roll.setBounds(400, 700, 200, 100);
            		frame.add(roll);
                    
                    player1.setBounds(100, 100, 50, 50);;
                    frame.add(player1);
                    player2.setBounds(500, 500, 50, 50);;
                    frame.add(player2);


                                      


                  frame.pack();
                  frame.setVisible(true);
              } catch (IOException exp) {
                  exp.printStackTrace();
              }
            }
        });
    }
}
