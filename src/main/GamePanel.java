package main;
import input.KeyboardInput;
import input.MouseInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;
public class GamePanel extends JPanel {
    private int xDelta = 0,yDelta = 0;
    private int aniTick,aniIndex,aniSpeed=15;
    private int playerAction = RUNNING;
    private int playerDir = -1;
    private boolean moving = false;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private KeyboardInput keyboardInput = new KeyboardInput(this);
    private MouseInput mouseInput = new MouseInput(this);
    public GamePanel(){
        addKeyListener(keyboardInput);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
        setPanelSize();
        importImage();
        loadAnimation();
    }
    public void importImage(){
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try{
            img = ImageIO.read(is);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                is.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    private void loadAnimation(){
        animations = new BufferedImage[9][6];
        for(int j = 0;j<animations.length;j++){
            for(int i = 0;i<animations[j].length;i++){
                animations[j][i] = img.getSubimage(i*64,j*40,64,40);
            }
        }
    }
    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    public void setPanelSize(){
        Dimension size  = new Dimension(1280,720);
        setMaximumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }
    public void setAnimation(){
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }
    private void updateAnimationTick(){
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick=0;
            aniIndex++;
            if(aniIndex>=GetSpriteAmount(playerAction)){
                aniIndex=0;
            }
        }
    }
    public void updatePos(){
        if(moving){
            switch (playerDir){
                case LEFT:
                    xDelta-=5;
                    break;
                case RIGHT:
                    xDelta+=5;
                    break;
                case UP:
                    yDelta-=5;
                    break;
                case DOWN:
                    yDelta+=5;
                    break;
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePos();
        g.drawImage(animations[playerAction][aniIndex],xDelta,yDelta,128,80,null);
    }

}
