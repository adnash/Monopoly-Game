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
                                      
//                  Start of top (inclusive)
                  JLabel label20 = new JLabel();
                  label20.setBorder(blackline);
                  label20.setOpaque(true);
                  label20.setBackground(Color.white);
                  c.ipadx = 130;
                  c.ipady = 130;
                  c.gridx = 0;
                  c.gridy = 0;
                  gridbag.setConstraints(label20, c);
                  frame.add(label20);
                  
                  JLabel label21 = new JLabel();
                  label21.setBorder(blackline);
                  label21.setOpaque(true);
                  label21.setBackground(Color.white);
                  c.ipadx = 80;
                  c.ipady = 130;
                  c.gridx = 1;
                  c.gridy = 0;
                  gridbag.setConstraints(label21, c);
                  frame.add(label21);

                  JLabel label22 = new JLabel();
                  label22.setBorder(blackline);
                  label22.setOpaque(true);
                  label22.setBackground(Color.white);
                  c.gridx = 2;
                  c.gridy = 0;
                  gridbag.setConstraints(label22, c);
                  frame.add(label22);
                  
                  JLabel label23 = new JLabel();
                  label23.setBorder(blackline);
                  label23.setOpaque(true);
                  label23.setBackground(Color.white);
                  c.gridx = 3;
                  c.gridy = 0;
                  gridbag.setConstraints(label23, c);
                  frame.add(label23);

                  JLabel label24 = new JLabel();
                  label24.setBorder(blackline);
                  label24.setOpaque(true);
                  label24.setBackground(Color.white);
                  c.gridx = 4;
                  c.gridy = 0;
                  gridbag.setConstraints(label24, c);
                  frame.add(label24);
                  
                  JLabel label25 = new JLabel();
                  label25.setBorder(blackline);
                  label25.setOpaque(true);
                  label25.setBackground(Color.white);
                  c.gridx = 5;
                  c.gridy = 0;
                  gridbag.setConstraints(label25, c);
                  frame.add(label25);
                  
                  JLabel label26 = new JLabel();
                  label26.setBorder(blackline);
                  label26.setOpaque(true);
                  label26.setBackground(Color.white);
                  c.gridx = 6;
                  c.gridy = 0;
                  gridbag.setConstraints(label26, c);
                  frame.add(label26);
                  
                  JLabel label27 = new JLabel();
                  label27.setBorder(blackline);
                  label27.setOpaque(true);
                  label27.setBackground(Color.white);
                  c.gridx = 7;
                  c.gridy = 0;
                  gridbag.setConstraints(label27, c);
                  frame.add(label27);
                  
                  JLabel label28 = new JLabel();
                  label28.setBorder(blackline);
                  label28.setOpaque(true);
                  label28.setBackground(Color.white);
                  c.gridx = 8;
                  c.gridy = 0;
                  gridbag.setConstraints(label28, c);
                  frame.add(label28);
                  
                  JLabel label29 = new JLabel();
                  label29.setBorder(blackline);
                  label29.setOpaque(true);
                  label29.setBackground(Color.white);
                  c.gridx = 9;
                  c.gridy = 0;
                  gridbag.setConstraints(label29, c);
                  frame.add(label29);
                  
                  JLabel label30 = new JLabel();
                  label30.setBorder(blackline);
                  label30.setOpaque(true);
                  label30.setBackground(Color.white);
                  c.ipadx = 130;
                  c.ipady = 130;
                  c.gridx = 10;
                  c.gridy = 0;
                  gridbag.setConstraints(label30, c);
                  frame.add(label30);
