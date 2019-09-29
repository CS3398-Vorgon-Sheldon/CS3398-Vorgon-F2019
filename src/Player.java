public class Player {

    // how much the player currently has
    private int balance;
    // array of current upgrades
    //private Upgrades upgrades[];
    private boolean debug = true;
    private int clickPower;

    Player(){
        balance = 0;
        clickPower = 1;
    }

    public void updateBalance(int amount) {
        balance += amount;
        displayBalance();
    }

    public void displayBalance(){
        System.out.println("Balance: " + balance);
    }
    public int getBalance(){ return balance; }
    // this is called constantly, use to update balance
    public void update(){
        //if(debug)
            //System.out.println("Player Update called");

    }
    /*
    maybe a click modifier
     */
}
