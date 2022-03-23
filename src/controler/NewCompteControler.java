package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Interface.ListeClientsForm;
import Interface.ListeComptesForm;
import Interface.OuvrirClientForm;
import Interface.OuvrirCompteForm;
import checking.CheckClientAdd;
import checking.CheckCompteAdd;
import db.DbCreateQueries;
import db.DbReadQueries;
import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import sessionData.CurrentSessionData;

public class NewCompteControler {
	public static void onAddCompteClick() {

		if (CheckCompteAdd.isFrais_transfertFieldOk() && CheckCompteAdd.isSolde_minimum_autoriseFieldOk()) {

			CompteCourant compteToAdd = new CompteCourant(
					"compte_courant_0" + (DbReadQueries.dbReadAllCompteInBdd().size() + 1),
					Integer.parseInt(CurrentSessionData.getOpenAccountForm().getNumero()),
					Double.parseDouble(CurrentSessionData.getOpenAccountForm().getSolde()), true,
					CurrentSessionData.getOpenAccountForm().getProprietaire_tutelle(), new Date(),
					CurrentSessionData.getSelectClientByClick().getId(),
					Double.parseDouble(CurrentSessionData.getOpenAccountForm().getFrais_transfert()),
					Double.parseDouble(CurrentSessionData.getOpenAccountForm().getSolde_minimum_autorise()));
			DbCreateQueries.addCompteCourantToDb(compteToAdd);
		} else {
			CompteEpargne compteToAdd = new CompteEpargne(
					"compte_epargne_0" + (DbReadQueries.dbReadAllCompteInBdd().size() + 1),
					Integer.parseInt(CurrentSessionData.getOpenAccountForm().getNumero()),
					Double.parseDouble(CurrentSessionData.getOpenAccountForm().getSolde()), true,
					CurrentSessionData.getOpenAccountForm().getProprietaire_tutelle(), new Date(),
					CurrentSessionData.getSelectClientByClick().getId(),
					Double.parseDouble(CurrentSessionData.getOpenAccountForm().getTaux_interet()),
					Double.parseDouble(CurrentSessionData.getOpenAccountForm().getPlafond()));
			DbCreateQueries.addCompteEpargneToDb(compteToAdd);
		}

		CurrentSessionData.getOpenAccountForm().dispose();
		
		CurrentSessionData.getGestionCompteClient().dispose();
		ListeComptesForm openAccountFrame = new ListeComptesForm();
		CurrentSessionData.setGestionCompteClient(openAccountFrame);
		CurrentSessionData.getGestionCompteClient().setVisible(true);
	}

	public static void onCancelClick() {
		// Close the current page
		CurrentSessionData.getOpenAccountForm().dispose();
	}

	public static int generateNewRandomCompteNumber() {
		// à l'aide d'une boucle do while, s'assurer que le num de compte retourné par
		// la fonction n'est pas déjà dans la bdd
		int numberToCheck;
		do {
			numberToCheck = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
		} while (CheckCompteAdd.isNumCompteAlreadyInDb(numberToCheck));
		return numberToCheck;
	}

	public static void onTypingSoldeTextField() {
		if (CheckCompteAdd.isSoldeFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setSoldeErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setSoldeErrorMsg(CheckCompteAdd.generateSoldeProperErrorMsg());
		}
	}

	public static void onTypingProprietaire_tutelleTextField() {
		if (CheckCompteAdd.isProprietaire_tutelleFieldOk()) {
			CurrentSessionData.getOpenAccountForm()
					.setProprietaire_tutelleErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm()
					.setProprietaire_tutelleErrorMsg(CheckCompteAdd.generateProprietaire_tutelleProperErrorMsg());
		}
	}

	public static void onTypingFrais_transfertTextField() {
		if (CheckCompteAdd.isFrais_transfertFieldOk()) {
			CurrentSessionData.getOpenAccountForm()
					.setFrais_transfertErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm()
					.setFrais_transfertErrorMsg(CheckCompteAdd.generateFrais_transfertProperErrorMsg());
		}
	}

	public static void onTypingSolde_minimum_autoriseTextField() {
		if (CheckCompteAdd.isSolde_minimum_autoriseFieldOk()) {
			CurrentSessionData.getOpenAccountForm()
					.setSolde_minimum_autoriseErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm()
					.setSolde_minimum_autoriseErrorMsg(CheckCompteAdd.generateSolde_minimum_autoriseProperErrorMsg());
		}
	}

	public static void onTypingTaux_interetTextField() {
		if (CheckCompteAdd.isTaux_interetFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setTaux_interetErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm()
					.setTaux_interetErrorMsg(CheckCompteAdd.generateTauxInteretProperErrorMsg());

		}
	}

	public static void onTypingPlafondTextField() {
		if (CheckCompteAdd.isPlafondFieldOk()) {
			CurrentSessionData.getOpenAccountForm().setPlafondErrorMsg(CheckCompteAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountForm().setPlafondErrorMsg(CheckCompteAdd.generatePlafondProperErrorMsg());
		}
	}

	public static void onAddingTextAnywhere() {
		if (CheckCompteAdd.AreAllFieldOk()) {
			CurrentSessionData.getOpenAccountForm().enableAddClientBtn();
		} else {
			CurrentSessionData.getOpenAccountForm().disableAddClientBtn();
		}
	}
}