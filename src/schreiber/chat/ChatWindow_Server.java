package schreiber.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow_Server extends JFrame {

	private JTextArea area;
	private JPanel panel;
	private JTextField field;
	private JButton button;

	public ChatWindow_Server() {
		setTitle("Chat - Server");
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
				area.setText(field.getText());
				field.setText(null);
			}
		});

	}

	public void setArea(String message) {
		this.area.setText(area.getText() + message);
	}
}
