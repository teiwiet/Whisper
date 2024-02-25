package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class GamePanel extends JPanel {
//    private long lastCheck = 0;
//    private int frame = 0;
//    private float xDir = 0.01f;
//    private float yDir = 0.01f;
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage img;
//    private Color color = new Color(0,0,0);
    private MouseInputs mouseInputs;
    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        importImage();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImage() {
        InputStream is  = getClass().getResourceAsStream("/player_sprites.png");
        try{
            img = ImageIO.read(is);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
//        setPreferredSize();
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void setRectPos(int x,int y){
        xDelta = x;
        yDelta = y;
    }
    public void changeXDelta(int value){
        this.xDelta += value;
    }
    public void changeYDelta(int value){
        this.yDelta += value;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,1,1,null);
    }

//    public void updateRectangle(){
//        xDelta+=xDir;
//        if(xDelta>200||xDelta<0)
//        {
//            xDir*=-1;
////            color = getRandomColor();
//        }
//        yDelta+=yDir;
//        if(yDelta>200||yDelta<0)
//        {
//            yDir*=-1;
////            color = getRandomColor();
//        }
//    }

//    private Color getRandomColor() {
//        int r= random.nextInt(0,255);
//        int g= random.nextInt(0,255);
//        int b= random.nextInt(0,255);
//        return new Color(r,g,b);
//    }

}
//package main;
//
//import inputs.KeyboardInputs;
//import inputs.MouseInputs;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Random;
//
//public class GamePanel extends JPanel {
//    private float xDir = 0.01f;
//    private float yDir = 0.01f;
//    private float xDelta = 100;
//    private float yDelta = 100;
//    private BufferedImage img;
//    private MouseInputs mouseInputs;
//    private Random random = new Random();
//
//    public GamePanel() {
//        mouseInputs = new MouseInputs(this);
//        importImage();
//        setPanelSize();
//        addKeyListener(new KeyboardInputs(this));
//        addMouseListener(mouseInputs);
//        addMouseMotionListener(mouseInputs);
//        setFocusable(true);
//        requestFocus();
//    }
//
//    private void importImage() {
//        InputStream is = getClass().getResourceAsStream("/player_sprites.png"); // Removed leading slash
//        try {
//            img = ImageIO.read(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void setPanelSize() {
//        Dimension size = new Dimension(1280, 800);
//        setPreferredSize(size);
//        setMinimumSize(size);
//    }
//
//    public void setRectPos(int x, int y) {
//        xDelta = x;
//        yDelta = y;
//    }
//
//    public void changeXDelta(int value) {
//        this.xDelta += value;
//    }
//
//    public void changeYDelta(int value) {
//        this.yDelta += value;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (img != null) {
//            g.drawImage(img, (int) xDelta, (int) yDelta, this);
//        }
//    }
//
//    public void updateRectangle() {
//        xDelta += xDir;
//        if (xDelta > getWidth() - img.getWidth() || xDelta < 0) {
//            xDir *= -1;
//        }
//        yDelta += yDir;
//        if (yDelta > getHeight() - img.getHeight() || yDelta < 0) {
//            yDir *= -1;
//        }
//        repaint();
//    }
//
//    private Color getRandomColor() {
//        int r = random.nextInt(256); // [0-255]
//        int g = random.nextInt(256);
//        int b = random.nextInt(256);
//        return new Color(r, g, b);
//    }
//}