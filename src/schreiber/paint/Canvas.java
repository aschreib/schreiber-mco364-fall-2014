package schreiber.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	// ArrayList<Integer> xList = new ArrayList<Integer>();
	// ArrayList<Integer> yList = new ArrayList<Integer>();

	private int x;
	private int y;
	private int oldX = 0;
	private int oldY = 0;
	private boolean clicked;

	BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		// Color newColor = JColorChooser.showDialog(this, "Choose Color",
		// Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		// g.setColor(palettePanel.getPalette().getColor());

	}

	public void clicked(boolean b) {
		clicked = b;
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		if (!clicked) {
			g.drawLine(x, y, oldX, oldY);
		}
		oldX = x;
		oldY = y;
		clicked = false;
	}

}
