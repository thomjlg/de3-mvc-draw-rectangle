package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelRectangle {
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		 this.pcs.addPropertyChangeListener(listener);
	 }

	private int width = 50;

	public int getHauteur() {
		return width;
	}

	public void setDim(int i) {
		int oldVal = width;
		width = i ;
		this.pcs.firePropertyChange("width", oldVal, width);
	}
	
	
}
