package engineMap;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
	private BufferedImage image;
	private boolean collision ;
	
	public Block() {
		collision = false ;
	}

	public void setImage(String s) throws IOException {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public boolean getCollision() {
		return collision;
	}
	public void setCollision(boolean a) {
		collision = a;
	}
	
}