//                  End of top (inclusive)
//                  Start of left 
                  JLabel label19 = new JLabel();
                  label19.setBorder(blackline);
                  label19.setOpaque(true);
                  label19.setBackground(Color.white);
                  c.ipadx = 130;
                  c.ipady = 80;
                  c.gridx = 0;
                  c.gridy = 1;
                  gridbag.setConstraints(label19, c);
                  frame.add(label19);

                  JLabel label18 = new JLabel();
                  label18.setBorder(blackline);
                  label18.setOpaque(true);
                  label18.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 2;
                  gridbag.setConstraints(label18, c);
                  frame.add(label18);
                  
                  JLabel label17 = new JLabel();
                  label17.setBorder(blackline);
                  label17.setOpaque(true);
                  label17.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 3;
                  gridbag.setConstraints(label17, c);
                  frame.add(label17);

                  JLabel label16 = new JLabel();
                  label16.setBorder(blackline);
                  label16.setOpaque(true);
                  label16.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 4;
                  gridbag.setConstraints(label16, c);
                  frame.add(label16);
                  
                  JLabel label15 = new JLabel();
                  label15.setBorder(blackline);
                  label15.setOpaque(true);
                  label15.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 5;
                  gridbag.setConstraints(label15, c);
                  frame.add(label15);
                  
                  JLabel label14 = new JLabel();
                  label14.setBorder(blackline);
                  label14.setOpaque(true);
                  label14.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 6;
                  gridbag.setConstraints(label14, c);
                  frame.add(label14);
                  
                  JLabel label13 = new JLabel();
                  label13.setBorder(blackline);
                  label13.setOpaque(true);
                  label13.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 7;
                  gridbag.setConstraints(label13, c);
                  frame.add(label13);
                  
                  JLabel label12 = new JLabel();
                  label12.setBorder(blackline);
                  label12.setOpaque(true);
                  label12.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 8;
                  gridbag.setConstraints(label12, c);
                  frame.add(label12);
                  
                  JLabel label11 = new JLabel();
                  label11.setBorder(blackline);
                  label11.setOpaque(true);
                  label11.setBackground(Color.white);
                  c.gridx = 0;
                  c.gridy = 9;
                  gridbag.setConstraints(label11, c);
                  frame.add(label11);
//                  End of left
//                  Start of bottom (inclusive)
                  JLabel label10 = new JLabel();
                  label10.setBorder(blackline);
                  label10.setOpaque(true);
                  label10.setBackground(Color.white);
                  c.ipadx = 130;
                  c.ipady = 130;
                  c.gridx = 0;
                  c.gridy = 10;
                  gridbag.setConstraints(label10, c);
                  frame.add(label10);
                  
                  JLabel label9 = new JLabel();
                  label9.setBorder(blackline);
                  label9.setOpaque(true);
                  label9.setBackground(Color.white);
                  c.ipadx = 80;
                  c.ipady = 130;
                  c.gridx = 1;
                  c.gridy = 10;
                  gridbag.setConstraints(label9, c);
                  frame.add(label9);
                  
                  JLabel label8 = new JLabel();
                  label8.setBorder(blackline);
                  label8.setOpaque(true);
                  label8.setBackground(Color.white);
                  c.gridx = 2;
                  c.gridy = 10;
                  gridbag.setConstraints(label8, c);
                  frame.add(label8);

                  JLabel label7 = new JLabel();
                  label7.setBorder(blackline);
                  label7.setOpaque(true);
                  label7.setBackground(Color.white);
                  c.gridx = 3;
                  c.gridy = 10;
                  gridbag.setConstraints(label7, c);
                  frame.add(label7);
                  
                  JLabel label6 = new JLabel();
                  label6.setBorder(blackline);
                  label6.setOpaque(true);
                  label6.setBackground(Color.white);
                  c.gridx = 4;
                  c.gridy = 10;
                  gridbag.setConstraints(label6, c);
                  frame.add(label6);
                  
                  JLabel label5 = new JLabel();
                  label5.setBorder(blackline);
                  label5.setOpaque(true);
                  label5.setBackground(Color.white);
                  c.gridx = 5;
                  c.gridy = 10;
                  gridbag.setConstraints(label5, c);
                  frame.add(label5);
                  
                  JLabel label4 = new JLabel();
                  label4.setBorder(blackline);
                  label4.setOpaque(true);
                  label4.setBackground(Color.white);
                  c.gridx = 6;
                  c.gridy = 10;
                  gridbag.setConstraints(label4, c);
                  frame.add(label4);
                  
                  JLabel label3 = new JLabel();
                  label3.setBorder(blackline);
                  label3.setOpaque(true);
                  label3.setBackground(Color.white);
                  c.gridx = 7;
                  c.gridy = 10;
                  gridbag.setConstraints(label3, c);
                  frame.add(label3);
                  
                  JLabel label2 = new JLabel();
                  label2.setBorder(blackline);
                  label2.setOpaque(true);
                  label2.setBackground(Color.white);
                  c.gridx = 8;
                  c.gridy = 10;
                  gridbag.setConstraints(label2, c);
                  frame.add(label2);
                  
                  JLabel label1 = new JLabel();
                  label1.setBorder(blackline);
                  label1.setOpaque(true);
                  label1.setBackground(Color.white);
                  c.gridx = 9;
                  c.gridy = 10;
                  gridbag.setConstraints(label1, c);
                  frame.add(label1);
                  
                  JLabel label0 = new JLabel();
                  label0.setBorder(blackline);
                  label0.setOpaque(true);
                  label0.setBackground(Color.white);
                  c.ipadx = 130;
                  c.ipady = 130;
                  c.gridx = 10;
                  c.gridy = 10;
                  gridbag.setConstraints(label0, c);
                  frame.add(label0);
