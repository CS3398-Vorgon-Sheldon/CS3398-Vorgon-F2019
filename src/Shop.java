import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//import sun.net.www.content.image.jpeg;

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
			String[] shopOptions = { "Shop Item 1", "Shop Item 2", "Shop Item 3", "Shop Item 4", "Shop Item 5" };
			String[] optionFlavorTexts = { "Item Description 1", "Item Description 2", "Item Description 3", "Item Description 4", "Item Description 5" };
			
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

			optionList.addListSelectionListener(new ListSelectionListener()
			{
			public void valueChanged(ListSelectionEvent e)
			{
				if (e.getValueIsAdjusting() == false)
				{
					flavorTextPane.setText("\n" + optionFlavorTexts[optionList.getSelectedIndex()]);
				}
				else
				{
				//System.out.println("The value is adjusting.");
				}
			}
			});

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

			buyButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					//code to buy item
					String s = String.valueOf("Buy: " + shopBox.getSelectedItem());
					JOptionPane.showMessageDialog(null, s);
				}
			});

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

			shopFrame.add(centerSplitPane, BorderLayout.CENTER);

			// Buttons at the bottom
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			//bottomPanel.setBackground(Color.LIGHT_GRAY);

			JButton exitButton = new JButton("Exit");
			exitButton.setBackground(Color.white);
			exitButton.setBorder(new LineBorder(Color.DARK_GRAY));
			exitButton.setPreferredSize(new Dimension(60, 40));
			exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
			exitButton.setFocusPainted(false);
//---------------------------------------------------------------------------------------------------------------------------------
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
