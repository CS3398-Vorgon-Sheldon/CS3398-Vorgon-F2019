import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.List;

import java.util.*;
import java.lang.*;

public class RNGEvents {
	
	int rng;
	int event;
	Player player;
	
	public RNGEvents(Player player) {
		
		this.player = player;
		
	}//end RNGEvents

	
	public int getEvent() {
		
		event = 0;
		
		rng = getRandomIntegerBetweenRange(1, 20);
		
		if(rng == 10) {
			
			event = getRandomIntegerBetweenRange(1, 4);
			
		}//end if
		
		return event;
		
	}//end event
	
	public void event() {
		
		if(player.getMoney() > 30 & player.getWorkHours() > 10) {
		
			switch(getEvent()) {
			
			//gain $20
			case 1:	player.updateMoney(10);
					break;
					
			//lose $10
			case 2: player.updateMoney(-(10));
					break;
					
			//gain 20 work hours		
			case 3: player.updateWorkHours(10);
					break;
					
			//lose 10 hours		
			case 4: player.updateWorkHours(-(10));
					break;
					
			}//end switch
		
		}//end if
		
	}//end eventMessage
	
	public static int getRandomIntegerBetweenRange(int min, int max) {
		
		int x = (int)(Math.random() * max + min);
		
		return x;
		
	}//end getRandomIntegerBetweenRange
	
}//end main
