package vue;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import control.ControlleurRectangle;
import model.ModelRectangle;

public class ModificationRectangle implements PropertyChangeListener {
	private ModelRectangle model;
	private ControlleurRectangle control;
	private JFrame RectDisplay;
	private AffichageRectangle Rectangle;

	public ModificationRectangle(String label, ModelRectangle modelrect, final ControlleurRectangle control, int posX, int posY) {
		this.model = modelrect;
		this.control = control;
		RectDisplay = new JFrame(label);
		RectDisplay.add(new JLabel(label), BorderLayout.NORTH);
		RectDisplay.setSize(250, 550);
		RectDisplay.setLocation(posX, posY);
		RectDisplay.setVisible(true);
		Rectangle = new AffichageRectangle(30, 20, 190, modelrect.getHauteur());
		RectDisplay.add(Rectangle);
		RectDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.addPropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		RectDisplay.remove(Rectangle);
		Rectangle.setHauteur(model.getHauteur());
		RectDisplay.add(Rectangle);
		RectDisplay.repaint();
	}
}

