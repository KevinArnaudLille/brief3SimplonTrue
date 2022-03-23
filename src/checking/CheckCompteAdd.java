package checking;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Interface.ListeComptesForm;
import Interface.OuvrirCompteForm;
import db.DbReadQueries;
import model.Compte;
import sessionData.CurrentSessionData;

public class CheckCompteAdd {

	// Correct Msg and Error Msg
	private static String properlyFilledFieldMsg = "OK";
	private static String fieldIsEmptyErrorMsg = "Champ nécessaire !";
	private static String fieldIsWrongErrorMsg = "Champ incorrect !";

	// GLOBAL FUNCTIONS
	private static boolean isStringContainSpecialCharacter(String stringToCheck) {
		Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(stringToCheck);
		return m.find();
	}

	// ALL FIELD
	public static boolean AreAllFieldOk() {
		return isSoldeFieldOk() && isProprietaire_tutelleFieldOk() && ((isFrais_transfertFieldOk() && isSolde_minimum_autoriseFieldOk()) || ( isPlafondFieldOk()
				 && isTaux_interetFieldOk()));
	}

	// NUMERO COMPTE FIELD
	public static boolean isNumCompteAlreadyInDb(int numToCheck) {
		ArrayList<Compte> comptes = DbReadQueries.dbReadAllCompteInBdd();
		boolean numberExists = comptes.stream().anyMatch(compte -> numToCheck == compte.getNumero());
		System.out.println("The account number already exists " + numberExists);
		return numberExists;
	}

	// SOLDE INITIAL FIELD
	public static boolean isSoldeFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getSolde();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+")
				&& (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generateSoldeProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getSolde();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// PROPRIETAIRE TUTELLE
	public static boolean isProprietaire_tutelleFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getProprietaire_tutelle();
		return !stringToCheck.contains(" ") && !isStringContainSpecialCharacter(stringToCheck);

	}

	public static String generateProprietaire_tutelleProperErrorMsg() {
		return fieldIsWrongErrorMsg;
	}

	
	
	// FRAIS TRANSFERT FIELD
	public static boolean isFrais_transfertFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getFrais_transfert();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+") && (Double.parseDouble(stringToCheck) <= 100000);
	}

	public static String generateFrais_transfertProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getFrais_transfert();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// SOLDE MINIMUM AUTORISE FIELD
	public static boolean isSolde_minimum_autoriseFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getSolde_minimum_autorise();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+") && (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generateSolde_minimum_autoriseProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getSolde_minimum_autorise();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	
	// FRAIS TAUX INTERET FIELD
	public static boolean isTaux_interetFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getTaux_interet();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+") && (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generateTauxInteretProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getTaux_interet();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// FRAIS PLAFOND FIELD
	public static boolean isPlafondFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getPlafond();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+") && (Double.parseDouble(stringToCheck) <= 100000);

	}

	public static String generatePlafondProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountForm().getPlafond();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// Getters
	public static String getProperlyFilledFieldMsg() {
		return properlyFilledFieldMsg;
	}

}
