package Biblio.Model;

import java.util.Date;

public class Utilisateur extends Personne
{
	private int	idUtilisateur;
	private	String	pwd;
	private	String	pseudonyme;
	
	public Utilisateur(String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, String pwd,
			String pseudonyme) 
	{
		super(nom, prenom, dateNaissance, sexe);
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
	}
}
