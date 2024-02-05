package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;

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
			g2.drawImage(image, player.getX()-(gp.getTileSize()/2), player.getY()-(gp.getTileSize()/2), gp.getTileSize(), gp.getTileSize(), null);
			g2.drawString(String.valueOf(gp.getBlockmanager().col), 200, 200);
			g2.drawString(String.valueOf(gp.getBlockmanager().row), 220, 200);
			
			
		}
		public void paint(BlockManager blockmanager,Graphics g2) throws IOException {
			int[][] tab = blockmanager.getTab();
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < 24; j++) {
					int image = tab[i][j];
					switch (image) {
					case 0 :
						g2.drawImage(blockmanager.getBlock0().getImage(),i*gp.getTileSize(),j*gp.getTileSize(),gp.getTileSize(),gp.getTileSize(),null);
						
						break;
					case 1:
						g2.drawImage(blockmanager.getBlock1().getImage(),i*gp.getTileSize(),j*gp.getTileSize(),gp.getTileSize(),gp.getTileSize(),null);
						break;
					case 2 :
						g2.drawImage(blockmanager.getBlock2().getImage(),i*gp.getTileSize(),j*gp.getTileSize(),gp.getTileSize(),gp.getTileSize(),null);
						break;
					case 3 :
						g2.drawImage(blockmanager.getBlock3().getImage(),i*gp.getTileSize(),j*gp.getTileSize(),gp.getTileSize(),gp.getTileSize(),null);
						break;
					case 4 :
						g2.drawImage(blockmanager.getBlock4().getImage(),i*gp.getTileSize(),j*gp.getTileSize(),gp.getTileSize(),gp.getTileSize(),null);
						break;
						

					default:
						break;
					}
					
				}
				
			}
		}
	
}
