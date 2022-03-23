package controler;

import db.DbUpdateQueries;
import model.CompteCourant;
import model.CompteEpargne;
import sessionData.CurrentSessionData;

/* ==============================================
 * IN PROGRESS
 * ==============================================*/

public class UpdateCompteControler {
	public static void onUpdateValidationBtnCLick() {
		if (CurrentSessionData.getCompteToUpdate() instanceof CompteCourant) {
			DbUpdateQueries.updateCompteInfoInDb(CurrentSessionData.getCompteToUpdate(),
					CurrentSessionData.getUpdateComptePage().getTextFieldFraisDeTransfert().getText());
		}
		if (CurrentSessionData.getCompteToUpdate() instanceof CompteEpargne) {
			DbUpdateQueries.updateCompteInfoInDb(CurrentSessionData.getCompteToUpdate(),
					CurrentSessionData.getUpdateComptePage().getTextFieldTauxInteret().getText());
		}

		CurrentSessionData.getUpdateComptePage().dispose();
	}

	public static void onCancelBtnClick() {
		CurrentSessionData.getUpdateComptePage().dispose();
	}

	public static void onAddingTextInFraisDeTransfert() {
		String textToCheck = CurrentSessionData.getUpdateComptePage().getTextFieldFraisDeTransfert().getText();
		if (textToCheck.isEmpty()) {
			CurrentSessionData.getUpdateComptePage().getFraisDeTransfertReturnMsg().setText("Champ nécessaire !");
			CurrentSessionData.getUpdateComptePage().disablebtnUpdateCompteValidation();
		} else if (Integer.parseInt(textToCheck) > 0 && Integer.parseInt(textToCheck) <= 100000) {
			CurrentSessionData.getUpdateComptePage().getFraisDeTransfertReturnMsg().setText("OK");
			CurrentSessionData.getUpdateComptePage().enablebtnUpdateCompteValidation();
		} else {
			CurrentSessionData.getUpdateComptePage().getFraisDeTransfertReturnMsg().setText("Champ incorrect !");
			CurrentSessionData.getUpdateComptePage().disablebtnUpdateCompteValidation();
		}
	}

	public static void onAddingTextInTauxInteret() {
		String textToCheck = CurrentSessionData.getUpdateComptePage().getTextFieldTauxInteret().getText();
		if (textToCheck.isEmpty()) {
			CurrentSessionData.getUpdateComptePage().getTauxInteretReturnMsg().setText("Champ nécessaire !");
			CurrentSessionData.getUpdateComptePage().disablebtnUpdateCompteValidation();
		} else if (Integer.parseInt(textToCheck) > 0 && Integer.parseInt(textToCheck) <= 100000) {
			CurrentSessionData.getUpdateComptePage().getTauxInteretReturnMsg().setText("OK");
			CurrentSessionData.getUpdateComptePage().enablebtnUpdateCompteValidation();
		} else {
			CurrentSessionData.getUpdateComptePage().getTauxInteretReturnMsg().setText("Champ incorrect !");
			CurrentSessionData.getUpdateComptePage().disablebtnUpdateCompteValidation();
		}
	}
}
