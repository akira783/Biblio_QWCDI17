package Biblio.Controler;

import Biblio.View.FenEnregistrerUnRetour;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnregistrerUnRetour 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 300, 240);
	
	public EnregistrerUnRetour()
	{
		FenEnregistrerUnRetour retour = new FenEnregistrerUnRetour();
		
		root.getChildren().add(retour);
		stage.setScene(scene);
		stage.show();
	}
}
