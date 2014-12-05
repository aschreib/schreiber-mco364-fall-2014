package schreiber.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Paint extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 6939766772751318748L;

	private JColorChooser colorChooser;
	private JButton chooseButton;
	private JButton clearButton;
	private JLabel strokeLabel;
	private DrawListener drawListener;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setLayout(new BorderLayout()); - it's default

		Canvas canvas = new Canvas();

		setChooseButton(new JButton("Choose Color"));
		getChooseButton().addActionListener(
				new ChooseButtonListener(canvas, this));
		setStrokeLabel(new JLabel("Current Stroke Width:"
				+ canvas.getStrokeWidth()));
		getStrokeLabel().setHorizontalAlignment(0);
		clearButton = new JButton("Clear Screen");
		clearButton.addActionListener(new ClearButtonListener(canvas));

		JPanel infoPanelBottom = new JPanel();
		infoPanelBottom.setLayout(new GridLayout());
		infoPanelBottom.add(getStrokeLabel());
		infoPanelBottom.add(getChooseButton());
		infoPanelBottom.add(clearButton);

		JButton pencilButton = new JButton("Pencil");
		pencilButton.addActionListener(new PencilButtonListener(canvas));
		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new LineButtonListener(canvas));
		JButton rectangleButton = new JButton("Rectangle");
		rectangleButton.addActionListener(new RectangleButtonListener(canvas));
		JButton ovalButton = new JButton("Oval");
		ovalButton.addActionListener(new OvalButtonListener(canvas));
		JButton fillRectangleButton = new JButton("Fill Rectangle");
		fillRectangleButton.addActionListener(new FillRectangleButtonListener(
				canvas));
		JButton fillOvalButton = new JButton("Fill Oval");
		fillOvalButton.addActionListener(new FillOvalButtonListener(canvas));

		JPanel infoPanelTop = new JPanel();
		infoPanelTop.setLayout(new GridLayout());

		infoPanelTop.add(pencilButton);
		infoPanelTop.add(lineButton);
		infoPanelTop.add(rectangleButton);
		infoPanelTop.add(ovalButton);
		infoPanelTop.add(fillRectangleButton);
		infoPanelTop.add(fillOvalButton);

		add(infoPanelTop, BorderLayout.PAGE_START);
		add(infoPanelBottom, BorderLayout.PAGE_END);

		colorChooser = new JColorChooser();
		colorChooser.getSelectionModel().addChangeListener(this);

		add(canvas, BorderLayout.CENTER);

		// begin with a pencil listener
		drawListener = canvas.getDrawListener();
		canvas.addMouseMotionListener(drawListener);
		canvas.addMouseListener(drawListener);
		canvas.addMouseWheelListener(new WheelListener(canvas, this));
	}

	// public void setDrawListener(DrawListener d) {
	// this.drawListener = d;
	// }
	//
	// public DrawListener getDrawListener() {
	// return drawListener;
	// }

	public void setMouseListener(MouseListener m) {
	}

	public void setMouseMotionListener(MouseMotionListener m) {
	}

	public static void main(String[] args) {
		Paint paintWindow = new Paint();
		paintWindow.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Color newColor = JColorChooser.showDialog(colorChooser, "Choose Color",
				Color.BLACK);
		if (newColor != null) {
		}
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
	}

	public JButton getChooseButton() {
		return chooseButton;
	}

	public void setChooseButton(JButton chooseButton) {
		this.chooseButton = chooseButton;
	}

	public JLabel getStrokeLabel() {
		return strokeLabel;
	}

	public void setStrokeLabel(JLabel strokeLabel) {
		this.strokeLabel = strokeLabel;
	}

}

class ChooseButtonListener implements ActionListener {
	private Canvas canvas;
	public Paint paint;

	public ChooseButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	public void actionPerformed(ActionEvent arg0) {
		Color color = JColorChooser.showDialog(canvas, "Choose Color",
				Color.BLACK);
		if (color != null) {
			canvas.setColor(color);
			paint.getChooseButton().setForeground(canvas.getColor());

		}
	}

}

class ClearButtonListener implements ActionListener {

	private Canvas canvas;

	public ClearButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.clearCanvas();
	}

}

class PencilButtonListener implements ActionListener {

	private Canvas canvas;

	public PencilButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());
		PencilListener listener = new PencilListener(canvas);
		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class LineButtonListener implements ActionListener {

	private Canvas canvas;

	public LineButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());
		LineListener listener = new LineListener(canvas);
		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class RectangleButtonListener implements ActionListener {

	private Canvas canvas;

	public RectangleButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());
		RectangleListener listener = new RectangleListener(canvas);
		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class OvalButtonListener implements ActionListener {

	private Canvas canvas;

	public OvalButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());
		OvalListener listener = new OvalListener(canvas);
		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class FillRectangleButtonListener implements ActionListener {

	private Canvas canvas;

	public FillRectangleButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());
		FillRectangleListener listener = new FillRectangleListener(canvas);
		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class FillOvalButtonListener implements ActionListener {

	private Canvas canvas;

	public FillOvalButtonListener(Canvas c) {
		this.canvas = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(canvas.getDrawListener());
		canvas.removeMouseMotionListener(canvas.getDrawListener());
		FillOvalListener listener = new FillOvalListener(canvas);
		canvas.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}