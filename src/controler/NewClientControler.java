package controler;

import Interface.ListeClientsForm;
import checking.CheckClientAdd;
import db.DbCreateQueries;
import db.DbReadQueries;
import model.Client;
import sessionData.CurrentSessionData;

public class NewClientControler {

	// ==== Button action functions ====
	public static void onAddClientClicked() {
		if (CheckClientAdd.AreAllFieldOk()) {
			// Create a new client object with users data
			Client clientToAdd = new Client("client_0" + (DbReadQueries.dbReadAllClient().size() + 1),
					CurrentSessionData.getOpenClientPage().getNom(), CurrentSessionData.getOpenClientPage().getPrenom(),
					CurrentSessionData.getOpenClientPage().getCourriel(),
					CurrentSessionData.getOpenClientPage().getAdresse(),
					CurrentSessionData.getOpenClientPage().getTel(),
					CurrentSessionData.getConnectedConseiller().getId());

			// Add the new client to db
			DbCreateQueries.addClientToDb(clientToAdd);

			// Dispose of open client frame
			CurrentSessionData.getOpenClientPage().dispose();

			// Dispose and recreate client list frame (to refresh it)
			CurrentSessionData.getConnectedConseillerClientsPage().dispose();
			ListeClientsForm newFrame = new ListeClientsForm();
			CurrentSessionData.setConnectedConseillerClientsPage(newFrame);
			CurrentSessionData.getConnectedConseillerClientsPage().setVisible(true);
		}
	}

	public static void onCancelClicked() {
		// Dispose of open account frame
		CurrentSessionData.getOpenClientPage().dispose();
	}

	// *******************************************************
	// ==== Text fields functions triggered by adding text ====
	// == NOM ==
	public static void onTypingNomTextField() {
		// check if field is correct
		if (CheckClientAdd.isNomFieldOk()) {
			CurrentSessionData.getOpenClientPage().setNomErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenClientPage().setNomErrorMsg(CheckClientAdd.generateNomProperErrorMsg());
		}
	}

	// == PRENOM ==
	public static void onTypingPrenomTextField() {
		if (CheckClientAdd.isPrenomFieldOk()) {
			CurrentSessionData.getOpenClientPage().setPrenomErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenClientPage().setPrenomErrorMsg(CheckClientAdd.generatePrenomProperErrorMsg());
		}
	}

	// == COURRIEL ==
	public static void onTypingCourrielTextField() {
		if (CheckClientAdd.isCourrielFieldOk()) {
			CurrentSessionData.getOpenClientPage().setCourrielErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenClientPage().setCourrielErrorMsg(CheckClientAdd.generateCourrielProperErrorMsg());
		}
	}

	// == ADRESSE ==
	public static void onTypingAdresseTextField() {
		if (CheckClientAdd.isAdresseFieldOk()) {
			CurrentSessionData.getOpenClientPage().setAdresseErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenClientPage().setAdresseErrorMsg(CheckClientAdd.generateAdresseProperErrorMsg());
		}
	}

	// == TEL ==
	public static void onTypingTelTextField() {
		if (CheckClientAdd.isTelFieldOk()) {
			CurrentSessionData.getOpenClientPage().setTelErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenClientPage().setTelErrorMsg(CheckClientAdd.generateTelProperErrorMsg());
		}
	}

	// ==! COMBINAISON OF ALL PREVIOUS !==
	// To enable/disable validation btn
	public static void onAddingTextAnywhere() {
		if (CheckClientAdd.AreAllFieldOk()) {
			CurrentSessionData.getOpenClientPage().enableAddClientBtn();
		} else {
			CurrentSessionData.getOpenClientPage().disableAddClientBtn();
		}
	}
}
