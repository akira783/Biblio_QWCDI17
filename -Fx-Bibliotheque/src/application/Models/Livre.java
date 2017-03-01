package application.Models;

import java.util.Date;


public class Livre implements Comparable<Livre>
{
	private int 	idLivre;
	private int 	nbPage;
	private String 	titre;
	private String	edition;
	private String	categorie;
	private String	type;
	private boolean status;
	private boolean retard;
	private Date	dateDeParution;
	
	public Livre()
	{
		titre = "INCONNUE";
	}

	public Livre(int idLivre, int nbPage, String titre, String edition, String categorie,
			String type, boolean status, boolean retard, Date dateDeParution) 
	{
		this.idLivre = idLivre;
		this.nbPage = nbPage;
		this.titre = titre;
		this.edition = edition;
		this.categorie = categorie;
		this.type = type;
		this.status = status;
		this.retard = retard;
		this.dateDeParution = dateDeParution;
	}
	
	@Override
	public String toString()
	{
		return titre;
	}

	public int getIdLivre()
	{
		return idLivre;
	}

	public void setIdLivre(int idLivre)
	{
		this.idLivre = idLivre;
	}

	public int getNbPage()
	{
		return nbPage;
	}

	public void setNbPage(int nbPage)
	{
		this.nbPage = nbPage;
	}

	public String getTitre()
	{
		return titre;
	}

	public void setTitre(String titre)
	{
		this.titre = titre;
	}

	public String getEdition()
	{
		return edition;
	}

	public void setEdition(String edition)
	{
		this.edition = edition;
	}

	public String getCategorie()
	{
		return categorie;
	}

	public void setCategorie(String categorie)
	{
		this.categorie = categorie;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public boolean isStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public boolean isRetard()
	{
		return retard;
	}

	public void setRetard(boolean retard)
	{
		this.retard = retard;
	}

	public Date getDateDeParution()
	{
		return dateDeParution;
	}

	public void setDateDeParution(Date dateDeParution)
	{
		this.dateDeParution = dateDeParution;
	}
	
	@Override
	public int compareTo(Livre fourn)
	{
		if (this.idLivre == fourn.idLivre)
		return 0;
	else if (this.idLivre < fourn.idLivre)
		return 1;
	else
		return -1;
	}
}
