package schreiber.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeButtonListener implements ActionListener {

	private Paint paint;
	private Canvas canvas;
	private int buttonNum;
	private DrawListener listener;

	public ShapeButtonListener(Paint p, Canvas c, int buttonNum) {
		this.paint = p;
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
			listener = new LineListener(canvas, paint);
			break;
		case 3:
			listener = new RectangleListener(canvas, paint);
			break;
		case 4:
			listener = new OvalListener(canvas, paint);
			break;
		case 5:
			listener = new FillRectangleListener(canvas, paint);
			break;
		case 6:
			listener = new FillOvalListener(canvas, paint);
			break;
		case 7:
			listener = new BucketFillListener(canvas, paint);
		}

		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}
