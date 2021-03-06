package model;

import java.util.Date;

public class Compte {
	private String id;
	private String client_id;
	private Integer numero;
	private Double solde;
	private boolean actif;
	private String proprietaire_tutelle;
	private Date date_ouverture;

	public Compte(String id, Integer numero, Double solde, boolean actif, String proprietaire_tutelle,
			Date date_ouverture, String client_id) {
		this.id = id;
		this.client_id = client_id;
		this.numero = numero;
		this.solde = solde;
		this.actif = actif;
		this.proprietaire_tutelle = proprietaire_tutelle;
		this.date_ouverture = date_ouverture;
	}

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

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public boolean getActif() {
		return actif;
	}

	public void setActif(boolean actif) {
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
}