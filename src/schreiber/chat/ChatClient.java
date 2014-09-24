package schreiber.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.79", 1025); // establishes connection
//		InputStream in = socket.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	}

	public static void main(String[] args) throws IOException {
		ChatWindow window = new ChatWindow();
		window.setVisible(true);

	}

	public Socket getSocket() {
		return socket;
	}

}
