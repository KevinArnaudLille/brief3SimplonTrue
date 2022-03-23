package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private static Connection myConnToReturn = null;
	private static Statement myStatToReturn = null;
	private static ResultSet myResToReturn = null;

	// ==== Connection to db ====
	public static Connection connectToDb() {
		// Try to connect with Imen/Kevin param.
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banque", "root", "");
			myConnToReturn = myConn;
			System.out.println("Imen/Kevin est connecte");

		} catch (SQLException e) {
			System.out.println("Imen/Kevin n'est pas connecte");
		}

		// Try to connect with Yasmine param.
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/Banque", "root", "root");
			myConnToReturn = myConn;
			System.out.println("Yasmine est connecte");
		} catch (SQLException e) {
			System.out.println("Yasmine n'est pas connecte");
		}

		return myConnToReturn;
	}

	// ==== Statement db generation ====
	public static Statement statementGeneration() {
		try {
			Connection myConn = connectToDb();
			myStatToReturn = myConn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myStatToReturn;
	}

	// ==== ResultSet db generation through SQL query as argument ====
	public static ResultSet getResultSetFromDbWithQuery(String query) {
		try {
			Statement myStat = statementGeneration();
			myResToReturn = myStat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myResToReturn;
	}
}