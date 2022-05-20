import control.ControlleurRectangle;
import model.ModelRectangle;
import vue.VueRectangle;
import vue.ModificationRectangle;

public class MVCRectangle {
	public MVCRectangle() {
		ModelRectangle modelRectangle = new ModelRectangle();
		ControlleurRectangle controleurRectangle = new ControlleurRectangle(modelRectangle);
		
		VueRectangle rectHauteur = new VueRectangle("Configurer la hauteur du rectangle :", modelRectangle, controleurRectangle, 100, 100);
		ModificationRectangle rectDisplay = new ModificationRectangle("Affichage du rectangle :", modelRectangle, controleurRectangle, 100, 200);
	}

	public static void main(String args[]) {
		new MVCRectangle();
	}
}
