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

	JColorChooser colorChooser;
	Color color = Color.BLACK;
	JButton chooseButton;
	JButton clearButton;
	JLabel strokeLabel;
	DrawListener drawListener;
	MouseListener mouseListener;
	MouseMotionListener mouseMotionListener;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setLayout(new BorderLayout()); - it's default

		Canvas canvas = new Canvas();

		chooseButton = new JButton("Choose Color");
		chooseButton.addActionListener(new ChooseButtonListener(canvas, this));
		strokeLabel = new JLabel("Current Stroke Width:" + canvas.getStrokeWidth());
		strokeLabel.setHorizontalAlignment(0);
		clearButton = new JButton("Clear Screen");
		clearButton.addActionListener(new ClearButtonListener(canvas));

		JPanel infoPanelBottom = new JPanel();
		infoPanelBottom.setLayout(new GridLayout());
		infoPanelBottom.add(strokeLabel);
		infoPanelBottom.add(chooseButton);
		infoPanelBottom.add(clearButton);

		JButton pencilButton = new JButton("Pencil");
		pencilButton.addActionListener(new PencilButtonListener(canvas, this));
		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new LineButtonListener(canvas, this));
		JButton rectangleButton = new JButton("Rectangle");
		rectangleButton.addActionListener(new RectangleButtonListener(canvas, this));
		JButton ovalButton = new JButton("Oval");
		ovalButton.addActionListener(new OvalButtonListener(canvas, this));
		JButton fillRectangleButton = new JButton("Fill Rectangle");
		fillRectangleButton.addActionListener(new FillRectangleButtonListener(canvas, this));
		JButton fillOvalButton = new JButton("Fill Oval");
		fillOvalButton.addActionListener(new FillOvalButtonListener(canvas, this));

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

		canvas.addMouseWheelListener(new WheelListener(canvas, this));
	}

	public void setDrawListener(DrawListener d) {
		this.drawListener = d;
	}

	public void setMouseListener(MouseListener m) {
		this.mouseListener = m;
	}

	public void setMouseMotionListener(MouseMotionListener m) {
		this.mouseMotionListener = m;
	}

	public static void main(String[] args) {
		Paint paintWindow = new Paint();
		paintWindow.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Color newColor = JColorChooser.showDialog(colorChooser, "Choose Color", Color.BLACK);
		if (newColor != null) {
			color = newColor;
		}
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
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
		Color color = JColorChooser.showDialog(canvas, "Choose Color", Color.BLACK);
		if (color != null) {
			canvas.setColor(color);
			paint.chooseButton.setForeground(canvas.getColor());

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
	public Paint paint;

	public PencilButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(paint.drawListener);
		canvas.removeMouseMotionListener(paint.drawListener);
		PencilListener listener = new PencilListener(canvas, paint);
		paint.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class LineButtonListener implements ActionListener {

	private Canvas canvas;
	public Paint paint;

	public LineButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(paint.drawListener);
		canvas.removeMouseMotionListener(paint.drawListener);
		LineListener listener = new LineListener(canvas, paint);
		paint.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class RectangleButtonListener implements ActionListener {

	private Canvas canvas;
	public Paint paint;

	public RectangleButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(paint.drawListener);
		canvas.removeMouseMotionListener(paint.drawListener);
		RectangleListener listener = new RectangleListener(canvas, paint);
		paint.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class OvalButtonListener implements ActionListener {

	private Canvas canvas;
	public Paint paint;

	public OvalButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(paint.drawListener);
		canvas.removeMouseMotionListener(paint.drawListener);
		OvalListener listener = new OvalListener(canvas, paint);
		paint.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class FillRectangleButtonListener implements ActionListener {

	private Canvas canvas;
	public Paint paint;

	public FillRectangleButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(paint.drawListener);
		canvas.removeMouseMotionListener(paint.drawListener);
		FillRectangleListener listener = new FillRectangleListener(canvas, paint);
		paint.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}

class FillOvalButtonListener implements ActionListener {

	private Canvas canvas;
	public Paint paint;

	public FillOvalButtonListener(Canvas c, Paint p) {
		this.canvas = c;
		this.paint = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvas.removeMouseListener(paint.drawListener);
		canvas.removeMouseMotionListener(paint.drawListener);
		FillOvalListener listener = new FillOvalListener(canvas, paint);
		paint.setDrawListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
	}

}