package application.View;

import java.util.Date;

import application.Models.Client;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddClient extends MainFrame
{
	public AddClient(Stage stage)
	{
		Text 		text = new Text();
		GridPane	grid = new GridPane();
		TextField	idpersonne = new TextField();
		TextField	nom = new TextField();
		TextField	prenom = new TextField();
		TextField	datenaissance = new TextField();
		TextField	age = new TextField();
		TextField	idclient = new TextField();
		Button 		bAppliquer = new Button();
		Button 		bCancel = new Button();
		Button 		bOk = new Button();
		
		text.setFont(Font.font(25));
		text.setText("Ajout d'un Client");
		
		bAppliquer.setText("Applique");
		bCancel.setText("Cancel");
		bOk.setText("Ok");

		grid.add(new Text("id Personne : "), 0, 0);
		grid.add(new Text("Nom : "), 0, 1);
		grid.add(new Text("Prenom : "), 0, 2);
		grid.add(new Text("Date de naissance : "), 0, 3);
		grid.add(new Text("age : "), 0, 4);
		grid.add(new Text("id Client : "), 0, 5);
		
		grid.add(idpersonne, 1, 0);
		grid.add(nom, 1, 1);
		grid.add(prenom, 1, 2);
		grid.add(datenaissance, 1, 3);
		grid.add(age, 1, 4);
		grid.add(idclient, 1, 5);
		grid.add(bAppliquer, 2, 7);
		grid.add(bCancel, 3, 7);
		grid.add(bOk, 4, 7);

		grid.setVgap(10);
		grid.setHgap(10);
		grid.setLayoutX(50);
		grid.setLayoutY(100);
	
		text.setLayoutX(150);
		text.setLayoutY(30);
		
		bCancel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				stage.close();
			}	
		});

		bOk.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				Client client = new application.Models.Client(Integer.parseInt(idpersonne.getText()),
							nom.getText(), prenom.getText(), Integer.parseInt(age.getText()),
							new Date(), Integer.parseInt(idclient.getText()), null, null, null);
				addClientList(client);
				MainFrame mf = new MainFrame();
				stage.close();
			}	
		});
		
		bAppliquer.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				Client client = new application.Models.Client(Integer.parseInt(idpersonne.getText()),
						nom.getText(), prenom.getText(), Integer.parseInt(age.getText()),
						new Date(), Integer.parseInt(idclient.getText()), null, null, null);
				addClientList(client);
				MainFrame mf = new MainFrame();
				stage.close();
			}	
		});
		this.getChildren().add(text);
		this.getChildren().add(grid);
	}
}
