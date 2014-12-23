package schreiber.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayerButtonListener implements ActionListener {

	private int buttonNumber;
	private Canvas canvas;
	private Paint paint;

	public LayerButtonListener(int buttonNum, Canvas c, Paint p) {
		this.buttonNumber = buttonNum;
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		canvas.setBufferedImage(buttonNumber);
		canvas.repaint();
		canvas.setLayerNumber(buttonNumber);
		paint.getLayerLabel().setText("Current Layer: " + buttonNumber);
	}

}
