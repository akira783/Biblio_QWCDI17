package Biblio.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQuery {


	private  Connection conn = JDBC.Connect();;	
	private String nomUtilisateur, pwd;
	 
	
	 
	 public boolean checkLog(String idUtil, String pwd){
		 
		 System.out.println("id :"+idUtil);
		 System.out.println("pwd :"+pwd);
		 System.out.println("Requête en cours...");
		 try {
			Statement st = conn.createStatement();
			
			ResultSet resultat = st.executeQuery("SELECT idUtilisateur, pwd FROM Utilisateur WHERE idUtilisateur = '"+idUtil+"'");
			 
			 while(resultat.next()){
				 
				 String id = resultat.getString( "idUtilisateur" );
	             	           
				 if(id.equals(idUtil)){
					 System.out.println("Trouvé !");
					 nomUtilisateur = resultat.getString("idUtilisateur");
					 this.pwd=resultat.getString("pwd");	 				 
				 }				 
			 }			 
			 if(nomUtilisateur==null) System.out.println("Cette utilisateur n'éxiste pas");
			 else{				 
				 System.out.println(nomUtilisateur);			 
			 }
			 
			 if(this.pwd.equals(pwd)){				 
				 System.out.println("Connection : AUTORISÉE");	
				 return true;
			 }			 
			 else System.out.println("Connection : REFUSÉE");	
			 return false;
			 
			 
			
		 } 
			 
		 catch (java.lang.NullPointerException e) {
			 System.out.println("nullptexcept");
			}
		 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return false;
		 
}
	 
	 public void setEmpruntEnCours(String pickUpDate ,String idUtilisateur ,String idExemplaire){
		 
		 try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO empruntencours (dateEmprunt,idUtilisateur,idExemplaire) VALUES ('"+pickUpDate+"',"+idUtilisateur+","+idExemplaire+";");
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 }

}
