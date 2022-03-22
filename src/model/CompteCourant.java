package model;

import java.util.Date;

public class CompteCourant extends Compte {
    private String frais_transfert;
	private String solde_minimum_autorise;

	

	public CompteCourant(String id, Integer numero, Integer solde, String actif, String proprietaire_tutelle, Date date_ouverture,String client_id,String frais_transfert, String solde_minimum_autorise) {
		
		
		super( id,  numero,  solde,  actif,  proprietaire_tutelle,  date_ouverture, client_id);
	
		this.frais_transfert = frais_transfert;
		this.solde_minimum_autorise = solde_minimum_autorise;
		
		
	}




	public String getFrais_transfert() {
		return frais_transfert;
	}




	public void setFrais_transfert(String frais_transfert) {
		this.frais_transfert = frais_transfert;
	}




	public String getSolde_minimum_autorise() {
		return solde_minimum_autorise;
	}




	public void setSolde_minimum_autorise(String solde_minimum_autorise) {
		this.solde_minimum_autorise = solde_minimum_autorise;
	}


	

	






}
