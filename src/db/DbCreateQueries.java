package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import Interface.OuvrirCompteForm;
//import Interface.OuvrirCompte_courantForm;
//import Interface.OuvrirCompte_epargneForm;
import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;

public class DbCreateQueries {

	public static void addClientToDb(Client clientToAdd) {
		Statement myStat = DbConnection.statementGeneration();
		if (!checkIfClientAlreadyInDb(clientToAdd)) {
			try {
				myStat.executeUpdate("INSERT INTO client VALUES('" + clientToAdd.getId() + "','" + clientToAdd.getNom()
						+ "','" + clientToAdd.getPrenom() + "','" + clientToAdd.getCourriel() + "','"
						+ clientToAdd.getAdresse() + "','" + clientToAdd.getTelephone() + "','"
						+ clientToAdd.getConseillerId() + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Client " + clientToAdd.getId() + " est d�ja dans la base de donn�e" );
		}
	}

	private static boolean checkIfClientAlreadyInDb(Client clientToAdd) {
		ArrayList<Client> allClients = DbReadQueries.dbReadAllClient();
		return allClients.stream().anyMatch(client -> client.getId().equals(clientToAdd.getId()));
	}
	
	//ADD COMPTE COURANT
	public static void addCompteCourantToDb(CompteCourant comptecourantToAdd) {
		Statement myStat = DbConnection.statementGeneration();
		if (!checkIfCompteCourantAlreadyInDb(comptecourantToAdd)) {
			try {
				myStat.executeUpdate("INSERT INTO compte_courant VALUES('" + comptecourantToAdd.getId() + "','" + comptecourantToAdd.getFrais_transfert()
						+ "','" + comptecourantToAdd.getSolde_minimum_autorise());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Compte " + comptecourantToAdd.getId() + " est d�ja dans la base de donn�e" );
		}
	}
	
	private static boolean checkIfCompteCourantAlreadyInDb(CompteCourant comptecourantToAdd) {
		ArrayList<Compte> allCompte = DbReadQueries.dbReadAllCompteInBdd();
		return allCompte.stream().anyMatch(compte -> compte.getId().equals(comptecourantToAdd.getId()));
	}
	
	
	//ADD COMPTE EPARGNE
	public static void addCompteEpargneToDb(CompteEpargne compteepargneToAdd) {
		Statement myStat = DbConnection.statementGeneration();
		if (!checkIfCompteEpargneAlreadyInDb(compteepargneToAdd)) {
			try {
				myStat.executeUpdate("INSERT INTO compte_epargne VALUES('" + compteepargneToAdd.getId() + "','" + compteepargneToAdd.getTaux_interet()
						+ "','" + compteepargneToAdd.getPlafond());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Compte " + compteepargneToAdd.getId() + " est d�ja dans la base de donn�e" );
		}
	}
	
	private static boolean checkIfCompteEpargneAlreadyInDb(CompteEpargne compteepargneToAdd) {
		ArrayList<Compte> allCompte = DbReadQueries.dbReadAllCompteInBdd();
		return allCompte.stream().anyMatch(compte -> compte.getId().equals(compteepargneToAdd.getId()));
	}


	public static Object dbReClientofConseiller(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}
