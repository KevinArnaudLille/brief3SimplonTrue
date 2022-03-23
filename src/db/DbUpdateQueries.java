package db;

import java.sql.SQLException;
import java.sql.Statement;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;

public class DbUpdateQueries {
	
	// ==== Update in db functions ====
	// == for Compte status update ==
	public static void updateCompteStatusInDb(Compte compteToUpdate, boolean newStatus) {
		Statement myStat = DbConnection.statementGeneration();
		try {
			myStat.executeUpdate("UPDATE compte SET Actif =" + newStatus +" WHERE id='" + compteToUpdate.getId() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// == for update Compte infos (UNUSED) ==
	public static void updateCompteInfoInDb(Compte compteToUpdate, String updatedValue) {
		Statement myStat = DbConnection.statementGeneration();
		if (compteToUpdate instanceof CompteCourant) {
			try {
				myStat.executeUpdate("UPDATE compte-courant SET Frais_transfert =" + updatedValue +" WHERE id='" + compteToUpdate.getId() + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (compteToUpdate instanceof CompteEpargne) {
			try {
				myStat.executeUpdate("UPDATE compte-epargne SET Taux_interet =" + updatedValue +" WHERE id='" + compteToUpdate.getId() + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}