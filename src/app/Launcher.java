package app;

import Interface.CreationBanqueForm;
import controler.ConseillerConnectionControler;
import sessionData.CurrentSessionData;

public class Launcher {
	public static void main(String[] args) {
		CreationBanqueForm firstFrame = new CreationBanqueForm();
		CurrentSessionData.setHomePage(firstFrame);
		ConseillerConnectionControler.setFrame(firstFrame);
		firstFrame.setVisible(true);
	}
}