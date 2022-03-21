package Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class ModifierCompteForm extends BaseTemplateForm {
	public ModifierCompteForm() {
		super();
		titlePageLabel.setText("Modifier les informations du compte " + "HERE Compte Numero" + " de " + "HERE Client prenom et nom");

		// Display correct editing field according to compte type
		if (true) {
			
		}
		if (false) {
			
		}
		
	}

	public static void main(String[] args) {
		ModifierCompteForm testFrame = new ModifierCompteForm();
		testFrame.setVisible(true);

	}

}
