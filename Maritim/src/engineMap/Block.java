package engineMap;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
	private BufferedImage image;

	public void setImage(String s) throws IOException {
		try {
			this.image = ImageIO.read(getClass().getResource(s));
		} catch (Exception e) {
			
		}
		
	}

	public BufferedImage getImage() {
		return image;
	}
	
}
