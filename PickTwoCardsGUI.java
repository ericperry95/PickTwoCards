// GUI Based version of the Picktwocards app from chapter 7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PickTwoCardsGUI extends JFrame implements ActionListener
{

	//GUI components for this class
	Font mainFont = new Font("Verdana", Font.BOLD, 32);
	Color myColor = new Color(93, 245, 66);
	JLabel mainTitle = new JLabel("Pick Two Cards");
	JLabel comLabel = new JLabel("Computer's card is: ");
	JLabel comResult = new JLabel("");
	JLabel playerLabel = new JLabel("Player's card is: ");
	JLabel playerResult = new JLabel("");
	JLabel endResult = new JLabel("");
	JButton button = new JButton("Draw Cards");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();

	
	//constructor method for this class
	public PickTwoCardsGUI()
	{
		//Use the Jframe constructor to construct the object from this class
		super("Two Cards GUI");
		setBounds(600, 380, 310, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		//Customize and then add GUI compnents to the frame
		getContentPane().setBackground(myColor);
		mainTitle.setFont(mainFont);
		button.setForeground(Color.RED);

		//add some components to the JPanels
		panel1.add(comLabel);
		panel1.add(comResult);
		panel2.add(playerLabel);
		panel2.add(playerResult);
		panel3.add(endResult);
		panel4.add(button);

		//add components to the frame
		add(mainTitle);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);

		//add the event listener to the button
		button.addActionListener(this);

	}

	//event handler method for the click event
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//call the playGame method
		playGame();
	}


	public void playGame()
	{
		// variables and constants
		final int CARDS_IN_SUIT = 13;
		int comValue;
		int userValue;
		String msg;
		Card comCard = new Card();
		Card userCard = new Card();
		// calculation phase
		comValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));
		userValue = ((int)(Math.random() * CARDS_IN_SUIT + 1));

		comCard.setValue(comValue);
		userCard.setValue(userValue);

		// UPDATE THIS WITH ARRAYS LATER!
		comCard.setSuit("Hearts");
		userCard.setSuit("Diamonds");
		// Determine a winner
		if(comCard.getValue() > userCard.getValue())
		{
			msg = "Sorry, the Computer has won.";
		}
		else
		{
			if(comCard.getValue() < userCard.getValue())
			{
				msg = "Congratulations, you win!";
			}
			else
			{
				msg = "We have a tie!";
			}
		}
		// Output phase
		comResult.setText(comCard.getRank() + " of " + comCard.getSuit());
		playerResult.setText(userCard.getRank() + " of " + userCard.getSuit());
		endResult.setText(msg);
	}



	public static void main(String[] args)
	{
		PickTwoCardsGUI frame1 = new PickTwoCardsGUI();
		frame1.setVisible(true);
	}
}



