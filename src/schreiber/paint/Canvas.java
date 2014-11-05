package schreiber.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	ArrayList<Integer> xList = new ArrayList<Integer>();
	ArrayList<Integer> yList = new ArrayList<Integer>();

	private int x;
	private int y;

	BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		while (xList != null) {
			for (int x = 0; x < xList.size() - 1; x++) {
				g.drawLine(xList.get(x), yList.get(x), xList.get(x + 1), yList.get(x + 1));
			}
		}

	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 10, 10);
	}

}
