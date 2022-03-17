package sessionData;

import Interface.CreationBanqueForm;
import Interface.ListeClientsForm;
import Interface.OuvrirCompteForm;
import checking.CheckConseillerConnection;
import model.Conseiller;

public class CurrentSessionData {
	private static Conseiller connectedConseiller;
	private static ListeClientsForm connectedConseillerClientsPage;
	private static CreationBanqueForm homePage;
	private static OuvrirCompteForm openAccountPage;
	
	// === GETTERS AND SETTERS ===
	public static CreationBanqueForm getHomePage() {
		return homePage;
	}

	public static void setHomePage(CreationBanqueForm homePage) {
		CurrentSessionData.homePage = homePage;
	}

	public static OuvrirCompteForm getOpenAccountPage() {
		return openAccountPage;
	}

	public static void setOpenAccountPage(OuvrirCompteForm openAccountPage) {
		CurrentSessionData.openAccountPage = openAccountPage;
	}

	
	// Set the logged conseiller
	public static void setConnectedConseiller(String identifiant) {
		connectedConseiller = CheckConseillerConnection.getConseillerList().stream()
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