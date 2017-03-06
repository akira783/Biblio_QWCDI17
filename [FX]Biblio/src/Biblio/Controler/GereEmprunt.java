package Biblio.Controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import Biblio.JDBC.JDBC;
import Biblio.View.FenGereEmprunt;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GereEmprunt 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 400, 400);
	FenGereEmprunt emprunt = new FenGereEmprunt();
	private static Connection conn = JDBC.Connect();
	
	public GereEmprunt()
	{
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM biblio.empruntencours;");
			
			while (result.next())
				System.out.println("idutilisateur = " + result.getString("idUtilisateur") + "\nid exemplaire" + result.getString("idExemplaire"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("ajouter les emprunts de la bdd dans la listview");
		
		root.getChildren().add(emprunt);
		stage.setScene(scene);
		stage.show();
	}
}
