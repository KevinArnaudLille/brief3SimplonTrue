package app;

import Interface.ListeClientsForm;
import checking.CheckConseillerConnection;
import db.DbCreateQueries;
import model.Client;
import sessionData.CurrentSessionData;

public class Main {

	public static void main(String[] args) {

//		TemporaryDBCreation.createDB(3306, "root", "");
//		TemporaryDBCreation.addDataToDB(3306, "root", "");


//		System.out.println(CheckConseillerConnection.isConseillerMdpInList("vachi"));

//		System.out.println(CheckConseillerConnection.isConseillerMdpMatchingIdentifiant("Rdupont", "vachier"));

		CurrentSessionData.setConnectedConseiller("MPTremblay");

		Client clientTest = new Client("bob","bob","bob","bob","bob","bob","bob");
		DbCreateQueries.addClientToDb(clientTest);
	}
}