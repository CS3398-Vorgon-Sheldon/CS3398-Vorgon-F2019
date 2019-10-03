
public class Shop {

	Player player;
    
    private int cost[] = new int[]{20, 50, 100};

    
    public Shop(Player player){
    
        this.player = player;
        
    }//end shop
	
    public void purchase(int index) {
    	
    	switch(index) {
    		
    		
    		case 0:
    			player.setClickPower(player.getClickPower() + 1);
    			player.updateMoney(-(getCost(index)));
    			updateCost(index);
    			break;
    			
    		case 1:
    			player.setTimer(true, 1000);
    			player.updateMoney(-(getCost(index)));
    			updateCost(index);
    			break;
    			
    		case 2:
    	
    	
    	}//end switch
    	    	
    }//end buy
    
    public int getCost(int index) {
    	
    	return cost[index];
    	
    }//end getCost
    
    //User can buy same item multiple times
    //But the cost will increase after each purchase
    public void updateCost(int index) {
    	
    	cost[index] = cost[index] * 2;
    	
    	
    }//end updateCost
    
}
	

