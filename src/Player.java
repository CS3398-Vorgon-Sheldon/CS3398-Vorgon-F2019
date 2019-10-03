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

    Player(){
        workHours = 0;
        money = 0;
        clickPower = 1;
        level = 1;                                           //level will unlock the powerups you can buy in shop
    }

    public void updateWorkHours(int amount) {
        workHours += amount;
        displayWorkHours();
    }

    public void displayWorkHours(){
        System.out.println("Hours Worked: " + workHours);
    }
    
    //updates money
    public void updateMoney(int amount) {
    	
        money += amount;
        
    }

    public int getWorkHours(){ return workHours; }
    // this is called constantly, use to update balance
    public int getMoney(){ return money; }
    
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
    
    public int getLevel(){ return level; }

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
          clickPower = 1
        }
        else
        {
          clickPower = 1*prestige //
        }


    }
    
    //*******************************************
    //ADDED SET TIMER FOR AUTO CLICKER
    public void setTimer(boolean start, int speed) {
    	
    	timer = new Timer(speed, new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e){
    			
    			balance++;
    			
    		}
    	});
    	
    	if (start == true) {
    		
    		timer.start();
    		
    	}
    	
    }//end setTimer
    

    public void update(){
        //if(debug)
            //System.out.println("Player Update called");

    }
    /*
    maybe a click modifier
     */
}
