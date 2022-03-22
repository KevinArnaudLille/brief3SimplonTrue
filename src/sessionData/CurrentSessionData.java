package sessionData;

import java.util.Optional;
import Interface.CreationBanqueForm;
import Interface.ListeClientsForm;
import Interface.OuvrirClientForm;
import Interface.OuvrirCompteForm;
import Interface.ListeComptesForm;
import Interface.ModifierCompteForm;


import checking.CheckConseillerConnection;
import db.DbReadQueries;
import model.Client;
import model.Compte;
import model.Conseiller;

public class CurrentSessionData {
	
	private static Conseiller connectedConseiller;
	private static Client selectClientByClick;
	private static Compte compteToUpdate;
	private static ListeClientsForm connectedConseillerClientsPage;
	private static CreationBanqueForm homePage;
	private static OuvrirCompteForm openAccountForm;
	private static OuvrirClientForm openAccountPage;
	private static ListeClientsForm registerCustomeInBdd;
	private static ListeComptesForm selectClientComptesList;
	private static ModifierCompteForm updateComptePage;
	
	
	// ==== GETTERS AND SETTERS ===
	public static CreationBanqueForm getHomePage() {
		return homePage;
	}

	public static void setHomePage(CreationBanqueForm homePage) {
		CurrentSessionData.homePage = homePage;
	}

	public static OuvrirClientForm getOpenAccountPage() {
		return openAccountPage;
	}

	public static void setOpenAccountPage(OuvrirClientForm openAccountPage) {
		CurrentSessionData.openAccountPage = openAccountPage;
	}
	
	//GETTER ET SETTER OUVRIR UN COMPTE: getOpenAccountForm is the good name or not ???
	public static OuvrirCompteForm getOpenAccountForm() {
		return openAccountForm;
	}

	public static void setOpenAccountForm(OuvrirCompteForm openAccountForm) {
		CurrentSessionData.openAccountForm = openAccountForm;
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


	public static void setBanqueFormPage(CreationBanqueForm openBanqueFormFrame) {
		// TODO Auto-generated method stub
		
	}
	
/***********************************************************************************************************************************/
	
	public static ListeClientsForm getRegisterCustomeInBdd() {
		return registerCustomeInBdd;
	}

	public static void setRegisterCustomeInBdd(ListeClientsForm registerCustomeInBdd) {
		CurrentSessionData.registerCustomeInBdd = registerCustomeInBdd;
	}
	
/************************************************************************************************************************************/
	
	
	public static ListeComptesForm getGestionCompteClient() {
		return selectClientComptesList;
	}

	public static void setGestionCompteClient(ListeComptesForm gestionCompteClient) {
		CurrentSessionData.selectClientComptesList = gestionCompteClient;
	}
	
/*****************************************************************************************************************************************/
	
   

	public static Client getSelectClientByClick() {
		return selectClientByClick;
	}

	public static void setSelectClientByClick(Client selectClientByClick) {
		CurrentSessionData.selectClientByClick = selectClientByClick;
	}
	
	public static Compte getCompteToUpdate() {
		return compteToUpdate;
	}
	
	public static void setCompteToUpdate(Compte compteToUpdate) {
		CurrentSessionData.compteToUpdate = compteToUpdate;
	}

	public static void setSelectClientByClick(String clientId) {
		System.out.println(clientId);
		CurrentSessionData.selectClientByClick = DbReadQueries.dbReadClientOfConseiller(getConnectedConseiller()).stream().filter(client -> clientId.equals(client.getId())).findFirst().orElse(null);
		System.out.println(CurrentSessionData.selectClientByClick.getId());
	}

	public static ModifierCompteForm getUpdateComptePage() {
		return updateComptePage;
	}

	public static void setUpdateComptePage(ModifierCompteForm updateComptePage) {
		CurrentSessionData.updateComptePage = updateComptePage;
	}

}