// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// InitialGUI.java

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class InitialGUI extends JFrame {

	private JPanel contentPane;
	private int numPlayers;

	private JButton twoPlayers;
	private JButton threePlayers;
	private JButton fourPlayers;
	
	private PlayerEntryGUI players;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BufferedImage logoImage = ImageIO.read(new File("monopoly-logo.png"));
					InitialGUI frame = new InitialGUI(logoImage);

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
	public InitialGUI(BufferedImage logoImage) {
		
		this.setTitle("Welcome to Monopoly!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JLabel logo = new JLabel(new ImageIcon(logoImage));
		contentPane.add(logo, BorderLayout.NORTH);
		
		twoPlayers = new JButton("2 Players");
		twoPlayers.setForeground(Color.BLACK);
		twoPlayers.setFont(new Font("PT Sans", Font.BOLD, 20));
		twoPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				players = new PlayerEntryGUI(2);
			}
		});
		contentPane.add(twoPlayers, BorderLayout.WEST);
		
		threePlayers = new JButton("3 Players");
		threePlayers.setForeground(Color.BLACK);
		threePlayers.setFont(new Font("PT Sans", Font.BOLD, 20));
		threePlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				players = new PlayerEntryGUI(3);
			}
		});
		contentPane.add(threePlayers, BorderLayout.CENTER);
		
		fourPlayers = new JButton("4 Players");
		fourPlayers.setForeground(Color.BLACK);
		fourPlayers.setFont(new Font("PT Sans", Font.BOLD, 20));
		fourPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				players = new PlayerEntryGUI(4);
			}
		});
		contentPane.add(fourPlayers, BorderLayout.EAST);
		PlayerEntryGUI frame = new PlayerEntryGUI(3);
	}
	
	public int getNumPlayers(){
		return numPlayers;
	}
}