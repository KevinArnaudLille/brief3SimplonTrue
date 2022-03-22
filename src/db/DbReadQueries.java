package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.Client;
import model.Compte;
import model.Conseiller;

public class DbReadQueries {
	// private variables for conseiller queries
	private static ResultSet conseillerResultSetFromDb = null;
	private static ArrayList<Conseiller> conseillerList = new ArrayList<Conseiller>();

	// private variables for client queries
	private static ResultSet clientResultSetFromDb = null;
	private static ArrayList<Client> clientFullList = new ArrayList<Client>();
	private static ArrayList<Client> clientOfConseillerList = new ArrayList<Client>();

	// COMPTE //
	private static ResultSet compteResultSetFromDb = null;
	private static ArrayList<Compte> allCompteList = new ArrayList<Compte>();
	private static ArrayList<Compte> compteOfClientList = new ArrayList<Compte>();

	// private static Connection myConnToReturn = null;

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

	@SuppressWarnings("unchecked")
	public static ArrayList<Compte> dbReadClientCompteInBdd(Client Client) {
		compteResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM compte");
		allCompteList = new ArrayList<Compte>();
		try {
			while (compteResultSetFromDb.next()) {
				if (compteResultSetFromDb.getString("id_1").equals(Client.getId())) {
					allCompteList
							.addAll((Collection<? extends Compte>) new Client(compteResultSetFromDb.getString("id"),
									compteResultSetFromDb.getString("compte_courant"),
									compteResultSetFromDb.getString("compte_courant"),
									compteResultSetFromDb.getString("compte_epargne"),
									compteResultSetFromDb.getString("compte_epargne"),
									compteResultSetFromDb.getString("Date_ouverture"),
									compteResultSetFromDb.getString("ad_1")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allCompteList;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Compte> dbReadAllCompteInBdd() {
		compteResultSetFromDb = DbConnection.getResultSetFromDbWithQuery("SELECT * FROM compte");
		allCompteList = new ArrayList<Compte>();
		try {
			while (compteResultSetFromDb.next()) {

				allCompteList.addAll((Collection<? extends Compte>) new Client(compteResultSetFromDb.getString("id"),
						compteResultSetFromDb.getString("compte_courant"),
						compteResultSetFromDb.getString("compte_courant"),
						compteResultSetFromDb.getString("compte_epargne"),
						compteResultSetFromDb.getString("compte_epargne"),
						compteResultSetFromDb.getString("Date_ouverture"), compteResultSetFromDb.getString("ad_1")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCompteList;
	}
}