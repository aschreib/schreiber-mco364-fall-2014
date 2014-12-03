package schreiber.paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LineListener implements DrawListener {

	Canvas canvas;
	Paint paint;

	int startX;
	int startY;
	int endX;
	int endY;

	public LineListener(Canvas canvas, Paint paint) {
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
		BufferedImage image = canvas.getBufferedImage();
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(canvas.getColor());
		g.setStroke(new BasicStroke(canvas.getStrokeWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawLine(startX, startY, endX, endY);
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
