package schreiber.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import schreiber.paint.message.LineMessage;

public class LineListener implements DrawListener {

	private Canvas canvas;
	private Paint paint;

	private int startX, startY, endX, endY;

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
		BufferedImage image = canvas.getBufferedImage();
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(canvas.getColor());
		g.setStroke(new BasicStroke(canvas.getStrokeWidth(),
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		// g.drawLine(startX, startY, endX, endY);
		LineMessage message = new LineMessage(startX, startY, endX, endY,
				canvas.getColor().getRGB(), canvas.getStrokeWidth());
		canvas.getModule().sendMessage(message);
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
		g.setColor(canvas.getColor());
		g.setStroke(new BasicStroke(canvas.getStrokeWidth(),
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawLine(startX, startY, endX, endY);
		canvas.repaint();
	}

}
