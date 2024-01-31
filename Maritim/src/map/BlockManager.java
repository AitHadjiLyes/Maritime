package map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.INPUT_STREAM;

import Maritim.GamePanel;

public class BlockManager {
	private GamePanel gp;
	private Block[] block;
	
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



	
}
