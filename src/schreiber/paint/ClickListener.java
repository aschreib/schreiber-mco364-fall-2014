package schreiber.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

	Canvas canvas;

	public ClickListener(Canvas canvas) {
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		canvas.clicked(true);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
