package sessionData;

import checking.CheckConseillerConnection;
import model.Conseiller;

public class CurrentSessionData {
	private static Conseiller connectedConseiller;
	
	// Set the logged conseiller
	public static void setConnectedConseiller(String identifiant) {
		connectedConseiller = CheckConseillerConnection.getConseillerList().stream()
				.filter(conseiller -> conseiller.getIdentifiant().equals(identifiant)).findAny().orElse(null);
	}

	// Get the logged conseiller
	public static Conseiller getConnectedConseiller() {
		return connectedConseiller;
	}
}