package Biblio.View;

import Biblio.Model.EmpruntEnCours;
import Biblio.Model.Exemplaire;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FenConsulterExemplaire extends Parent 
{
	ListView<Exemplaire> list = new ListView<Exemplaire>();
	private Text		titre = new Text("Consulter les Exemplaires");
	
	public FenConsulterExemplaire()
	{
		titre.setFont(new Font(20));
		titre.setLayoutX(100);
		titre.setLayoutY(40);
		
	
		list.setPrefSize(380, 330);
		list.setLayoutX(10);
		list.setLayoutY(60);
	
	this.getChildren().add(list);
	this.getChildren().add(titre);
		
	}
	public ListView<Exemplaire> getList() {
		return list;
	}

	public void setList(ListView<Exemplaire> list) {
		this.list = list;
	}

	public Text getTitre() {
		return titre;
	}

	public void setTitre(Text titre) {
		this.titre = titre;
	}
	
	
}
