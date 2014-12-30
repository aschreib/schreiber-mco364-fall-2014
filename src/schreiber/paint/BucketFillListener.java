package schreiber.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import schreiber.paint.message.BucketFillMessage;

public class BucketFillListener implements DrawListener {

	private Canvas canvas;
	private Paint paint;

	private int x, y;
	private Color color;
	private int colorRGB;
	private BufferedImage image;
	private int colorClicked;

	public BucketFillListener(Canvas canvas, Paint paint) {
		this.canvas = canvas;
		this.paint = paint;
		image = canvas.getBufferedImage();
	}

	public void Fill(int x, int y, int fillColor, int colorClicked) {
		// create queue of points that will store all the points to be filled
		Queue<Point> queue = new LinkedList<Point>();
		// start the fill at the clicked point
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			// bounds check and color check
			if (validCoordinate(p.x, p.y)) {
				int pixelColor = image.getRGB(p.x, p.y);
				if (pixelColor != fillColor && pixelColor == colorClicked) {
					image.setRGB(p.x, p.y, fillColor);
					if (validCoordinate(p.x - 1, p.y)) {
						queue.add(new Point(p.x - 1, p.y));
					}
					if (validCoordinate(p.x + 1, p.y)) {
						queue.add(new Point(p.x + 1, p.y));
					}
					if (validCoordinate(p.x, p.y - 1)) {
						queue.add(new Point(p.x, p.y - 1));
					}
					if (validCoordinate(p.x, p.y + 1)) {
						queue.add(new Point(p.x, p.y + 1));
					}

					// System.out.println(queue.peek());
				}
			}
		}
	}

	public boolean validCoordinate(int x, int y) {
		return (x >= 0 && x < 800 && y >= 0 && y < 600);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		color = canvas.getColor();
		colorRGB = color.getRGB();
		colorClicked = image.getRGB(x, y);
		// Fill(x, y, colorRGB, colorClicked);
		BucketFillMessage message = new BucketFillMessage(x, y, colorRGB);
		canvas.getModule().sendMessage(message);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
