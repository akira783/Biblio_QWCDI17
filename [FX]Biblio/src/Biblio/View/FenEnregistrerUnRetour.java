package Biblio.View;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FenEnregistrerUnRetour extends Parent
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root);
	
	public FenEnregistrerUnRetour()
	{
		stage.setScene(scene);
		stage.show();
	}
}
