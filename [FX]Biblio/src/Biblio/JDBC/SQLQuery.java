package Biblio.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Biblio.Model.EmpruntEnCours;
import Biblio.View.FenGereEmprunt;
import javafx.collections.ObservableList;

public class SQLQuery 
{
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

	public void gereEmpruntSql(ObservableList<EmpruntEnCours> listEmprunt, FenGereEmprunt emprunt)
	{
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM biblio.empruntencours;");
			
			while (result.next())
			{
				System.out.println("idutilisateur = " + result.getString("idUtilisateur") + "\nid exemplaire" + result.getString("idExemplaire"));
				listEmprunt.add(new EmpruntEnCours(	Integer.parseInt(result.getString("idEmprunt")), 
													result.getString("dateEmprunt"), 
													Integer.parseInt(result.getString("idUtilisateur")), 
													Integer.parseInt(result.getString("idExemplaire"))));
			}
			emprunt.getList().setItems(listEmprunt);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getNbEmprunt(int idUtilisateur){
		
			int i = 0;
			Statement st;
			try {				
				st = conn.createStatement();			
				ResultSet resultat = st.executeQuery("SELECT idUtilisateur FROM empruntencours WHERE idUtilisateur = "+idUtilisateur+"");
				System.out.println("Requete getNbEmprunt : OK");
				while(resultat.next())
					{	
					if (resultat.equals(idUtilisateur)){
					String id = resultat.getString( "idUtilisateur" );
					i++;					
					}
					}
			System.out.println("L'utilisateur : "+ idUtilisateur +" à emprunté "+i+ " livre(s)");
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
			
		
		
		
	}
}
