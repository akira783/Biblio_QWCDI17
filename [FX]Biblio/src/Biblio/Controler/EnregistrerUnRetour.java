package Biblio.Controler;

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
				System.out.println("Enregistrer les infos de retour dans la bibliotheque");
			}
		});
	}
}
