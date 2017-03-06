package Biblio.Controler;

import Biblio.View.FenEnregistrerUnEmprunt;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EnregistrerUnEmprunt 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 300, 240);
	private FenEnregistrerUnEmprunt fenEmprunt = new FenEnregistrerUnEmprunt();
	
	public EnregistrerUnEmprunt()
	{
		gestionBouttons();
		
		root.getChildren().add(fenEmprunt);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gestionBouttons()
	{
		fenEmprunt.getbAnnuler().setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				stage.close();
			}
		});
		
		fenEmprunt.getbEnregistrer().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Enregistrer les infos de l'emprunt dans la bibliotheque");
			}
		});
		
		fenEmprunt.getLivre().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
					
				}
			}
		});
	}
}
