package schreiber.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setLayout(new BorderLayout()); - it's default

		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);

		// PalettePanel palette = new PalettePanel();
		// add(palette, BorderLayout.PAGE_START);

		// Color newColor = JColorChooser.showDialog(canvas, "Choose Color",
		// Color.BLACK);

		ClickListener clickListener = new ClickListener(canvas);
		canvas.addMouseListener(clickListener);

		DrawListener drawListener = new DrawListener(canvas);
		canvas.addMouseMotionListener(drawListener);
	}

	public static void main(String[] args) {
		Paint paintWindow = new Paint();
		paintWindow.setVisible(true);

	}

}
