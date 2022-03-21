package model;


public class CompteEpargne extends Compte {
	// CORR - voir Compte-courant
	private String id;
	private String Taux_interet;
	private String Plafond;
	
	public CompteEpargne(String id, String Taux_interet, String Plafond) {
		super();
		this.id = id;
		this.Taux_interet= Taux_interet;
		this.Plafond = Plafond;
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaux_interet() {
		return Taux_interet;
	}

	public void setTaux_interet(String taux_interet) {
		Taux_interet = taux_interet;
	}

	public String getPlafond() {
		return Plafond;
	}

	public void setPlafond(String plafond) {
		Plafond = plafond;
	}

	
	
}
