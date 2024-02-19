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
			g2.drawImage(image, player.getScreenPosX()-(gp.getTileSize()/2), player.getScreenPosY()-(gp.getTileSize()/2), gp.getTileSize(), gp.getTileSize(), null);
			g2.drawString(String.valueOf("x :"+gp.getBlockmanager().col), 50, 20);
			g2.drawString(String.valueOf("y :"+gp.getBlockmanager().row), 100, 20);
			
			
		}
		public void paint(BlockManager blockmanager,Graphics g2) throws IOException {
			int[][] tab = blockmanager.getTab();
			for (int i = 0; i < gp.getMaxWorldCol(); i++) {
				for (int j = 0; j < gp.getMaxWorldRow(); j++) {
					int image = tab[i][j];
					
					int worldX = i * gp.getTileSize();
					int worldY = j * gp.getTileSize();
					int screenX = worldX - gp.getPlayer().getworldPosX() + gp.getPlayer().getScreenPosX();
					int screenY = worldY - gp.getPlayer().getworldPosY() + gp.getPlayer().getScreenPosY();
					g2.drawImage(blockmanager.whichTile(image).getImage(),screenX,screenY,gp.getTileSize(),gp.getTileSize(),null);		
					
				}
				
			}
		}
	
}
