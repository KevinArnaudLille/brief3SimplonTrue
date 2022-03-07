package checking;

import java.util.ArrayList;

import db.DbReadQueries;
import model.Conseiller;

public class CheckConseillerConnection {
	private static ArrayList<Conseiller> conseillerList = new ArrayList<Conseiller>();

	private static String errorMsgsWrongIdentifiant = "L'identifiant de connexion n'est pas valide.";
	private static String errorMsgsWrongMdp = "Le mot de passe de connexion n'est pas valide.";
	private static String errorMsgsIdentifiantMdpNotMatching = "L'identifiant et le mot de passe ne correspondent pas.";



	public static ArrayList<Conseiller> getConseillerList() {
		return conseillerList;
	}

	// Get error msg if conseiller identifiant not in db
	public static String getErrorMsgsWrongIdentifiant() {
		return errorMsgsWrongIdentifiant;
	}

	// Get error msg if conseiller mdp not in db
	public static String getErrorMsgsWrongMdp() {
		return errorMsgsWrongMdp;
	}

	// Get error msg if conseiller identifiant and mdp not matching in db
	public static String getErrorMsgsIdentifiantMdpNotMatching() {
		return errorMsgsIdentifiantMdpNotMatching;
	}

	// Return if a conseiller Identifiant is in the db
	public static boolean isConseillerIdentifiantInList(String identifiant) {
		conseillerList = DbReadQueries.dbReadConseillers();
		return conseillerList.stream().anyMatch(conseiller -> conseiller.getIdentifiant().equals(identifiant));
	}

	// Return if a conseiller Mdp is in the db
	public static boolean isConseillerMdpInList(String mdp) {
		conseillerList = DbReadQueries.dbReadConseillers();
		return conseillerList.stream().anyMatch(conseiller -> conseiller.getMdp().equals(mdp));
	}

	// Return if a conseiller Identifiant and Mdp are matching in the db
	public static boolean isConseillerMdpMatchingIdentifiant(String identifiant, String mdp) {
		conseillerList = DbReadQueries.dbReadConseillers();
		Conseiller conseillerToCheck = (Conseiller) conseillerList.stream()
				.filter(conseiller -> conseiller.getIdentifiant().equals(identifiant)).findAny().orElse(null);
		if (conseillerToCheck != null) {
			return conseillerToCheck.getMdp().equals(mdp);
		}
		return false;
	}

	// Check all verifications at once
	public static boolean isConseillerConnectionValid(String identifiant, String mdp) {
		return isConseillerIdentifiantInList(identifiant) && isConseillerMdpInList(mdp) && isConseillerMdpMatchingIdentifiant(identifiant, mdp); 
	}
	
	// Return the appropriate error msg
	public static String appriopriateMsgError(String identifiant, String mdp) {
		if (!isConseillerIdentifiantInList(identifiant)) {
			return getErrorMsgsWrongIdentifiant();
		} else if (!isConseillerMdpMatchingIdentifiant(identifiant, mdp)) {
			return getErrorMsgsIdentifiantMdpNotMatching();
		}
		return getErrorMsgsWrongMdp();
	}
}
