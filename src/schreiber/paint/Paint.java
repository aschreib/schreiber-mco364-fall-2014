package schreiber.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setLayout(new BorderLayout()); -it's default

		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);

		MouseListener listener = new MouseListener(canvas);
		canvas.addMouseMotionListener(listener);
	}

	public static void main(String[] args) {
		Paint paintWindow = new Paint();
		paintWindow.setVisible(true);

	}

}
