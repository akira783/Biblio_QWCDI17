package Biblio.Controler;

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
	
	public GereEmprunt()
	{
		
		root.getChildren().add(emprunt);
		stage.setScene(scene);
		stage.show();
	}
}
