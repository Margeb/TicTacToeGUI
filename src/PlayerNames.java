import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerNames implements ActionListener, FocusListener
{
	
	private String player1;
	private String player2;
	ImageIcon gameIcon;
	
	JTextField player1_nameField;
	JTextField player2_nameField;
	
	JFrame frame = new JFrame("Tic Tac Toe");
	JButton confirm_button = new JButton("START");
	
	PlayerNames()
	{
		gameIcon = new ImageIcon("gameIcon.png");
		frame.setIconImage(gameIcon.getImage());
		frame.setResizable(false);
		
		confirm_button.setBounds(100,160,200,40);
		confirm_button.setFocusable(false);
		confirm_button.addActionListener(this);
		confirm_button.setBackground(Color.black);
		confirm_button.setForeground(new Color(50,200,50));
		
		player1_nameField = new JTextField("Player1");
		player2_nameField = new JTextField("Player2");
		player1_nameField.setBackground(new Color(0,0,0));
		player2_nameField.setBackground(new Color(0,0,0));
		player1_nameField.setForeground(new Color(50,200,50));
		player2_nameField.setForeground(new Color(50,200,50));
		player1_nameField.setFont(new Font("28 Days Later",Font.PLAIN, 35));
		player2_nameField.setFont(new Font("28 Days Later",Font.PLAIN, 35));
		player1_nameField.addFocusListener(this);
		player2_nameField.addFocusListener(this);
		
		JLabel player1_label = new JLabel("P1: ");
		JLabel player2_label = new JLabel("P2: ");
		player1_label.setForeground(new Color(255,255,255));
		player2_label.setForeground(new Color(255,255,255));
		
		player1_nameField.setPreferredSize(new Dimension(250,40));
		player2_nameField.setPreferredSize(new Dimension(250,40));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0));
		panel.setBounds(0, 0, 800, 500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.add(player1_label);
		panel.add(player1_nameField);
		panel.add(player2_label);
		panel.add(player2_nameField);
		panel.add(confirm_button);
		frame.pack();
	}
	
	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==confirm_button)
		{
			frame.dispose();
			this.setPlayer1((String)player1_nameField.getText());
			this.setPlayer2((String)player2_nameField.getText());
			TicTacToe tictactoe = new TicTacToe(this);
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==player1_nameField)
		{
			player1_nameField.selectAll();
		}
		if(e.getSource()==player2_nameField)
		{
			player2_nameField.selectAll();
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==player1_nameField)
		{
			player1_nameField.select(0,0);
		}
		if(e.getSource()==player2_nameField)
		{
			player2_nameField.select(0,0);
		}
		
	}

	public ImageIcon getIcon() {
		return gameIcon;
	}

		
}
