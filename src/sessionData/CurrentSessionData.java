package sessionData;

import java.util.ArrayList;
import Interface.CreationBanqueForm;
import Interface.ListeClientsForm;
import Interface.OuvrirClientForm;
import Interface.OuvrirCompteForm;
import Interface.ListeComptesForm;
import Interface.ModifierCompteForm;
import db.DbReadQueries;
import model.Client;
import model.Compte;
import model.Conseiller;

public class CurrentSessionData {
	
	// ==== ArrayList to store variables declaration ====
	private static ArrayList<Conseiller> conseillerList = new ArrayList<Conseiller>();

	// ==== Model to store variable declaration ====
	private static Conseiller connectedConseiller;
	private static Client selectClientByClick;
	private static Compte compteToUpdate;

	// ==== Page to store variable declaration ====
	private static CreationBanqueForm homePage;
	private static ListeClientsForm connectedConseillerClientsPage;
	private static OuvrirClientForm openClientPage;
	private static ListeComptesForm selectClientComptesListPage;
	private static OuvrirCompteForm openComptePage;
	private static ModifierCompteForm updateComptePage;

	
	// ==== GETTERS AND SETTERS ====
	public static ArrayList<Conseiller> getConseillerList() {
		return conseillerList;
	}

	public static void setConseillerList(ArrayList<Conseiller> conseillerList) {
		CurrentSessionData.conseillerList = conseillerList;
	}

	public static Conseiller getConnectedConseiller() {
		return connectedConseiller;
	}

	public static void setConnectedConseiller(String identifiant) {
		connectedConseiller = DbReadQueries.dbReadConseillers().stream()
				.filter(conseiller -> conseiller.getIdentifiant().equals(identifiant)).findAny().orElse(null);
	}

	public static Client getSelectClientByClick() {
		return selectClientByClick;
	}

	// --------------------------------------
	// FUNCTION OVERLOAD
	public static void setSelectClientByClick(Client selectClientByClick) {
		CurrentSessionData.selectClientByClick = selectClientByClick;
	}

	public static void setSelectClientByClick(String clientId) {
		CurrentSessionData.selectClientByClick = DbReadQueries.dbReadClientOfConseiller(getConnectedConseiller())
				.stream().filter(client -> clientId.equals(client.getId())).findFirst().orElse(null);
		System.out.println(CurrentSessionData.selectClientByClick.getId());
	}
	// FUNCTION OVERLOAD
	// --------------------------------------

	public static Compte getCompteToUpdate() {
		return compteToUpdate;
	}

	// --------------------------------------
	// FUNCTION OVERLOAD
	public static void setCompteToUpdate(Compte compteToUpdate) {
		CurrentSessionData.compteToUpdate = compteToUpdate;
	}

	public static void setCompteToUpdate(String compteId) {
		CurrentSessionData.compteToUpdate = DbReadQueries.dbReadAllCompteInBdd().stream()
				.filter(compte -> compteId.equals(compte.getId())).findFirst().orElse(null);
	}
	// FUNCTION OVERLOAD
	// --------------------------------------

	public static CreationBanqueForm getHomePage() {
		return homePage;
	}

	public static void setHomePage(CreationBanqueForm homePage) {
		CurrentSessionData.homePage = homePage;
	}

	public static ListeClientsForm getConnectedConseillerClientsPage() {
		return connectedConseillerClientsPage;
	}

	public static void setConnectedConseillerClientsPage(ListeClientsForm connectedConseillerClientsPage) {
		CurrentSessionData.connectedConseillerClientsPage = connectedConseillerClientsPage;
	}

	public static OuvrirClientForm getOpenClientPage() {
		return openClientPage;
	}

	public static void setOpenClientPage(OuvrirClientForm openAccountPage) {
		CurrentSessionData.openClientPage = openAccountPage;
	}

	public static ListeComptesForm getSelectClientComptesListPage() {
		return selectClientComptesListPage;
	}

	public static void setSelectClientComptesListPage(ListeComptesForm gestionCompteClient) {
		CurrentSessionData.selectClientComptesListPage = gestionCompteClient;
	}

	public static OuvrirCompteForm getOpenComptePage() {
		return openComptePage;
	}

	public static void setOpenComptePage(OuvrirCompteForm openAccountForm) {
		CurrentSessionData.openComptePage = openAccountForm;
	}

	public static ModifierCompteForm getUpdateComptePage() {
		return updateComptePage;
	}

	public static void setUpdateComptePage(ModifierCompteForm updateComptePage) {
		CurrentSessionData.updateComptePage = updateComptePage;
	}
}