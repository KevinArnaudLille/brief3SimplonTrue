package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//import Interface.OuvrirCompte_courantForm;
//import Interface.OuvrirCompte_epargneForm;

import Interface.OuvrirCompteForm;

import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import sessionData.CurrentSessionData;

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
			System.out.println("Client " + clientToAdd.getId() + " est dï¿½ja dans la base de donnï¿½e");
		}
	}

	private static boolean checkIfClientAlreadyInDb(Client clientToAdd) {
		ArrayList<Client> allClients = DbReadQueries.dbReadAllClient();
		return allClients.stream().anyMatch(client -> client.getId().equals(clientToAdd.getId()));
	}

	// ADD COMPTE COURANT
	public static void addCompteCourantToDb(CompteCourant comptecourantToAdd) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Statement myStat = DbConnection.statementGeneration();

		if (!checkIfCompteCourantAlreadyInDb(comptecourantToAdd)) {
			try {
				myStat.executeUpdate("INSERT INTO compte VALUES('" + comptecourantToAdd.getId() + "',"
						+ comptecourantToAdd.getNumero() + "," + comptecourantToAdd.getSolde() + ",true,"
						+ (comptecourantToAdd.getProprietaire_tutelle() != null
								? "'" + comptecourantToAdd.getProprietaire_tutelle() + "'"
								: "null")
						+ ",'" + simpleDateFormat.format(comptecourantToAdd.getDate_ouverture()) + "','"
						+ CurrentSessionData.getSelectClientByClick().getId() + "')");

				myStat.executeUpdate("INSERT INTO compte_courant VALUES('" + comptecourantToAdd.getId() + "',"
						+ comptecourantToAdd.getFrais_transfert() + "," + comptecourantToAdd.getSolde_minimum_autorise()
						+ ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Compte " + comptecourantToAdd.getId() + " est déja dans la base de donnée");
		}
	}

	private static boolean checkIfCompteCourantAlreadyInDb(CompteCourant comptecourantToAdd) {
		ArrayList<Compte> allCompte = DbReadQueries.dbReadAllCompteInBdd();
		return allCompte.stream().anyMatch(compte -> compte.getId().equals(comptecourantToAdd.getId()));
	}

	// ADD COMPTE EPARGNE
	public static void addCompteEpargneToDb(CompteEpargne compteEpargneToAdd) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Statement myStat = DbConnection.statementGeneration();

		if (!checkIfCompteEpargneAlreadyInDb(compteEpargneToAdd)) {
			try {
				myStat.executeUpdate("INSERT INTO compte VALUES('" + compteEpargneToAdd.getId() + "',"
						+ compteEpargneToAdd.getNumero() + "," + compteEpargneToAdd.getSolde() 
						+ ",true,"
						+ (compteEpargneToAdd.getProprietaire_tutelle() != null
								? "'" + compteEpargneToAdd.getProprietaire_tutelle() + "'"
								: "null")
						+ ",'" + simpleDateFormat.format(compteEpargneToAdd.getDate_ouverture()) + "','"
						+ CurrentSessionData.getSelectClientByClick().getId() + "')");

				myStat.executeUpdate("INSERT INTO compte_epargne VALUES('" + compteEpargneToAdd.getId() + "',"
						+ compteEpargneToAdd.getTaux_interet() + "," + compteEpargneToAdd.getPlafond() + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Compte " + compteEpargneToAdd.getId() + " est dï¿½ja dans la base de donnï¿½e");
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
