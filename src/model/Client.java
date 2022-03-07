package model;

public class Client {
	private String id;
	private String nom;
	private String prenom;
	private String courriel;
	private String adresse;
	private String telephone;
	private String conseillerId;
	
	public Client(String id, String nom, String prenom, String courriel, String adresse, String telephone,
			String conseillerId) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.adresse = adresse;
		this.telephone = telephone;
		this.conseillerId = conseillerId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getConseillerId() {
		return conseillerId;
	}

	public void setConseillerId(String conseillerId) {
		this.conseillerId = conseillerId;
	}


}
