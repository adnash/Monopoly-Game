// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// InitialGUI.java

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class PlayerEntryGUI extends JFrame {

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	
	private JComboBox<String> player1icon;
	private JComboBox<String> player2icon;
	private JComboBox<String> player3icon;
	private JComboBox<String> player4icon;
	
	private String username1;
	private String username2;
	private String username3;
	private String username4;
	
	private String usericon1;
	private String usericon2;
	private String usericon3;
	private String usericon4;
	
	private JPanel contentPane;
	private JButton start;	
	private boolean unique = false;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerEntryGUI frame = new PlayerEntryGUI(3);
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
		
		
		ArrayList<String> iconList = new ArrayList<String>();
		iconList.add("");iconList.add("Battleship");iconList.add("Cat");iconList.add("Race Car");iconList.add("Scottie Dog");iconList.add("Shoe");iconList.add("Thimble");iconList.add("Top Hat");iconList.add("Wheelbarrow");
		
		// Creates the icon fields
		player1icon = new JComboBox(iconList.toArray());
		c.gridx = 1;
		c.gridy = 0;
		GridBagLayout.setConstraints(player1icon, c);
		
		player2icon = new JComboBox(iconList.toArray());
		c.gridx = 1;
		c.gridy = 1;
		GridBagLayout.setConstraints(player2icon, c);
		
		player3icon = new JComboBox(iconList.toArray());
		c.gridx = 1;
		c.gridy = 2;
		GridBagLayout.setConstraints(player3icon, c);
		
		player4icon = new JComboBox(iconList.toArray());
		c.gridx = 1;
		c.gridy = 3;
		GridBagLayout.setConstraints(player4icon, c);
		
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

		
		// creates the go button
		start = new JButton("Start Game!");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Getting all of the fields when the GO button is pressed
				setUsername1(text1.getText());
				setUsername2(text2.getText());
				setUsername3(text3.getText());
				setUsername4(text4.getText());
				
				// making sure all the icons are unique
				if(!player1icon.getSelectedItem().equals(player2icon.getSelectedItem()) && !player1icon.getSelectedItem().equals(player3icon.getSelectedItem()) && !player1icon.getSelectedItem().equals(player4icon.getSelectedItem())){
					if(!player2icon.getSelectedItem().equals(player3icon.getSelectedItem()) && !player2icon.getSelectedItem().equals(player4icon.getSelectedItem())){
						if(!player3icon.getSelectedItem().equals(player4icon.getSelectedItem())){
							setUsericon1(player1icon.getName());
							setUsericon2(player2icon.getName());
							setUsericon3(player3icon.getName());
							setUsericon4(player4icon.getName());
							unique = true;
						}else{
							JOptionPane.showMessageDialog(contentPane, "Every player must choose an icon and all user icons must be unique");
						}
					}else{
						JOptionPane.showMessageDialog(contentPane, "Every player must choose an icon and all user icons must be unique");
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Every player must choose an icon and all user icons must be unique");
				}
				
				
			}

		});
		c.gridx = 0;
		c.gridy = 5;
		contentPane.add(start, c);	
		

	}
	
	//Username getter setters
	private void setUsername1(String name){
		username1 = name;
	}
	private void setUsername2(String name){
		username2 = name;
	}
	private void setUsername3(String name){
		username3 = name;
	}
	private void setUsername4(String name){
		username4 = name;
	}
	public String getUsername1() {
		return username1;
	}
	public String getUsername2() {
		return username2;
	}
	public String getUsername3() {
		return username3;
	}
	public String getUsername4() {
		return username4;
	}
	
	//Icon getter setters
	public String getUsericon1() {
		return usericon1;
	}
	public void setUsericon1(String usericon1) {
		this.usericon1 = usericon1;
	}
	public String getUsericon2() {
		return usericon2;
	}
	public void setUsericon2(String usericon2) {
		this.usericon2 = usericon2;
	}
	public String getUsericon3() {
		return usericon3;
	}
	public void setUsericon3(String usericon3) {
		this.usericon3 = usericon3;
	}
	public String getUsericon4() {
		return usericon4;
	}
	public void setUsericon4(String usericon4) {
		this.usericon4 = usericon4;
	}
		
}