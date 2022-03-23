package model;

import java.sql.Date;

public class Operation {

	public class Crediter {

		private String id_1;
		private String id_2;
		private String id;
		private Integer numero_compte_emetteur;
		private Integer numero_compte_beneficiaire;
		private Double montant;
		private Date date_operation;
		private Integer debit;
		private Integer credit;
		private Integer transfert;
		private String raison;
	
		public Crediter(String id_1, String id_2, String id, Integer numero_compte_emetteur, Integer numero_compte_beneficiaire, Double montant, Date date_operation,  
				Integer debit, Integer credit, Integer transfert, String raison) {
			
			this.id_1 = id_1;
			this.id_2 = id_2;
			this.id = id;
			this.numero_compte_emetteur = numero_compte_emetteur;
			this.numero_compte_beneficiaire = numero_compte_beneficiaire;
			this.montant = montant;
			this.date_operation = date_operation;
			this.debit = debit;
			this.credit = credit;
			this.transfert = transfert;
			this.raison = raison;
		}

		public String getId_1() {
			return id_1;
		}

		public void setId_1(String id_1) {
			this.id_1 = id_1;
		}

		public String getId_2() {
			return id_2;
		}

		public void setId_2(String id_2) {
			this.id_2 = id_2;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Integer getNumero_compte_emetteur() {
			return numero_compte_emetteur;
		}

		public void setNumero_compte_emetteur(Integer numero_compte_emetteur) {
			this.numero_compte_emetteur = numero_compte_emetteur;
		}

		public Integer getNumero_compte_beneficiaire() {
			return numero_compte_beneficiaire;
		}

		public void setNumero_compte_beneficiaire(Integer numero_compte_beneficiaire) {
			this.numero_compte_beneficiaire = numero_compte_beneficiaire;
		}

		public Double getMontant() {
			return montant;
		}

		public void setMontant(Double montant) {
			this.montant = montant;
		}

		public Date getDate_operation() {
			return date_operation;
		}

		public void setDate_operation(Date date_operation) {
			this.date_operation = date_operation;
		}

		public Integer getDebit() {
			return debit;
		}

		public void setDebit(Integer debit) {
			this.debit = debit;
		}

		public Integer getCredit() {
			return credit;
		}

		public void setCredit(Integer credit) {
			this.credit = credit;
		}

		public Integer getTransfert() {
			return transfert;
		}

		public void setTransfert(Integer transfert) {
			this.transfert = transfert;
		}

		public String getRaison() {
			return raison;
		}

		public void setRaison(String raison) {
			this.raison = raison;
		}
		
	}

}
