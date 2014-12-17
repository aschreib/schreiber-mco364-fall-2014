package schreiber.paint.message;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import schreiber.paint.Canvas;
import schreiber.paint.Paint;

public class PaintClient {

	private Socket socket;
	private PaintMessage paintMessage;
	private Canvas canvas;

	public PaintClient() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.107", 3773); // establishes connection
		PaintMessageFactory messageFactory = new PaintMessageFactory();
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		String message = "GET /\n";
		out.write(message.getBytes());
		out.flush(); // sends data out
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			paintMessage = messageFactory.getMessage(line);
			paintMessage.apply((Graphics2D) canvas.getGraphics());
		}
	}

	public static void main(String[] args) throws IOException {
		Paint window = new Paint();
		window.setVisible(true);
		PaintClient client = new PaintClient();
	}

	public Socket getSocket() {
		return socket;
	}
}
