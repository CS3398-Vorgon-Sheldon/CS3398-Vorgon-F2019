import java.io.FileReader;
import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientList {

    static int clientLength = 5;

    Client[] clients = new Client[clientLength];

    Player player;
    View view;

//manually setting the clients since I can't get the File Reader to work
    public ClientList(Player player, View view) {
      this.player = player;
      this.view = view;
    }

//This is supposed to utilize a file reader to read individual lines off of a text file but
//it is not functional right now but WHEN IT IS I"LL USE THIS INstead of that abomination above.
/*
    public void ClientList() throws Exception {

        FileReader fr = new FileReader("clientList.txt");
        Scanner inFile = new Scanner(fr);

        for(int i = 0 ; i < clientLength; i++){
            clients[i].setTitle(inFile.nextLine());
            clients[i].setPayment(Integer.parseInt(inFile.nextLine()));
            clients[i].setHourPay(Integer.parseInt(inFile.nextLine()));
            clients[i].setFlavorText(inFile.nextLine());
        }
        inFile.close(); //Close file
    }
*/


    //getter for a specific client from the list
    public Client getClient(int index){
        return clients[index];
    }


    final int WINDOW_WIDTH = 800; // Window width in pixels
	  final int WINDOW_HEIGHT = 600; // Window height in pixels
//The Gui implementation
    public void clientMenu() {

        JFrame clientFrame = new JFrame();
        clientFrame.setTitle("Clients");
        clientFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        clientFrame.setLayout(new BorderLayout());

        clientFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        clientFrame.getContentPane().setBackground(Color.white);

        // Clients Options
//---------------------------------------------------------------------------------------------------------------------------------
        JPanel leftPanel = new JPanel();
    	leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
    	leftPanel.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.gridwidth = GridBagConstraints.REMAINDER;
    	leftPanel.setBackground(Color.white);

    	JPanel rightPanel = new JPanel();
    	rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
    	rightPanel.setLayout(new GridBagLayout());
    	rightPanel.setBackground(Color.white);

    	// Shop Options
    	String[] clientOptions = { "Classmate's homework", "Dr.Lehr's Sprint",
                    "Design Operating System Simulation", "CS Final Project",
                    "Set up Company's Network" };
        String[] optionFlavorTexts = { "Jack forgot to do his homework and the due date is upcoming",
                    "Dr.Lehr assigned another sprint and Jerry needs someone to help him with his part.",
                    "Dr. Palacios assigned a very vague project one. Work like hell to finish it.",
                    "Josh is lost in computer architecture, finish his final project so he can pass the course.",
                    "Enjoy the rest of your life doing CS Stuff" };

        JList optionList = new JList<>(clientOptions);
		optionList.setBorder(new LineBorder(Color.DARK_GRAY));
		optionList.setFont(new Font("Arial", Font.PLAIN, 20));
		optionList.setSelectedIndex(0);

		JTextPane flavorTextPane = new JTextPane();
		//flavorTextArea.setBackground(Color.LIGHT_GRAY);
		flavorTextPane.setBorder(new LineBorder(Color.DARK_GRAY));
		flavorTextPane.setPreferredSize(new Dimension(400, 200));
		flavorTextPane.setFont(new Font("Arial", Font.PLAIN, 20));
		flavorTextPane.setEditable(false);
		flavorTextPane.setText("\n" + optionFlavorTexts[0]);

		StyledDocument doc = flavorTextPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		leftPanel.add(optionList, gbc);
		leftPanel.add(Box.createRigidArea(new Dimension(50, 15)), gbc);
		gbc.fill = GridBagConstraints.NONE;
		leftPanel.add(flavorTextPane, gbc);

		JComboBox clientBox = new JComboBox<>(clientOptions);
        clientBox.setBackground(Color.white);
		clientBox.setBorder(new LineBorder(Color.DARK_GRAY));
		clientBox.setFont(new Font("Arial", Font.PLAIN, 20));

		clientBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				flavorTextPane.setText("\n" + optionFlavorTexts[clientBox.getSelectedIndex()]);
				optionList.setSelectedIndex(clientBox.getSelectedIndex());
			}
		});

		optionList.addListSelectionListener(new ListSelectionListener()
		{
            public void valueChanged(ListSelectionEvent e)
            {
                if (e.getValueIsAdjusting() == false)
                {
                    flavorTextPane.setText("\n" + optionFlavorTexts[optionList.getSelectedIndex()]);
					clientBox.setSelectedIndex(optionList.getSelectedIndex());
                }
                else
                {
                    //System.out.println("The value is adjusting.");
                }
            }
		});

		JButton hireButton = new JButton("Work");
        hireButton.setBackground(Color.BLUE);
        hireButton.setForeground(Color.white);
		hireButton.setBorder(new LineBorder(Color.DARK_GRAY));
		hireButton.setPreferredSize(new Dimension(60, 40));
		hireButton.setFont(new Font("Arial", Font.PLAIN, 20));
        hireButton.setFocusPainted(false);

        hireButton.addActionListener(new ActionListener()
	    {
            public void actionPerformed(ActionEvent e)
            {

               String s = String.valueOf("Completed: " + clientBox.getSelectedItem());
               int cost   = 0;
               int payout = 0;

               if(s.equals("Completed: Classmate's homework")){
                 cost = 3;
                 payout = 5;
               }
               else if(s.equals("Completed: Dr.Lehr's Sprint")){
                 cost = 10;
                 payout = 20;
               }
               else if(s.equals("Completed: Design Operating System Simulation")){
                 cost = 100;
                 payout = 400;
               }
               else if(s.equals("Completed: CS Final Project")){
                 cost = 1000;
                 payout = 10000;
               }
               else if(s.equals("Completed: Set up Company's Network")){
                 cost = 5000;
                 payout = 100000;
               }


               if(player.getWorkHours() < cost) {

                 JOptionPane.showMessageDialog(null, "Not Enough Hours");

               }

               else {
                 cost = cost *-1;
                 player.updateWorkHours(cost);
                 player.updateMoney(payout);
                 player.updateJobsDone();

                 //moneyLabel.setText("Current Funds: $" + player.getMoney());


                 JOptionPane.showMessageDialog(null, s);

              }
            }
	    });

		gbc.fill = GridBagConstraints.HORIZONTAL;
		rightPanel.add(clientBox, gbc);
		rightPanel.add(Box.createRigidArea(new Dimension(50, 15)), gbc);
		gbc.fill = GridBagConstraints.NONE;
		rightPanel.add(hireButton, gbc);

		JSplitPane centerSplitPane = new JSplitPane(SwingConstants.VERTICAL, leftPanel, rightPanel);
		centerSplitPane.setResizeWeight(0.5);
		centerSplitPane.setOrientation(SwingConstants.VERTICAL);

		// Set JSplitPane divider color
		BasicSplitPaneDivider divider = (BasicSplitPaneDivider)centerSplitPane.getComponent(2);
		divider.setBorder(new LineBorder(Color.LIGHT_GRAY, 5));
		divider.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		clientFrame.add(centerSplitPane, BorderLayout.CENTER);
//---------------------------------------------------------------------------------------------------------------------------------

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
                clientFrame.setVisible(false);
            }
        });

        bottomPanel.add(exitButton);

        clientFrame.add(bottomPanel, BorderLayout.SOUTH);

        clientFrame.setLocationRelativeTo(null);

        clientFrame.setVisible(true);

    }

}
