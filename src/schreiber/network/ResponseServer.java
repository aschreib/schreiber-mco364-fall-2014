package schreiber.network;

import java.io.IOException;
import java.net.ServerSocket;

public class ResponseServer {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(8080);

		ResponseServerThread thread = new ResponseServerThread(serverSocket);
		thread.start();
	}
}
