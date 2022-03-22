package model;

import java.util.Date;

public class Compte {
	
	
	// CORR - Les noms de variables doit �tre en camelCase
	
	private String id;
	private int Numero;
	private int Solde;
	private String Actif;
	private String Proprietaire_tutelle;
	private Date Date_ouverture;
	// CORR - ajouter variable clef etrang�re, nomm� clientProprietaire String
	
	public Compte(String id, int numero, int solde, String actif, String proprietaire_tutelle, Date date_ouverture) {
		
		// CORR - c'est ok de mettre this, mais si c'est mis une fois, il faut le mettre partout
		
		super();
		this.id = id;
		Numero = numero;
		Solde = solde;
		Actif = actif;
		Proprietaire_tutelle = proprietaire_tutelle;
		Date_ouverture = date_ouverture;
	}
	
	// ajouter getters et setters (� g�n�rer automatiquement)
}
