package model;


public class CompteEpargne extends Compte {
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

	private void setId(String id) {
		this.id = id;
	}

	private String getTaux_interet() {
		return Taux_interet;
	}

	private void setTaux_interet(String taux_interet) {
		Taux_interet = taux_interet;
	}

	private String getPlafond() {
		return Plafond;
	}

	private void setPlafond(String plafond) {
		Plafond = plafond;
	}

	
	
}
