package Biblio.Controler;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Biblio.JDBC.JDBC;
import Biblio.Model.EmpruntArchive;
import Biblio.View.FenEnregistrerUnRetour;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EnregistrerUnRetour 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 300, 240);
	private FenEnregistrerUnRetour retour = new FenEnregistrerUnRetour();
	private	Connection conn = JDBC.Connect();
	
	public EnregistrerUnRetour()
	{
		gestionBouttons();
		
		root.getChildren().add(retour);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gestionBouttons()
	{
		retour.getbAnnuler().setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				stage.close();
			}
		});
		
		retour.getbEnregistrer().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				EnregistrerUnEmprunt();
				System.out.println("Enregistrer les infos de retour dans la bibliotheque");
			}
		});
	}
	
	public void EnregistrerUnEmprunt()
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
}
