import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InitialUI {

	public static void main(String[] args) {
        new InitialUI();
    }

    public InitialUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Load the background image
                    BufferedImage img = ImageIO.read(new File("monopoly.png"));

                    // Create the frame...
                    JFrame frame = new JFrame("Testing");
                    frame.setBounds(0, 0, 1000, 1000);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Set the frames content pane to use a JLabel
                    // whose icon property has been set to use the image
                    // we just loaded                        
                    frame.setContentPane(new JLabel(new ImageIcon(img)));

                    // Supply a layout manager for the body of the content
                    GridBagLayout gridbag = new GridBagLayout();
                    GridBagConstraints c = new GridBagConstraints();
                    frame.setLayout(gridbag);
                                        
                    
                    JLabel label;
                    JButton button;
                    
                    // global specs
                    Border blackline = BorderFactory.createLineBorder(Color.black);
                    button = new JButton();
                    label = new JLabel();

                                      
//                    Start of top (inclusive)
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 130;
                    c.ipady = 130;
                    c.gridx = 0;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 80;
                    c.ipady = 130;
                    c.gridx = 1;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 2;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 3;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 4;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 5;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 6;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 7;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 8;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 9;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 130;
                    c.ipady = 130;
                    c.gridx = 10;
                    c.gridy = 0;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
//                    End of top (inclusive)
//                    Start of left 
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 130;
                    c.ipady = 80;
                    c.gridx = 0;
                    c.gridy = 1;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 2;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 3;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 4;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 5;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 6;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 7;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 8;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 0;
                    c.gridy = 9;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
//                    End of left
//                    Start of bottom (inclusive)
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 130;
                    c.ipady = 130;
                    c.gridx = 0;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 80;
                    c.ipady = 130;
                    c.gridx = 1;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 2;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 3;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 4;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 5;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 6;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 7;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 8;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 9;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 130;
                    c.ipady = 130;
                    c.gridx = 10;
                    c.gridy = 10;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
//                    End of bottom (inclusive)
//                    Start of right
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.ipadx = 130;
                    c.ipady = 80;
                    c.gridx = 10;
                    c.gridy = 1;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 2;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 3;
                    gridbag.setConstraints(label, c);
                    frame.add(label);

                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 4;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 5;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 6;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 7;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 8;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
                    
                    label = new JLabel();
                    label.setBorder(blackline);
                    label.setOpaque(true);
                    label.setBackground(Color.white);
                    c.gridx = 10;
                    c.gridy = 9;
                    gridbag.setConstraints(label, c);
                    frame.add(label);
//                    End of right

                    frame.pack();
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
	
	
	
	
	
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InitialUI frame = new InitialUI();
//
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public InitialUI() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(0, 0, 1100, 1100);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		setContentPane(new JLabel(new ImageIcon("monopoly.png")));
//
//
//	}

}
