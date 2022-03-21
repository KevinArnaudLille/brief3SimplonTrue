package model;

public class CompteCourant extends Compte {
     
	// CORR - Les noms de variables doit être en camelCase
	private String id; // pas besoin de id car deja dans classe parente
	private String Frais_transfert;
	private String Solde_minimum_autorise;
	private String Raison; // ????? n'a pas ça place ici
	
	// CORR - Il faut que le constructeur de CompteCourant reçoive les paramètres de ses variables ET les variables de la classe parente (ici Compte), les variables relatives à la classe parente reçu doivent être renvoyé au constructeur de la classe parente vie la fonction super();
	private CompteCourant(String id, String frais_transfert, String solde_minimum_autorise, String raison) {
		super();
		this.id = id;
		Frais_transfert = frais_transfert;
		Solde_minimum_autorise = solde_minimum_autorise;
		Raison = raison;
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	private String getFrais_transfert() {
		return Frais_transfert;
	}

	private void setFrais_transfert(String frais_transfert) {
		Frais_transfert = frais_transfert;
	}

	private String getSolde_minimum_autorise() {
		return Solde_minimum_autorise;
	}

	private void setSolde_minimum_autorise(String solde_minimum_autorise) {
		Solde_minimum_autorise = solde_minimum_autorise;
	}

	private String getRaison() {
		return Raison;
	}

	private void setRaison(String raison) {
		Raison = raison;
	}
	




}
