package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int xDelta = 0;
    private int yDelta = 0;
    private GamePanel gamePanel;
    private MouseInputs mouseInputs;
    public GamePanel(){
        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(100+xDelta,100+yDelta,200,50);
    }
}
