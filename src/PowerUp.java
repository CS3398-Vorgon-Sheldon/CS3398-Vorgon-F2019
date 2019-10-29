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
		String[] optionFlavorTexts = { "Description of ability 1", "Description of ability 2", "Description of ability 3", "Description of ability 4", "Description of ability 5" };

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

		JComboBox powerUpBox = new JComboBox<>(powerUpOptions);
        powerUpBox.setBackground(Color.white);
		powerUpBox.setBorder(new LineBorder(Color.DARK_GRAY));
		powerUpBox.setFont(new Font("Arial", Font.PLAIN, 20));

		powerUpBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				flavorTextPane.setText("\n" + optionFlavorTexts[powerUpBox.getSelectedIndex()]);
				optionList.setSelectedIndex(powerUpBox.getSelectedIndex());
			}
		});

		optionList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (e.getValueIsAdjusting() == false)
				{
					flavorTextPane.setText("\n" + optionFlavorTexts[optionList.getSelectedIndex()]);
					powerUpBox.setSelectedIndex(optionList.getSelectedIndex());
				}
				else
				{
					//System.out.println("The value is adjusting.");
				}
			}
		});

		JButton activateButton = new JButton("Activate");
        activateButton.setBackground(Color.ORANGE);
		activateButton.setBorder(new LineBorder(Color.DARK_GRAY));
		activateButton.setPreferredSize(new Dimension(85, 40));
		activateButton.setFont(new Font("Arial", Font.PLAIN, 20));
		activateButton.setFocusPainted(false);

		activateButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				//code to activate power up
				String s = String.valueOf("Activate: " + powerUpBox.getSelectedItem());
				JOptionPane.showMessageDialog(null, s);
			}
	    });

		gbc.fill = GridBagConstraints.HORIZONTAL;
		rightPanel.add(powerUpBox, gbc);
		rightPanel.add(Box.createRigidArea(new Dimension(50, 15)), gbc);
		gbc.fill = GridBagConstraints.NONE;
		rightPanel.add(activateButton, gbc);

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
