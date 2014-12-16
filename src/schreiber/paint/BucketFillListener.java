package schreiber.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFillListener implements DrawListener {

	private Canvas canvas;

	private int x, y;
	private Color color;
	private int colorRGB;
	private BufferedImage image;
	private int colorClicked;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;
		image = canvas.getBufferedImage();
	}

	public void Fill(int x, int y, int color, int colorClicked) {
		// create queue of points that will store all the points to be filled
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] alreadyQueued = new boolean[800][600];
		// start the fill at the passed point
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			// bounds check and color check
			if (validCoordinate(p.x, p.y)) {
				if (image.getRGB(p.x, p.y) != color
						&& image.getRGB(p.x, p.y) == colorClicked) {
					image.setRGB(p.x, p.y, color);
					if (validCoordinate(p.x - 1, p.y)
							&& !alreadyQueued[p.x - 1][p.y]) {
						queue.add(new Point(p.x - 1, p.y));
						alreadyQueued[p.x - 1][p.y] = true;
					}
					if (validCoordinate(p.x + 1, p.y)
							&& !alreadyQueued[p.x + 1][p.y]) {
						queue.add(new Point(p.x + 1, p.y));
						alreadyQueued[p.x + 1][p.y] = true;
					}
					if (validCoordinate(p.x, p.y - 1)
							&& !alreadyQueued[p.x][p.y - 1]) {
						queue.add(new Point(p.x, p.y - 1));
						alreadyQueued[p.x][p.y - 1] = true;
					}
					if (validCoordinate(p.x, p.y + 1)
							&& !alreadyQueued[p.x][p.y + 1]) {
						queue.add(new Point(p.x, p.y + 1));
						alreadyQueued[p.x][p.y + 1] = true;
					}

					System.out.println(queue.peek());
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
		System.out.println(color.getRGB());
		colorClicked = image.getRGB(x, y);
		System.out.println(colorClicked);
		Fill(x, y, colorRGB, colorClicked);
		canvas.repaint();
		System.out.println("done");
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
