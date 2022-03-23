package controler;

import java.util.Date;
import Interface.ListeComptesForm;
import checking.CheckCompteAdd;
import db.DbCreateQueries;
import db.DbReadQueries;
import model.CompteCourant;
import model.CompteEpargne;
import sessionData.CurrentSessionData;

public class NewCompteControler {

	// ==== Button action functions ====
	public static void onAddCompteClicked() {
		// Check type of compte to add via which field are completed
		if (CheckCompteAdd.isFrais_transfertFieldOk() && CheckCompteAdd.isSolde_minimum_autoriseFieldOk()) {
			// Create a new compte courant object with users data
			CompteCourant compteToAdd = new CompteCourant(
					"compte_courant_0" + (DbReadQueries.dbReadAllCompteInBdd().size() + 1),
					Integer.parseInt(CurrentSessionData.getOpenComptePage().getNumero()),
					Double.parseDouble(CurrentSessionData.getOpenComptePage().getSolde()), true,
					CurrentSessionData.getOpenComptePage().getProprietaire_tutelle(), new Date(),
					CurrentSessionData.getSelectClientByClick().getId(),
					Double.parseDouble(CurrentSessionData.getOpenComptePage().getFrais_transfert()),
					Double.parseDouble(CurrentSessionData.getOpenComptePage().getSolde_minimum_autorise()));

			// Add the new compte courant to db
			DbCreateQueries.addCompteCourantToDb(compteToAdd);

		} else {
			// Create a new compte epargne object with users data
			CompteEpargne compteToAdd = new CompteEpargne(
					"compte_epargne_0" + (DbReadQueries.dbReadAllCompteInBdd().size() + 1),
					Integer.parseInt(CurrentSessionData.getOpenComptePage().getNumero()),
					Double.parseDouble(CurrentSessionData.getOpenComptePage().getSolde()), true,
					CurrentSessionData.getOpenComptePage().getProprietaire_tutelle(), new Date(),
					CurrentSessionData.getSelectClientByClick().getId(),
					Double.parseDouble(CurrentSessionData.getOpenComptePage().getTaux_interet()),
					Double.parseDouble(CurrentSessionData.getOpenComptePage().getPlafond()));

			// Add the new compte epargne to db
			DbCreateQueries.addCompteEpargneToDb(compteToAdd);
		}

		// Dispose of open account frame
		CurrentSessionData.getOpenComptePage().dispose();

		// Dispose and recreate compte list frame (to refresh it)
		CurrentSessionData.getSelectClientComptesListPage().dispose();
		ListeComptesForm listCompteFrame = new ListeComptesForm();
		CurrentSessionData.setSelectClientComptesListPage(listCompteFrame);
		CurrentSessionData.getSelectClientComptesListPage().setVisible(true);
	}

	public static void onCancelClicked() {
		// Close the current page
		CurrentSessionData.getOpenComptePage().dispose();
	}

	// *******************************************************
	// ==== New random compte number generation ====
	public static int generateNewRandomCompteNumber() {
		int numberToCheck;
		do {
			numberToCheck = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
		} while (CheckCompteAdd.isNumCompteAlreadyInDb(numberToCheck));
		return numberToCheck;
	}

	// *******************************************************
	// ==== Text fields functions triggered by adding text ====
	// == SOLDE ==
	public static void onTypingSoldeTextField() {
		if (CheckCompteAdd.isSoldeFieldOk()) {
			CurrentSessionData.getOpenComptePage().setSoldeErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenComptePage().setSoldeErrorMsg(CheckCompteAdd.generateSoldeProperErrorMsg());
		}
	}

	// == PROPRIETAIRE TUTELLE ==
	public static void onTypingProprietaire_tutelleTextField() {
		if (CheckCompteAdd.isProprietaire_tutelleFieldOk()) {
			CurrentSessionData.getOpenComptePage()
					.setProprietaire_tutelleErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenComptePage()
					.setProprietaire_tutelleErrorMsg(CheckCompteAdd.generateProprietaire_tutelleProperErrorMsg());
		}
	}

	// == FRAIS DE TRANSFERT ==
	public static void onTypingFrais_transfertTextField() {
		if (CheckCompteAdd.isFrais_transfertFieldOk()) {
			CurrentSessionData.getOpenComptePage()
					.setFrais_transfertErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenComptePage()
					.setFrais_transfertErrorMsg(CheckCompteAdd.generateFrais_transfertProperErrorMsg());
		}
	}

	// == SOLDE MINIMUM AUTORISE ==
	public static void onTypingSolde_minimum_autoriseTextField() {
		if (CheckCompteAdd.isSolde_minimum_autoriseFieldOk()) {
			CurrentSessionData.getOpenComptePage()
					.setSolde_minimum_autoriseErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenComptePage()
					.setSolde_minimum_autoriseErrorMsg(CheckCompteAdd.generateSolde_minimum_autoriseProperErrorMsg());
		}
	}

	// == TAUX D'INTERET ==
	public static void onTypingTaux_interetTextField() {
		if (CheckCompteAdd.isTaux_interetFieldOk()) {
			CurrentSessionData.getOpenComptePage().setTaux_interetErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenComptePage()
					.setTaux_interetErrorMsg(CheckCompteAdd.generateTauxInteretProperErrorMsg());

		}
	}

	// == PLAFOND ==
	public static void onTypingPlafondTextField() {
		if (CheckCompteAdd.isPlafondFieldOk()) {
			CurrentSessionData.getOpenComptePage().setPlafondErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenComptePage().setPlafondErrorMsg(CheckCompteAdd.generatePlafondProperErrorMsg());
		}
	}

	// ==! COMBINAISON OF ALL PREVIOUS !==
	// To enable/disable validation btn
	public static void onAddingTextAnywhere() {
		if (CheckCompteAdd.AreAllFieldOk()) {
			CurrentSessionData.getOpenComptePage().enableAddClientBtn();
		} else {
			CurrentSessionData.getOpenComptePage().disableAddClientBtn();
		}
	}
}