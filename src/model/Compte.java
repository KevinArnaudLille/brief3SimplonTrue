package model;

import java.util.Date;

public class Compte {
	
	private String id;
	private int Numero;
	private int Solde;
	private String Actif;
	private String Proprietaire_tutelle;
	protected Date Date_ouverture;
	
	private Compte(String id, int numero, int solde, String actif, String proprietaire_tutelle, Date date_ouverture) {
		
		super();
		this.id = id;
		Numero = numero;
		Solde = solde;
		Actif = actif;
		Proprietaire_tutelle = proprietaire_tutelle;
		Date_ouverture = date_ouverture;
	}

	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
