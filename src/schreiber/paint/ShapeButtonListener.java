package schreiber.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeButtonListener implements ActionListener {

	private Canvas canvas;
	private int buttonNum;
	private DrawListener listener;

	public ShapeButtonListener(Canvas c, int buttonNum) {
		this.canvas = c;
		this.buttonNum = buttonNum;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());

		switch (buttonNum) {
		case 1:
			listener = new PencilListener(canvas);
			break;
		case 2:
			listener = new LineListener(canvas);
			break;
		case 3:
			listener = new RectangleListener(canvas);
			break;
		case 4:
			listener = new OvalListener(canvas);
			break;
		case 5:
			listener = new FillRectangleListener(canvas);
			break;
		case 6:
			listener = new FillOvalListener(canvas);
			break;
		}

		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}
