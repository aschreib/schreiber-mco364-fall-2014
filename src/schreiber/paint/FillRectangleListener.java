package schreiber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class FillRectangleListener implements DrawListener {

	Canvas canvas;
	Paint paint;

	int startX, startY, endX, endY, width, height;

	public FillRectangleListener(Canvas canvas, Paint paint) {
		this.canvas = canvas;
		this.paint = paint;
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
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		endX = e.getX();
		endY = e.getY();
		width = Math.abs(startX - endX);
		height = Math.abs(startY - endY);
		if (startX > endX && startY > endY) {
			startX = endX;
			startY = endY;
		} else if (startX < endX && startY > endY) {
			startY = endY;
		} else if (startX > endX && startY < endY) {
			startX = endX;
		}
		BufferedImage image = canvas.getBufferedImage();
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(canvas.getColor());
		g.fillRect(startX, startY, width, height);
		canvas.repaint();
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
