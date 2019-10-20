
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class Player {

    // how much the player currently has
    private int workHours;
    private int money;
    private int prestige;
    private int level;                                        //level is calculated by hours worked to unlock
    // array of current upgrades
    //private Upgrades upgrades[];
    private boolean debug = true;
    private int clickPower;
    Timer timer;

    Player(){
        workHours = 0;
        money = 200; //testing purposes Change this back when clients have been introduced
        clickPower = 1;
        level = 1;                                           //level will unlock the powerups you can buy in shop
    }

//updates workHours
    public void updateWorkHours(int amount) {
        workHours += amount;
        displayWorkHours();
    }

//helps us debugg by being able to look at command console and see that our inputs are going through
    public void displayWorkHours(){
        System.out.println("Hours Worked: " + workHours);
    }

//updates money
    public void updateMoney(int amount) {
        money += amount;
        displayMoney();
    }

//helps us debugg by being able to look at command console and see that our inputs are going through
    public void displayMoney(){
        System.out.println("Money: " + money);
    }





    public void updateLevel(int hrs) {                    //updates and calculates for next level
    	int xpNeeded = ((level * level) * 50);
        if (hrs == xpNeeded)
        {
        	level++;
        }
        displayLevel();
    }

    public void displayLevel(){
        System.out.println("Current Level: " + level);
    }



    /*
    Only called during a reset or "ascension". Adds prestige currency
    should return a value of log(base10)moneyEarned so 10 dollars reset gives 1
    100 = 2, 1,000 = 3, 1E10 = 10, 1E1000 = 1000
    */
    public void calcPrestige(int moneyEarned){
        int counter = 0;

        while(moneyEarned > 9)
        {
          moneyEarned = moneyEarned / 10;

          counter++;
        }
        prestige = counter;

    }

    //sets clickPower
    public void setClickPower(int count) {

    	clickPower = count;

    }//end setClickPower

    //returns clickPower
    public int getClickPower() {

    	return clickPower;

    }//end getClickPower

    /*
    called after purchasing upgrades or after reseting. Determines the clicking
    power of the main clicker.
    Full formula without prestige should be (1 + additive_bonuses)*multiplicative_bonuses
    Full formula w/ prestige adds 2^prestige. So 10 prestige should give 1024 multiplicative_bonus
    actually with that formula we don't even need the if statement b/c 2^0 = 1
    */
    public void calcClickPower(){

        if(prestige == 0)
        {
          clickPower = 1;
        }
        else
        {
          clickPower = 1*prestige; //
        }
    }

    //*******************************************
    //ADDED SET TIMER FOR AUTO CLICKER
    public void setTimer(boolean start, int speed) {
      	timer = new Timer(speed, new ActionListener() {
          	public void actionPerformed(ActionEvent e){
          		  workHours++;
          	}
      	});

    	  if (start == true) {
    		    timer.start();
    	  }
    }//end setTimer

//getters
    public int getWorkHours(){ return workHours; }
    public int getMoney(){ return money; }
    public int getLevel(){ return level; }
    public int getClickPower() { return clickPower; }

//setters
    public void setClickPower(int count) {clickPower = count;}


    public void update(){
        //if(debug)
            //System.out.println("Player Update called");

    }
    /*
    maybe a click modifier
     */
}
