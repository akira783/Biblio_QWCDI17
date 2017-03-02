package Biblio.Model;

public class BiblioException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  BiblioException()
	{
		super("Le bug vien de la bibliotheque");
	}
	
	public	BiblioException(String msg)
	{
		super(msg);
	}
	
	

}
