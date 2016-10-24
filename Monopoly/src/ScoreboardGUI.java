// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// ScoreboardGIO.java

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
import java.awt.Font;

public class ScoreboardGUI extends JFrame {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreboardGUI frame = new ScoreboardGUI(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ScoreboardGUI(Board board) {
		int num = 3;
		this.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setTitle("Scoreboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 500);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout GridBagLayout = new GridBagLayout();
		GridBagLayout.columnWeights = new double[]{0.0};
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(GridBagLayout);
		
		JLabel title = new JLabel("Scoreboard");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		c.gridx = 0;
		c.gridy = 0;
		GridBagLayout.setConstraints(title, c);
		contentPane.add(title);
		
		switch (num) {
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
		
		
		
		
	}		
}