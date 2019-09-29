import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private int balance;
    JLabel label = new JLabel("Balance: " + String.valueOf(balance), SwingConstants.CENTER);

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

        setTitle("Game!");
        setSize(750,750); // subject to change
        getContentPane().add(new MyPanel(c), BorderLayout.CENTER);
        getContentPane().add(label, BorderLayout.PAGE_START);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt){ repaint();}
}
