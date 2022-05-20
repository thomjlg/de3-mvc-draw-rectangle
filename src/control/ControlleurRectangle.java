package control;

import model.ModelRectangle;
import vue.ModificationRectangle;

public class ControlleurRectangle {
	private ModelRectangle modelrect ;
	private ModificationRectangle view = null ;

	public ControlleurRectangle(ModelRectangle m) {
		modelrect = m;
	}

	public void augmenterHauteur() { //pas de hauteur superieure à 450
		if(modelrect.getHauteur() < 450){
			modelrect.setDim(modelrect.getHauteur() + 1);
		}
	}

	public void reduireHauteur() {
		if(modelrect.getHauteur() > 0){ //pas de hauteur negative pour le rectangle
			modelrect.setDim(modelrect.getHauteur() - 1);
		}
	}

	public void fixeHauteur(int rectwidth) {
		//si input < 0 alors on met 0 (valeur min)
		//si input > 450 alors on met 450 (valeur max)
		modelrect.setDim(rectwidth);
		if(rectwidth < 0){
			modelrect.setDim(0);
		}
		if(rectwidth > 450){
			modelrect.setDim(450);
		}
	}

	public void setView(ModificationRectangle view) {
		this.view = view;
	}
}
