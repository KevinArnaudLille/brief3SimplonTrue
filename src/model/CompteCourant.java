package model;

import java.util.Date;

public class CompteCourant extends Compte {
    private Double frais_transfert;
	private Double solde_minimum_autorise;

	public CompteCourant(String id, int numero, Double solde, boolean actif, String proprietaire_tutelle, Date date_ouverture, String client_id, Double frais_transfert, Double solde_minimum_autorise) {
		
		super(id,numero,solde,actif,proprietaire_tutelle,date_ouverture,client_id);

		this.frais_transfert = frais_transfert;
		this.solde_minimum_autorise = solde_minimum_autorise;
	}

	public Double getFrais_transfert() {
		return frais_transfert;
	}

	public void setFrais_transfert(Double frais_transfert) {
		this.frais_transfert = frais_transfert;
	}

	public Double getSolde_minimum_autorise() {
		return solde_minimum_autorise;
	}

	public void setSolde_minimum_autorise(Double solde_minimum_autorise) {
		this.solde_minimum_autorise = solde_minimum_autorise;
	}
}
