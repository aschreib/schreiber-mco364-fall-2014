package schreiber.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame {

	private JTextArea area;
	private JPanel panel;
	private JTextField field;
	private JButton button;
	private ChatClient client;

	public ChatWindow() throws UnknownHostException, IOException {
		setTitle("Chat");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		area = new JTextArea();
		panel = new JPanel();
		field = new JTextField();
		button = new JButton("SEND");

		panel.setLayout(new BorderLayout());
		panel.add(field, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);

		add(area, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = field.getText() + "\n";
				area.setText(area.getText() + message);
				OutputStream out;
				try {
					out = client.getSocket().getOutputStream();
					out.write(message.getBytes());
					out.flush(); // actually sends data out
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		client = new ChatClient();
	}

}
