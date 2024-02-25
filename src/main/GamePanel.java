package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    //    private long lastCheck = 0;
//    private int frame = 0;
//    private float xDir = 0.01f;
//    private float yDir = 0.01f;
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick,aniIndex,aniSpeed=30;
    //    private Color color = new Color(0,0,0);
    private MouseInputs mouseInputs;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImage();
        loadAnimation();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimation() {
        animations= new BufferedImage[9][6];
        for(int j=0;j<animations.length;j++){
            for(int i=0;i<animations.length;i++){
                animations[j][i] = img.getSubimage(i*64,j*40,64,40);
            }
        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                is.close();
            }
             catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
//        setPreferredSize();
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void setRectPos(int x, int y) {
        xDelta = x;
        yDelta = y;
    }
    private void updateAnimationTick() {
//        aniTick++;
//        if(aniTick >= aniSpeed){
//            aniTick = 0;
//            aniIndex++;
//            if(aniIndex >= idleAni.length ){
//                aniIndex = 0;
//            }
//        }
    }
    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
//        subImage = img.getSubimage(1*64,8*40,64,40);
        g.drawImage(animations[7][1], (int)xDelta,(int) yDelta,128,80, null);
    }


}