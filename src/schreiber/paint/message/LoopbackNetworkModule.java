package schreiber.paint.message;

import java.awt.Graphics2D;

import schreiber.paint.Canvas;

public class LoopbackNetworkModule implements NetworkModule {

	private Canvas canvas;

	public LoopbackNetworkModule(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub
		message.apply((Graphics2D) canvas.getBufferedImage().getGraphics());
	}

}
