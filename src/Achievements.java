import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Achievements {
	
	AchievementsList al = new AchievementsList();
	
	Player player = new Player();
	
	//private JPanel achievementsPanel;
	List<String> aList = al.getAchievementsList();

	//get achievements list
	public int [] workGoal = al.getWhGoals();
	public int [] jobGoal = al.getJobGoals();
	public int [] clientGoal = al.getPowerUpGoals();
	public int [] moneyGoal = al.getMoneyGoals();
	
	JLabel[] achievementsTextLabel = new JLabel[aList.size()];
	Font tabFont = new Font("Arial", Font.BOLD, 25);
	Font textFont = new Font("Arial", Font.BOLD, 12);
	Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED); 
	
	
	//complete to see if achievements has been completed
	public void checkAchievements() {
		
			if(player.getWorkHours() > 0) {
				
				achievementsTextLabel[0].setForeground(Color.green);
				achievementsTextLabel[0].repaint();
				
			}
		
	}//end
	
	
	
	public JPanel achDisplay() {
		 
		
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
		
		EmptyBorder border = new EmptyBorder(5, 5, 5, 5);
        LineBorder line = new LineBorder(Color.white, 2, true);
        CompoundBorder compound = new CompoundBorder(line, border);
        
        
		for(int i = 0; i < aList.size(); i++) {
			
			//achievementsTextLabel[i] = new JLabel(aList.get(i));
			
			achievementsTextLabel[i] = new JLabel();
			achievementsTextLabel[i].setText(aList.get(i).toString());
			achievementsTextLabel[i].setFont(textFont);
			achievementsTextLabel[i].setBorder(compound);
			achievementsTextLabel[i].setOpaque(true);
			achievementsTextLabel[i].setBackground(Color.WHITE);
			achievementsTextLabel[i].setForeground(Color.RED);
			
			checkAchievements();
			
			achievementsTextPanel.add(achievementsTextLabel[i]);
			
			
			
		}//end for loop
		
		//completeAchievements();
		
		return achievementsTextPanel;
		
	}//end
}

