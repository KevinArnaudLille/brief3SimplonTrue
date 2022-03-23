package checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sessionData.CurrentSessionData;

public class CheckClientAdd {

	// ==== Correct Msg and Error Msgs ====
	private static String properlyFilledFieldMsg = "OK";
	private static String fieldIsEmptyErrorMsg = "Champ nécessaire !";
	private static String fieldIsWrongErrorMsg = "Champ incorrect !";
	private static String fieldIsNotAnEmailErrorMsg = "Email incorrect !";

	//*******************************************************
	// ==== Getter ====
	public static String getProperlyFilledFieldMsg() {
		return properlyFilledFieldMsg;
	}
	
	//*******************************************************
	// ==== Global unitary checking function ====
	private static boolean isStringContainSpecialCharacter(String stringToCheck) {
		Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(stringToCheck);
		return m.find();
	}

	private static boolean isStringAnEmail(String stringToCheck) {
		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher m = p.matcher(stringToCheck);
		return m.matches();
	}

	// ==== Checking all field at once ====
	public static boolean AreAllFieldOk() {
		return isNomFieldOk() && isPrenomFieldOk() && isCourrielFieldOk() && isAdresseFieldOk() && isTelFieldOk();
	}

	//*******************************************************
	// ==== Checking specific field ====
	// == NOM ==
	public static boolean isNomFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getNom();
		return !stringToCheck.isEmpty() && !stringToCheck.contains(" ")
				&& !isStringContainSpecialCharacter(stringToCheck);
	}

	public static String generateNomProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getNom();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == PRENOM ==
	public static boolean isPrenomFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getPrenom();
		return !stringToCheck.isEmpty() && !stringToCheck.contains(" ")
				&& !isStringContainSpecialCharacter(stringToCheck);
	}

	public static String generatePrenomProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getPrenom();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == COURRIEL ==
	public static boolean isCourrielFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getCourriel();
		return !stringToCheck.isEmpty() && isStringAnEmail(stringToCheck);
	}

	public static String generateCourrielProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getCourriel();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		} else if (!isStringAnEmail(stringToCheck)) {
			return fieldIsNotAnEmailErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == ADRESSE ==
	public static boolean isAdresseFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getAdresse();
		return !stringToCheck.isEmpty() && !isStringContainSpecialCharacter(stringToCheck);
	}

	public static String generateAdresseProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getAdresse();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}

	// == TEL ==
	public static boolean isTelFieldOk() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getTel();
		return !stringToCheck.isEmpty() && stringToCheck.matches("[0-9]+");
	}

	public static String generateTelProperErrorMsg() {
		String stringToCheck = CurrentSessionData.getOpenAccountPage().getTel();
		if (stringToCheck.isEmpty()) {
			return fieldIsEmptyErrorMsg;
		}
		return fieldIsWrongErrorMsg;
	}
}