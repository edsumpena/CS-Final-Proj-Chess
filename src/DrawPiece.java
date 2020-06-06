import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawPiece {
	private Graphics2D g;
	private Piece p;
	private Properties prop;
	private String filePath;
	
	public DrawPiece(Graphics2D g, Piece p, Properties prop) {
		this.g = g;
		this.p = p;
		this.prop = prop;
		
		filePath = "src/pieces/" + p.toString().toLowerCase() + " (2).png";
	}
	
	public Piece getPiece() {
		return p;
	}
	
	public Properties getProperties() {
		return prop;
	}
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	public void draw() {
		if(g != null && p != null && prop != null)
			g.drawImage(updateImgScaling(), prop.getX(), prop.getY(), null);
	}
	
	private Image updateImgScaling() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return image.getScaledInstance(prop.getWidth(), prop.getHeight(), java.awt.Image.SCALE_SMOOTH);
	}

}
