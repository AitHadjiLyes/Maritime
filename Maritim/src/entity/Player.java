package entity;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Maritim.GamePanel;
import Maritim.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp =gp;
		this.keyH=keyH;
		setDefaultValues();
		getPlayerImage();
	}
	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("up.png"));
			left = ImageIO.read(getClass().getResourceAsStream("left.png"));
			down = ImageIO.read(getClass().getResourceAsStream("down.png"));
			right = ImageIO.read(getClass().getResourceAsStream("right.png"));
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
		if(keyH.upPressed == true) {
			direction ="up";
			y = y - speed;
		}
		if(keyH.downPressed == true) {
			direction ="down";
			y = y + speed;
		}
		if(keyH.leftPressed == true) {
			direction ="left";
			x = x + speed;
		}
		if(keyH.rightPressed == true) {
			direction ="right";
			x = x - speed;
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "up" :
			image = up;
			break;
		case "down" :
			image = down;
			break;
		case "left" :
			image = left;
			break;
		case "right" :
			image = right;
			break;
		}
		g2.drawImage(image, x, y, gp.getTileSize(), gp.getTileSize(), null);
	}
}
