package controler;

import javax.swing.SwingUtilities;

import Interface.ListeClientsForm;
import Interface.OuvrirClientForm;
import checking.CheckClientAdd;
import db.DbCreateQueries;
import db.DbReadQueries;
import model.Client;
import sessionData.CurrentSessionData;

public class NewClientControler {
	public static void onAddClientClick() {
		/*
		 * check client informations if info good add client to db else display error
		 * about what was wrong
		 */
		if (CheckClientAdd.AreAllFieldOk()) {
			Client clientToAdd = new Client(
					"client_0"+(DbReadQueries.dbReadAllClient().size()+1),
					CurrentSessionData.getOpenAccountPage().getNom(),
					CurrentSessionData.getOpenAccountPage().getPrenom(),
					CurrentSessionData.getOpenAccountPage().getCourriel(),
					CurrentSessionData.getOpenAccountPage().getAdresse(),
					CurrentSessionData.getOpenAccountPage().getTel(),
					CurrentSessionData.getConnectedConseiller().getId()
					);
			DbCreateQueries.addClientToDb(clientToAdd);
			CurrentSessionData.getOpenAccountPage().setVisible(false);
		
			CurrentSessionData.getConnectedConseillerClientsPage().dispose();;
			ListeClientsForm newFrame = new ListeClientsForm();
			CurrentSessionData.setConnectedConseillerClientsPage(newFrame);
			CurrentSessionData.getConnectedConseillerClientsPage().setVisible(true);
		}
	}

	public static void onCancelClick() {
		// Close the current page
		CurrentSessionData.getOpenAccountPage().setVisible(false);
	}

	public static void onLeavingNomTextField() {
		// check if field is correct
		if(CheckClientAdd.isNomFieldOk()) {
			CurrentSessionData.getOpenAccountPage().setNomErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountPage().setNomErrorMsg(CheckClientAdd.generateNomProperErrorMsg());
		}
	}

	public static void onLeavingPrenomTextField() {
		if(CheckClientAdd.isPrenomFieldOk()) {
			CurrentSessionData.getOpenAccountPage().setPrenomErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountPage().setPrenomErrorMsg(CheckClientAdd.generatePrenomProperErrorMsg());
		}
	}

	public static void onLeavingCourrielTextField() {
		if(CheckClientAdd.isCourrielFieldOk()) {
			CurrentSessionData.getOpenAccountPage().setCourrielErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountPage().setCourrielErrorMsg(CheckClientAdd.generateCourrielProperErrorMsg());
		}
	}

	public static void onLeavingAdresseTextField() {
		if(CheckClientAdd.isAdresseFieldOk()) {
			CurrentSessionData.getOpenAccountPage().setAdresseErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountPage().setAdresseErrorMsg(CheckClientAdd.generateAdresseProperErrorMsg());
		}
	}

	public static void onLeavingTelTextField() {
		if(CheckClientAdd.isTelFieldOk()) {
			CurrentSessionData.getOpenAccountPage().setTelErrorMsg(CheckClientAdd.getProperlyFilledFieldMsg());
		} else {
			CurrentSessionData.getOpenAccountPage().setTelErrorMsg(CheckClientAdd.generateTelProperErrorMsg());
		}
	}
	
	public static void onAddingTextAnywhere() {
		if (CheckClientAdd.AreAllFieldOk()) {
			CurrentSessionData.getOpenAccountPage().enableAddClientBtn();
		}
	}
}
