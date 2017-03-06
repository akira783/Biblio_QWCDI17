package Biblio.Controler;

import Biblio.JDBC.SQLQuery;
import Biblio.Model.EmpruntEnCours;
import Biblio.View.FenGereEmprunt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GereEmprunt 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 400, 400);
	FenGereEmprunt emprunt = new FenGereEmprunt();
	ObservableList<EmpruntEnCours> listEmprunt = FXCollections.observableArrayList();
	
	public GereEmprunt()
	{
		SQLQuery sql = new SQLQuery();
		
		sql.gereEmpruntSql(listEmprunt, emprunt);

		root.getChildren().add(emprunt);
		stage.setScene(scene);
		stage.show();
	}
}
