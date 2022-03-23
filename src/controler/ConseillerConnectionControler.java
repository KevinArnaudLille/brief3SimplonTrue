package controler;

import Interface.CreationBanqueForm;
import Interface.ListeClientsForm;
import checking.CheckConseillerConnection;
import db.DbReadQueries;
import sessionData.CurrentSessionData;

public class ConseillerConnectionControler {

	private static String[][] errorMsgAndNewTextFieldEdit = new String[2][2];

	public static void logInBtnClicked(String identifiant, String mdp) {
		if (!CheckConseillerConnection.isConseillerConnectionValid(identifiant, mdp)) {
			errorMsgAndNewTextFieldEdit = CheckConseillerConnection.appriopriateMsgErrorWithTextFieldToEdit(identifiant,
					mdp);
			System.out.println(errorMsgAndNewTextFieldEdit[0][0]);
			CurrentSessionData.getHomePage().setErrorMsgTextField(errorMsgAndNewTextFieldEdit[0][0]);
			CurrentSessionData.getHomePage().setIdentifiantTextField(errorMsgAndNewTextFieldEdit[1][0]);
			CurrentSessionData.getHomePage().setMdpTextField(errorMsgAndNewTextFieldEdit[1][1]);
		} else {
			CurrentSessionData.setConnectedConseiller(identifiant);
			ListeClientsForm listClientPage = new ListeClientsForm();
			CurrentSessionData.setConnectedConseillerClientsPage(listClientPage);
			CurrentSessionData.getConnectedConseillerClientsPage().setVisible(true);
			CurrentSessionData.getHomePage().dispose();
			System.out.println("Well done " + CurrentSessionData.getConnectedConseiller().getPrenom() + " "
				+ CurrentSessionData.getConnectedConseiller().getNom());
		}
	}
}
