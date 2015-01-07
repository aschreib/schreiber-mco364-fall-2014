package schreiber.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JComponent;

import schreiber.paint.message.LineMessage;
import schreiber.paint.message.LoopbackNetworkModule;
import schreiber.paint.message.NetworkModule;
import schreiber.paint.message.OnlineNetworkModule;
import schreiber.paint.message.PaintClient;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 5557512110330206586L;

	private int oldX = 0;
	private int oldY = 0;
	private boolean clicked;
	private boolean cleared;
	private Color color = Color.BLACK;
	private int strokeWidth = 3;
	private PaintClient client;
	private NetworkModule module;

	private DrawListener listener = new PencilListener(this);
	private BufferedImage image;

	public Canvas() throws UnknownHostException, IOException {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		try {
			client = new PaintClient(this);
			setModule(new OnlineNetworkModule(client));
		} catch (Exception e) {
			setModule(new LoopbackNetworkModule(this));
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		if (!cleared) {
			listener.drawPreview((Graphics2D) g);
		}
	}

	public DrawListener getDrawListener() {
		return listener;
	}

	public void setDrawListener(DrawListener listener) {
		this.listener = listener;
	}

	public void clicked(boolean b) {
		clicked = b;
	}

	public void cleared(boolean b) {
		cleared = b;
	}

	public void setPoint(int x, int y) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(color);
		g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		if (!clicked) {
			// g.drawLine(x, y, oldX, oldY);
			LineMessage message = new LineMessage(x, y, oldX, oldY,
					color.getRGB(), strokeWidth);
			getModule().sendMessage(message);
		}
		oldX = x;
		oldY = y;
		clicked = false;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(int rotation) {
		strokeWidth += rotation * -1;
		if (strokeWidth <= 1) {
			strokeWidth = 1;
		}
		if (strokeWidth >= 50) {
			strokeWidth = 50;
		}
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public BufferedImage getBufferedImage() {
		return image;
	}

	public void clearCanvas() {
		cleared(true);
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}

	public NetworkModule getModule() {
		return module;
	}

	public void setModule(NetworkModule module) {
		this.module = module;
	}

	public PaintClient getClient() {
		// TODO Auto-generated method stub
		return client;
	}
}
