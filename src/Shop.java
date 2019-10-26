import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop {

	Player player;
    
	private int cost[] = new int[]{20, 50, 100};
	
	final int WINDOW_WIDTH = 800; // Window width in pixels
	final int WINDOW_HEIGHT = 600; // Window height in pixels

    
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
	
	public void shopMenu() {
		
		JFrame shopFrame = new JFrame();
		shopFrame.setTitle("Shop");
		shopFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		shopFrame.setLayout(new BorderLayout());
		
		shopFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		shopFrame.getContentPane().setBackground(Color.white);
		
		// Shop Options
		 
		
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
	       shopFrame.setVisible(false);
	      }
	    }); 	 
		 
		bottomPanel.add(exitButton);
		 
		shopFrame.add(bottomPanel, BorderLayout.SOUTH);
		
		shopFrame.setLocationRelativeTo(null);
		
		shopFrame.setVisible(true);
		
	}//end shopMenu
    
}
