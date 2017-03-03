package Biblio.Controler;

import Biblio.View.FenEnregistrerUnEmprunt;
import Biblio.View.FenMenuBibliothecaire;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuBibliothecaire 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 300, 240);
	private FenMenuBibliothecaire fenEmprunt = new FenMenuBibliothecaire();
	
	public MenuBibliothecaire()
	{
		gestionButton();
		
		root.getChildren().add(fenEmprunt);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gestionButton()
	{
		fenEmprunt.getbEmprunter().getbutton().setOnMouseClicked(new EventHandler<MouseEvent>() 
		{

			@Override
			public void handle(MouseEvent event) 
			{
				EnregistrerUnEmprunt emprunt = new EnregistrerUnEmprunt();
			}
		});
		
		fenEmprunt.getbRetour().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("faire la classe controller pour le retour");
				
			}
		});
		
		fenEmprunt.getbGereEmprunt().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("faire la classe controller pour gere les emprunt");
				
			}
		});
	}
}
