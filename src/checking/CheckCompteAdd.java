package checking;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import db.DbReadQueries;
import model.Compte;
import sessionData.CurrentSessionData;

public class CheckCompteAdd {

	// ==== Correct Msg and Error Msgs ====
	private static String properlyFilledFieldMsg = "OK";
	private static String fieldIsEmptyErrorMsg = "Champ nécessaire !";
	private static String fieldIsWrongErrorMsg = "Champ incorrect !";

	// *******************************************************
	// ==== Getter ====
	public static String getProperlyFilledFieldMsg() {
		return properlyFilledFieldMsg;
	}

	// *******************************************************
	// ==== Global unitary checking function ====
	private static boolean isStringContainSpecialCharacter(String stringToCheck) {
		Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(stringToCheck);
		return m.find();
	}

	// ==== Checking all field at once ====
	public static boolean AreAllFieldOk() {
		return isSoldeFieldOk() && isProprietaire_tutelleFieldOk()
				&& ((isFrais_transfertFieldOk() && isSolde_minimum_autoriseFieldOk())
						|| (isPlafondFieldOk() && isTaux_interetFieldOk()));
	}

	// *******************************************************
	// ==== Checking specific field ====
	// == NUMERO ==
	public static boolean isNumCompteAlreadyInDb(int numToCheck) {
		ArrayList<Compte> comptes = DbReadQueries.dbReadAllCompteInBdd();
		boolean numberExists = comptes.stream().anyMatch(compte -> numToCheck == compte.getNumero());
		System.out.println("The account number already exists " + numberExists);
		return numberExists;
	}

	// == SOLDE INITIAL ==
	public static boolean isSoldeFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getSolde();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+")
				&& (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generateSoldeProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getSolde();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == PROPRIETAIRE TUTELLE ==
	public static boolean isProprietaire_tutelleFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getProprietaire_tutelle();
		return !stringToCheck.contains(" ") && !isStringContainSpecialCharacter(stringToCheck);
	}

	public static String generateProprietaire_tutelleProperErrorMsg() {
		return fieldIsWrongErrorMsg;
	}

	// == FRAIS TRANSFERT ==
	public static boolean isFrais_transfertFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getFrais_transfert();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+")
				&& (Double.parseDouble(stringToCheck) <= 100000);
	}

	public static String generateFrais_transfertProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getFrais_transfert();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == SOLDE MINIMUM AUTORISE ==
	public static boolean isSolde_minimum_autoriseFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getSolde_minimum_autorise();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+")
				&& (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generateSolde_minimum_autoriseProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getSolde_minimum_autorise();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == TAUX INTERET ==
	public static boolean isTaux_interetFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getTaux_interet();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+")
				&& (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generateTauxInteretProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getTaux_interet();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == PLAFOND ==
	public static boolean isPlafondFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getPlafond();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+")
				&& (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generatePlafondProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenComptePage().getPlafond();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}
}
