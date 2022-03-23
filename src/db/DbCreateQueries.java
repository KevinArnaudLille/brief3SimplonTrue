package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import sessionData.CurrentSessionData;

public class DbCreateQueries {

	// ==== Add client, from client object, to db ====
	public static void addClientToDb(Client clientToAdd) {
		Statement myStat = DbConnection.statementGeneration();
		try {
			myStat.executeUpdate("INSERT INTO client VALUES('" + clientToAdd.getId() + "','" + clientToAdd.getNom()
					+ "','" + clientToAdd.getPrenom() + "','" + clientToAdd.getCourriel() + "','"
					+ clientToAdd.getAdresse() + "','" + clientToAdd.getTelephone() + "','"
					+ clientToAdd.getConseillerId() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ==== Add compte courant, from compte courant object, to db ====
	public static void addCompteCourantToDb(CompteCourant comptecourantToAdd) {
		Statement myStat = DbConnection.statementGeneration();
		try {
			myStat.executeUpdate("INSERT INTO compte VALUES('" + comptecourantToAdd.getId() + "',"
					+ comptecourantToAdd.getNumero() + "," + comptecourantToAdd.getSolde() + ",true,"
					+ (comptecourantToAdd.getProprietaire_tutelle() != null
							? "'" + comptecourantToAdd.getProprietaire_tutelle() + "'"
							: "null")
					+ ",'" + generateDateFormatForDb().format(comptecourantToAdd.getDate_ouverture()) + "','"
					+ CurrentSessionData.getSelectClientByClick().getId() + "')");

			myStat.executeUpdate("INSERT INTO compte_courant VALUES('" + comptecourantToAdd.getId() + "',"
					+ comptecourantToAdd.getFrais_transfert() + "," + comptecourantToAdd.getSolde_minimum_autorise()
					+ ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ==== Add compte epargne, from compte epargne object, to db ====
	public static void addCompteEpargneToDb(CompteEpargne compteEpargneToAdd) {
		Statement myStat = DbConnection.statementGeneration();
		try {
			myStat.executeUpdate("INSERT INTO compte VALUES('" + compteEpargneToAdd.getId() + "',"
					+ compteEpargneToAdd.getNumero() + "," + compteEpargneToAdd.getSolde() + ",true,"
					+ (compteEpargneToAdd.getProprietaire_tutelle() != null
							? "'" + compteEpargneToAdd.getProprietaire_tutelle() + "'"
							: "null")
					+ ",'" + generateDateFormatForDb().format(compteEpargneToAdd.getDate_ouverture()) + "','"
					+ CurrentSessionData.getSelectClientByClick().getId() + "')");

			myStat.executeUpdate("INSERT INTO compte_epargne VALUES('" + compteEpargneToAdd.getId() + "',"
					+ compteEpargneToAdd.getTaux_interet() + "," + compteEpargneToAdd.getPlafond() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// *******************************************************
	// ==== SimpleDateFormat that allows SQL queries ====
	private static SimpleDateFormat generateDateFormatForDb() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat;
	}
}