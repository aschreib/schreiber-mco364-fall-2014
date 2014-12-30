package schreiber.paint.message;

import java.io.PrintWriter;

public class OnlineNetworkModule implements NetworkModule {

	private PaintClient client;

	public OnlineNetworkModule(PaintClient client) {
		this.client = client;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		PrintWriter writer = new PrintWriter(client.getOutputStr());
		writer.print(message.toString());
		writer.flush();
	}

}
