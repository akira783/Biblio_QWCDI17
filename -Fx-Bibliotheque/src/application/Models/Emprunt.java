package application.Models;

import java.util.Date;

public class Emprunt implements Comparable<Emprunt>
{
	private int		idEmpreint;
	private Client	client;
	private Livre	livre;
	private Date	dateEmpreint;
	private	Date	dateRendue;
	
	public Emprunt()
	{
		
	}

	public Emprunt(int idEmpreint, Client client, Livre livre, Date dateEmpreint, Date dateRendue) 
	{
		this.idEmpreint = idEmpreint;
		this.client = client;
		this.livre = livre;
		this.dateEmpreint = dateEmpreint;
		this.dateRendue = dateRendue;
	}
	
	@Override
	public String toString()
	{
		return client.getPrenom() + " a emprunter " + livre.getTitre();
	}

	public int getIdEmpreint()
	{
		return idEmpreint;
	}

	public void setIdEmpreint(int idEmpreint)
	{
		this.idEmpreint = idEmpreint;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public Livre getLivre()
	{
		return livre;
	}

	public void setLivre(Livre livre)
	{
		this.livre = livre;
	}

	public Date getDateEmpreint()
	{
		return dateEmpreint;
	}

	public void setDateEmpreint(Date dateEmpreint)
	{
		this.dateEmpreint = dateEmpreint;
	}

	public Date getDateRendue()
	{
		return dateRendue;
	}

	public void setDateRendue(Date dateRendue)
	{
		this.dateRendue = dateRendue;
	}
	
	@Override
	public int compareTo(Emprunt fourn)
	{
		if (this.idEmpreint == fourn.idEmpreint)
		return 0;
	else if (this.idEmpreint < fourn.idEmpreint)
		return 1;
	else
		return -1;
	}

	
	
}
