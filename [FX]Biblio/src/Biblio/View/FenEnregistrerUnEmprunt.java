package Biblio.View;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FenEnregistrerUnEmprunt extends Parent 
{
	private Button		bEnregistrer = new Button("Enregistrer");
	private Button		bAnnuler = new Button("Annuler");
	private GridPane	grid = new GridPane();
	private Text		titre = new Text("Enregistrer un emprunt");
	private TextField	adherant = new TextField(); 
	private TextField	livre = new TextField();
	private DatePicker	date = new DatePicker();
	
	public FenEnregistrerUnEmprunt()
	{
	
		bEnregistrer.setLayoutY(200);
		bEnregistrer.setLayoutX(150);
		
		bAnnuler.setLayoutX(230);
		bAnnuler.setLayoutY(200);
		
		titre.setFont(new Font(20));
		titre.setLayoutX(45);
		titre.setLayoutY(40);
		
		grid.setVgap(10);
		grid.setHgap(5);
		grid.setLayoutY(60);
		grid.setLayoutX(25);
		
		grid.add(new Text("ID Adherant"), 0, 1);
		grid.add(new Text("ID Livre"), 0, 2);
		grid.add(new Text("Date de retour"), 0, 3);
		grid.add(adherant, 1, 1);
		grid.add(livre, 1, 2);
		grid.add(date, 1, 3);
		
		this.getChildren().add(bAnnuler);
		this.getChildren().add(bEnregistrer);
		this.getChildren().add(titre);
		this.getChildren().add(grid);
	}

	public Button getbEnregistrer() {
		return bEnregistrer;
	}	

	public Button getbAnnuler() {
		return bAnnuler;
	}	

	public GridPane getGrid() {
		return grid;
	}
	
	public Text getTitre() {
		return titre;
	}
	
	public TextField getAdherant() {
		return adherant;
	}

	public TextField getLivre() {
		return livre;
	}

	public DatePicker getDate() {
		
		return date;
	}
		
}
