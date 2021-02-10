import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{
	
	//Random random = new Random();
	int rounds = 1;
	
	JFrame frame = new JFrame("Tic Tac Toe");
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel text_field = new JLabel();
	JButton[] buttons = new JButton[9];
	
	boolean player1_turn = true;
	String player1;
	String player2;
	ImageIcon gameIcon;
	
	TicTacToe(PlayerNames names)
	{
		player1 = names.getPlayer1();
		player2 = names.getPlayer2();
		gameIcon = names.getIcon();
		frame.setIconImage(gameIcon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		text_field.setBackground(new Color(25,25,25));
		text_field.setForeground(new Color(25,255,0));
		text_field.setFont(new Font("Chiller",Font.PLAIN,75));
		text_field.setHorizontalAlignment(JLabel.CENTER);
		text_field.setText(player1 + "'s turn");
		text_field.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.black);
		
		for(int i = 0; i < 9 ; i++)
		{
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Lucida Handwriting",Font.ITALIC,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(text_field);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		//firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0; i<9; i++)
		{
			if(e.getSource()==buttons[i])
			{
				
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn = false;
						text_field.setText(player2 + "'s turn");
						rounds++;
						check();
					}
				}
				else
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn = true;
						text_field.setText(player1 + "'s turn");
						rounds++;
						check();
					}
				}
				
			}
		}
		
	}
	
	/*
	public void firstTurn()
	{
		
		if(random.nextInt(2)==0)
		{
			player1_turn = true;
			text_field.setText(player1 + "'s turn");
		}
		else
		{
			player1_turn = false;
			text_field.setText(player2 + "'s turn");
		}
	}
	*/
	
	public void check ()
	{
		//check xWins
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X"))
		{
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X"))
		{
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X"))
		{
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X"))
		{
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X"))
		{
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X"))
		{
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X"))
		{
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X"))
		{
			xWins(2,4,6);
		}
		
		//check oWins
		
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O"))
		{
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O"))
		{
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O"))
		{
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O"))
		{
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O"))
		{
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O"))
		{
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O"))
		{
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O"))
		{
			oWins(2,4,6);
		}
		//Tie
		if(rounds>9)
		{
			tie();
		}
	}
	
	private void tie() {
		
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		text_field.setText("It's a tie!");
	}

	public void xWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		text_field.setText(player1 + " wins!");
	}
	
	public void oWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		text_field.setText(player2 + " wins!");
	}
}
