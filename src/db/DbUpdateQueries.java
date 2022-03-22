package db;

import java.sql.SQLException;
import java.sql.Statement;

import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;

public class DbUpdateQueries {
	static public void updateCompteInfoInDb(Compte compteToUpdate, String updatedValue) {
		Statement myStat = DbConnection.statementGeneration();
		if (compteToUpdate instanceof CompteCourant) {
			try {
				myStat.executeUpdate("UPDATE compte-courant SET Frais_transfert =" + updatedValue +" WHERE id='" + compteToUpdate.getId() + "'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (compteToUpdate instanceof CompteEpargne) {
			try {
				myStat.executeUpdate("UPDATE compte-epargne SET Taux_interet =" + updatedValue +" WHERE id='" + compteToUpdate.getId() + "'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
