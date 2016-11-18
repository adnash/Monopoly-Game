package monopolySrc;
// CS414e
// Conor Cox, Dan Wood, Alex Arbuckle, Alan Nash
// A4
// InitialGUI.java

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class PostTurn extends JFrame {

	private JPanel contentPane;
	private int numPlayers;

	private JButton buysell;
	private JButton endTurn;
	private JButton mortgage;
	private JButton unmortgage;
	private JButton trade;
	private Board board;
	private int answer;
	private Player Curr_Player;
	private Square sq;
	Font font = new Font("PT Sans", Font.BOLD, 20);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostTurn frame = new PostTurn(null, null);
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
	public PostTurn(Board board, Player Curr_Player) {
		this.board = board;
		this.Curr_Player = Curr_Player;
		start(this);		
	}
	
	public void start(PostTurn post){
		this.setTitle("Post Turn Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1300, 500, 500, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5,5));
				
		buysell = new JButton("Buy/Sell");
		buysell.setFont(font);
		buysell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] array = new String[Curr_Player.getPropertiesOwned().size()];
				for (int i = 0; i < Curr_Player.getPropertiesOwned().size(); i++) {
					sq = board.getSquare(Curr_Player.getPropertiesOwned().get(i));
					array[i] = sq.getID() + " " + sq.getName();		
				}
				
				answer = JOptionPane.showConfirmDialog(contentPane,Curr_Player.getName() + ", would you like to buy any houses? Answering \"no\" assumes sell.", "Buy houses?", JOptionPane.YES_NO_OPTION);
				if(answer == 0){
					Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to buy a house.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
					if(answerString != null){
						answer = Integer.parseInt(answerString.toString().replaceAll("[\\D]", ""));
						if(answer != -1)
							board.buyHouse(answer, Curr_Player);
						else
							JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
					}
				}else{
					Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to sell a house.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
					if(answerString != null){
						answer = Integer.parseInt(answerString.toString().replaceAll("[\\D]", ""));
						if(answer != -1)
							board.sellHouse(answer, Curr_Player);
						else
							JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
					}
				}

			}
		});
		contentPane.add(buysell, BorderLayout.EAST);
		
		endTurn = new JButton("End Turn");
		endTurn.setFont(font);
		endTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				post.dispose();
			}
		});
		contentPane.add(endTurn, BorderLayout.CENTER);
		
		trade = new JButton("Trade");
		trade.setFont(font);
		trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.trade(Curr_Player);
			}
		});
		contentPane.add(trade, BorderLayout.WEST);
		
		mortgage = new JButton("Mortgage");
		mortgage.setFont(font);
		mortgage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] array = new String[Curr_Player.getPropertiesOwned().size()];
				for (int i = 0; i < Curr_Player.getPropertiesOwned().size(); i++) {
					sq = board.getSquare(Curr_Player.getPropertiesOwned().get(i));
					array[i] = sq.getID() + " " + sq.getName();	
				}
				
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to mortgage.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString().replaceAll("[\\D]", ""));
					if(answer != -1)
						board.mortgageProperty(answer, Curr_Player);
					else
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
				}
			}
		});
		contentPane.add(mortgage, BorderLayout.NORTH);
		
		unmortgage = new JButton("Unmortgage");
		unmortgage.setFont(font);
		unmortgage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] array = new String[Curr_Player.getPropertiesOwned().size()];
				for (int i = 0; i < Curr_Player.getPropertiesOwned().size(); i++) {
					sq = board.getSquare(Curr_Player.getPropertiesOwned().get(i));
					array[i] = sq.getID() + " " + sq.getName();			
				}
				
				Object answerString = JOptionPane.showInputDialog(contentPane, Curr_Player.getName() + ", you own these properties.\nSelect a property to unmortgage.", "Owned properties", JOptionPane.PLAIN_MESSAGE, null, array, null);
				if(answerString != null){
					answer = Integer.parseInt(answerString.toString().replaceAll("[\\D]", ""));
					if(answer != -1)
						board.unmortgageProperty(answer, Curr_Player);
					else
						JOptionPane.showMessageDialog(contentPane, "Invalid answer. Try again next turn.");
				}
			}
		});
		contentPane.add(unmortgage, BorderLayout.SOUTH);
	}
	
	public int getNumPlayers(){
		return numPlayers;
	}
}