package schreiber.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import schreiber.paint.message.ClearMessage;
import schreiber.paint.message.PaintClient;

public class Paint extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 6939766772751318748L;

	private JColorChooser colorChooser;
	private JButton chooseButton;
	private JButton clearButton;
	private JLabel strokeLabel;
	private DrawListener drawListener;
	private PaintClient client;

	public Paint() throws UnknownHostException, IOException {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setLayout(new BorderLayout()); - it's default

		final Canvas canvas = new Canvas(this);

		setChooseButton(new JButton("Choose Color"));
		getChooseButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color color = JColorChooser.showDialog(canvas, "Choose Color", Color.BLACK);
				if (color != null) {
					canvas.setColor(color);
					getChooseButton().setForeground(canvas.getColor());
				}

			}
		});
		setStrokeLabel(new JLabel("Current Stroke Width:" + canvas.getStrokeWidth()));
		getStrokeLabel().setHorizontalAlignment(0);
		clearButton = new JButton("Clear Screen");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// canvas.clearCanvas();
				ClearMessage message = new ClearMessage();
				canvas.getModule().sendMessage(message);
			}

		});

		JPanel infoPanelBottom = new JPanel();
		infoPanelBottom.setLayout(new GridLayout());
		infoPanelBottom.add(getStrokeLabel());
		infoPanelBottom.add(getChooseButton());
		infoPanelBottom.add(clearButton);

		JButton pencilButton = new JButton("Pencil");
		pencilButton.addActionListener(new ShapeButtonListener(this, canvas, 1));
		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new ShapeButtonListener(this, canvas, 2));
		JButton rectangleButton = new JButton("Rectangle");
		rectangleButton.addActionListener(new ShapeButtonListener(this, canvas, 3));
		JButton ovalButton = new JButton("Oval");
		ovalButton.addActionListener(new ShapeButtonListener(this, canvas, 4));
		JButton fillRectangleButton = new JButton("Fill Rectangle");
		fillRectangleButton.addActionListener(new ShapeButtonListener(this, canvas, 5));
		JButton fillOvalButton = new JButton("Fill Oval");
		fillOvalButton.addActionListener(new ShapeButtonListener(this, canvas, 6));
		JButton bucketFillButton = new JButton("Bucket Fill");
		bucketFillButton.addActionListener(new ShapeButtonListener(this, canvas, 7));

		JPanel infoPanelTop = new JPanel();
		infoPanelTop.setLayout(new GridLayout());

		infoPanelTop.add(pencilButton);
		infoPanelTop.add(lineButton);
		infoPanelTop.add(rectangleButton);
		infoPanelTop.add(ovalButton);
		infoPanelTop.add(fillRectangleButton);
		infoPanelTop.add(fillOvalButton);
		infoPanelTop.add(bucketFillButton);

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

	public void setMouseListener(MouseListener m) {
	}

	public void setMouseMotionListener(MouseMotionListener m) {
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Paint paintWindow = new Paint();
		paintWindow.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Color newColor = JColorChooser.showDialog(colorChooser, "Choose Color", Color.BLACK);
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

	public PaintClient getClient() {
		// TODO Auto-generated method stub
		return client;
	}

}