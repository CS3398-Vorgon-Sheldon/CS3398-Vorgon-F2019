import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

public class Controller implements MouseListener {
    Player player;
    Model model;
    View view;
    Shop shop;


    Controller() throws IOException, Exception{
        model = new Model();
        player = new Player();
        view = new View(this);
        shop = new Shop(player);
        
        new Timer(10, view).start();
    }

    public void update(Graphics g){ model.update(g);}

    @Override
    public void mousePressed(MouseEvent e){

        if(SwingUtilities.isLeftMouseButton(e)){
            player.updateWorkHours(player.getClickPower());
            view.workLabel.setText("Hours Worked: " + String.valueOf(player.getWorkHours()));
            player.updateLevel(player.getWorkHours());
            view.levelLabel.setText("Current Level: " + String.valueOf(player.getLevel()));
        } else if(SwingUtilities.isRightMouseButton(e)){

        }
    }

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    // main
    public static void main(String[] args) throws Exception{
        //playMusic("Mario.wav");      
        Controller game = new Controller();
    }

}

/*
TODO:
    IMPLEMENT A CLICKER TO GET MONEY

 */
