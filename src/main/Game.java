package main;

public class Game implements Runnable{
    private Thread gameThread;
    private final int FPS = 120;
    private GamePanel gamePanel;
    private GameWindow gameWindow;
    public Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0/FPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frame = 0;
        long lastCheck = System.currentTimeMillis();
        while(true){
            now = System.nanoTime();
            if(now-lastFrame>=timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                frame++;
            }
            if(System.currentTimeMillis() - lastCheck>=1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS:"+frame);
                frame=0;
            }

        }
    }
}
