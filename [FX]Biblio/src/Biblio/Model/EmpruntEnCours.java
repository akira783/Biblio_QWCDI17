package Biblio.Model;

import java.util.Date;

public class EmpruntEnCours 
{
	private int		idEmprunt;
	private Date	DateEmprunt;
	
	public EmpruntEnCours(int idEmprunt, Date dateEmprunt) 
	{
		this.idEmprunt = idEmprunt;
		DateEmprunt = dateEmprunt;
	}

	public int getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public Date getDateEmprunt() {
		return DateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}

	
	
}
