package model;

import java.util.Date;

public class CompteEpargne extends Compte {

	private Double taux_interet;
	private Double plafond;

	public CompteEpargne(String id, int numero, Double solde, boolean actif, String proprietaire_tutelle,
			Date date_ouverture, String client_id, Double taux_interet, Double plafond) {

		super(id, numero, solde, actif, proprietaire_tutelle, date_ouverture, client_id);

		this.taux_interet = taux_interet;
		this.plafond = plafond;

	}

	public Double getTaux_interet() {
		return taux_interet;
	}

	public void setTaux_interet(Double taux_interet) {
		this.taux_interet = taux_interet;
	}

	public Double getPlafond() {
		return plafond;
	}

	public void setPlafond(Double plafond) {
		this.plafond = plafond;
	}
}
