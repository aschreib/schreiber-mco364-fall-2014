package schreiber.paint;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PalettePanel extends JPanel {

	JColorChooser palette;

	public PalettePanel() {
		super(new BorderLayout());
		palette = new JColorChooser(Color.BLACK);
		add(palette, BorderLayout.CENTER);
	}

	public JColorChooser getPalette() {
		return palette;
	}
}
