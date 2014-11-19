package schreiber.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class PencilListener implements DrawListener {

	Canvas canvas;
	Paint paint;

	public PencilListener(Canvas canvas, Paint paint) {
		this.canvas = canvas;
		this.paint = paint;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// The magic happens here!
		canvas.setPoint(e.getX(), e.getY());
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		canvas.clicked(true);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
