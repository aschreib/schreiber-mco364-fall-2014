package schreiber.paint;

import java.awt.BasicStroke;
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
		endX = startX;
		endY = startY;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		endX = e.getX();
		endY = e.getY();
		width = Math.abs(startX - endX);
		height = Math.abs(startY - endY);
		startX = startX < endX ? startX : endX;
		startY = startY < endY ? startY : endY;
		BufferedImage image = canvas.getBufferedImage();
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(canvas.getColor());
		g.fillRect(startX, startY, width, height);
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		endX = e.getX();
		endY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		Integer x1 = startX;
		Integer y1 = startY;
		width = Math.abs(startX - endX);
		height = Math.abs(startY - endY);
		x1 = startX < endX ? startX : endX;
		y1 = startY < endY ? startY : endY;
		g.setColor(canvas.getColor());
		g.setStroke(new BasicStroke(canvas.getStrokeWidth()));
		g.fillRect(x1, y1, width, height);
		canvas.repaint();
	}

}
