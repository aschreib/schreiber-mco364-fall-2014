package schreiber.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.138", 8080); // establishes connection
	}

	public static void main(String[] args) throws IOException {
		ChatWindow_Client window = new ChatWindow_Client();
		window.setVisible(true);

	}

	public Socket getSocket() {
		return socket;
	}

}
