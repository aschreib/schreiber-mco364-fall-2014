package schreiber.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BucketFillListener implements DrawListener {

	private Canvas canvas;

	private int x, y;
	private Color color;
	private BufferedImage image;
	private int colorClicked;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;
		image = canvas.getBufferedImage();
	}

	public void Fill(int x, int y, Color color, int colorClicked) {

		if (colorClicked == color.getRGB()) {
			return;
		}
		if (color.getRGB() == image.getRGB(x, y)) {
			return;
		}
		image.setRGB(x, y, colorClicked);
		if (validCoordinate(x - 1, y)) {
			Fill(x - 1, y, color, colorClicked);
		}
		if (validCoordinate(x + 1, y)) {
			Fill(x + 1, y, color, colorClicked);
		}
		if (validCoordinate(x, y - 1)) {
			Fill(x, y - 1, color, colorClicked);
		}
		if (validCoordinate(x, y + 1)) {
			Fill(x, y + 1, color, colorClicked);
		}
		return;
	}

	public boolean validCoordinate(int x, int y) {
		return (x >= 0 && x <= 800 && y >= 0 && y <= 600);
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
		System.out.println(color.getRGB());
		colorClicked = image.getRGB(x, y);
		System.out.println(colorClicked);
		Fill(x, y, color, colorClicked);
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
