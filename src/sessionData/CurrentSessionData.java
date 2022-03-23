package sessionData;

import java.awt.Window;
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
	
	private static ArrayList<Conseiller> conseillerList = new ArrayList<Conseiller>();
	private static Conseiller connectedConseiller;
	private static Client selectClientByClick;
	private static Compte compteToUpdate;
	private static CreationBanqueForm homePage;
	private static ListeClientsForm connectedConseillerClientsPage;
	private static OuvrirClientForm openClientPage;
	private static ListeComptesForm selectClientComptesListPage;
	private static OuvrirCompteForm openComptePage;
	private static ModifierCompteForm updateComptePage;
	
	// ==== GETTERS AND SETTERS ===
	public static ArrayList<Conseiller> getConseillerList() {
		return conseillerList;
	}
	
	public static void setConseillerList(ArrayList<Conseiller> conseillerList) {
		CurrentSessionData.conseillerList = conseillerList;
	}

	public static CreationBanqueForm getHomePage() {
		return homePage;
	}

	public static void setHomePage(CreationBanqueForm homePage) {
		CurrentSessionData.homePage = homePage;
	}

	public static OuvrirClientForm getOpenClientPage() {
		return openClientPage;
	}

	public static void setOpenClientPage(OuvrirClientForm openAccountPage) {
		CurrentSessionData.openClientPage = openAccountPage;
	}
	
	//GETTER ET SETTER OUVRIR UN COMPTE
	public static OuvrirCompteForm getOpenComptePage() {
		return openComptePage;
	}

	public static void setOpenComptePage(OuvrirCompteForm openAccountForm) {
		CurrentSessionData.openComptePage = openAccountForm;
	}
	
	// Set the logged conseiller
	public static void setConnectedConseiller(String identifiant) {
		connectedConseiller = DbReadQueries.dbReadConseillers().stream()
				.filter(conseiller -> conseiller.getIdentifiant().equals(identifiant)).findAny().orElse(null);
	}

	// Get the logged conseiller
	public static Conseiller getConnectedConseiller() {
		return connectedConseiller;
	}

	public static ListeClientsForm getConnectedConseillerClientsPage() {
		return connectedConseillerClientsPage;
	}

	public static void setConnectedConseillerClientsPage(ListeClientsForm connectedConseillerClientsPage) {
		CurrentSessionData.connectedConseillerClientsPage = connectedConseillerClientsPage;
	}


	public static ListeComptesForm getSelectClientComptesListPage() {
		return selectClientComptesListPage;
	}

	public static void setSelectClientComptesListPage(ListeComptesForm gestionCompteClient) {
		CurrentSessionData.selectClientComptesListPage = gestionCompteClient;
	}
	
	public static Client getSelectClientByClick() {
		return selectClientByClick;
	}

	public static void setSelectClientByClick(Client selectClientByClick) {
		CurrentSessionData.selectClientByClick = selectClientByClick;
	}
	
	public static void setSelectClientByClick(String clientId) {
		CurrentSessionData.selectClientByClick = DbReadQueries.dbReadClientOfConseiller(getConnectedConseiller()).stream().filter(client -> clientId.equals(client.getId())).findFirst().orElse(null);
		System.out.println(CurrentSessionData.selectClientByClick.getId());
	}
	
	public static Compte getCompteToUpdate() {
		return compteToUpdate;
	}
	
	public static void setCompteToUpdate(Compte compteToUpdate) {
		CurrentSessionData.compteToUpdate = compteToUpdate;
	}

	public static void setCompteToUpdate(String compteId) {
		CurrentSessionData.compteToUpdate = DbReadQueries.dbReadAllCompteInBdd().stream().filter(compte -> compteId.equals(compte.getId())).findFirst().orElse(null);
	}

	public static ModifierCompteForm getUpdateComptePage() {
		return updateComptePage;
	}

	public static void setUpdateComptePage(ModifierCompteForm updateComptePage) {
		CurrentSessionData.updateComptePage = updateComptePage;
	}

	public static Window enableValidateBtn() {
		// TODO Auto-generated method stub
		return null;
	}

}