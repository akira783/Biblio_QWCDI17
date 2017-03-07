package Biblio.Model;

import java.util.Date;

public class EmpruntArchive 
{
	private String	dateRestitutionEff;
	private String	dateEmprunt;
	private int		idUtlisateur;
	private int		idExemplaire;
	
	public EmpruntArchive()
	{
		
		
	}
	
	public EmpruntArchive(String dateRestitutionEff, String dateEmprunt, int idExemplaire, int idUtlisateur) 
	{
		this.dateRestitutionEff = dateRestitutionEff;
		this.dateEmprunt = dateEmprunt;
		this.idUtlisateur = idUtlisateur;
		this.idExemplaire = idExemplaire;
	}

	public String getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(String dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public String getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(String dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public int getIdUtlisateur() {
		return idUtlisateur;
	}

	public void setIdUtlisateur(int idUtlisateur) {
		this.idUtlisateur = idUtlisateur;
	}

	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	
	
}
