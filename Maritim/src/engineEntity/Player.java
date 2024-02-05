package engineEntity;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engineMap.BlockManager;
import gui.GamePanel;
import gui.KeyHandler;

public class Player extends Entity {
	private GamePanel gp;
	private KeyHandler keyH;
	private int food=1000;
	private Font stringFont = new Font( "SansSerif", Font.PLAIN, 18 );
	private int spriteCounter=0;
	private int sprite=1;
	
	
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp = gp;
		this.keyH=keyH;
		setDefaultValues();
		getPlayerImage();
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 2;
		direction ="left";
	}
	public void Update() {
		if((keyH.isUpPressed() == true)&&(gp.getBlockmanager().collisions(x, y-speed))) {
			direction ="up";
			y = y - speed;
		}
		if((keyH.isDownPressed() == true)&&(gp.getBlockmanager().collisions(x, y+speed))) {
			direction ="down";
			y = y + speed;
		}
		if((keyH.isLeftPressed() == true)&&(gp.getBlockmanager().collisions(x+speed, y))) {
			direction ="left";
			x = x + speed;
		}
		if((keyH.isRightPressed() == true)&&(gp.getBlockmanager().collisions(x-speed, y))) {
			direction ="right";
			x = x - speed;
		}
		if ((keyH.isUpPressed() == true)||(keyH.isDownPressed() == true)||(keyH.isLeftPressed() == true)||(keyH.isRightPressed() == true)) {
			calculateFood();
			spriteCounter++;
			if (spriteCounter>20) {
				if(sprite==1) {
					sprite =2;
					spriteCounter=0;
				}else  {
					sprite=1;
					spriteCounter=0;
				}
			}
		}else {
			sprite = 1;
		}
		
		
	}
	private void calculateFood() {
		food = food -1;
	}



	public KeyHandler getKeyH() {
		return keyH;
	}
	public void setKeyH(KeyHandler keyH) {
		this.keyH = keyH;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public Font getStringFont() {
		return stringFont;
	}
	public void setStringFont(Font stringFont) {
		this.stringFont = stringFont;
	}
	public int getSpriteCounter() {
		return spriteCounter;
	}
	public void setSpriteCounter(int spriteCounter) {
		this.spriteCounter = spriteCounter;
	}
	public int getSprite() {
		return sprite;
	}
	public void setSprite(int sprite) {
		this.sprite = sprite;
	}
}
