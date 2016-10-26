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

	private JLabel player1bal;
	private JLabel player2bal;
	private JLabel player3bal;
	private JLabel player4bal;
	
	private JLabel player1icon;
	private JLabel player2icon;
	private JLabel player3icon;
	private JLabel player4icon;
	
	private JLabel die1;
	private JLabel die2;
	
	
	private int newSpace;
	
	
	private int player_turn = 0;
	
	public static void main(String[] args) {
        new BoardGUI(4, new String[]{"bob","joe","shannon","beth"},new String[]{"Cat","Shoe","Battleship","Thimble"});
    }
	
	private int x(){
		return 80 * ((newSpace - 1) % 10);
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
                    
                    Font font = new Font("Verdana", Font.BOLD, 20);
                    
                    // setting the player icons
                    switch (numPlayers) {
            		case 2:
            			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			
            			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			
            			player1bal = new JLabel(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
            			player2bal = new JLabel(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
            			
            			player1.setBounds(870, 870, 50, 50);;
                        frame.add(player1);
                        player2.setBounds(950, 870, 50, 50);;
                        frame.add(player2);
                        
                        player1icon.setBounds(450, 125, 50, 50);
                        frame.add(player1icon);
                        player2icon.setBounds(400, 150, 50, 50);
                        frame.add(player2icon);
                        
                        player1bal.setBounds(500, 125, 300, 50);
                        player1bal.setFont(font);
                        frame.add(player1bal);
                        player2bal.setBounds(500, 150, 300, 50);
                        player2bal.setFont(font);
                        frame.add(player2bal);
            			break;
            		case 3:
            			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			player3 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[2] + ".png")))));
            			
            			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			player3icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[2] + ".png")))));
            			
            			player1bal = new JLabel(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
            			player2bal = new JLabel(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
            			player3bal = new JLabel(board.getPlayers()[2].getName() + "'s balance: " + board.getPlayers()[2].getBalance());
            			
            			player1.setBounds(870, 870, 50, 50);;
                        frame.add(player1);
                        player2.setBounds(950, 870, 50, 50);;
                        frame.add(player2);
                        player3.setBounds(870, 950, 50, 50);;
                        frame.add(player3);
                        
                        player1icon.setBounds(450, 125, 50, 50);
                        frame.add(player1icon);
                        player2icon.setBounds(400, 150, 50, 50);
                        frame.add(player2icon);
                        player3icon.setBounds(450, 175, 50, 50);
                        frame.add(player3icon);
                        
                        player1bal.setBounds(500, 125, 300, 50);
                        player1bal.setFont(font);
                        frame.add(player1bal);
                        player2bal.setBounds(500, 150, 300, 50);
                        player2bal.setFont(font);
                        frame.add(player2bal);
                        player3bal.setBounds(500, 175, 300, 50);
                        player3bal.setFont(font);
                        frame.add(player3bal);
            			break;
            		case 4:
            			player1 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			player3 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[2] + ".png")))));
            			player4 = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[3] + ".png")))));
            			
            			player1icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[0] + ".png")))));
            			player2icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[1] + ".png")))));
            			player3icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[2] + ".png")))));
            			player4icon = new JLabel(new ImageIcon(ImageIO.read((new File("monopoly-" + playericons[3] + ".png")))));
            			
            			player1bal = new JLabel(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
            			player2bal = new JLabel(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
            			player3bal = new JLabel(board.getPlayers()[2].getName() + "'s balance: " + board.getPlayers()[2].getBalance());
            			player4bal = new JLabel(board.getPlayers()[3].getName() + "'s balance: " + board.getPlayers()[3].getBalance());
            			
            			player1.setBounds(870, 870, 50, 50);;
                        frame.add(player1);
                        player2.setBounds(950, 870, 50, 50);;
                        frame.add(player2);
                        player3.setBounds(870, 950, 50, 50);;
                        frame.add(player3);
                        player4.setBounds(950, 950, 50, 50);;
                        frame.add(player4);
                        
                        player1icon.setBounds(450, 125, 50, 50);
                        frame.add(player1icon);
                        player2icon.setBounds(400, 150, 50, 50);
                        frame.add(player2icon);
                        player3icon.setBounds(450, 175, 50, 50);
                        frame.add(player3icon);
                        player4icon.setBounds(400, 200, 50, 50);
                        frame.add(player4icon);
                        
                        player1bal.setBounds(500, 125, 300, 50);
                        player1bal.setFont(font);
                        frame.add(player1bal);
                        player2bal.setBounds(500, 150, 300, 50);
                        player2bal.setFont(font);
                        frame.add(player2bal);
                        player3bal.setBounds(500, 175, 300, 50);
                        player3bal.setFont(font);
                        frame.add(player3bal);
                        player4bal.setBounds(500, 200, 300, 50);
                        player4bal.setFont(font);
                        frame.add(player4bal);
            			break;
            		}
                    
                    
                    die1 = new JLabel("Die 1:    " + board.dice.getFace1());
                    die2 = new JLabel("Die 2:    " + board.dice.getFace2());
                    die1.setFont(font);
                    die2.setFont(font);
                    die1.setBounds(400, 675, 125, 50);
    				die2.setBounds(400, 700, 125, 50);
    				frame.add(die1);
    				frame.add(die2);
                    
                    JButton roll = new JButton("ROLL");
            		roll.setFont(new Font("PT Sans", Font.BOLD, 50));
            		roll.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				
            				board.gamePlay(player_turn);
            				newSpace = board.getPlayers()[player_turn].getCurrentSquare();
            				if(newSpace == 0){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(870, 870, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(950, 870, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(870, 950, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(950, 950, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace >= 1 && newSpace <= 9){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(775 - x(), 900, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(810 - x(), 900, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(775 - x(), 950, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(810 - x(), 950, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace == 10){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(0, 870, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(0, 920, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(30, 950, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(80, 950, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace >= 11 && newSpace <= 19){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(0, 780 - x(), 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(50, 780 - x(), 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(0, 810 - x(), 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(50, 810 - x(), 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace == 20){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(0, 0, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(80, 0, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(0, 80, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(80, 80, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace >= 21 && newSpace <= 29){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(130 + x(), 0, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(160 + x(), 0, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(130 + x(), 50, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(160 + x(), 50, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace == 30){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(870, 0, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(950, 0, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(870, 80, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(950, 80, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace >= 31 && newSpace <= 39){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(900, 130 + x(), 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(950, 130 + x(), 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(900, 160 + x(), 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(950, 160 + x(), 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else if(newSpace == 40){
            					switch(player_turn){
            					case 0:
            						player1.setBounds(35, 870, 50, 50);;
                                    frame.add(player1);
            						break;
            					case 1:
                                    player2.setBounds(85, 870, 50, 50);;
                                    frame.add(player2);
            						break;
            					case 2:
                                    player3.setBounds(30, 915, 50, 50);;
                                    frame.add(player3);
            						break;
            					case 3:
                                    player4.setBounds(80, 915, 50, 50);;
                                    frame.add(player4);
            						break;
            					}
            				}else{
            					//should never get here
            				}
            				
            				switch(numPlayers){
            				case 2:
            					player1bal.setText(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
                    			player2bal.setText(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
                    			frame.add(player1bal);
                    			frame.add(player2bal);
            					break;
            				case 3:
            					player1bal.setText(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
                    			player2bal.setText(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
                    			player3bal.setText(board.getPlayers()[2].getName() + "'s balance: " + board.getPlayers()[2].getBalance());
                    			frame.add(player1bal);
                    			frame.add(player2bal);
                    			frame.add(player3bal);
            					break;
            				case 4:
                    			player1bal.setText(board.getPlayers()[0].getName() + "'s balance: " + board.getPlayers()[0].getBalance());
                    			player2bal.setText(board.getPlayers()[1].getName() + "'s balance: " + board.getPlayers()[1].getBalance());
                    			player3bal.setText(board.getPlayers()[2].getName() + "'s balance: " + board.getPlayers()[2].getBalance());
                    			player4bal.setText(board.getPlayers()[3].getName() + "'s balance: " + board.getPlayers()[3].getBalance());
                    			frame.add(player1bal);
                    			frame.add(player2bal);
                    			frame.add(player3bal);
                    			frame.add(player4bal);
            					break;
            				}

            				
            				player_turn = (player_turn+1)%numPlayers;
            				
            				die1.setText("Die 1:    " + board.dice.getFace1());
                            die2.setText("Die 2:    " + board.dice.getFace2());
            				frame.add(die1);
            				frame.add(die2);
            				//TODO figure out how to update GUI after resolvesquare
            				
            				frame.revalidate();
            				frame.repaint();
            			}
            		});
            		roll.setBounds(400, 750, 200, 100);
            		frame.add(roll);
            		
            		
                    
//                    player1.setBounds(900, 130, 50, 50);;
//                    frame.add(player1);
//                    
//                    player2.setBounds(950, 130, 50, 50);;
//                    frame.add(player2);
//                    
//                    player3.setBounds(900, 160, 50, 50);;
//                    frame.add(player3);
//                    
//                    player4.setBounds(950, 160, 50, 50);;
//                    frame.add(player4);


                                      


                  frame.pack();
                  frame.setVisible(true);
              } catch (IOException exp) {
                  exp.printStackTrace();
              }
            }
        });
    }
}
