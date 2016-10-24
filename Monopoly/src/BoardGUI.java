// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// BoardGUI.java

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoardGUI {
	private Board board;

	public static void main(String[] args) {
        new BoardGUI(2, new String[]{"bob","joe"},new String[]{"Cat","Shoe"});
    }

    public BoardGUI(int numPlayers, String[] playernames, String[] playericons) {
    	
    	board = new Board(playernames, playericons);
    	
    	ScoreboardGUI scoreboard = new ScoreboardGUI(board);
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Load the background image
                    BufferedImage monopolyImage = ImageIO.read(new File("monopoly.png"));
                    
                    // Load the icons
                    BufferedImage dogImage = ImageIO.read(new File("monopoly-shoe.png"));
                    BufferedImage catImage = ImageIO.read(new File("monopoly-cat.png"));
                    BufferedImage shoeImage = ImageIO.read(new File("monopoly-shoe.png"));
                    BufferedImage carImage = ImageIO.read(new File("monopoly-race-car.png"));
                    BufferedImage shipImage = ImageIO.read(new File("monopoly-battleship.png"));
                    BufferedImage hatImage = ImageIO.read(new File("monopoly-top-hat.png"));
                    BufferedImage thimbleImage = ImageIO.read(new File("monopoly-thimble.png"));
                    BufferedImage wheelbarrowImage = ImageIO.read(new File("monopoly-wheelbarrow.png"));

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
                    
                    JLabel dog = new JLabel(new ImageIcon(dogImage));
                    JLabel cat = new JLabel(new ImageIcon(catImage));
                    JLabel shoe = new JLabel(new ImageIcon(shoeImage));
                    JLabel car = new JLabel(new ImageIcon(carImage));
                    JLabel ship = new JLabel(new ImageIcon(shipImage));
                    JLabel hat = new JLabel(new ImageIcon(hatImage));
                    JLabel thimble = new JLabel(new ImageIcon(thimbleImage));
                    JLabel wheelbarrow = new JLabel(new ImageIcon(wheelbarrowImage));
                    
                    dog.setBounds(100, 100, 50, 50);;
                    frame.add(dog);


                                      


                  frame.pack();
                  frame.setVisible(true);
              } catch (IOException exp) {
                  exp.printStackTrace();
              }
            }
        });
    }
}
