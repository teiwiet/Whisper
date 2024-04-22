package main;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private JFrame jFrame;
//    private GamePanel gamePanel;
    public GameWindow(GamePanel gamePanel){
        jFrame = new JFrame();
        jFrame.setTitle("Whisper");
//        jFrame.setSize(new Dimension(500,500));
        jFrame.add(gamePanel);
        jFrame.pack();
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
