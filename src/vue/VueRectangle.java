package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import control.ControlleurRectangle;
import model.ModelRectangle;

public class VueRectangle implements PropertyChangeListener {
	private ModelRectangle model;
	private ControlleurRectangle controller;
	private JFrame RectHauteur;
	private JTextField display = new JTextField();
	private JButton upJButton = new JButton("+ (max. 450)");
	private JButton downJButton = new JButton("- (min. 0)");
	
	public VueRectangle(String label, ModelRectangle model, final ControlleurRectangle controller, int posX, int posY) {
		this.model = model;
		this.controller = controller;
		
		RectHauteur = new JFrame(label);
		RectHauteur.add(new JLabel(label), BorderLayout.NORTH);
		RectHauteur.add(display, BorderLayout.CENTER);
		RectHauteur.setSize(250, 100);
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(downJButton);
		panelbuttons.add(upJButton);
		RectHauteur.add(panelbuttons, BorderLayout.SOUTH);
		RectHauteur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RectHauteur.setLocation(posX, posY);
		RectHauteur.setVisible(true);

		model.addPropertyChangeListener(this);

		setDisplay("" + model.getHauteur());

		addUpListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.augmenterHauteur();
			}
		});
		addDownListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.reduireHauteur();
			}
		});
		addDisplayListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rectHauteur = getDisplay();
				controller.fixeHauteur(rectHauteur);
			}
		});
	}

	public void propertyChange(PropertyChangeEvent e) {
		setDisplay("" + model.getHauteur());
	}

	public void setDisplay(String s) {
		display.setText(s);
	}

	public void enableWarningColor() {
		display.setBackground(Color.RED);
	}

	public void disableWarningColor() {
		display.setBackground(Color.WHITE);
	}

	public int getDisplay() {
		int result = 0;
		try {
			result = Integer.valueOf(display.getText());
		} catch (NumberFormatException e) {
			System.err.println("String to int Conversion error:" + e.getMessage());
		}
		return result;
	}

	public void addDisplayListener(ActionListener a) {
		display.addActionListener(a);
	}

	public void addUpListener(ActionListener a) {
		upJButton.addActionListener(a);
	}

	public void addDownListener(ActionListener a) {
		downJButton.addActionListener(a);
	}
}
