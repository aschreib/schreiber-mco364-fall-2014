package schreiber.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseMotionListener {

	Canvas canvas;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
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

}
