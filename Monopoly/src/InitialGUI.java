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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JDialog;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class InitialGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtHost;
	private JTextField txtPort;
	private JPasswordField pwdPassword;
	private JButton btnGo;
	
	private String username;
	private String password;
	private String host;
	private int port;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialGUI frame = new InitialGUI();
					try{
						frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("monopoly.png")))));
					}catch(IOException e){
						e.printStackTrace();
					}
					frame.pack();
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
	public InitialGUI() {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setTitle("Welcome to DLC Chat!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		// Creates the username field
		txtUsername = new JTextField();
		txtUsername.setText("UserName");
		contentPane.add(txtUsername, BorderLayout.NORTH);
		txtUsername.setColumns(10);
		
		// Creates the Host field
		txtHost = new JTextField();
		txtHost.setText("localhost");
		contentPane.add(txtHost, BorderLayout.WEST);
		txtHost.setColumns(10);
		
		// Creates the Port Field
		txtPort = new JTextField();
		txtPort.setText("5555");
		contentPane.add(txtPort, BorderLayout.EAST);
		txtPort.setColumns(10);
		
		// Creates the password field
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		contentPane.add(pwdPassword, BorderLayout.SOUTH);
		
		// creates the go button
		btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			int once = 1;
			public void actionPerformed(ActionEvent e) {
				// Getting all of the fields when the GO button is pressed
				
				
				setUsername(txtUsername.getText());
				setPassword(new String(pwdPassword.getPassword()));
				setPort(Integer.parseInt(txtPort.getText()));
				setHost(txtHost.getText());
				
				//TODO check if the username and password are valid. If they are then a ClientGUI needs to be called
				if(once == 1){
					//ClientGUI gui = new ClientGUI();
					//gui.setVisible(true);
					once--;
				}
			}
		});
		contentPane.add(btnGo, BorderLayout.CENTER);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}