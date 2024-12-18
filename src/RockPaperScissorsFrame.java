import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RockPaperScissorsFrame implements ActionListener {
	JFrame  MainFrame ;
	JTextField turnField ,winField,counter1_player,counter2_computer;
	JButton rockButton,scissorsButton,paperButton;
	JPanel buttonPanel,counterPanel;
	int  counterPlayer = 0 , counter_Computer = 0;
	Random random = new Random();
	String[] computerPicks = {"Rock","Paper","Scissors"} ;
	
	// Constructor of RockPaperScissorsFrame class
	RockPaperScissorsFrame(){
		MainFrame = new JFrame("Rock Paper Scissors");
		MainFrame.setLayout(new BorderLayout());
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setSize(500,500);
		// player turn
		turnField = new JTextField("Computer's Choice: ");
		turnField.setFont(new Font("Ink Free",Font.BOLD,25));
		turnField.setForeground(Color.white);
		turnField.setSize(200,200);
		turnField.setBackground(Color.gray);
		turnField.setEditable(false);
		turnField.setHorizontalAlignment(JTextField.CENTER);
		// win field
		winField = new JTextField("Whoever is better wins!!");
		winField.setSize(50,50);
		winField.setFont(new Font("Ink Free",Font.BOLD,25));
		winField.setForeground(Color.white);
		winField.setBackground(Color.DARK_GRAY);
		winField.setHorizontalAlignment(JTextField.CENTER);
		winField.setEditable(false);
		// Setting icon for rockButton
		ImageIcon rock = new ImageIcon("rock.png");
		Image img =  rock.getImage();
		Image newimg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		rock.setImage(newimg);
				
		// Setting icon for paperButton		
		ImageIcon paper = new ImageIcon("paper.png");
		Image imgp = paper.getImage();
		Image newimgp = imgp.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		paper.setImage(newimgp);
		
		//Setting icon for scissorsButton
		ImageIcon scissors = new ImageIcon("scissors.png");
		Image imgs = scissors.getImage();
		Image newimgs = imgs.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		scissors.setImage(newimgs);
		
		
		//buttons
		// creating and initializing rockButton
		rockButton = new JButton("Rock");
		rockButton.setFont(new Font("Ink Free",Font.BOLD,18));
		rockButton.setPreferredSize(new Dimension(100,50));
		rockButton.setIcon(rock);
		rockButton.setFocusable(false);
		rockButton.addActionListener(this);
		// creating and initializing scissorsButton
		scissorsButton = new JButton("Scissors");
		scissorsButton.setFont(new Font("Ink Free",Font.BOLD,18));
		scissorsButton.setIcon(scissors);
		scissorsButton.addActionListener(this);
		scissorsButton.setFocusable(false);
		scissorsButton.setPreferredSize(new Dimension(100,50));
		// creating and initializing paperButton
		paperButton = new JButton("Paper");
		paperButton.setFont(new Font("Ink Free",Font.BOLD,18));
		paperButton.setIcon(paper);
		paperButton.addActionListener(this);
		paperButton.setFocusable(false);
		paperButton.setPreferredSize(new Dimension(100,50));
		
		buttonPanel = new JPanel();
		buttonPanel.setSize(30,15);
		buttonPanel.setLayout(new GridLayout(1,3,10,10));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		// buttonPanel for holding rockButton,paperButton and scissorsButton
		buttonPanel.add(rockButton);
		buttonPanel.add(scissorsButton);
		buttonPanel.add(paperButton);
		
		// counter for player
		counter1_player = new JTextField("Player:");
		counter1_player.setSize(30,15);
		counter1_player.setFont(new Font("Ink Free",Font.BOLD,18));
		counter1_player.setEditable(false);
		// counter for computer
		counter2_computer = new JTextField("Computer:");
		counter2_computer.setSize(30,15);
		counter2_computer.setFont(new Font("Ink Free",Font.BOLD,18));
		counter2_computer.setEditable(false);
		
		// creating a panel that holds counter for player and computer
		
	     counterPanel = new JPanel();
	     counterPanel.setLayout(new GridLayout(1,1));
	     counterPanel.add(counter1_player);
	     counterPanel.add(counter2_computer);
		
		
		
		
		 
		 
		
		
		
		// Adding components to frame
		 MainFrame.add(turnField,BorderLayout.NORTH);
		 MainFrame.add(winField,BorderLayout.CENTER);
		 MainFrame.add(buttonPanel,BorderLayout.SOUTH);
		 MainFrame.add(counterPanel,BorderLayout.EAST);
		
		MainFrame.setVisible(true);
	}
	// method called "counter" to follow wins.
	public void counter() {
		
		if(winField.getText().equals("Player win the round")) {
			counterPlayer++;
			counter1_player.setText(" Player: "+String.valueOf(counterPlayer));
			
		}else if (winField.getText().equals("Computer win the round")) {
			counter_Computer++;
			counter2_computer.setText(" Computer " +String.valueOf(counter_Computer));
			
		}else {
			counterPlayer++;
			counter_Computer++;
			counter1_player.setText(" Player: "+String.valueOf(counterPlayer));
			counter2_computer.setText(" Computer: "+String.valueOf(counter_Computer));
			
		}
		who_Wins();
		
	}
     // Method called "who_Wins" to decide whether player or computer wins.
	public void who_Wins() {
		JButton[] rps = {rockButton,scissorsButton,paperButton};
	   if(counterPlayer == 3) {
		   for(int i = 0; i < rps.length; i++) {
			   rps[i].setEnabled(false);
		   }
		  winField.setText("Player win the game!!");
		  winField.setForeground(Color.green);
		}
	   if(counter_Computer == 3) {
		   for(int i = 0; i < rps.length; i++) {
			   rps[i].setEnabled(false);
		   }
		  winField.setText("Computer win the game!!");
		  winField.setForeground(Color.red);
		}
	   if(counter_Computer == 3 && counterPlayer == 3) {
		   for(int i = 0; i < rps.length; i++) {
			   rps[i].setEnabled(false);
		   }
		  winField.setText("Draw");
		  winField.setForeground(Color.yellow);
		}
	   
	   
		
	}
	

	
	
	

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		/* I declared compPick as local variable because initially i declared as a instance variable,
		 * i couldn't reset it when it was declared within class so i came with declaring inside actionPerformed.
		 * problem solved!!
		 */
		String compPick =  computerPicks[random.nextInt(computerPicks.length)];
		if(e.getSource() == rockButton) {
			if(compPick.equals(rockButton.getText())) {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Round tie");
				
			
			
			
			}else if(compPick.equals(scissorsButton.getText())) {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Player win the round");
				
				
			
				
			}else {
				turnField.setText("Computer's choice: " +compPick);
			
				winField.setText("Computer win the round");
			
				}
			counter();
		}
		if(e.getSource() == scissorsButton) {
			
			if(compPick.equals(scissorsButton.getText())) {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Round tie");
				
				
				
				
				
			}else if(compPick.equals(paperButton.getText())) {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Player win the round");
				
				
				
				
				
			}else {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Computer win the round");
				
				
				
				
				
			}
			counter();
		}
		if(e.getSource() == paperButton) {
			if(compPick.equals(paperButton.getText())) {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Round tie");
				
				
				
			}else if(compPick.equals(rockButton.getText())) {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Player win the round");
				
				
				
				
				
			}else {
				turnField.setText("Computer's choice: " +compPick);
				winField.setText("Computer win the round");
				
				
				
				}
			counter();
		}
			
		
		
		
	}

}
