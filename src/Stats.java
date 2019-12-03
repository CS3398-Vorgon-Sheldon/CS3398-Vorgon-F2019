import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stats {

	Player player;
	Player leaderboard[];
	
	Achievements achievements = new Achievements();
	Leaderboard board = new Leaderboard(player);
	
	final int WINDOW_WIDTH = 800; // Window width in pixels
	final int WINDOW_HEIGHT = 600; // Window height in pixels

    
    public Stats(Player player){
    
        this.player = player;
        
    }
    
    public void leaderboardRank()
    {
    	//setting up dummy players
    	Player dummy1 = new Player();
    	dummy1.updateWorkHours(100);
    	dummy1.setName("John");
    	Player dummy2 = new Player();
    	dummy2.updateWorkHours(900);
    	dummy2.setName("Steve");
    	Player dummy3 = new Player();
    	dummy3.updateWorkHours(750);
    	dummy3.setName("Max");
    	
    	leaderboard = new Player[] {dummy1, dummy2, dummy3, player};
    	
    	//sorting leaderboard
    	for(int i = 0; i < leaderboard.length-1; i++){
    		for(int j = 0; j < leaderboard.length-i-1; j++){
    			if (leaderboard[j].getWorkHours() < leaderboard[j+1].getWorkHours()){
    				Player swap = leaderboard[j+1];
    				leaderboard[j+1] = leaderboard[j];
    				leaderboard[j] = swap;
    			}
    		}
    	}
    }
    
	
	public void statsMenu() {
		
		JFrame statsFrame = new JFrame();
		statsFrame.setTitle("Statistics");
		statsFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		statsFrame.setLayout(new BorderLayout());
		
		statsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		statsFrame.getContentPane().setBackground(Color.white);
		
		Font tabFont = new Font("Arial", Font.BOLD, 25);
		Font textFont = new Font("Arial", Font.BOLD, 18);
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED); 
		
	//~~~Tabs and respective text Panels~~~
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(0,3));
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,3));
		
		
		//Stats Panel at TOP
		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel statsLabel = new JLabel("Stats:");
		statsLabel.setFont(tabFont);
		statsPanel.add(statsLabel);
		
		//text for Stats tab
		JPanel statsTextPanel = new JPanel();
		statsTextPanel.setLayout(new BoxLayout(statsTextPanel, BoxLayout.PAGE_AXIS));
		statsTextPanel.setBackground(Color.WHITE);
		
		JLabel statsTextLabel = new JLabel("Level: " + player.getLevel());
		statsTextLabel.setFont(textFont);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Total Clicks: ");
		statsTextLabel.setFont(textFont);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Total Hours: " + player.getWorkHours());
		statsTextLabel.setFont(textFont);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Total Money: " + player.getMoney());
		statsTextLabel.setFont(textFont);
		statsTextPanel.add(statsTextLabel);
		
		//Achievements Panel at TOP
		JPanel achievementsPanel = new JPanel();
		achievementsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel achievementsLabel = new JLabel("Achievements:");
		achievementsLabel.setFont(tabFont);
		achievementsPanel.add(achievementsLabel);
		
		//text for Achievements tab
		JPanel achievementsTextPanel = new JPanel();
		achievementsTextPanel.setLayout(new BoxLayout(achievementsTextPanel, BoxLayout.PAGE_AXIS));
		achievementsTextPanel.setBackground(Color.WHITE);
		
		JLabel achievementsTextLabel = new JLabel("Achievement 1");
		achievementsTextLabel.setBorder(raisedetched);
		achievementsTextLabel.setFont(tabFont);
		achievementsTextLabel.setOpaque(true);
		achievementsTextLabel.setBackground(Color.GREEN);
		achievementsTextPanel.add(achievementsTextLabel);
		
		achievementsTextLabel = new JLabel("Achievement 2");
		achievementsTextLabel.setBorder(raisedetched);
		achievementsTextLabel.setFont(tabFont);
		achievementsTextLabel.setOpaque(true);
		achievementsTextLabel.setBackground(Color.GREEN);
		achievementsTextPanel.add(achievementsTextLabel);
		
		achievementsTextLabel = new JLabel("Achievement 3");
		achievementsTextLabel.setBorder(raisedetched);
		achievementsTextLabel.setFont(tabFont);
		achievementsTextLabel.setOpaque(true);
		achievementsTextLabel.setBackground(Color.LIGHT_GRAY);
		achievementsTextPanel.add(achievementsTextLabel);
		
		//LeaderBoard Panel at TOP
		JPanel leaderboardPanel = new JPanel();
		leaderboardPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel leaderboardLabel = new JLabel("Leaderboard:");
		leaderboardLabel.setFont(tabFont);
		leaderboardPanel.add(leaderboardLabel);
		//leaderBoardPanel.setBackground(Color.darkGray);
		
		//text for LeaderBoard tab
		JPanel leaderboardTextPanel = new JPanel();
		leaderboardTextPanel.setLayout(new BoxLayout(leaderboardTextPanel, BoxLayout.PAGE_AXIS));
		leaderboardTextPanel.setBackground(Color.WHITE);
				
		JLabel leaderboardTextLabel = new JLabel("~Leaderboard text~");
		leaderboardTextLabel.setFont(textFont);
		leaderboardTextPanel.add(leaderboardTextLabel);
		
		//prints leaderboad in label
		leaderboardRank();
		for(int x = 0; x < leaderboard.length; x++ ) {
			leaderboardTextLabel = new JLabel(x+1+ "."+leaderboard[x].getName()+ " "+leaderboard[x].getWorkHours());
			leaderboardTextLabel.setFont(textFont);
			leaderboardTextPanel.add(leaderboardTextLabel);
		}
		
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
		 
		
	//~~Frame and Panel management~~
		statsFrame.add(bottomPanel, BorderLayout.SOUTH);
		statsFrame.add(centerPanel, BorderLayout.CENTER);
		statsFrame.add(topPanel, BorderLayout.NORTH);
		
		 JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 
		 tabbedPane.addTab("Stats",statsTextPanel);
		 //tabbedPane.addTab("Achievements",achievementsTextPanel);
		 tabbedPane.addTab("Achievements",achievements.achDisplay());
		 tabbedPane.addTab("Leaderboard", leaderboardTextPanel);
		 //tabbedPane.addTab("Leaderboard", board.createLeaderboard());
		 
		/*//Top tabs
		topPanel.add(statsPanel);
		topPanel.add(achievementsPanel);
		topPanel.add(leaderboardPanel);
		
		//Text panels
		centerPanel.add(statsTextPanel);
		centerPanel.add(achievementsTextPanel);
		centerPanel.add(leaderboardTextPanel);*/
		
		statsFrame.getContentPane().add(tabbedPane);
		
		statsFrame.setLocationRelativeTo(null);
		
		statsFrame.setVisible(true);
		
	}
    
}
