//package com.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.io.File;



public class Sounds {

    public static void playMusic(String filepath)
    {
        try
        {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("Mario.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            Thread.sleep(10000); // looping as long as this thread is alive
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public static void playSound(String soundName)
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }
}
