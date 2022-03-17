package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Client;

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
			System.out.println("Client " + clientToAdd.getId() + " est déja dans la base de donnée" );
		}
	}

	private static boolean checkIfClientAlreadyInDb(Client clientToAdd) {
		ArrayList<Client> allClients = DbReadQueries.dbReadAllClient();
		return allClients.stream().anyMatch(client -> client.getId().equals(clientToAdd.getId()));
	}

}
