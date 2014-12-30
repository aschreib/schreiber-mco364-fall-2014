package schreiber.paint.message;

import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {

	public ClearMessage() {

	}

	@Override
	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
