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
		 System.out.println("Requ�te en cours...");
		 try {
			Statement st = conn.createStatement();
			
			ResultSet resultat = st.executeQuery("SELECT idUtilisateur, pwd FROM Utilisateur WHERE idUtilisateur = '"+idUtil+"'");
			 
			 while(resultat.next()){
				 
				 String id = resultat.getString( "idUtilisateur" );
	             	           
				 if(id.equals(idUtil)){
					 System.out.println("Trouv� !");
					 nomUtilisateur = resultat.getString("idUtilisateur");
					 this.pwd=resultat.getString("pwd");	 				 
				 }				 
			 }			 
			 if(nomUtilisateur==null) System.out.println("Cette utilisateur n'�xiste pas");
			 else{				 
				 System.out.println(nomUtilisateur);			 
			 }
			 
			 if(this.pwd.equals(pwd)){				 
				 System.out.println("Connection : AUTORIS�E");	
				 return true;
			 }			 
			 else System.out.println("Connection : REFUS�E");	
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
		 
		 checkStatusExemplaire(Integer.parseInt(idExemplaire));
		 
		 try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO biblio.empruntencours (dateEmprunt,idUtilisateur,idExemplaire) VALUES ('"+pickUpDate+"',"+idUtilisateur+","+idExemplaire+");");
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 }

	 
	 public  String checkStatusExemplaire(int idExemplaire){
		 
		 
		 try {
				Statement st = conn.createStatement();
				ResultSet resultat = st.executeQuery("SELECT status FROM exemplaire WHERE idExemplaire = '"+idExemplaire+"'");
				while (resultat.next()){
				String status = resultat.getString("status");
				return status;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		 
		 
		 
		 
		 
	 }
	 
public  void setStatusExemplaire(int i, int idExemplaire){
		String status = null;
	
		 if(i==1) {
			  status = "DISPONIBLE";
					 }
		 
		 if(i==0){
			  status = "PRETE";
		 }
		 
		 if(i== -1){
			 status = "SUPPRIME";
		 }
		 
		 
		 try {
				Statement st = conn.createStatement();
				st.executeUpdate("UPDATE exemplaire SET status = '"+status+"' WHERE idExemplaire = "+idExemplaire+";");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 
		 
		 
	 }
	 
}
