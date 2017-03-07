package Biblio.Controler;

import Biblio.JDBC.SQLQuery;
import Biblio.Model.EmpruntEnCours;
import Biblio.Model.Exemplaire;
import Biblio.View.FenConsulterExemplaire;
import Biblio.View.FenGereEmprunt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConsulterExemplaire 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 400, 400);
	FenConsulterExemplaire livre = new FenConsulterExemplaire();
	ObservableList<Exemplaire> listEmprunt = FXCollections.observableArrayList();
	
	public ConsulterExemplaire()
	{
	
		SQLQuery sql = new SQLQuery();
		
		sql.listerExemplaire(listEmprunt, livre);
		
		root.getChildren().add(livre);
		stage.setScene(scene);
		stage.show();
	}
}
