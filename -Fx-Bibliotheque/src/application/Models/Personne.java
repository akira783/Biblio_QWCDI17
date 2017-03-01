package application.Models;

import java.util.Date;

public class Personne
{
	private int		idPersonne;
	private String 	nom;
	private String	prenom;
	private int		age;
	private Date	dateDeNaissance;
	
	public Personne()
	{
		nom = "INCONNUE";
		prenom = "INCONNUE";
	}
	
	public Personne(int idPersonne, String nom, String prenom, int age, Date dateDeNaissance) 
	{
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getIdPersonne()
	{
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne)
	{
		this.idPersonne = idPersonne;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Date getDateDeNaissance()
	{
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance)
	{
		this.dateDeNaissance = dateDeNaissance;
	}
	
	
}
