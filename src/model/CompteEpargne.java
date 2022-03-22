package model;

import java.util.Date;

public class CompteEpargne extends Compte {
	
	
	private String taux_interet;
	private String plafond;
	private static Integer numero;
	private static Integer solde;
	private static String solde_minimum_autorise;
	
	public CompteEpargne(String taux_interet, String plafond, String id, Integer numero, Integer solde, String actif, String proprietaire_tutelle, Date date_ouverture,String client_id,String frais_transfert, String solde_minimum_autorise) {
		
		super(id,  numero,  solde,  actif,  proprietaire_tutelle,  date_ouverture, client_id);
		
		
		this.taux_interet= taux_interet;
		this.plafond = plafond;
	
	}

	public String getTaux_interet() {
		return taux_interet;
	}

	public void setTaux_interet(String taux_interet) {
		this.taux_interet = taux_interet;
	}

	public String getPlafond() {
		return plafond;
	}

	public void setPlafond(String plafond) {
		this.plafond = plafond;
	}

}
