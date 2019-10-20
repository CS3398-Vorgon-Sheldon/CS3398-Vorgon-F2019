public class Client {

    // Name of the client or job that will be done.
    private String title;
    // how much money the player will receive as base.
    private int payment;
    // how many hours the player will input to complete job
    private int hourPay;
    // short description of what is being asked of the player in universe
    private String flavorText;
    // keeps track of total job completions for a client
    private int timesDone;
    // intended for level implementation
    private int level;

    //default contructor. not planned to be called
    Client(){
        title = null;
        payment = 0;
        hourPay = 0;
        flavorText = null;
        timesDone = 0;
        level = 0;
    }

    //constructor that is planned to be called when first opened
    Client(String name, int pay, int hours, String text){
        title = name;
        payment = pay;
        hourPay = hours;
        flavorText = text;
        timesDone = 0;
        level = 0;
    }

    //constructor called that includes times Done number. Planned for Save/Load
    Client(String name, int pay, int hours, String text, int completed, int currentLevel){
        title = name;
        payment = pay;
        hourPay = hours;
        flavorText = text;
        timesDone = completed;
        level = currentLevel;
    }

    Client(Client copy){
        title = copy.title;
        payment = copy.payment;
        hourPay = copy.hourPay;
        flavorText = copy.flavorText;
        timesDone = copy.timesDone;
        level = copy.level;
    }

//  old workClient that doesn't integrate levels
/*    public void workClient(Player player) {
        if(player.getWorkHours() >= hourPay){
            player.updateWorkHours(hourPay * -1);
            player.updateMoney(payment);
            timesDone++;
        }
    }
*/
    //second version that includes level progression but not implemented yet
    public void workClient(Player player){
        if(player.getWorkHours() >= newHours()){
            player.updateWorkHours(newHours() * -1);
            player.updateMoney(newPay());
            timesDone++;
        }

    }

    //calculates client level based on timesDone level = log(timesDone)-2. level >=0
    public void calcLevel(){
        int counter = 0;
        int levelTracker = timesDone;

        while(levelTracker > 10){
            if(counter < 10){
                levelTracker /= 10;
                counter++;
            }
            else{
                levelTracker = 1;
            }
        }
        level = counter;
    }

    //Intended for level integration. Uses base hours and multiplies by a 0.05
    //constant and subtracts that from hour pay
    public int newHours(){
        return (int)(hourPay * (1 - (level * 0.05)));
    }

    //Intended for level integration. Uses base hours and multiplies by a 0.05
    //constant and adds that to payment
    public int newPay(){
        return (int)(payment * (1 + (level * 0.05)));
      }

    //getters for display in GUI
    public String getTitle(){return title;}
    public int getPayment(){return payment;}
    public int getHourPay(){return hourPay;}
    public String getFlavorText(){return flavorText;}

    //setters for initialization
    public void setTitle(String name){this.title = name;}
    public void setPayment(int num){this.payment = num;}
    public void setHourPay(int num){this.hourPay = num;}
    public void setFlavorText(String text){this.flavorText = text;}




}
