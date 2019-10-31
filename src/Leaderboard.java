import javax.swing.*;

import java.awt.*;

public class Leaderboard {
	
	Player player;
	Player leaderboard[];
	Font tabFont = new Font("Arial", Font.BOLD, 25);
	Font textFont = new Font("Arial", Font.BOLD, 18);
	JPanel leaderboardPanel = new JPanel();;
	JLabel leaderboardTextLabel = new JLabel();
	
	public Leaderboard(Player player)
	{
		this.player = player;
		//fillBoard();
		//createLeaderboard();
	}
	
	public void fillBoard()
	{
		Player John = new Player();
		John.updateWorkHours(100);
		//John.updateMoney(10000);
		//John.updateLevel(John.getWorkHours());
		John.setName("John");
		
    	Player Steve = new Player();
    	Steve.updateWorkHours(900);
    	//Steve.updateMoney(13000);
    	//Steve.updateLevel(John.getWorkHours());
    	Steve.setName("Steve");
    	
    	Player Max = new Player();
    	Max.updateWorkHours(750);
    	//Max.updateMoney(11000);
    	//Max.updateLevel(John.getWorkHours());
    	Max.setName("Max");
    	
		leaderboard = new Player[] {John, Steve, Max, player};
	}
	
	public void rankByHours()
	{
		fillBoard();
		//sorts by category
		for(int i = 0; i < leaderboard.length-1; i++){
    		for(int j = 0; j < leaderboard.length-i-1; j++){
    			if ((leaderboard[j].getWorkHours()) < (leaderboard[j+1].getWorkHours())){
 /*   				Player swap = leaderboard[j+1];
    				leaderboard[j+1] = leaderboard[j];
    				leaderboard[j] = swap; */
    			}
    		} 
    	} 
		//creates title
		leaderboardTextLabel = new JLabel("Work Hours Leaderboard");
		leaderboardTextLabel.setFont(textFont);
		leaderboardPanel.add(leaderboardTextLabel);
		//prints name with parameter
		for(int x = 0; x < leaderboard.length; x++ ) {
//			leaderboardTextLabel = new JLabel(x+1+ "."+leaderboard[x].getName()+ " "+leaderboard[x].getWorkHours());
			leaderboardTextLabel.setFont(textFont);
			leaderboardPanel.add(leaderboardTextLabel);
		}
	}
	
	public void rankByLevel(JLabel leaderboardTextLabel, JPanel leaderboardTextPanel)
	{
		//sorts by category
		for(int i = 0; i < leaderboard.length-1; i++){
    		for(int j = 0; j < leaderboard.length-i-1; j++){
    			if (leaderboard[j].getLevel() < leaderboard[j+1].getLevel()){
    				Player swap = leaderboard[j+1];
    				leaderboard[j+1] = leaderboard[j];
    				leaderboard[j] = swap;
    			}
    		}
    	}
		//creates title
		leaderboardTextLabel = new JLabel("Level Leaderboard");
		leaderboardTextLabel.setFont(textFont);
		leaderboardTextPanel.add(leaderboardTextLabel);
		//prints name with parameter
		for(int x = 0; x < leaderboard.length; x++ ) {
			leaderboardTextLabel = new JLabel(x+1+ "."+leaderboard[x].getName()+ " "+leaderboard[x].getLevel());
			leaderboardTextLabel.setFont(textFont);
			leaderboardTextPanel.add(leaderboardTextLabel);
		}
	}
	
	public void rankByMoney(JLabel leaderboardTextLabel, JPanel leaderboardTextPanel)
	{
		//sorts by category
		for(int i = 0; i < leaderboard.length-1; i++){
    		for(int j = 0; j < leaderboard.length-i-1; j++){
    			if (leaderboard[j].getMoney() < leaderboard[j+1].getMoney()){
    				Player swap = leaderboard[j+1];
    				leaderboard[j+1] = leaderboard[j];
    				leaderboard[j] = swap;
    			}
    		}
    	}
		// creates title 
		leaderboardTextLabel = new JLabel("Money Leaderboard");
		leaderboardTextLabel.setFont(textFont);
		leaderboardTextPanel.add(leaderboardTextLabel);
		//prints name with parameter
		for(int x = 0; x < leaderboard.length; x++ ) {
			leaderboardTextLabel = new JLabel(x+1+ "."+leaderboard[x].getName()+ " "+leaderboard[x].getMoney());
			leaderboardTextLabel.setFont(textFont);
			leaderboardTextPanel.add(leaderboardTextLabel);
		}
	}
	
	public JPanel createLeaderboard()
	{
		leaderboardPanel = new JPanel();
		//fillBoard();
		leaderboardPanel.setLayout(new BoxLayout(leaderboardPanel, BoxLayout.PAGE_AXIS));
		leaderboardPanel.setBackground(Color.WHITE);
		leaderboardTextLabel = new JLabel();
		//rankByMoney(leaderboardTextLabel, leaderboardPanel);
		rankByHours();
		//rankByLevel(leaderboardTextLabel, leaderboardPanel);
		
		return leaderboardPanel;
	}

}
