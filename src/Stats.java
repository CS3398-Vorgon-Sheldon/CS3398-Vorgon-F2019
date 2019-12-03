import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;

import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Stats {

	Player player;
	Player leaderboard[];
	
	AchievementsList al = new AchievementsList();
	//Achievements achievements = new Achievements();
	
	
	final int WINDOW_WIDTH = 800; // Window width in pixels
	final int WINDOW_HEIGHT = 600; // Window height in pixels

	
	//private JPanel achievementsPanel;
	List<String> aList = al.getAchievementsList();

	//get achievements list
	public int [] workGoal = al.getWhGoals();
	public int [] jobGoal = al.getJobGoals();
	public int [] clientGoal = al.getClientsGoals();
	public int [] moneyGoal = al.getMoneyGoals();
	
	JLabel[] achievementsTextLabel = new JLabel[aList.size()];
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
		Font achFont = new Font("Arial", Font.BOLD, 12);
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED); 
		
		EmptyBorder border = new EmptyBorder(5, 5, 5, 5);
        LineBorder line = new LineBorder(Color.white, 2, true);
        CompoundBorder compound = new CompoundBorder(line, border);
        
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
		statsTextLabel.setBorder(compound);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Total Clicks: " + 10);
		statsTextLabel.setFont(textFont);
		statsTextLabel.setBorder(compound);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Total Hours: " + player.getWorkHours());
		statsTextLabel.setFont(textFont);
		statsTextLabel.setBorder(compound);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Total Money: " + player.getMoney());
		statsTextLabel.setFont(textFont);
		statsTextLabel.setBorder(compound);
		statsTextPanel.add(statsTextLabel);
/*		statsTextLabel = new JLabel("Total Clients: ");
		statsTextLabel.setBorder(compound);
		statsTextLabel.setFont(textFont);
		statsTextPanel.add(statsTextLabel);
		statsTextLabel = new JLabel("Jobs Completed: ");
		statsTextLabel.setFont(textFont);
		statsTextLabel.setBorder(compound);
		statsTextPanel.add(statsTextLabel); */
		statsTextLabel = new JLabel("Power Ups Used: " + player.get_PWR_use());
		statsTextLabel.setFont(textFont);
		statsTextLabel.setBorder(compound);
		statsTextPanel.add(statsTextLabel);

		//Achievements Panel at TOP
		JPanel achievementsPanel = new JPanel();
		achievementsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel achievementsLabel = new JLabel("Achievements:");
		achievementsLabel.setFont(tabFont);
		achievementsPanel.add(achievementsLabel);
		
		//text for Achievements tab
		JPanel achievementsTextPanel = new JPanel();
		//EmptyBorder panelBorder = new EmptyBorder(10, 20, 20, 20);
		
		//achievementsTextPanel.setBorder(panelBorder);
		achievementsTextPanel.setLayout(new BoxLayout(achievementsTextPanel, BoxLayout.PAGE_AXIS));
		achievementsTextPanel.setBackground(Color.WHITE);
        
		for(int i = 0; i < aList.size(); i++) {
			
			//achievementsTextLabel[i] = new JLabel(aList.get(i));
			
			achievementsTextLabel[i] = new JLabel();
			achievementsTextLabel[i].setText(aList.get(i).toString());
			achievementsTextLabel[i].setFont(achFont);
			achievementsTextLabel[i].setBorder(compound);
			achievementsTextLabel[i].setOpaque(true);
			achievementsTextLabel[i].setBackground(Color.WHITE);
			achievementsTextLabel[i].setForeground(Color.RED);
			
		
			
			achievementsTextPanel.add(achievementsTextLabel[i]);
		}//end for
		
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
				
		JLabel leaderboardTextLabel = new JLabel("Ranked by Work Hours");
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
		
		
		 JTabbedPane tabbedPane = new JTabbedPane(/*JTabbedPane.TOP*/);
		 
		 tabbedPane.addTab("Stats",statsTextPanel);
		 tabbedPane.addTab("Achievements",achievementsTextPanel);
		 //tabbedPane.addTab("Achievements",achievements.achDisplay());
		 tabbedPane.addTab("Leaderboard", leaderboardTextPanel);
		 //tabbedPane.addTab("Leaderboard", board.createLeaderboard());
		 
		 tabbedPane.addChangeListener(new ChangeListener() {
			 
			 public void stateChanged(ChangeEvent ce) {
				 
				 //achievements.checkAchievements();
				 updateAchievements();
				 System.out.println("\nAchievement Tab: " + player.getWorkHours());
				 
			 }

		 });

			
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
	
	//check and update if player finished achievements
	public void updateAchievements() {
		
		 int counter = 0;
		 
		 for(int i = 0; i < workGoal.length; i++) {
			 
			 if(player.getWorkHours() >= workGoal[i]) {
				 
					achievementsTextLabel[counter].setForeground(Color.green);
					achievementsTextLabel[counter].repaint();
				 
				 
			 }//end if
			 
			 counter++;
			 
		 }//end work for
		 		
		 counter = 11;
		 
		 for(int i = 0; i < moneyGoal.length; i++) {
			 
			 if(player.getMoney() >= moneyGoal[i]) {
				 
				achievementsTextLabel[counter].setForeground(Color.green);
				achievementsTextLabel[counter].repaint();
			 }
			 
			 counter++;
		 }
		 
		 
	}//end update achievements
	
    
}
