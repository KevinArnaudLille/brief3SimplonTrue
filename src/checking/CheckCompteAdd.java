package checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Interface.OuvrirCompteCourant;
import Interface.OuvrirCompteForm;
import model.Client;
import Interface.OuvrirClientForm;

public class CheckCompteAdd {
	
	private static OuvrirCompteForm frame;
	private ButtonGroup group;


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
		
		private static boolean isStringContainSpecialCharacter(String stringToCheck) {
			Pattern p = Pattern.compile("[0-9]");
	        Matcher m = p.matcher(stringToCheck);
			return m.matches();
		}
		
		private static boolean isStringContainSpecialCharacter(String stringToCheck) {
			Pattern p = Pattern.compile("");
	        Matcher m = p.matcher(stringToCheck);
			return m.matches();
		}
		
		public static void setFrame(OuvrirCompteForm IncommingFrame) {
			frame = IncommingFrame;
		}
		
		// ALL FIELD
		public static boolean AreAllFieldOk() {
			return isNumeroFieldOk() && isNomFieldOk() && isSoldeFieldOk() && isFrais_transfertFieldOk() && isSolde_minimum_autoriseFieldOk() 
					&& isPlafondFieldOk() && isProprietaire_tutelleFieldOk() && isTaux_interetFieldOk();
		}
		
		// NUM COMPTE FIELD
		public static boolean isNumeroFieldOk() {
			String stringToCheck = frame.getNumero();
			return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]");
		}
		public static String generateNumeroProperErrorMsg() {
			String stringToCheck = frame.getNumero();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		
		// NOM CLIENT FIELD
		public static boolean isNomFieldOk() {
			String stringToCheck = frame.getNom();
			return !stringToCheck.isEmpty() && !stringToCheck.contains(" ") && !isStringContainSpecialCharacter(stringToCheck);
		}
		public static String generateNomProperErrorMsg() {
			String stringToCheck = frame.getNom();
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
		public static String generateTauxInteretFieldOkProperErrorMsg() {
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
		public static String generatePlafondFieldOkProperErrorMsg() {
			String stringToCheck = frame.getPlafond();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// PROPRIETAIRE TUTELLE
		public static boolean isProprietaire_tutelleFieldOk() {
			String stringToCheck = frame.getPlafond();
			return !stringToCheck.isEmpty()  && stringToCheck.matches("");

		}
		public static String generateProprietaire_tutelleFieldOkProperErrorMsg() {
			String stringToCheck = frame.getProprietaire_tutelle();
			if (stringToCheck.isEmpty()) {
				return fieldIsEmptyErrorMsg;
			}
			return fieldIsWrongErrorMsg;
		}
		
		// Getters
		public static String getProperlyFilledFieldMsg() {
			return properlyFilledFieldMsg;
		}
		
		//Button Radio
		/*int x = 40;
		int y = 144;
		int JRadioBtnWidth = 500;
		int JRadioBtnAndJTextFieldHeigth = 26;
		
		
		group = new ButtonGroup();
		
		for (Compte compte : this.conseillerClients) {			
			JRadioButton rdbtnNewRadioButton = new JRadioButton(compte.getId());
			rdbtnNewRadioButton.setBounds(x, y, JRadioBtnWidth, JRadioBtnAndJTextFieldHeigth);
			getContentPane().add(rdbtnNewRadioButton);
			txtCompte = new JTextField();
			rdbtnNewRadioButton.setActionCommand(compte.getId());
			group.add(rdbtnNewRadioButton);
			
			y += 50;
		}*/
		
	}

}
