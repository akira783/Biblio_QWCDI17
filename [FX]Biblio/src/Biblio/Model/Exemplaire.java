package Biblio.Model;

import java.util.Date;

public class Exemplaire 
{
	private int		idExemplaire;
	private	String	dateAchat;
	private	String	isbn;
	private EnumStatusExemplaire status;
	
	public Exemplaire(int idExemplaire, String dateAchat, String isbn, EnumStatusExemplaire status) 
	{
		this.idExemplaire = idExemplaire;
		this.dateAchat = dateAchat;
		this.isbn = isbn;
		this.status = status;
	}

	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public String getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public EnumStatusExemplaire getStatus() {
		return status;
	}

	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}
	
	@Override
	public String toString()
	{
		return "idExemplaire = " + idExemplaire + " dateAchat = " + dateAchat + " \nstatus = " + status.name() + " isbn = " + isbn;
	}
}
