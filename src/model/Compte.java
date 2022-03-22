package model;

import java.util.Date;

public class Compte {
	

	private String id;
	private String client_id;
	public Integer numero;
	private Integer solde;
	private String actif;
	private String proprietaire_tutelle;
	private Date date_ouverture;
	
	
	    public Compte(String id, Integer numero, Integer solde, String actif, String proprietaire_tutelle, Date date_ouverture, String client_id) {
		
		this.id = id;
		this.client_id =client_id;
		this.numero = numero;
		this.solde = solde;
		this.actif = actif;
		this.proprietaire_tutelle = proprietaire_tutelle;
		this.date_ouverture = date_ouverture;
	}

	
	// ajouter getters et setters (� g�n�rer automatiquement)

		public String getClient_id() {
			return client_id;
		}

		public void setClient_id(String client_id) {
			this.client_id = client_id;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getSolde() {
			return solde;
		}

		public void setSolde(int solde) {
			this.solde = solde;
		}

		public String getActif() {
			return actif;
		}

		public void setActif(String actif) {
			this.actif = actif;
		}

		public String getProprietaire_tutelle() {
			return proprietaire_tutelle;
		}

		public void setProprietaire_tutelle(String proprietaire_tutelle) {
			this.proprietaire_tutelle = proprietaire_tutelle;
		}

		public Date getDate_ouverture() {
			return date_ouverture;
		}

		public void setDate_ouverture(Date date_ouverture) {
			this.date_ouverture = date_ouverture;
		}


         public String getCompteCourant() {
			// TODO Auto-generated method stub
			return null;
		}







		public String CompteEpargne() {
			// TODO Auto-generated method stub
			return null;
		}


}
