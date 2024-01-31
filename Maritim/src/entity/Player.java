package entity;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Maritim.GamePanel;
import Maritim.KeyHandler;

public class Player extends Entity {
	private GamePanel gp;
	private KeyHandler keyH;
	private int food=1000;
	private Font stringFont = new Font( "SansSerif", Font.PLAIN, 18 );
	private int spriteCounter=0;
	private int sprite=1;
	
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp =gp;
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
		if(keyH.isUpPressed() == true) {
			direction ="up";
			y = y - speed;
		}
		if(keyH.isDownPressed() == true) {
			direction ="down";
			y = y + speed;
		}
		if(keyH.isLeftPressed() == true) {
			direction ="left";
			x = x + speed;
		}
		if(keyH.isRightPressed() == true) {
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

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "up" :
			if (sprite == 1) {
				image = up1;
			}
			if (sprite ==2) {
				image = up2;
			}
		
			break;
		case "down" :
			if (sprite == 1) {
				image = down1;
			}
			if (sprite ==2) {
				image = down2;
			}

			break;
		case "left" :
			if (sprite == 1) {
				image = left1;
			}
			if (sprite ==2) {
				image = left2;
			}
			
			break;
		case "right" :
			if (sprite == 1) {
				image = right1;
			}
			if (sprite ==2) {
				image = right2;
			}
			
			break;
		}
		g2.drawImage(image, x, y, gp.getTileSize()*2, gp.getTileSize()*2, null);
		g2.setFont(stringFont);
		g2.drawString(String.valueOf(food), 64, 64);
	}
}
