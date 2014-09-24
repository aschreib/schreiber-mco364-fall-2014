package schreiber.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkRequest {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("www.amazon.com", 8080);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		String request = "GET /index.html\n\n";
		out.write(request.getBytes());
		out.flush(); // actually sends data out
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

	}
}
