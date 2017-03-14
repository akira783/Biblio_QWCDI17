package Biblio.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Biblio.Model.EmpruntArchive;
import Biblio.Model.EmpruntEnCours;
import Biblio.Model.EnumStatusExemplaire;
import Biblio.Model.Exemplaire;
import Biblio.View.FenConsulterExemplaire;
import Biblio.View.FenEnregistrerUnRetour;
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


	public int getNbEmprunt(int idUtilisateur){
		
			int i = 0;
			Statement st;
			try {				
				st = conn.createStatement();			
				ResultSet resultat = st.executeQuery("SELECT COUNT(*) AS nbEmprunt FROM empruntencours WHERE idUtilisateur = "+idUtilisateur+";");
				
					while(resultat.next()){						
						System.out.println(resultat.getString("nbEmprunt"));
						i = Integer.parseInt(resultat.getString("nbEmprunt"));
					}
			
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("L'utilisateur : "+ idUtilisateur +" à emprunté "+i+ " livre(s)");
			return i;
			
		
		
		
	}
	
	
	public void setDispoAll(){
		
		Statement st;
		try {				
			st = conn.createStatement();			
			st.executeUpdate("UPDATE exemplaire SET status = 'DISPONIBLE';");
			System.out.println("Requete setDispoAll : OK");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void EnregistrerUnRetour(FenEnregistrerUnRetour retour)
	{
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());								
		
		
			Statement st;
			ResultSet result;
			String idemprunt = "";
			
			try {
				EmpruntArchive empruntArchive = new EmpruntArchive();
				st = conn.createStatement();
				result = st.executeQuery("SELECT * FROM empruntencours WHERE idUtilisateur = "+ Integer.parseInt(retour.getAdherant().getText()) +" AND idExemplaire = "+ Integer.parseInt(retour.getLivre().getText())+";");
				while(result.next())
					{
							empruntArchive = new EmpruntArchive(timeStamp, result.getString("dateEmprunt"), Integer.parseInt(result.getString("idExemplaire")), Integer.parseInt(result.getString("idUtilisateur")));
							idemprunt = result.getString("idEmprunt");
					}
				st.executeUpdate("insert into biblio.empruntarchive (dateEmprunt, dateRestitutionEff, idExemplaire, idUtilisateur)"+ 
								"VALUES ('" + empruntArchive.getDateEmprunt() + "'," +
								"'" + empruntArchive.getDateRestitutionEff() +
								"', " + empruntArchive.getIdExemplaire() +
								", " + empruntArchive.getIdUtlisateur()+ ");");
				st.executeUpdate("UPDATE exemplaire SET status = 'DISPONIBLE' where idExemplaire = " + empruntArchive.getIdExemplaire() + ";");
				st.executeUpdate("DELETE FROM empruntencours where idEmprunt = " + idemprunt + ";");
				
	
			} catch (SQLException e) {
				
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

	public void listerExemplaire(ObservableList<Exemplaire> listLivre, FenConsulterExemplaire livre)
	{
		try {
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM biblio.Exemplaire;");
			while (result.next())
			listLivre.add(new Exemplaire(Integer.parseInt(result.getString("idExemplaire")), 
										result.getString("dateAchat"), 
										result.getString("isbn"), 
										findnumm(result.getString("status"))));
			livre.getList().setItems(listLivre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EnumStatusExemplaire findnumm(String enumm)
	{
		if (enumm.equals("DISPONIBLE"))
			return EnumStatusExemplaire.DISPONIBLE;
		else if (enumm.equals("PRETE"))
			return EnumStatusExemplaire.PRETE;
		else
			return EnumStatusExemplaire.SUPPRIME;
	}

	public void getDateEmprunt(int idUtilisateur){
		
		try {
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT dateEmprunt FROM biblio.empruntencours WHERE idUtilisateur = "+idUtilisateur+";");
			while (result.next()){
				
				System.out.println(result.getString("dateEmprunt"));
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
	}
public boolean isLate(int idUtilisateur) {
		
		boolean bool = false;
			Statement st;
			try {
				st = conn.createStatement();
			
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("nous sommes le : "+df.format(today));
			
			ResultSet result = st.executeQuery("SELECT dateEmprunt,idExemplaire FROM biblio.empruntencours WHERE idUtilisateur = "+idUtilisateur+";");
			
			while (result.next()){
				
				
				String date = result.getString("dateEmprunt");
				String ide= result.getString("idExemplaire");
				Date res;
				
				try {
					res = df.parse(date);
					System.out.println(df.format(res));
					int t = dateDiff(today, res);
					if (t>15){
						bool = true;
						System.out.println("Exemplaire n°"+ide+" en retard de "+t+" jours !");
						
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 
			
				
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return bool;}
		
			public int dateDiff(Date debut, Date fin) {
			
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Statement st = conn.createStatement();
				ResultSet result2 = st.executeQuery("SELECT DATEDIFF('"+df.format(debut)+"', '"+df.format(fin)+"') AS datediff;");
				while (result2.next()){
					
					return Integer.parseInt(result2.getString("datediff"));
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
			
			
		 
	
		
		}
	}
	

