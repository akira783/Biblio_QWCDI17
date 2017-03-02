package Biblio.Model;

import java.util.Date;

public class EmpruntArchive 
{
	private Date	dateRestitutionEff;
	private Date	dateEmprunt;
	
	public EmpruntArchive(Date dateRestitutionEff, Date dateEmprunt) 
	{
		this.dateRestitutionEff = dateRestitutionEff;
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
}
