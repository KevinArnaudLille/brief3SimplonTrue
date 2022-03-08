package app;

import Interface.ListeClientsForm;
import checking.CheckConseillerConnection;
import sessionData.CurrentSessionData;

public class Main {

	public static void main(String[] args) {

//		TemporaryDBCreation.createDB(3306, "root", "");
//		TemporaryDBCreation.addDataToDB(3306, "root", "");

		System.out.println(CheckConseillerConnection.isConseillerIdentifiantInList("MPTremblay"));

//		System.out.println(CheckConseillerConnection.isConseillerMdpInList("vachi"));

//		System.out.println(CheckConseillerConnection.isConseillerMdpMatchingIdentifiant("Rdupont", "vachier"));

		CurrentSessionData.setConnectedConseiller("MPTremblay");
		System.out.println(CurrentSessionData.getConnectedConseiller().getPrenom());

		new ListeClientsForm();
	}
}