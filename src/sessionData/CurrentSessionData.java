package sessionData;

import Interface.CreationBanqueForm;
import Interface.ListeClientsForm;
import Interface.OuvrirClientForm;
import checking.CheckConseillerConnection;
import db.DbReadQueries;
import model.Conseiller;

public class CurrentSessionData {
	private static Conseiller connectedConseiller;
	private static ListeClientsForm connectedConseillerClientsPage;
	private static CreationBanqueForm homePage;
	private static OuvrirClientForm openAccountPage;
	
	// === GETTERS AND SETTERS ===
	public static CreationBanqueForm getHomePage() {
		return homePage;
	}

	public static void setHomePage(CreationBanqueForm homePage) {
		CurrentSessionData.homePage = homePage;
	}

	public static OuvrirClientForm getOpenAccountPage() {
		return openAccountPage;
	}

	public static void setOpenAccountPage(OuvrirClientForm openAccountPage) {
		CurrentSessionData.openAccountPage = openAccountPage;
	}

	
	// Set the logged conseiller
	public static void setConnectedConseiller(String identifiant) {
		connectedConseiller = DbReadQueries.dbReadConseillers().stream()
				.filter(conseiller -> conseiller.getIdentifiant().equals(identifiant)).findAny().orElse(null);
	}

	// Get the logged conseiller
	public static Conseiller getConnectedConseiller() {
		return connectedConseiller;
	}

	public static ListeClientsForm getConnectedConseillerClientsPage() {
		return connectedConseillerClientsPage;
	}

	public static void setConnectedConseillerClientsPage(ListeClientsForm connectedConseillerClientsPage) {
		CurrentSessionData.connectedConseillerClientsPage = connectedConseillerClientsPage;
	}
}