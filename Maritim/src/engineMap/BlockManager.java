package engineMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.INPUT_STREAM;

import gui.GamePanel;

public class BlockManager {
	
	private GamePanel gp;
	private Block[] block;
	private int[][] tab;
	public int col;
	public int row;
	
	
	public BlockManager(GamePanel gp) {
		this.gp = gp;
		block = new Block[5];
		try {
			block[0] = new Block();
			block[0].setImage("/tiles/block0.png");
			block[0].setCollision(true);
			
			block[1] = new Block();
			block[1].setImage("/tiles/block1.png");
			
			block[2] = new Block();
			block[2].setImage("/tiles/block2.png");
			
			block[3] = new Block();
			block[3].setImage("/tiles/block3.png");
			
			block[4] = new Block();
			block[4].setImage("/tiles/block4.png");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tab = new int[gp.getMaxWorldCol()][gp.getMaxWorldRow()];
		
	}
	
	public void loadMap() throws IOException {
		InputStream is = getClass().getResourceAsStream("/map/map2.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String ligne;
		int j = 0;
		while ((ligne = br.readLine()) != null) {
			String[] splited = ligne.split(" ");
			for (int i = 0; i < gp.getMaxWorldCol(); i++) {
				tab[i][j] =  Integer.parseInt(splited[i]);
			}					
		j = j+1;
		}
		
		
	}

		
	

	public void setBlock(Block[] block) {
		this.block = block;
	}

	public int[][] getTab() {
		return tab;
	}

	public void setTab(int[][] tab) {
		this.tab = tab;
	}
	public Block getBlock0() {
		return block[0];
	}
	public Block getBlock1() {
		return block[1];
	}
	public Block getBlock2() {
		return block[2];
	}
	public Block getBlock3() {
		return block[3];
	}
	public Block getBlock4() {
		return block[4];
	}
	
	
	public boolean collisions(int x, int y) {
		 col = (x/gp.getTileSize());
		 row = (y/gp.getTileSize());
		int n = tab[col][row];
		Block block = whichTile(n);
		System.out.println(block.getCollision());
		return block.getCollision();
	}
	
	
	public Block whichTile(int n) {
	    switch (n) {
	        case 0:
	            return block[0];
	        case 1:
	            return block[1];
	        case 2:
	            return block[2];
	        case 3:
	            return block[3];
	        default:
	            return block[4];
	    }
	}




	}

