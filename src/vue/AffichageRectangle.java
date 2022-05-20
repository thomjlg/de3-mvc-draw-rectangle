package vue;

import java.awt.Graphics;
import javax.swing.JPanel;

public class AffichageRectangle extends JPanel {
	
	private int x;
	private int y;
	private int width;
	private int height;

	public AffichageRectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void paintComponent(Graphics g) {
		g.drawRect(x, y, width, height);
	}
	
	public void setHauteur(int h) {
		this.height = h;
		this.repaint();
	}
	
}
