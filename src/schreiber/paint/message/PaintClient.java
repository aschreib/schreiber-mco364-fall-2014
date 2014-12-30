package schreiber.paint.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import schreiber.paint.Canvas;

public class PaintClient {

	private Socket socket;
	private PaintMessage paintMessage;
	private Canvas canvas;
	private OutputStream out;

	public PaintClient() throws UnknownHostException, IOException {
		// socket = new Socket("192.168.117.107", 3773); // establishes
		// connection
		// connect to self to test:
		socket = new Socket("127.0.0.1", 3773); // establishes connection
		// PaintMessageFactory messageFactory = new PaintMessageFactory();
		InputStream in = socket.getInputStream();
		out = socket.getOutputStream();
		// String message = "GET /\n";
		// out.write(message.getBytes());
		// out.flush(); // sends data out
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(in));
		// String line;
		// while ((line = reader.readLine()) != null) {
		// paintMessage = messageFactory.getMessage(line);
		// paintMessage.apply((Graphics2D) canvas.getGraphics());
		// }
	}

	// public static void main(String[] args) throws IOException {
	// Paint window = new Paint(out);
	// window.setVisible(true);
	// }

	public OutputStream getOutputStr() {
		return out;
	}

	public void setOutputStr(OutputStream out) {
		this.out = out;
	}

	public Socket getSocket() {
		return socket;
	}
}
