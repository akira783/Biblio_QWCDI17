package Biblio.Model;

import java.util.Date;

public class Adherant extends Utilisateur 
{
	private String	telephone;
	private int		nbMaxPrets = 3;
	private int		dureeMaxPrets;
	
	public Adherant(String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, String pwd,
			String pseudonyme, String telephone, int nbMaxPrets, int dureeMaxPrets) 
	{
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.telephone = telephone;
		this.nbMaxPrets = nbMaxPrets;
		this.dureeMaxPrets = dureeMaxPrets;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getNbMaxPrets() {
		return nbMaxPrets;
	}

	public void setNbMaxPrets(int nbMaxPrets) {
		this.nbMaxPrets = nbMaxPrets;
	}

	public int getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	public void setDureeMaxPrets(int dureeMaxPrets) {
		this.dureeMaxPrets = dureeMaxPrets;
	}
}
