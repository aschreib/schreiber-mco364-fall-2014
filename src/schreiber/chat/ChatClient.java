package schreiber.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.107", 9097); // establishes connection
		// InputStream in = socket.getInputStream();
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(in));
	}

	public static void main(String[] args) throws IOException {
		ChatWindow window = new ChatWindow();
		window.setVisible(true);

	}

	public Socket getSocket() {
		return socket;
	}

}
