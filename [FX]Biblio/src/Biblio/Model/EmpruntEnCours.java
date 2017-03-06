package Biblio.Model;

public class EmpruntEnCours 
{
	private int		idEmprunt;
	private String	DateEmprunt;
	private int		idUtilisateur;
	private int 	idExemplaire;
	
	public EmpruntEnCours(int idEmprunt, String dateEmprunt, int idUtilisateur, int idExemplaire) 
	{
		this.idEmprunt = idEmprunt;
		DateEmprunt = dateEmprunt;
		this.idUtilisateur = idUtilisateur;
		this.idExemplaire = idExemplaire;
	}

	public int getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public String getDateEmprunt() {
		return DateEmprunt;
	}

	public void setDateEmprunt(String dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	
	@Override
	public String toString()
	{
		return "IdAdherant = " + idUtilisateur + "\tIdLivre = " + idExemplaire + "\t date = " + DateEmprunt;
	}
}
