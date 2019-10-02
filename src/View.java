import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private int balance;
    JLabel label = new JLabel("Balance: " + String.valueOf(balance), SwingConstants.CENTER);
    
    JButton jobButton = new JButton("Do job");
    JButton powerButton = new JButton("Power up!");
    JButton shopButton = new JButton("Buy from shop");

    JLabel jobFlavorLabel = new JLabel("Job description flavor text...");
    JLabel powerFlavorLabel = new JLabel("Power up flavor text...");
    JLabel shopFlavorLabel = new JLabel("Shop/item flavor text...");

    String jobOptions[] = { "Job 1", "Job 2", "Job 3" };
    String powerOptions[] = { "Power up 1", "Power up 2", "Power up 3" };
    String shopOptions[] = { "Item 1", "Item 2", "Item 3" };

    private class MyPanel extends JPanel {
        Controller controller;

        MyPanel(Controller c) {
            controller = c;
            addMouseListener(c);
        }

        public void paintComponent(Graphics g) {
            revalidate();
            controller.update(g);
            balance = controller.player.getBalance();
        }
    }

    public View(Controller c)throws Exception{
        int balance = c.player.getBalance();

        setTitle("Vorgon Clicker!");
        setSize(750,750); // subject to change
        getContentPane().add(new MyPanel(c), BorderLayout.CENTER);
        getContentPane().add(label, BorderLayout.PAGE_START);

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
        sidePanel.add(new JComboBox<>(jobOptions), gbc);
        gbc.gridx = 1;
        sidePanel.add(jobButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        jobFlavorLabel.setForeground(Color.white);
        sidePanel.add(jobFlavorLabel, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        sidePanel.add(new JComboBox<>(powerOptions), gbc);
        gbc.gridx = 1;
        sidePanel.add(powerButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        powerFlavorLabel.setForeground(Color.white);
        sidePanel.add(powerFlavorLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        sidePanel.add(new JComboBox<>(shopOptions), gbc);
        gbc.gridx = 1;
        sidePanel.add(shopButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        shopFlavorLabel.setForeground(Color.white);
        sidePanel.add(shopFlavorLabel, gbc);
        
        getContentPane().add(sidePanel, BorderLayout.EAST);
        // end side menu

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt){ repaint();}
}
