package application.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Personne implements Comparable<Client>
{
	private int			idClient;
	private Date 		dateInscription;
	private List<Emprunt>	livresEnEmprunt;
	private List<Livre>	livres;
	
	public Client()
	{
		super();
	}

	public Client(int idPersonne, String nom, String prenom, int age, Date dateDeNaissance,
			int idClient, Date dateInscription, List<Emprunt> livresEnEmpreint, List<Livre> livres) 
	{
		super(idPersonne, nom, prenom, age, dateDeNaissance);
		this.idClient = idClient;
		this.dateInscription = dateInscription;
		this.livresEnEmprunt = livresEnEmpreint;
		this.livres = livres;
		this.livresEnEmprunt = new ArrayList<>();
	}
	
	public void addEmpreint(Livre livre, int duree)
	{
		Date date = new Date();
		Date rendu = new Date();
		
		rendu.setDate(date.getDay() + duree);
		
		Emprunt empreint = new Emprunt(0, this, livre, date, rendu);
		//livres.add(livre);
		livre.setStatus(false);
		livresEnEmprunt.add(empreint);
	}

	public List<Emprunt> getLivresEnEmprunt()
	{
		return livresEnEmprunt;
	}

	public int getIdClient()
	{
		return idClient;
	}

	public void setIdClient(int idClient)
	{
		this.idClient = idClient;
	}

	public Date getDateInscription()
	{
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription)
	{
		this.dateInscription = dateInscription;
	}

	public List<Livre> getLivres()
	{
		return livres;
	}

	public void setLivres(List<Livre> livres)
	{
		this.livres = livres;
	}

	public void setLivresEnEmprunt(List<Emprunt> livresEnEmprunt)
	{
		this.livresEnEmprunt = livresEnEmprunt;
	}


	@Override
	public int compareTo(Client fourn)
	{
		if (this.idClient == fourn.idClient)
			return 0;
		else if (this.idClient < fourn.idClient)
			return 1;
		else
			return -1;
	}
	
	@Override
	public String toString()
	{
		return getNom() + " " + getPrenom();
	}
	
	
}
