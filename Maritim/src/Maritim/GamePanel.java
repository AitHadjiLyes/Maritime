package Maritim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	//SCREEN SETTINGS
	final int orignalTileSize = 64; // which means each tile has 16px
	final int scale = 1; // to be able to modify the scaling of the game easily

	
	final int tileSize = orignalTileSize * scale ;
	final int maxScreenCol = 32;
	final int maxScreenRow = 24;
	final int screenWidhth = maxScreenCol * tileSize;
	final int screenHeight = maxScreenRow * tileSize;
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	//FPS
	int fps = 60;
	//Constructor 
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidhth,screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/fps;
		double nextDrawTime = System.nanoTime() + drawInterval;
		while(gameThread != null){
			
			update();
			
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);
				
				nextDrawTime += drawInterval;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	public void update() {
		player.Update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		player.draw(g2);
		g2.drawRect(0, 0, tileSize, tileSize);
		g2.dispose();
	}
	public int getTileSize() {
		return this.tileSize;
	}
}

