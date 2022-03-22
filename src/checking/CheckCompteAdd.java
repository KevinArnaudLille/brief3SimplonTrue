package checking;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Interface.ListeComptesForm;
import Interface.OuvrirCompteForm;
import db.DbReadQueries;
import model.Compte;

public class CheckCompteAdd {
	
	private static OuvrirCompteForm frame;


	// Correct Msg and Error Msg
		private static String properlyFilledFieldMsg = "OK";
		private static String fieldIsEmptyErrorMsg = "Champ nécessaire !";
		private static String fieldIsWrongErrorMsg = "Champ incorrect !";
		
		// GLOBAL FUNCTIONS 
		private static boolean isStringContainSpecialCharacter(String stringToCheck) {
			Pattern p = Pattern.compile("[^a-z0-9]",Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(stringToCheck);
			return m.find();
		}
		
		public static void setFrame(OuvrirCompteForm IncommingFrame) {
			frame = IncommingFrame;
		}
		
		// ALL FIELD
		public static boolean AreAllFieldOk() {
			return isClient_idFieldOk() && isSoldeFieldOk() && isFrais_transfertFieldOk() && isSolde_minimum_autoriseFieldOk() 
					&& isPlafondFieldOk() && isProprietaire_tutelleFieldOk() && isTaux_interetFieldOk();
		}
		
		// NUMERO COMPTE FIELD
		public static boolean isNumCompteAlreadyInDb(int numToCheck) {
			ArrayList<Compte> comptes = DbReadQueries.dbReadAllCompteInBdd();
			boolean numberExists = comptes.stream().anyMatch(compte -> numToCheck == compte.getNumero());
			System.out.println("The account number already exists " + numberExists);
			return numberExists;
		}
		
		
		// NOM CLIENT FIELD
		public static boolean isClient_idFieldOk() {
			String stringToCheck = frame.getClient();
			return !stringToCheck.isEmpty() && !stringToCheck.contains(" ") && !isStringContainSpecialCharacter(stringToCheck);
		}
		public static String generateNomProperErrorMsg() {
			String stringToCheck = frame.getClient();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// SOLDE INITIAL FIELD
		public static boolean isSoldeFieldOk() {
			String stringToCheck = frame.getSolde();
			return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]");

		}
		public static String generateSoldeProperErrorMsg() {
			String stringToCheck = frame.getSolde();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		
		// FRAIS TRANSFERT FIELD
		public static boolean isFrais_transfertFieldOk() {
			String stringToCheck = frame.getFrais_transfert();
			return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]");

		}
		public static String generateFrais_transfertProperErrorMsg() {
			String stringToCheck = frame.getFrais_transfert();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// SOLDE MINIMUM AUTORISE FIELD
		public static boolean isSolde_minimum_autoriseFieldOk() {
			String stringToCheck = frame.getSolde_minimum_autorise();
			return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]");

		}
		public static String generateSolde_minimum_autoriseProperErrorMsg() {
			String stringToCheck = frame.getSolde_minimum_autorise();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// FRAIS TAUX INTERET FIELD
		public static boolean isTaux_interetFieldOk() {
			String stringToCheck = frame.getTaux_interet();
			return !stringToCheck.isEmpty()  && stringToCheck.matches("[0-9]");

		}
		public static String generateTauxInteretProperErrorMsg() {
			String stringToCheck = frame.getTaux_interet();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// FRAIS PLAFOND FIELD
		public static boolean isPlafondFieldOk() {
			String stringToCheck = frame.getPlafond();
			return !stringToCheck.isEmpty()  && stringToCheck.matches("[0-9]");

		}
		public static String generatePlafondProperErrorMsg() {
			String stringToCheck = frame.getPlafond();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// PROPRIETAIRE TUTELLE
		public static boolean isProprietaire_tutelleFieldOk() {
			String stringToCheck = frame.getProprietaire_tutelle();
			return !stringToCheck.contains(" ");

		}
		public static String generateProprietaire_tutelleProperErrorMsg() {
			return fieldIsWrongErrorMsg;
		}
		
		// Getters
		public static String getProperlyFilledFieldMsg() {
			return properlyFilledFieldMsg;
		}
		
		public static void setFrame(ListeComptesForm openAccountFrame) {
			// TODO Auto-generated method stub
			
		}
	
		
	}


