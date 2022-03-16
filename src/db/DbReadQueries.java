package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;
import model.Conseiller;

public class DbReadQueries {
	// private variables for conseiller queries
	private static ResultSet conseillerResultSetFromDb = null;
	private static ArrayList<Conseiller> conseillerList = new ArrayList<Conseiller>();

	// private variables for client queries
	private static ResultSet clientResultSetFromDb = null;
	private static ArrayList<Client> clientFullList = new ArrayList<Client>();
	private static ArrayList<Client> clientOfConseillerList = new ArrayList<Client>();

	
	// Get a list of all conseiller as Conseiller object
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

	
	// Get a list of all client as Client object
	public static ArrayList<Client> dbReadAllClient() {

		clientResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM client");

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

	// Get a list of client for a given conseiller as Client object
	public static ArrayList<Client> dbReadClientOfConseiller(Conseiller conseiller) {
		clientResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM client");

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
}