import javax.swing.*;
import javax.swing.border.LineBorder;

//import javafx.scene.Cursor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private int workHours;
    private int money;
    private int prestige;
    private int level;
    
    private ImageIcon shopIcon = new ImageIcon(getClass().getResource("store.jpg"));  //gets image files
    private ImageIcon jobIcon = new ImageIcon(getClass().getResource("jobs.jpg"));
    private ImageIcon powerUpIcon = new ImageIcon(getClass().getResource("powerup.jpg"));
    private ImageIcon statsIcon = new ImageIcon(getClass().getResource("stats.png"));
    private ImageIcon kbImage = new ImageIcon(getClass().getClassLoader().getResource("keyboard.png"));
 
    
    JLabel workLabel = new JLabel("Hours worked: " + String.valueOf(workHours));
    JLabel moneyLabel = new JLabel("Dollars: $" + String.valueOf(money));
    JLabel levelLabel = new JLabel("Current level: " + String.valueOf(level));
    JLabel shopLabel = new JLabel(shopIcon);  //for shop Icon
    JLabel jobLabel = new JLabel(jobIcon);  //for job Icon
    JLabel powerUpLabel = new JLabel(powerUpIcon);  //for powerup Icon

    JPanel kbPanel = new JPanel();
    JButton kbButton = new JButton();

    final int WINDOW_WIDTH = 800; // Window width in pixels
    final int WINDOW_HEIGHT = 600; // Window height in pixels

	JLabel counterLabel;
	JButton jobsButton, powerUpButton, shopButton, statsButton;

    public View(Controller c) throws Exception {

	      // Set the title.
        setTitle("Vorgon Clicker!");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //Layout
        setLayout(new BorderLayout());

	      // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);

        kbPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        kbPanel.setBounds(300, 175, 210, 92);
        kbPanel.setBackground(Color.white);
        add(kbPanel, BorderLayout.CENTER);

        kbButton.setBackground(Color.white);
        kbButton.setFocusPainted(false);
        kbButton.setBorder(null);
        kbButton.setIcon(kbImage);

        // Update work hours when clicked
        kbButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Sounds.playSound("coin.wav");
                
                
                if(PowerUp.powerUp1activated) {
                    c.player.updateWorkHours(2); //Powerup activated = double pay.
                }
                else {
                    c.player.updateWorkHours(1); //No powerup = regular pay.
                }
                counterLabel.setText("Work Hours: " + c.player.getWorkHours());
                //System.out.println("RandomEVENT: " + c.randomevents.event());
                
                c.randomevents.event();            	

            }
        });

        kbPanel.add(kbButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(310, 80, 210, 80);
        counterPanel.setBackground(Color.white);
        add(counterPanel);

        counterLabel = new JLabel(" Work Hours: " + c.player.getWorkHours());
        counterLabel.setBackground(Color.white);
        Font counterFont = new Font("Arial", Font.BOLD, 24);
        counterLabel.setFont(counterFont);
        counterPanel.add(counterLabel, BorderLayout.PAGE_START);

        //Buttons at the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        jobsButton = new JButton();
        powerUpButton = new JButton();
        shopButton = new JButton();
        statsButton = new JButton();

        setNavButtonProperties(jobsButton, jobIcon, "Clients");
        setNavButtonProperties(powerUpButton, powerUpIcon, "Power Ups");
        setNavButtonProperties(shopButton, shopIcon, "Shop");
        setNavButtonProperties(statsButton, statsIcon, "Statistics");

        bottomPanel.add(jobsButton);
        bottomPanel.add(powerUpButton);
        bottomPanel.add(shopButton);
        bottomPanel.add(statsButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Jobs button ActionListener
        jobsButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            Sounds.playSound("job.wav");
            c.clientList.clientMenu();
          }
        });

        // Power Up button ActionListener
        powerUpButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              Sounds.playSound("powerup.wav");
              c.powerUp.powerUpMenu();
          }
        });

        // Shop button ActionListener
        shopButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            Sounds.playSound("coin.wav");
            c.shop.shopMenu();
          }
        });

        // Stats button ActionListener
        statsButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            Sounds.playSound("pause.wav");
            c.stats.statsMenu();
          }
        });

        // Start the application in the center of the screen
        setLocationRelativeTo(null);

        // Display the window.
        setVisible(true);

    }

    // Sets properties for the bottom navigation buttons
    public void setNavButtonProperties(JButton button, ImageIcon icon, String toolTipText) {
      button.setIcon(icon);
      button.setToolTipText(toolTipText);
      button.setBackground(Color.white);
      button.setBorder(new LineBorder(Color.DARK_GRAY));
      button.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent e) { repaint(); }
}
