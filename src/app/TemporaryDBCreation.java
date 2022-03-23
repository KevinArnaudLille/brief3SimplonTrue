package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TemporaryDBCreation {

	private static final String[] tablesCreationQuery = new String[6];
	private static final String[] dataAddingQuery = new String[19];

	private static void privateSetTablesCreationQuery() {
		tablesCreationQuery[0] = "CREATE TABLE Conseiller(id VARCHAR(255),Nom VARCHAR(255),Prenom VARCHAR(255),Identifiant VARCHAR(255),Mot_de_passe VARCHAR(255),PRIMARY KEY(id));";
		tablesCreationQuery[1] = "CREATE TABLE Client(id VARCHAR(255),Nom VARCHAR(255),Prenom VARCHAR(255),Courriel VARCHAR(50),Adresse VARCHAR(255),Telephone VARCHAR(15),id_1 VARCHAR(255) NOT NULL,PRIMARY KEY(id),FOREIGN KEY(id_1) REFERENCES Conseiller(id));";
		tablesCreationQuery[2] = "CREATE TABLE Compte(id VARCHAR(255),Numero INT,Solde DECIMAL(8,2),Actif BOOLEAN,Proprietaire_tutelle VARCHAR(255),Date_ouverture DATE,id_1 VARCHAR(255) NOT NULL,PRIMARY KEY(id),FOREIGN KEY(id_1) REFERENCES Client(id));";
		tablesCreationQuery[3] = "CREATE TABLE Compte_courant(id VARCHAR(255),Frais_transfert DECIMAL(8,2),Solde_minimum_autorise DECIMAL(8,2),PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Compte(id));";
		tablesCreationQuery[4] = "CREATE TABLE Compte_epargne(id VARCHAR(255),Taux_interet DECIMAL(8,2),Plafond DECIMAL(8,2),PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Compte(id));";
		tablesCreationQuery[5] = "CREATE TABLE Operation(id_1 VARCHAR(255),id_2 VARCHAR(255),id VARCHAR(255),Numero_compte_emetteur INT,Numero_compte_beneficiaire INT,Montant DECIMAL(11,2),Date_operation DATE,Debit BOOLEAN,Credit BOOLEAN,Transfert BOOLEAN,Raison VARCHAR(255),PRIMARY KEY(id_1, id_2),UNIQUE(id),UNIQUE(Numero_compte_emetteur),UNIQUE(Numero_compte_beneficiaire),FOREIGN KEY(id_1) REFERENCES Compte(id),FOREIGN KEY(id_2) REFERENCES Compte(id));";
	}

	private static void privateSetDataToAdd() {
		// add "conseiller"
		dataAddingQuery[0] = "INSERT INTO conseiller VALUES('1','Dupont','Robert','Rdupont','vachier')";
		dataAddingQuery[1] = "INSERT INTO conseiller VALUES('2','Tremblay','Marie-pier','MPTremblay','tropsuper')";

		// add "client"
		dataAddingQuery[2] = "INSERT INTO client VALUES('client_01','Parker','Peter','iLoveSpiders@sp.com','1 rue de la toile','0101010101',(SELECT id FROM conseiller WHERE Nom = 'Dupont'))";
		dataAddingQuery[3] = "INSERT INTO client VALUES('client_02','Wayne','Bruce','iLoveBats@sp.com','2 rue du sonar','0202020202',(SELECT id FROM conseiller WHERE Nom = 'Dupont'))";
		dataAddingQuery[4] = "INSERT INTO client VALUES('client_03','Jean','Jean','grosFraisier@lol.com','derri�re la cabane','-',(SELECT id FROM conseiller WHERE Nom = 'Tremblay'))";

		// add "compte-courant"
		dataAddingQuery[5] = "INSERT INTO compte VALUES('compte_courant_01',111111,2000,true,null,'2022-02-28',(SELECT id FROM client WHERE Nom='Parker'))";
		dataAddingQuery[6] = "INSERT INTO compte_courant VALUES('compte_courant_01',5.5,1000)";
		dataAddingQuery[7] = "INSERT INTO compte VALUES('compte_courant_02',111112,5000,true,null,'2022-02-26',(SELECT id FROM client WHERE Nom='Parker'))";
		dataAddingQuery[8] = "INSERT INTO compte_courant VALUES('compte_courant_02',1.5,10)";
		dataAddingQuery[9] = "INSERT INTO compte VALUES('compte_courant_03',122222,3000,true,null,'2022-03-01',(SELECT id FROM client WHERE Nom='Wayne'))";
		dataAddingQuery[10] = "INSERT INTO compte_courant VALUES('compte_courant_03',6.7,100)";
		dataAddingQuery[11] = "INSERT INTO compte VALUES('compte_courant_04',133333,1000,true,'JoJo','2022-03-03',(SELECT id FROM client WHERE Nom='Jean'))";
		dataAddingQuery[12] = "INSERT INTO compte_courant VALUES('compte_courant_04',9.9,1)";

		// add "compte-epargne"
		dataAddingQuery[13] = "INSERT INTO compte VALUES('compte_epargne_05',211111,10000,true,null,'2022-02-28',(SELECT id FROM client WHERE Nom='Parker'))";
		dataAddingQuery[14] = "INSERT INTO compte_epargne VALUES('compte_epargne_05',9.9,20000)";
		dataAddingQuery[15] = "INSERT INTO compte VALUES('compte_epargne_06',222222,500,true,'JoJo','2022-03-04',(SELECT id FROM client WHERE Nom='Jean'))";
		dataAddingQuery[16] = "INSERT INTO compte_epargne VALUES('compte_epargne_06',1.1,20000)";

		// add "operation"
		// "debit"
		dataAddingQuery[17] = "INSERT INTO operation VALUES('compte_courant_01','compte_courant_02','operation_debit_01',null,null,500,'2022-02-28',true,false,false,'PS5')";
		dataAddingQuery[18] = "INSERT INTO operation VALUES('compte_courant_01','compte_courant_01','operation_debit_01',null,null,500,'2022-02-28',true,false,false,'PS5')";
//		dataAddingQuery[18] = "INSERT INTO operation VALUES('operation_debit_02','compte_courant_04',null,null,null,100,'2022-03-03',true,false,false,'gros_restaurant')";
//		dataAddingQuery[19] = "INSERT INTO operation VALUES('operation_debit_03','compte_epargne_01',null,null,null,20,'2022-03-04',true,false,false,'cadeau_robert')";
//
//		// "credit"
//		dataAddingQuery[20] = "INSERT INTO operation VALUES('operation_credit_01','compte_courant_02',null,null,null,1499.99,'2022-03-01',false,true,false,'salaire')";
//		dataAddingQuery[21] ="INSERT INTO operation VALUES('operation_credit_02','compte_courant_03',null,null,null,30,'2022-03-04',false,true,false,'remboursement_deplacement')";
//		dataAddingQuery[22] = "INSERT INTO operation VALUES('operation_credit_03','compte_epargne_01',null,null,null,666,'2022-03-05',false,true,false,'pacte_satan')";
//
//		// "transfert"
//		dataAddingQuery[23] ="INSERT INTO operation VALUES('operation_transfert_01','compte_epargne_01','compte_courant_01',111111,011111,250,'2022-03-06',false,false,true,'pour_achat')";
//		dataAddingQuery[24] ="INSERT INTO operation VALUES('operation_transfert_01','compte_courant_04','compte_epargne_02',33333,122222,1000,'2022-03-03',false,false,true,'achat_voiture')";
	}

	private static Statement connectToDB(int port, String id, String mdp) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/Banque", id, mdp);
			Statement myStat = myConn.createStatement();
			return myStat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void createDB(int port, String id, String mdp) {
		// Add data to the table query
		privateSetTablesCreationQuery();

		try {
			// connection to service
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/", id, mdp);

			// create statement
			Statement myStat = myConn.createStatement();

			// Delete previous database
			try {
				myStat.executeUpdate("DROP DATABASE Banque");
			} catch (Exception e) {
				e.printStackTrace();
			}

			// create database
			myStat.execute("CREATE DATABASE Banque");

			// connection to just creates db (banque)
			Statement myNewStat = connectToDB(port, id, mdp);

			// create tables
			for (String table : tablesCreationQuery) {
				try {
					myNewStat.executeUpdate(table);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addDataToDB(int port, String id, String mdp) {
		Statement myStat = connectToDB(port, id, mdp);
		privateSetDataToAdd();

		for (String dataToAdd : dataAddingQuery) {
			try {
				myStat.executeUpdate(dataToAdd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
