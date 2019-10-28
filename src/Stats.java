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
		
		// ~Stats Options~
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,3));
		
		Font tabFont = new Font("Arial", Font.BOLD, 25);
		
		//General Stats Panel
		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel statsLabel = new JLabel("Stats:\n");
		statsLabel.setFont(tabFont);
		statsPanel.add(statsLabel);
		//statsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel infoLabel = new JLabel("level");
		statsPanel.add(infoLabel);
		
		//Achievements Panel
		JPanel achievementsPanel = new JPanel();
		//achievementsPanel.setPreferredSize(200,200);
		achievementsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel achievementsLabel = new JLabel("Achievements:");
		achievementsLabel.setFont(tabFont);
		achievementsPanel.add(achievementsLabel);
		
		//LeaderBoard Panel
		JPanel leaderBoardPanel = new JPanel();
		leaderBoardPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel leaderBoardLabel = new JLabel("LeaderBoard:");
		leaderBoardLabel.setFont(tabFont);
		leaderBoardPanel.add(leaderBoardLabel);
		//leaderBoardPanel.setBackground(Color.darkGray);
		 
		
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
		
		statsFrame.add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(statsPanel, BorderLayout.LINE_START);
		centerPanel.add(achievementsPanel, BorderLayout.CENTER);
		centerPanel.add(leaderBoardPanel, BorderLayout.LINE_END);
		
		
		statsFrame.setLocationRelativeTo(null);
		
		statsFrame.setVisible(true);
		
	}
    
}
