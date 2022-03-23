package checking;

import java.util.ArrayList;

import db.DbReadQueries;
import model.Conseiller;
import sessionData.CurrentSessionData;

public class CheckConseillerConnection {

	// ==== Error Msgs ====
	private static String errorMsgsWrongIdentifiant = "L'identifiant de connexion n'est pas valide.";
	private static String errorMsgsWrongMdp = "Le mot de passe de connexion n'est pas valide.";
	private static String errorMsgsIdentifiantMdpNotMatching = "L'identifiant et le mot de passe ne correspondent pas.";

	//*******************************************************
	// ==== Getters and Setters ====
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

	//*******************************************************
	// ==== Checking functions ====
	// Return if a conseiller Identifiant is in the db
	public static boolean isConseillerIdentifiantInList(String identifiant) {
		return CurrentSessionData.getConseillerList().stream().anyMatch(conseiller -> conseiller.getIdentifiant().equals(identifiant));
	}

	// Return if a conseiller Mdp is in the db
	public static boolean isConseillerMdpInList(String mdp) {
		return CurrentSessionData.getConseillerList().stream().anyMatch(conseiller -> conseiller.getMdp().equals(mdp));
	}

	// Return if a conseiller Identifiant and Mdp are matching in the db
	public static boolean isConseillerMdpMatchingIdentifiant(String identifiant, String mdp) {
		Conseiller conseillerToCheck = (Conseiller) CurrentSessionData.getConseillerList().stream()
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
	
	//*******************************************************
	// ==== Error msg generation ====
	// Return the appropriate error msg (DEPRICATED)
	public static String appriopriateMsgError(String identifiant, String mdp) {
		if (!isConseillerIdentifiantInList(identifiant)) {
			return getErrorMsgsWrongIdentifiant();
		} else if (!isConseillerMdpMatchingIdentifiant(identifiant, mdp)) {
			return getErrorMsgsIdentifiantMdpNotMatching();
		}
		return getErrorMsgsWrongMdp();
	}

	// Return the appropriate error msg
	public static String[][] appriopriateMsgErrorWithTextFieldToEdit(String identifiant, String mdp) {
		String[][] toSend = new String[2][2];
		if (!isConseillerIdentifiantInList(identifiant)) {
			toSend[0][0] = getErrorMsgsWrongIdentifiant();
			toSend[1][0] = "";
			toSend[1][1] = "";
			return toSend;
		} else if (!isConseillerMdpMatchingIdentifiant(identifiant, mdp)) {
			toSend[0][0] = getErrorMsgsIdentifiantMdpNotMatching();
			toSend[1][0] = identifiant;
			toSend[1][1] = "";
			return toSend;
		}
		toSend[0][0] = getErrorMsgsWrongMdp();
		toSend[1][0] = "";
		toSend[1][1] = "";
		return toSend;
	}
}