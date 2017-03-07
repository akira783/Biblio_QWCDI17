package Biblio.Controler;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Biblio.JDBC.JDBC;
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
				EnregitrerUnEmprunt();
				System.out.println("Enregistrer les infos de retour dans la bibliotheque");
			}
		});
	}
	
	public void EnregitrerUnEmprunt()
	{
		try {
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT idEmprunt FROM empruntencours WHERE idUtilisateur = "+ Integer.parseInt(retour.getAdherant().getText()) +" AND idExemplaire = "+ Integer.parseInt(retour.getLivre().getText())+";");
			while(result.next())
			System.out.println(result.getString("idEmprunt"));
		} catch (SQLException e) {
				System.out.println("fail");
		}
	}
}
