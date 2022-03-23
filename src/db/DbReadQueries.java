package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;
import model.Compte;
import model.Conseiller;

public class DbReadQueries {
	// ==== Variables declaration ====
	// == for conseiller ==
	private static ResultSet conseillerResultSetFromDb = null;
	private static ArrayList<Conseiller> conseillerList = new ArrayList<Conseiller>();

	// == for client ==
	private static ResultSet clientResultSetFromDb = null;
	private static ArrayList<Client> clientFullList;
	private static ArrayList<Client> clientOfConseillerList;

	// == for compte ==
	private static ResultSet compteResultSetFromDb = null;
	private static ArrayList<Compte> allCompteList;
	private static ArrayList<Compte> compteOfClientList;

	// *******************************************************
	// ==== Read from db functions ====
	// == Read all Conseillers ==
	public static ArrayList<Conseiller> dbReadConseillers() {
		conseillerResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM conseiller");
		try {
			while (conseillerResultSetFromDb.next()) {
				conseillerList.add(new Conseiller(conseillerResultSetFromDb.getString("id"),
						conseillerResultSetFromDb.getString("Nom"), conseillerResultSetFromDb.getString("Prenom"),
						conseillerResultSetFromDb.getString("Identifiant"),
						conseillerResultSetFromDb.getString("Mot_de_passe")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conseillerList;
	}

	// == Read all Clients ==
	public static ArrayList<Client> dbReadAllClient() {
		clientResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM client");
		clientFullList = new ArrayList<Client>();
		try {
			while (clientResultSetFromDb.next()) {
				clientFullList.add(new Client(clientResultSetFromDb.getString("id"),
						clientResultSetFromDb.getString("Nom"), clientResultSetFromDb.getString("Prenom"),
						clientResultSetFromDb.getString("Courriel"), clientResultSetFromDb.getString("Adresse"),
						clientResultSetFromDb.getString("Telephone"), clientResultSetFromDb.getString("id_1")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientFullList;
	}

	// == Read all Clients of a given Conseiller ==
	public static ArrayList<Client> dbReadClientOfConseiller(Conseiller conseiller) {
		clientResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM client");
		clientOfConseillerList = new ArrayList<Client>();
		try {
			while (clientResultSetFromDb.next()) {
				if (clientResultSetFromDb.getString("id_1").equals(conseiller.getId())) {
					clientOfConseillerList.add(new Client(clientResultSetFromDb.getString("id"),
							clientResultSetFromDb.getString("Nom"), clientResultSetFromDb.getString("Prenom"),
							clientResultSetFromDb.getString("Courriel"), clientResultSetFromDb.getString("Adresse"),
							clientResultSetFromDb.getString("Telephone"), clientResultSetFromDb.getString("id_1")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientOfConseillerList;
	}
	
	// == Read all Comptes ==
	public static ArrayList<Compte> dbReadAllCompteInBdd() {
		compteResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM compte");
		allCompteList = new ArrayList<Compte>();
		try {
			while (compteResultSetFromDb.next()) {
				allCompteList.add(new Compte(compteResultSetFromDb.getString("id"),
						compteResultSetFromDb.getInt("Numero"), compteResultSetFromDb.getDouble("Solde"),
						compteResultSetFromDb.getBoolean("Actif"),
						compteResultSetFromDb.getString("Proprietaire_tutelle"),
						compteResultSetFromDb.getDate("Date_ouverture"), compteResultSetFromDb.getString("id_1")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allCompteList;
	}

	// == Read all Comptes of a given Client ==
	public static ArrayList<Compte> dbReadClientCompteInBdd(Client Client) {
		compteResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM compte");
		compteOfClientList = new ArrayList<Compte>();
		try {
			while (compteResultSetFromDb.next()) {
				if (compteResultSetFromDb.getString("id_1").equals(Client.getId())) {
					compteOfClientList.add(new Compte(compteResultSetFromDb.getString("id"),
							compteResultSetFromDb.getInt("Numero"), compteResultSetFromDb.getDouble("Solde"),
							compteResultSetFromDb.getBoolean("Actif"),
							compteResultSetFromDb.getString("Proprietaire_tutelle"),
							compteResultSetFromDb.getDate("Date_ouverture"), compteResultSetFromDb.getString("id_1")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compteOfClientList;
	}
}