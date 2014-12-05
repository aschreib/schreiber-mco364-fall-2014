package schreiber.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5557512110330206586L;

	private int oldX = 0;
	private int oldY = 0;
	private boolean clicked;
	private Color color = Color.BLACK;
	private int strokeWidth = 3;

	private Paint paint;
	private DrawListener listener = new PencilListener(this, paint);
	private BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		listener.drawPreview((Graphics2D) g);
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

	public void clearCanvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}
}
