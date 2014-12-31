package schreiber.paint.message;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import schreiber.paint.Canvas;

public class BucketFillMessage implements PaintMessage {

	private int x;
	private int y;
	private int color;

	private Canvas canvas;

	public BucketFillMessage(int x, int y, int color, Canvas c) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.canvas = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "BUCKET_FILL " + x + " " + y + " " + color + " " + "\n";
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		BufferedImage image = canvas.getBufferedImage();
		int colorClicked = image.getRGB(x, y);

		// create queue of points that will store all the points to be filled
		Queue<Point> queue = new LinkedList<Point>();
		// start the fill at the clicked point
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			// bounds check and color check
			if (validCoordinate(p.x, p.y)) {
				int pixelColor = image.getRGB(p.x, p.y);
				if (pixelColor != color && pixelColor == colorClicked) {
					image.setRGB(p.x, p.y, color);
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

	private boolean validCoordinate(int x, int y) {
		return (x >= 0 && x < 800 && y >= 0 && y < 600);
	}
}
