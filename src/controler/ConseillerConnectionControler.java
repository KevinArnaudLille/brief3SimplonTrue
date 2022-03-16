package controler;

import Interface.CreationBanqueForm;
import checking.CheckConseillerConnection;
import sessionData.CurrentSessionData;

public class ConseillerConnectionControler {
	
	private static String[][] errorMsgAndNewTextFieldEdit = new String[2][2];
	private static CreationBanqueForm frame;
	
	
	public static void logInBtnClicked(String identifiant, String mdp) {
		if(!CheckConseillerConnection.isConseillerConnectionValid(identifiant, mdp)) {
			
			errorMsgAndNewTextFieldEdit = CheckConseillerConnection.appriopriateMsgErrorWithTextFieldToEdit(identifiant, mdp);
			
			System.out.println(errorMsgAndNewTextFieldEdit[0][0]);
			
			frame.setIdentifiantTextField(errorMsgAndNewTextFieldEdit[1][0]);
			frame.setMdpTextField(errorMsgAndNewTextFieldEdit[1][1]);	
		} else {
			CurrentSessionData.setConnectedConseiller(identifiant);
			System.out.println("Well done " + CurrentSessionData.getConnectedConseiller().getPrenom() + " " + CurrentSessionData.getConnectedConseiller().getNom());
		}
		
		
		/* Check if identifiant and mdp are good \o/
		if not good \o/
			show error msg \o
			empty identifiant and mdp fields\o/
		
		if good \o/
			show success msg \o/
			Set current conseiller in SessionData \o/
			go to next page (clientList) */
	
	}


	public static void setFrame(CreationBanqueForm IncommingFrame) {
		frame = IncommingFrame;
	}
	
	
}
