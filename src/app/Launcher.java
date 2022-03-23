package app;

import Interface.CreationBanqueForm;
import db.DbReadQueries;
import sessionData.CurrentSessionData;

public class Launcher {
	public static void main(String[] args) {

		// ==== Generate (or event replace) starting data set in db ====
		// winOS ids
		try {
			TemporaryDBCreation.createDB(3306, "root", "");
			TemporaryDBCreation.addDataToDB(3306, "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		// macOS ids
		try {
			TemporaryDBCreation.createDB(8889, "root", "root");
			TemporaryDBCreation.addDataToDB(8889, "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}

		// ==== Set Conseillers List with db data ====
		CurrentSessionData.setConseillerList(DbReadQueries.dbReadConseillers());
		
		// ==== Launch the first Conseiller login frame ====
		CreationBanqueForm firstFrame = new CreationBanqueForm();
		CurrentSessionData.setHomePage(firstFrame);
		CurrentSessionData.getHomePage().setVisible(true);
	}
}