package schreiber.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RectangleListener implements DrawListener {

	private Canvas canvas;

	private Integer startX, startY, endX, endY, width, height;

	public RectangleListener(Canvas canvas) {
		this.canvas = canvas;
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
		canvas.cleared(false);
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
		g.setStroke(new BasicStroke(canvas.getStrokeWidth()));
		g.drawRect(startX, startY, width, height);
		canvas.cleared(true);
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		endX = e.getX();
		endY = e.getY();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		width = Math.abs(startX - endX);
		height = Math.abs(startY - endY);
		Integer x1 = startX < endX ? startX : endX;
		Integer y1 = startY < endY ? startY : endY;
		g.setColor(canvas.getColor());
		g.setStroke(new BasicStroke(canvas.getStrokeWidth()));
		g.drawRect(x1, y1, width, height);
		canvas.repaint();
	}

}
