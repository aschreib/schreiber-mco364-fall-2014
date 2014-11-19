package schreiber.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private int x;
	private int y;
	private int oldX = 0;
	private int oldY = 0;
	private boolean clicked;
	private Color color = Color.BLACK;
	private int strokeWidth = 3;

	BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public void clicked(boolean b) {
		clicked = b;
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(color);
		g.setStroke(new BasicStroke(strokeWidth));
		if (!clicked) {
			g.drawLine(x, y, oldX, oldY);
		}
		oldX = x;
		oldY = y;
		clicked = false;
	}

	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;		
	}

	public void setWidth(int rotation) {
		// TODO Auto-generated method stub
		if(rotation < 0)
		strokeWidth -= rotation;
		else strokeWidth += rotation;
	}
	
	public int getStrokeWidth(){
		return strokeWidth;
	}

}
