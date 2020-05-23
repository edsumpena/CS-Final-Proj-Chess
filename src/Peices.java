import java.awt.Color;
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

public class Peices {

	public enum Type {
		ROOK, KING, QUEEN, PAWN, BISHOP,  KNIGHT
	}

	private String filePath;
	private boolean visible;
	private boolean color;
	private Image Peice;
	private Type obstacleType;

	private int obstWidth = 40;
	private int obstHeight = 45;
	private double theta = 0;

	private double obstX = 0;
	private double obstY = 0;

	public Obstacle(Type obstacleType, double xPos, double yPos) {
		switch (obstacleType) {
		case SPIKE_WHOLE:
			filePath = "src/obstacles/spike.png";
			obstWidth = 50;
			obstHeight = 50;
			theta = 0;
			break;
		case SPIKE_HALF:
			filePath = "src/obstacles/spike.png";
			obstWidth = 50;
			obstHeight = 25;
			theta = 0;
			break;
		case BLOCK_WHOLE:
			filePath = "src/obstacles/block.png";
			obstWidth = 60;
			obstHeight = 60;
			theta = 0;
			break;
		case BLOCK_HALF:
			filePath = "src/obstacles/block.png";
			obstWidth = 60;
			obstHeight = 30;
			theta = 0;
			break;
		case PORTAL_SPACESHIP_IN:
			filePath = "src/obstacles/portalShipIn.png";
			obstWidth = 60;
			obstHeight = 130;
			theta = 0;
			break;
		case PORTAL_SPACESHIP_OUT:
			filePath = "src/obstacles/portalShipOut.png";
			obstWidth = 60;
			obstHeight = 130;
			theta = 0;
			break;
		case JUMP_CIRCLE:
			filePath = "src/obstacles/jumpCircle.png";
			obstWidth = 15;
			obstHeight = 15;
			theta = 0;
			break;
		case LAUNCH_CIRCLE:
			filePath = "src/obstacles/jumpCircle.png";
			obstWidth = 40;
			obstHeight = 15;
			theta = 0;
			break;
		}
		visible = false;
		obstX = xPos;
		obstY = yPos;
		System.out.println();
		this.obstacleType = obstacleType;
	}
}