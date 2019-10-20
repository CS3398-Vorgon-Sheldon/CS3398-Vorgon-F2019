public class Player {

    // how much the player currently has
    private int workHours;
    private int money;
    // array of current upgrades
    //private Upgrades upgrades[];
    private boolean debug = true;
    private int clickPower;

    Player(){
        workHours = 0;
        clickPower = 1;
    }

    public void updateWorkHours(int amount) {
        workHours += amount;
        displayWorkHours();
    }

/*    public void subtractWorkHours(int amount) {
        workHours -= amount;
        displayWorkHours();
    }
*/

    public void updateMoney(int amount) {
        money += amount;
        displayMoney();
    }

/*
    public void subtractMoney(int amount) {
        money -= amount;
        displayWorkHours();
    }
*/

    public void displayWorkHours(){
        System.out.println("Hours Worked: " + workHours);
    }

    public void displayMoney(){
        System.out.println("Money: " + money);
    }

    public int getWorkHours(){ return workHours; }
    // this is called constantly, use to update balance
    public int getMoney(){ return money; }

    public void update(){
        //if(debug)
            //System.out.println("Player Update called");

    }
    /*
    maybe a click modifier
     */
}
