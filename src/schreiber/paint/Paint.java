package schreiber.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JLabel colorLabel;
	
	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setLayout(new BorderLayout()); - it's default
		
		Canvas canvas = new Canvas();
		
		JButton chooseButton = new JButton("Choose Color");
	    chooseButton.addActionListener(new ChooseButtonListener(canvas, this));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(2,1));
		
		colorLabel = new JLabel("Current Color");
		infoPanel.add(colorLabel);
		
		JLabel strokeLabel = new JLabel("Current Stroke Width:" +canvas.getStrokeWidth());
		infoPanel.add(strokeLabel);
		
		add(infoPanel,BorderLayout.PAGE_START);
	    
		colorChooser = new JColorChooser();
		colorChooser.getSelectionModel().addChangeListener(this);
		
		add(canvas, BorderLayout.CENTER);
		//add(colorChooser, BorderLayout.PAGE_END);
		add(chooseButton, BorderLayout.PAGE_END);

		ClickListener clickListener = new ClickListener(canvas);
		canvas.addMouseListener(clickListener);

		DrawListener drawListener = new DrawListener(canvas);
		canvas.addMouseMotionListener(drawListener);
	}
	
    public void actionPerformed(ActionEvent e) {
        Color newColor = JColorChooser.showDialog(colorChooser,"Choose Color", Color.BLACK);
        if (newColor != null) {
            color = newColor;
        }
    }

	public static void main(String[] args) {
		Paint paintWindow = new Paint();
		paintWindow.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
	}

}

class ChooseButtonListener implements ActionListener{
	private Canvas canvas;
	public Paint paint;
	
	public ChooseButtonListener(Canvas c, Paint p){
		this.canvas = c;
		this.paint = p;
	}
	
	public void actionPerformed(ActionEvent arg0){
		Color color = JColorChooser.showDialog(canvas,  "Choose Color", Color.BLACK);
		if (color != null) {
				canvas.setColor(color);
				paint.colorLabel.setForeground(canvas.getColor());
				
			}
	}
}
