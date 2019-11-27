import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.Timer;

import javafx.scene.Cursor;

import javax.swing.SwingUtilities;

//import static com.game.Sounds.playSound; //Need this to use the sound functions.

public class Controller implements MouseListener {
    Player player;
    Model model;
    View view;
    Shop shop;
    PowerUp powerUp;
    Stats stats;
    ClientList clientList;
    Achievements achievements;

    Controller() throws IOException, Exception{
        model = new Model();
        player = new Player();
        view = new View(this);
        shop = new Shop(player, view);
        powerUp = new PowerUp(player);
        stats = new Stats(player);
        clientList = new ClientList();
        achievements = new Achievements();
        
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
