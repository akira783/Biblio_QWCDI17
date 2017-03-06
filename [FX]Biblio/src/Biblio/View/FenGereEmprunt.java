package Biblio.View;

import Biblio.Model.EmpruntEnCours;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FenGereEmprunt extends Parent 
{
	ListView<EmpruntEnCours> list = new ListView<EmpruntEnCours>();
	private Text		titre = new Text("Gere les Emprunts");
	
	public  FenGereEmprunt()
	{
		titre.setFont(new Font(20));
		titre.setLayoutX(110);
		titre.setLayoutY(40);
		
		list.setPrefSize(380, 330);
		list.setLayoutX(10);
		list.setLayoutY(60);
		
		this.getChildren().add(list);
		this.getChildren().add(titre);
	}

	public ListView<EmpruntEnCours> getList() {
		return list;
	}

	public void setList(ListView<EmpruntEnCours> list) {
		this.list = list;
	}

	public Text getTitre() {
		return titre;
	}

	public void setTitre(Text titre) {
		this.titre = titre;
	}
}
