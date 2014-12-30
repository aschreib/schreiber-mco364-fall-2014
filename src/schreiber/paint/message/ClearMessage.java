package schreiber.paint.message;

import java.awt.Graphics2D;

import schreiber.paint.Canvas;

public class ClearMessage implements PaintMessage {

	private Canvas canvas;

	public ClearMessage() {

	}

	@Override
	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		canvas.clearCanvas();
	}

}
