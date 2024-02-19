package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;

import engineEntity.Player;
import engineMap.BlockManager;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	// map settings
	private int MaxWorldRow = 100;
	private int maxWorldCol = 100;
	//SCREEN SETTINGS
	private final int orignalTileSize = 32; // which means each tile has 16px
	private final int scale = 1; // to be able to modify the scaling of the game easily
	private final int tileSize = orignalTileSize * scale ;
	private final int maxScreenCol = 40;
	private final int maxScreenRow = 30;
	private final int screenWidhth = maxScreenCol * tileSize;
	private final int screenHeight = maxScreenRow * tileSize;
	private KeyHandler keyH = new KeyHandler();
	private Thread gameThread;
	private Player player = new Player(this,keyH);
	private BlockManager blockmanager  = new BlockManager(this);
	private PaintElements paintelements = new PaintElements(this);
	// map settings
	
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
			
			try {
				update();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
				e.printStackTrace();
			}
		}
		
	}
	public void update() throws IOException {
		player.Update();
		blockmanager.loadMap();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		Graphics2D g2 = (Graphics2D)g;
		try {
			paintelements.paint(blockmanager, g2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		paintelements.paint(player, g2);
		
		
	    
	    
	       
	        g2.dispose();
	    }
		
		
		
		
		
		

		
	

	public int getTileSize() {
		return this.tileSize;
	}
	public int getOrignalTileSize() {
		return orignalTileSize;
	}

	public int getScale() {
		return scale;
	}

	public int getMaxScreenCol() {
		return maxScreenCol;
	}

	public int getMaxScreenRow() {
		return maxScreenRow;
	}

	public int getScreenWidhth() {
		return screenWidhth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public KeyHandler getKeyH() {
		return keyH;
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public Player getPlayer() {
		return player;
	}

	public BlockManager getBlockmanager() {
		return blockmanager;
	}

	public PaintElements getPaintelements() {
		return paintelements;
	}

	public int getFps() {
		return fps;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getMaxWorldCol() {
		return maxWorldCol;
	}

	public int getMaxWorldRow() {
		return MaxWorldRow;
	}
}

