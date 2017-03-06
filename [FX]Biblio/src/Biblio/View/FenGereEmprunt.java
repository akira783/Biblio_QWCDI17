package Biblio.View;

import Biblio.Model.EmpruntEnCours;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FenGereEmprunt extends Parent 
{
	ListView list = new ListView<EmpruntEnCours>();
	private Text		titre = new Text("Gere les Emprunts");
	
	public  FenGereEmprunt()
	{
		
		titre.setFont(new Font(20));
		titre.setLayoutX(45);
		titre.setLayoutY(40);
		
		list.setLayoutX(10);
		list.setLayoutY(60);
		
		this.getChildren().add(list);
		this.getChildren().add(titre);
	}
}