//                  End of bottom (inclusive)
//                  Start of right
                  JLabel label31 = new JLabel();
                  label31.setBorder(blackline);
                  label31.setOpaque(true);
                  label31.setBackground(Color.white);
                  c.ipadx = 130;
                  c.ipady = 80;
                  c.gridx = 10;
                  c.gridy = 1;
                  gridbag.setConstraints(label31, c);
                  frame.add(label31);

                  JLabel label32 = new JLabel();
                  label32.setBorder(blackline);
                  label32.setOpaque(true);
                  label32.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 2;
                  gridbag.setConstraints(label32, c);
                  frame.add(label32);
                  
                  JLabel label33 = new JLabel();
                  label33.setBorder(blackline);
                  label33.setOpaque(true);
                  label33.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 3;
                  gridbag.setConstraints(label33, c);
                  frame.add(label33);

                  JLabel label34 = new JLabel();
                  label34.setBorder(blackline);
                  label34.setOpaque(true);
                  label34.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 4;
                  gridbag.setConstraints(label34, c);
                  frame.add(label34);
                  
                  JLabel label35 = new JLabel();
                  label35.setBorder(blackline);
                  label35.setOpaque(true);
                  label35.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 5;
                  gridbag.setConstraints(label35, c);
                  frame.add(label35);
                  
                  JLabel label36 = new JLabel();
                  label36.setBorder(blackline);
                  label36.setOpaque(true);
                  label36.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 6;
                  gridbag.setConstraints(label36, c);
                  frame.add(label36);
                  
                  JLabel label37 = new JLabel();
                  label37.setBorder(blackline);
                  label37.setOpaque(true);
                  label37.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 7;
                  gridbag.setConstraints(label37, c);
                  frame.add(label37);
                  
                  JLabel label38 = new JLabel();
                  label38.setBorder(blackline);
                  label38.setOpaque(true);
                  label38.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 8;
                  gridbag.setConstraints(label38, c);
                  frame.add(label38);
                  
                  JLabel label39 = new JLabel();
                  label39.setBorder(blackline);
                  label39.setOpaque(true);
                  label39.setBackground(Color.white);
                  c.gridx = 10;
                  c.gridy = 9;
                  gridbag.setConstraints(label39, c);
                  frame.add(label39);
//                  End of right

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
