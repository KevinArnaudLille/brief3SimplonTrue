package app;

import Interface.CreationBanqueForm;
import controler.ConseillerConnectionControler;
import sessionData.CurrentSessionData;

public class Launcher {
	public static void main(String[] args) {
		try {
			TemporaryDBCreation.createDB(3306, "root", "");	
			TemporaryDBCreation.addDataToDB(3306, "root", "");	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			TemporaryDBCreation.createDB(8889, "root", "root");			
			TemporaryDBCreation.addDataToDB(8889, "root", "root");			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		CreationBanqueForm firstFrame = new CreationBanqueForm();
		CurrentSessionData.setHomePage(firstFrame);
		ConseillerConnectionControler.setFrame(firstFrame);
		firstFrame.setVisible(true);
	}
}