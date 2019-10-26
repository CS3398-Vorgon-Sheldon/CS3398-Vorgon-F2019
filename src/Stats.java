import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stats {

	Player player;
	
	final int WINDOW_WIDTH = 800; // Window width in pixels
	final int WINDOW_HEIGHT = 600; // Window height in pixels

    
    public Stats(Player player){
    
        this.player = player;
        
    }
	
	public void statsMenu() {
		
		JFrame statsFrame = new JFrame();
		statsFrame.setTitle("Statistics");
		statsFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		statsFrame.setLayout(new BorderLayout());
		
		statsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		statsFrame.getContentPane().setBackground(Color.white);
		
		// Stats Options
		 
		
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
	       statsFrame.setVisible(false);
	      }
	    }); 	 
		 
		bottomPanel.add(exitButton);
		 
		statsFrame.add(bottomPanel, BorderLayout.SOUTH);
		
		statsFrame.setLocationRelativeTo(null);
		
		statsFrame.setVisible(true);
		
	}
    
}
