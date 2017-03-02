package Biblio.Model;

import java.util.Date;

public class EmpruntEnCours 
{
	private Date	DateEmprunt;

	public EmpruntEnCours(Date dateEmprunt) 
	{
		DateEmprunt = dateEmprunt;
	}

	public Date getDateEmprunt() {
		return DateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}
}
