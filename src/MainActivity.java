import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainActivity extends JPanel implements KeyListener, MouseListener, ActionListener {
	public static JFrame frame;
	
	public static int screenWidth = 850;
	public static int screenHeight = 750;
	
	public MainActivity() {
		frame = new JFrame();
		frame.setTitle("Chess");
		frame.setSize(Math.round(screenWidth), Math.round(screenHeight));
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int x = 50;
		int y = 50;
		Color c = Color.BLACK;
		
		for(int i = 0; i < 8; i++) {
			x = 50;
			c = (c.equals(Color.WHITE)) ? Color.GRAY : Color.WHITE;
			for(int j = 0; j < 8; j++) {
				g2d.setColor(c);
				g2d.fillRect(x, y, 75, 75);
				x += 75;
				c = (c.equals(Color.WHITE)) ? Color.GRAY : Color.WHITE;
			}
			y += 75;
			
			g2d.setColor(Color.BLACK);
			g2d.drawRect(50, 50, 75 * 8, 75 * 8);
		}
		
		drawLetters(g2d, 50 + 75 / 2 - 5, 50 + 75 * 8 + 25);
		drawLetters(g2d, 50 + 75 / 2 - 5, 35);
		drawNumbers(g2d, 25, 50 + 75 / 2 + 5);
		drawNumbers(g2d, 50 + 75 * 8 + 20, 50 + 75 / 2 + 5);
		
		ArrayList<DrawPiece> pieces = new ArrayList<>();
		
		int[] yList = new int[] { 50, 50 + 75, 50 + 75 * 6, 50 + 75 * 7 };
		Piece[] pieceListBlack = new Piece[] { Piece.BLACK_ROOK, Piece.BLACK_KNIGHT, Piece.BLACK_BISHOP,
				Piece.BLACK_QUEEN, Piece.BLACK_KING, Piece.BLACK_BISHOP, Piece.BLACK_KNIGHT, Piece.BLACK_ROOK};
		Piece[] pieceListWhite = new Piece[] { Piece.WHITE_ROOK, Piece.WHITE_KNIGHT, Piece.WHITE_BISHOP,
				Piece.WHITE_QUEEN, Piece.WHITE_KING, Piece.WHITE_BISHOP, Piece.WHITE_KNIGHT, Piece.WHITE_ROOK};

		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 8; j++) {
				if(i == 0)
					pieces.add(new DrawPiece(g2d, pieceListBlack[j], 
							new Properties(50 + 75 * j, yList[i], 70, 70)));
				else if(i == 1)
					pieces.add(new DrawPiece(g2d, Piece.BLACK_PAWN, 
							new Properties(50 + 75 * j, yList[i], 70, 70)));
				else if(i == 2)
					pieces.add(new DrawPiece(g2d, Piece.WHITE_PAWN, 
							new Properties(50 + 75 * j, yList[i], 70, 70)));
				else if(i == 3)
					pieces.add(new DrawPiece(g2d, pieceListWhite[j], 
							new Properties(50 + 75 * j, yList[i], 70, 70)));
			}
		
		for(DrawPiece dp : pieces)
			dp.draw();
				

	}
	
	private void drawLetters(Graphics2D g2d, int startX, int startY) {
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		
		g2d.drawString("a", startX, startY);
		g2d.drawString("b", startX + 75, startY);
		g2d.drawString("c", startX + 75 * 2, startY);
		g2d.drawString("d", startX + 75 * 3, startY);
		g2d.drawString("e", startX + 75 * 4, startY);
		g2d.drawString("f", startX + 75 * 5, startY);
		g2d.drawString("g", startX + 75 * 6, startY);
		g2d.drawString("h", startX + 75 * 7, startY);
	}
	
	private void drawNumbers(Graphics2D g2d, int startX, int startY) {
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		
		for(int i = 0; i < 8; i++) {
			g2d.drawString(String.valueOf(i + 1), startX, startY);
			startY += 75;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
