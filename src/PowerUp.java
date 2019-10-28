import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUp {

	Player player;
	
	final int WINDOW_WIDTH = 800; // Window width in pixels
	final int WINDOW_HEIGHT = 600; // Window height in pixels

    
    public PowerUp(Player player){
    
        this.player = player;
        
    }
	
	public void powerUpMenu() {
		
		JFrame powerUpFrame = new JFrame();
		powerUpFrame.setTitle("Power Ups");
		powerUpFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		powerUpFrame.setLayout(new BorderLayout());
		
		powerUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		powerUpFrame.getContentPane().setBackground(Color.white);
		
		// Power ups Options
		 
		
		// Buttons at the bottom
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		 
		JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.white);
		exitButton.setBorder(new LineBorder(Color.DARK_GRAY));
		exitButton.setPreferredSize(new Dimension(60, 40));
		exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
		exitButton.setFocusPainted(false);
		 
		// Exit back to main game
		exitButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
			  powerUpFrame.setVisible(false);
	      }
	    }); 	 
		 
		bottomPanel.add(exitButton);
		 
		powerUpFrame.add(bottomPanel, BorderLayout.SOUTH);
		
		powerUpFrame.setLocationRelativeTo(null);
		
		powerUpFrame.setVisible(true);
		
	}
    
}
