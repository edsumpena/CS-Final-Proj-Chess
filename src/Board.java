import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class Board {
	private static int bx, by = 0; // position of log
	private static int bwidth, bheight = 0;
	private static Image img;// image for the Frog

	public Board(String fileName) {
		bwidth = 900;
		bheight = 900;
		bx = 0;
		by = 0;
		//init(1, 1);
		img = getbImage(fileName);
	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(bx, by);

	public void updateAfflineTransform(int scaleX, int scaleY) {
		tx = AffineTransform.getTranslateInstance(bx, by);
		tx.scale(scaleX, scaleY);

	}

	public AffineTransform getAfflineTransform(int x, int y) {
		return AffineTransform.getTranslateInstance(x, y);
	}

	// draw the affinetransform
	public void paint(Graphics g) {
		//updateAfflineTransform(5, 5);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, tx, null);

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getbImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path)); // Import log Image
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return image.getScaledInstance(bwidth, bheight,
				java.awt.Image.SCALE_SMOOTH);
	}
}


