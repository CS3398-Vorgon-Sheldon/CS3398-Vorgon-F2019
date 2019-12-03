import java.util.ArrayList;
import java.util.List;

public class AchievementsList {

	List<String> aList = new ArrayList<>();
	
	private int[] workhourAchievements = {1, 100, 1000, 100000};
	private int[] power_upAchievements = {1, 10, 50};
	private int[] JobsAchievements = {1, 10, 50, 100};
	private int[] moneyAchievemetns = {25, 100, 250};
	
	public AchievementsList() {
		
		createList();
		
	}//end
	
	public void createList() {
		
		//Work hours
		aList.add("Hello World!: Complete " + workhourAchievements[0] + " work hour");
		aList.add("Have Stack Overflow bookmarked: Complete " + workhourAchievements[1] + " work hour");
		aList.add("Google is my best friend: Complete " + workhourAchievements[2] + " work hour");
		aList.add("You comment all your functions?: Complete " + workhourAchievements[3] + " work hour");
		
		//Power up
		aList.add("Have a little taste: Used " + power_upAchievements[0] + " power ups");
		aList.add("You are zooming: Used " + power_upAchievements[1] + " power ups");
		aList.add("You addicted?: Used " + power_upAchievements[2] + " power ups");
		
		//jobs
		aList.add("New Guy: Complete " + JobsAchievements[0] + " job");
		aList.add("Intern: Complete " + JobsAchievements[1] + " jobs");
		aList.add("Intern: Complete " + JobsAchievements[2] + " jobs");
		aList.add("Intern: Complete " + JobsAchievements[3] + " jobs");
		
		//money
		aList.add("Okay: Earn $" + moneyAchievemetns[0]);
		aList.add("Nice: Earn $" + moneyAchievemetns[1]);
		aList.add("Great: Earn $" + moneyAchievemetns[2]);
		
	}//end aList
	
	public List<String> getAchievementsList() {
		
		return aList;
		
	}//end
	
	public int[] getWhGoals() {
		return workhourAchievements;
	}//end
	
	public int[] getPowerUpGoals() {
		return power_upAchievements;
	}//end
	
	public int[] getJobGoals() {
		return JobsAchievements;
	}//end
	
	public int[] getMoneyGoals() {
		return moneyAchievemetns;
	}//end
	
}
