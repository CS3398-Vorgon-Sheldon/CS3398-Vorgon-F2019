import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUp {

	Player player;
	
	final int WINDOW_WIDTH = 800; // Window width in pixels
	final int WINDOW_HEIGHT = 600; // Window height in pixels

    
    public PowerUp(Player player){
    
        this.player = player;
        
    }
	
	public void powerUpMenu() {
		
		JFrame powerUpFrame = new JFrame();
		powerUpFrame.setTitle("Power Ups");
		powerUpFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		powerUpFrame.setLayout(new BorderLayout());
		
		powerUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		powerUpFrame.getContentPane().setBackground(Color.white);

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
		
		// Power ups Options
		String[] powerUpOptions = { "Power Up 1", "Power Up 2", "Power Up 3", "Power Up 4", "Power Up 5" };
		String[] optionFlavorTexts = { "Description 1", "Description 2", "Description 3", "Description 4", "Description 5" };

		JList optionList = new JList<>(powerUpOptions);
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

		JComboBox shopBox = new JComboBox<>(powerUpOptions);
        shopBox.setBackground(Color.white);
		shopBox.setBorder(new LineBorder(Color.DARK_GRAY));
		shopBox.setFont(new Font("Arial", Font.PLAIN, 20));

		JButton buyButton = new JButton("Activate");
        buyButton.setBackground(Color.ORANGE);
		buyButton.setBorder(new LineBorder(Color.DARK_GRAY));
		buyButton.setPreferredSize(new Dimension(85, 40));
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

		powerUpFrame.add(centerSplitPane, BorderLayout.CENTER);
		
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
			  powerUpFrame.setVisible(false);
	      }
	    }); 	 
		 
		bottomPanel.add(exitButton);
		 
		powerUpFrame.add(bottomPanel, BorderLayout.SOUTH);
		
		powerUpFrame.setLocationRelativeTo(null);
		
		powerUpFrame.setVisible(true);
		
	}
    
}
