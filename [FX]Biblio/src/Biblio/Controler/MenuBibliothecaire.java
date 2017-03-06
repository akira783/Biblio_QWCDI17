package Biblio.Controler;

import Biblio.View.FenEnregistrerUnEmprunt;
import Biblio.View.FenMenuBibliothecaire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuBibliothecaire 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 400, 400);
	private FenMenuBibliothecaire fenEmprunt = new FenMenuBibliothecaire();
	
	public MenuBibliothecaire()
	{
		gestionKeyButton();
		gestionClickButton();
		
		root.getChildren().add(fenEmprunt);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gestionClickButton()
	{
		fenEmprunt.getbEmprunter().getbutton().setOnMouseClicked(new EventHandler<MouseEvent>() 
		{

			@Override
			public void handle(MouseEvent event) 
			{
				EnregistrerUnEmprunt emprunt = new EnregistrerUnEmprunt();
			}
		});
		
		fenEmprunt.getbRetour().getbutton().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				EnregistrerUnRetour retour = new EnregistrerUnRetour();
			}
		});
		
		fenEmprunt.getbGereEmprunt().getbutton().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				GereEmprunt emprunt = new GereEmprunt();
			}
		});
		
		fenEmprunt.getbQuit().getbutton().setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
					stage.close();
			}
		});
	}
	
	public void gestionKeyButton()
	{
		fenEmprunt.getbEmprunter().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
					EnregistrerUnEmprunt emprunt = new EnregistrerUnEmprunt();
				}
				
			}
		});

		fenEmprunt.getbGereEmprunt().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
				GereEmprunt emprunt = new GereEmprunt();
				}
			}
		});
		
		fenEmprunt.getbRetour().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
				EnregistrerUnRetour retour = new EnregistrerUnRetour();
				}
			}
		});
		
		fenEmprunt.getbQuit().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
				stage.close();
				}
			}
		});
	}
}
