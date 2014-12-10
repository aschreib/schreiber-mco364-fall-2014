package schreiber.paint.message;

import java.awt.Color;

public class BucketFillMessage implements PaintMessage {

	private int x;
	private int y;
	private Color color;

	public BucketFillMessage(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "BucketFillMessage " + x + " " + y + " " + color + " " + "\n";
	}

}
