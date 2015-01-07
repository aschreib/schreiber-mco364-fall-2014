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
	private InputThread inputThread;

	public PaintClient(Canvas c) throws UnknownHostException, IOException {
		this.canvas = c;
		socket = new Socket("192.168.117.107", 3773); // establishes connection
		// connect to self to test:
		// socket = new Socket("127.0.0.1", 3773); // establishes connection
		out = socket.getOutputStream();
		inputThread = new InputThread(socket, canvas);
		inputThread.start();
	}

	public InputThread getInputThread() {
		return inputThread;
	}

	public OutputStream getOutputStream() {
		return out;
	}

	public void setOutputStream(OutputStream out) {
		this.out = out;
	}

	public Socket getSocket() {
		return socket;
	}
}
