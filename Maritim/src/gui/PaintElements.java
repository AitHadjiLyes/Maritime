package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import engineEntity.Player;
import engineMap.BlockManager;

public class PaintElements {
		private GamePanel gp;
		public PaintElements(GamePanel gp) {
			this.gp =gp;
		}
		public void paint(Player player , Graphics g2) {
			BufferedImage image = null;
			switch(player.getDirection()) {
			case "up" :
				if (player.getSprite() == 1) {
					image = player.getUp1();
				}
				if (player.getSprite() ==2) {
					image = player.getUp2();
				}
			
				break;
			case "down" :
				if (player.getSprite() == 1) {
					image = player.getDown1();
				}
				if (player.getSprite() ==2) {
					image = player.getDown2();
				}

				break;
			case "left" :
				if (player.getSprite() == 1) {
					image = player.getLeft1();
				}
				if (player.getSprite() ==2) {
					image = player.getLeft2();
				}
				
				break;
			case "right" :
				if (player.getSprite() == 1) {
					image = player.getRight1();
				}
				if (player.getSprite() ==2) {
					image = player.getRight2();
				}
				
				break;
			}
			g2.drawImage(image, player.getX(), player.getY(), gp.getTileSize()*2, gp.getTileSize()*2, null);
			
		}
		/*
		public void paint(BlockManager blockmanager,Graphics g2) throws IOException {
			blockmanager.loadMap();
		}
		*/
	
}
