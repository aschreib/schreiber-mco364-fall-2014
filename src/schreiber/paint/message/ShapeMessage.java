package schreiber.paint.message;

import java.awt.Color;

public class ShapeMessage implements PaintMessage {

	private String shapeType;
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private int strokeWidth;
	private boolean fill;

	public ShapeMessage(String shapeType, int x, int y, int width, int height, Color color, int strokeWidth,
			boolean fill) {
		super();
		this.shapeType = shapeType;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strokeWidth = strokeWidth;
		this.fill = fill;
	}

	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	@Override
	public String toString() {
		return "ShapeMessage " + x + " " + y + " " + width + " " + height + " " + color + " " + strokeWidth + " "
				+ fill + "\n";
	}

}
