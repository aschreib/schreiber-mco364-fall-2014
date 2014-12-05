package schreiber.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WheelListener implements MouseWheelListener {

	private Canvas canvas;
	private Paint paint;

	public WheelListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int rotation = (int) e.getWheelRotation();
		canvas.setWidth(rotation);
		paint.getStrokeLabel().setText(
				"Current Stroke Width:" + canvas.getStrokeWidth());

	}

}
