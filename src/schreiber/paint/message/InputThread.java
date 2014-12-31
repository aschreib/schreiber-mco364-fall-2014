package schreiber.paint.message;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import schreiber.paint.Canvas;

public class InputThread extends Thread {

	private Socket socket;
	private Canvas canvas;
	private PaintMessage paintMessage;

	public InputThread(Socket s, Canvas c) {
		this.socket = s;
		this.canvas = c;
	}

	@Override
	public void run() {
		PaintMessageFactory messageFactory = new PaintMessageFactory();
		InputStream in;
		try {
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					paintMessage = messageFactory.getMessage(line, canvas);
					paintMessage.apply((Graphics2D) canvas.getBufferedImage()
							.getGraphics());
					canvas.repaint();
				} catch (Exception e) {
					// ignore the bad message and keep reading
					continue;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
