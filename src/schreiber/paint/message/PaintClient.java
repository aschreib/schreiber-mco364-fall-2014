package schreiber.paint.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import schreiber.paint.Canvas;

public class PaintClient {

	private Socket socket;
	private Canvas canvas;
	private OutputStream out;

	public PaintClient(Canvas c) throws UnknownHostException, IOException {
		this.canvas = c;
		socket = new Socket("192.168.117.107", 3773); // establishes
		// connection
		// connect to self to test:
		// socket = new Socket("127.0.0.1", 3773); // establishes connection
		out = socket.getOutputStream();
		InputThread inputThread = new InputThread(socket, canvas);
		// inputThread.run();
	}

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
