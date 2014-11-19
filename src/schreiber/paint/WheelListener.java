package schreiber.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WheelListener implements MouseWheelListener {

	Canvas canvas;
	Paint paint;

	public WheelListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int rotation = (int) e.getWheelRotation();
		canvas.setWidth(rotation);
		paint.strokeLabel.setText("Current Stroke Width:" + canvas.getStrokeWidth());

	}

}
