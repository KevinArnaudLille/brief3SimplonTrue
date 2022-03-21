package checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Interface.CreationBanqueForm;
import Interface.OuvrirClientForm;

public class CheckClientAdd {
	
	private static OuvrirClientForm frame;

	// Correct Msg and Error Msg
	private static String properlyFilledFieldMsg = "OK";
	private static String fieldIsEmptyErrorMsg = "Champ n�cessaire !";
	private static String fieldIsWrongErrorMsg = "Champ incorrect !";
	private static String fieldIsNotAnEmailErrorMsg = "Email incorrect !";
	
	// GLOBAL FUNCTIONS
	private static boolean isStringContainSpecialCharacter(String stringToCheck) {
		Pattern p = Pattern.compile("[^a-z0-9]",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(stringToCheck);
		return m.find();
	}
	
	private static boolean isStringAnEmail(String stringToCheck) {
		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher m = p.matcher(stringToCheck);
		return m.matches();
	}
	
	public static void setFrame(OuvrirClientForm IncommingFrame) {
		frame = IncommingFrame;
	}
	
	// ALL FIELD
	public static boolean AreAllFieldOk() {
		return isNomFieldOk() && isPrenomFieldOk() && isCourrielFieldOk() && isAdresseFieldOk() && isTelFieldOk();
	}
	
	// NOM FIELD
	public static boolean isNomFieldOk() {
		String stringToCheck = frame.getNom();
		return !stringToCheck.isEmpty()  && !stringToCheck.contains(" ") && !isStringContainSpecialCharacter(stringToCheck);
	}
	public static String generateNomProperErrorMsg() {
		String stringToCheck = frame.getNom();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// PRENOM FIELD
	public static boolean isPrenomFieldOk() {
		String stringToCheck = frame.getPrenom();
		return !stringToCheck.isEmpty()  && !stringToCheck.contains(" ") && !isStringContainSpecialCharacter(stringToCheck);
	}
	public static String generatePrenomProperErrorMsg() {
		String stringToCheck = frame.getPrenom();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}
	
	// COURRIEL FIELD
	public static boolean isCourrielFieldOk() {
		String stringToCheck = frame.getCourriel();
		return !stringToCheck.isEmpty() && isStringAnEmail(stringToCheck);
	}
	public static String generateCourrielProperErrorMsg() {
		String stringToCheck = frame.getCourriel();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		} else if (!isStringAnEmail(stringToCheck)) {
			return fieldIsNotAnEmailErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}
	
	// ADRESSE FIELD
	public static boolean isAdresseFieldOk() {
		String stringToCheck = frame.getAdresse();
		return !stringToCheck.isEmpty() && !isStringContainSpecialCharacter(stringToCheck);
	}
	public static String generateAdresseProperErrorMsg() {
		String stringToCheck = frame.getAdresse();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}
	
	// TEL FIELD
	public static boolean isTelFieldOk() {
		String stringToCheck = frame.getTel();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+");
	}
	public static String generateTelProperErrorMsg() {
		String stringToCheck = frame.getTel();
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
