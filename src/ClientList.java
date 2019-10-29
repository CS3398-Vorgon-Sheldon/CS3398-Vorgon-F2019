import java.io.FileReader;
import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
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


//manually setting the clients since I can't get the File Reader to work
    public void ClientList() throws Exception {
        clients[0].setTitle("Classmate's homework");
        clients[0].setPayment(5);
        clients[0].setHourPay(3);
        clients[0].setFlavorText("Jack forgot to do his homework and the due date is upcoming");

        clients[1].setTitle("Dr.Lehr's Sprint");
        clients[1].setPayment(20);
        clients[1].setHourPay(10);
        clients[1].setFlavorText("Dr.Lehr assigned another sprint and Jerry needs someone to help him with his part.");

        clients[2].setTitle("Design Operating System Simulation");
        clients[2].setPayment(400);
        clients[2].setHourPay(100);
        clients[2].setFlavorText("Dr. Palacios assigned a very vague project one. Work like hell to finish it.");

        clients[3].setTitle("CS Final Project");
        clients[3].setPayment(10000);
        clients[3].setHourPay(1000);
        clients[3].setFlavorText("Josh is lost in computer architecture, finish his final project so he can pass the course.");

        clients[4].setTitle("Set up Company's Network");
        clients[4].setPayment(100000);
        clients[4].setHourPay(5000);
        clients[4].setFlavorText("Enjoy the rest of your life doing CS Stuff");
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
    		String[] shopOptions = { "Why", "wont", "it", "work", "Right!!" };
    		String[] optionFlavorTexts = { "Description 1", "Description 2", "Description 3", "Description 4", "Description 5" };

    		JList optionList = new JList<>(shopOptions);
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

    		JComboBox shopBox = new JComboBox<>(shopOptions);
            shopBox.setBackground(Color.white);
    		shopBox.setBorder(new LineBorder(Color.DARK_GRAY));
    		shopBox.setFont(new Font("Arial", Font.PLAIN, 20));

    		JButton buyButton = new JButton("Buy");
            buyButton.setBackground(new Color(133, 187, 101)); //green
    		buyButton.setBorder(new LineBorder(Color.DARK_GRAY));
    		buyButton.setPreferredSize(new Dimension(60, 40));
    		buyButton.setFont(new Font("Arial", Font.PLAIN, 20));
    		buyButton.setFocusPainted(false);

    		gbc.fill = GridBagConstraints.HORIZONTAL;
    		rightPanel.add(shopBox, gbc);
    		rightPanel.add(Box.createRigidArea(new Dimension(50, 15)), gbc);
    		gbc.fill = GridBagConstraints.NONE;
    		rightPanel.add(buyButton, gbc);

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
