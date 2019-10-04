import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private int workHours;
    private int money;
    private int prestige;
    private int level;
    private ImageIcon shopIcon = new ImageIcon(getClass().getResource("store.jpg"));    //gets image files
    private ImageIcon jobIcon = new ImageIcon(getClass().getResource("jobs.jpg"));
    private ImageIcon workDeskIcon = new ImageIcon(getClass().getResource("workdesk.jpg"));
    private ImageIcon powerUpIcon = new ImageIcon(getClass().getResource("powerup.jpg"));

    JLabel workLabel = new JLabel("Hours worked: " + String.valueOf(workHours));
    JLabel moneyLabel = new JLabel("Dollars: $" + String.valueOf(money));
    JLabel levelLabel = new JLabel("Current level: " + String.valueOf(level));
    JLabel shopLabel = new JLabel(shopIcon);                                //for shop Icon
    JLabel jobLabel = new JLabel(jobIcon);                                  //for job Icon
    JLabel workDeskLabel = new JLabel(workDeskIcon);                         //for workdek Icon
    JLabel powerUpLabel = new JLabel(powerUpIcon);                        //for powerup Icon

    JButton jobButton = new JButton("Do job");
    JButton powerButton = new JButton("Power up!");
    JButton shopButton = new JButton("Buy from shop");

    JLabel jobFlavorLabel = new JLabel("Job description flavor text...");
    JLabel powerFlavorLabel = new JLabel("Power up flavor text...");
    JLabel shopFlavorLabel = new JLabel("Shop/item flavor text...");

    String jobOptions[] = { "Job 1", "Job 2", "Job 3" };
    String powerOptions[] = { "Power up 1", "Power up 2", "Power up 3" };
    
    String shopOptions[] = {"Plus 1: $20", 
							"Auto Clicks: $50", 
							"Employee Upgrade: $100" };

    private class MyPanel extends JPanel {
        Controller controller;

        MyPanel(Controller c) {
            controller = c;
            addMouseListener(c);
        }

        public void paintComponent(Graphics g) {
            revalidate();
            controller.update(g);
            workHours = controller.player.getWorkHours();
        }
    }

    public View(Controller c)throws Exception{
        int workHours = c.player.getWorkHours();
        int money = c.player.getMoney();
        int level = c.player.getLevel();

        setTitle("Vorgon Clicker!");
        setSize(750,750); // subject to change
        getContentPane().add(workDeskLabel,BorderLayout.WEST);             //for showing desk image
        getContentPane().add(new MyPanel(c), BorderLayout.CENTER);
        

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.darkGray);
        workLabel.setForeground(Color.white);
        moneyLabel.setForeground(Color.white);
        levelLabel.setForeground(Color.white);
        topPanel.add(workLabel, BorderLayout.WEST);
        topPanel.add(moneyLabel, BorderLayout.CENTER);
        topPanel.add(levelLabel, BorderLayout.EAST);

        getContentPane().add(topPanel, BorderLayout.PAGE_START);

        // begin side menu
        GridBagLayout sideLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        JPanel sidePanel = new JPanel(sideLayout);
        sidePanel.setBackground(Color.darkGray);
        

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel sideTitle = new JLabel("Modifier Menu:", SwingConstants.CENTER);
        sideTitle.setForeground(Color.white);
        sidePanel.add(sideTitle, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        
        JComboBox jobBox = new JComboBox(jobOptions);
        //sidePanel.add(new JComboBox<>(jobOptions), gbc);
        sidePanel.add(jobBox, gbc);
        
        gbc.gridx = 1;
        sidePanel.add(jobButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        jobFlavorLabel.setForeground(Color.white);
        sidePanel.add(jobFlavorLabel, gbc);
        gbc.gridx = 1;
        sidePanel.add(jobLabel, gbc);                          //shows job image
        

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        
        JComboBox powerBox = new JComboBox(powerOptions);
        //sidePanel.add(new JComboBox<>(powerOptions), gbc);
        sidePanel.add(powerBox, gbc);
        
        
        gbc.gridx = 1;
        sidePanel.add(powerButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        powerFlavorLabel.setForeground(Color.white);
        sidePanel.add(powerFlavorLabel, gbc);
        gbc.gridx = 1;
        sidePanel.add(powerUpLabel, gbc);                          //shows powerup image

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        
        
        
        JComboBox shopBox = new JComboBox(shopOptions);
        //sidePanel.add(new JComboBox<>(shopOptions), gbc);
        sidePanel.add(shopBox, gbc);
        
        gbc.gridx = 1;
        sidePanel.add(shopButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        shopFlavorLabel.setForeground(Color.white);
        sidePanel.add(shopFlavorLabel, gbc);
        gbc.gridx = 1;
        sidePanel.add(shopLabel, gbc);                          //shows shop image

        getContentPane().add(sidePanel, BorderLayout.EAST);
        // end side menu

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //Shop actionlistener
       /* BUTTON FOR SHOP
        * UNCOMMENT TO TEST
        shopButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              //if user's wallet is less than cost. They cannot purchase
        	  if(c.player.getWallet() < c.shop.getCost(shopBox.getSelectedIndex())) {
        		    		  
        		  //display error message
        		  
        	  }else {
        		  
        		  //purchase upgrade
        		  c.shop.purchase(shopBox.getSelectedIndex());
        		  
        	  }
        	  
          }
        });   */     
        
        
        
        
    }

    public void actionPerformed(ActionEvent evt){ repaint();}
}
