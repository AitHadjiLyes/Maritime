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
	
	public BlockManager(GamePanel gp) {
		this.gp = gp;
		block = new Block[5];
		try {
			block[0] = new Block();
			block[0].setImage("/tile/block0.png");
			
			block[1] = new Block();
			block[1].setImage("/tile/block1.png");
			
			block[2] = new Block();
			block[2].setImage("/tile/block2.png");
			
			block[3] = new Block();
			block[3].setImage("/tile/block3.png");
			
			block[4] = new Block();
			block[4].setImage("/tile/block4.png");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*
	public void loadMap() throws IOException {
		InputStream is = getClass().getResourceAsStream("/map/map.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String ligne;
		while ((ligne = br.readLine()) != null) {
			int j = 0;
			String[] splited = ligne.split(" ");
			for (int i = 0; i < splited.length; i++) {
			
				tab[j][i] =  Integer.parseInt(splited[i]);
			}
			j++;
		}
		
		for (int i = 0; i < 10 ;i++) {
			for (int j = 0; j < 11; j++) {
				int t = tab[j][i];
				System.out.println(t+" ");
			}
			
		}
	}

*/

	}

