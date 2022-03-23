package controler;

import Interface.ListeClientsForm;
import checking.CheckConseillerConnection;
import sessionData.CurrentSessionData;

public class ConseillerConnectionControler {

	// ==== Error msgs ====
	private static String[][] errorMsgAndNewTextFieldEdit = new String[2][2];

	// *******************************************************
	// ==== Button action functions ====
	public static void onLogInBtnClicked(String identifiant, String mdp) {
		if (!CheckConseillerConnection.isConseillerConnectionValid(identifiant, mdp)) {
			// Set error msg value
			errorMsgAndNewTextFieldEdit = CheckConseillerConnection.appriopriateMsgErrorWithTextFieldToEdit(identifiant,
					mdp);

			// Display error msg
			CurrentSessionData.getHomePage().setErrorMsgTextField(errorMsgAndNewTextFieldEdit[0][0]);
			CurrentSessionData.getHomePage().setIdentifiantTextField(errorMsgAndNewTextFieldEdit[1][0]);
			CurrentSessionData.getHomePage().setMdpTextField(errorMsgAndNewTextFieldEdit[1][1]);
		} else {
			// Add Conseiller to session storage
			CurrentSessionData.setConnectedConseiller(identifiant);

			// Create client list frame object
			ListeClientsForm listClientPage = new ListeClientsForm();

			// Add client list frame object to session storage
			CurrentSessionData.setConnectedConseillerClientsPage(listClientPage);

			// Display client list frame
			CurrentSessionData.getConnectedConseillerClientsPage().setVisible(true);

			// Dispose of Conseiller connection frame
			CurrentSessionData.getHomePage().dispose();

			// Print validation msg in console
			System.out.println(CurrentSessionData.getConnectedConseiller().getPrenom() + " "
					+ CurrentSessionData.getConnectedConseiller().getNom() + " est connecté.e");
		}
	}
}
