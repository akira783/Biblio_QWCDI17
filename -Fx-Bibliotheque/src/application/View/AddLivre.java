package application.View;




import java.util.Date;
import application.Models.Livre;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddLivre extends MainFrame
{
	public AddLivre(Stage stage)
	{
		Text 		text = new Text();
		GridPane	grid = new GridPane();
		TextField	titre = new TextField();
		TextField	id = new TextField();
		TextField	edition = new TextField();
		TextField	dateParution = new TextField();
		TextField	type = new TextField();
		TextField	nbPage = new TextField();
		TextField	categorie = new TextField();
		Button 		bAppliquer = new Button();
		Button 		bCancel = new Button();
		Button 		bOk = new Button();
		
		text.setFont(Font.font(25));
		text.setText("Ajout d'un livre");
		
		bAppliquer.setText("Applique");
		bCancel.setText("Cancel");
		bOk.setText("Ok");
		
		grid.add(new Text("Titre : "), 0, 0);
		grid.add(new Text("ID : "), 0, 1);
		grid.add(new Text("Edition : "), 0, 2);
		grid.add(new Text("Date de parution : "), 0, 3);
		grid.add(new Text("Type : "), 0, 4);
		grid.add(new Text("Nombre de page : "), 0, 5);
		grid.add(new Text("Categorie : "), 0, 6);

		grid.add(titre, 1, 0);
		grid.add(id, 1, 1);
		grid.add(edition, 1, 2);
		grid.add(dateParution, 1, 3);
		grid.add(type, 1, 4);
		grid.add(nbPage, 1, 5);
		grid.add(categorie, 1, 6);
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
				Livre livre = new Livre(Integer.parseInt(id.getText()), Integer.parseInt(nbPage.getText()),
						titre.getText(), edition.getText(), categorie.getText(), type.getText(), 
						true, false, new Date());
				addLivreList(livre);
				MainFrame mf = new MainFrame();
				stage.close();
			}	
		});
		
		bAppliquer.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				Livre livre = new Livre(Integer.parseInt(id.getText()), Integer.parseInt(nbPage.getText()),
						titre.getText(), edition.getText(), categorie.getText(), type.getText(), 
						true, false, new Date());
				addLivreList(livre);
				MainFrame mf = new MainFrame();
			}	
		});
		this.getChildren().add(text);
		this.getChildren().add(grid);
		//this.getChildren().add(button);
	}
}
