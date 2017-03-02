package Biblio.Model;

import java.util.Date;

public class Personne 
{
	private String	nom;
	private String	prenom;
	private Date	dateNaissance;
	private String	sexe;
	
	public Personne(String nom, String prenom, Date dateNaissance, String sexe) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
	}
}
