package Biblio.View;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenueBibliothecaire extends Parent 
{
	public MenueBibliothecaire(Stage old)
	{
		BoutonMenue bEmprunter = new BoutonMenue("Enregistrer un Emprunt");
		BoutonMenue bRetour = new BoutonMenue("Enregistrer un retour");
		BoutonMenue bGereEmprunt = new BoutonMenue("Gérè les emprunt");
		GridPane grid = new GridPane();
		Text titre = new Text("             Menu");
		
		titre.setFont(new Font(30));
		
		
		bEmprunter.getbutton().setOnMouseClicked(new EventHandler<MouseEvent>() 
		{

			@Override
			public void handle(MouseEvent event) 
			{
				System.out.println("passe");
				BorderPane root = new BorderPane();
				Stage stage = new Stage();
				Scene scene = new Scene(root, 500, 400);
				
				EnregistrerUnEmprunt emprunt = new EnregistrerUnEmprunt();
				
				root.getChildren().add(emprunt);
				stage.setScene(scene);
				stage.show();
			}
		});
		
		grid.add(titre, 0, 0);
		grid.add(bEmprunter, 0, 1);
		grid.add(bRetour, 0, 2);
		grid.add(bGereEmprunt, 0, 3);
		grid.setVgap(30);
		grid.setLayoutX(50);
		grid.setLayoutY(60);
		
		
		this.getChildren().add(grid);
	}
}
