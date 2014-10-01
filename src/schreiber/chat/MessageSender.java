package schreiber.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MessageSender extends Thread {

	private BlockingQueue<String> messages;
	private List<Socket> sockets;

	public MessageSender(BlockingQueue<String> messages, List<Socket> sockets) {
		this.messages = messages;
		this.sockets = sockets;
	}

	public void run() {

		while (true) {
			String message;
			try {
				message = messages.take();

				for (Socket socket : sockets) {

					// if (socket.isClosed());

					try {
						OutputStream out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.println(message);
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			messages.clear();
		}
	}

}
