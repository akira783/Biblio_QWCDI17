package Biblio.View;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;

public class EnregistrerUnEmprunt extends Parent 
{
	public EnregistrerUnEmprunt()
	{
		GridPane grid = new GridPane();
		TextField id = new TextField("idUtilisateur"); 
		TextField pwd = new TextField("Mot de passe");
		
		grid.add(id, 0, 0);
		grid.add(pwd, 0, 1);
		
		id.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent event) 
			{
				if (id.getText() == null)
					id.setText("idUtilisateur");
				id.setText("");
			}
		});
		
		
		pwd.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent event) 
			{
				pwd.setText("");
			}
		});
		
		
		this.getChildren().add(grid);
	}
}
