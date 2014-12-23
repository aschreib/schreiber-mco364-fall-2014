package schreiber.paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 5557512110330206586L;

	private int oldX = 0;
	private int oldY = 0;
	private boolean clicked;
	private boolean cleared;
	private Color color = Color.BLACK;
	private int strokeWidth = 3;
	private int layerNumber = 1;
	private BufferedImage[] layers = new BufferedImage[4];

	private DrawListener listener = new PencilListener(this);
	private BufferedImage image = layers[layerNumber - 1];

	public Canvas() {
		for (int i = 0; i < 4; i++) {
			layers[i] = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
			setBackground(i);
		}
		image = layers[0];
	}

	public void setBackground(int number) {
		Graphics2D g = layers[number].createGraphics();
		g.setPaint(Color.WHITE);
		if (number == 0) {
			g.fillRect(0, 0, 800, 600);
		} else {
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			g.fillRect(0, 0, 800, 600);
			// reset composite
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		if (!cleared) {
			listener.drawPreview((Graphics2D) g);
		}
	}

	public DrawListener getDrawListener() {
		return listener;
	}

	public void setDrawListener(DrawListener listener) {
		this.listener = listener;
	}

	public void clicked(boolean b) {
		clicked = b;
	}

	public void cleared(boolean b) {
		cleared = b;
	}

	public void setPoint(int x, int y) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(color);
		g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		if (!clicked) {
			g.drawLine(x, y, oldX, oldY);
		}
		oldX = x;
		oldY = y;
		clicked = false;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(int rotation) {
		strokeWidth += rotation * -1;
		if (strokeWidth <= 1) {
			strokeWidth = 1;
		}
		if (strokeWidth >= 50) {
			strokeWidth = 50;
		}
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public BufferedImage getBufferedImage() {
		return image;
	}

	public void setBufferedImage(int number) {
		image = layers[number - 1];
	}

	public void clearCanvas() {
		cleared(true);
		layers[layerNumber - 1] = new BufferedImage(800, 600,
				BufferedImage.TYPE_INT_ARGB);
		setBufferedImage(layerNumber);
		repaint();
	}

	public int getLayerNumber() {
		return layerNumber;
	}

	public void setLayerNumber(int number) {
		layerNumber = number;
	}
}
