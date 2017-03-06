package Biblio.View;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FenMenuBibliothecaire extends Parent 
{
	BoutonMenue bEmprunter = new BoutonMenue("Enregistrer un Emprunt");
	BoutonMenue bRetour = new BoutonMenue("Enregistrer un retour");
	BoutonMenue bGereEmprunt = new BoutonMenue("Gérè les emprunt");
	GridPane grid = new GridPane();
	Text titre = new Text("             Menu");

	public FenMenuBibliothecaire()
	{
		titre.setFont(new Font(30));
		
		grid.add(titre, 0, 0);
		grid.add(bEmprunter, 0, 1);
		grid.add(bRetour, 0, 2);
		grid.add(bGereEmprunt, 0, 3);
		grid.setVgap(30);
		grid.setLayoutX(50);
		grid.setLayoutY(60);

		this.getChildren().add(grid);
	}

	public BoutonMenue getbEmprunter() {
		return bEmprunter;
	}

	public void setbEmprunter(BoutonMenue bEmprunter) {
		this.bEmprunter = bEmprunter;
	}

	public BoutonMenue getbRetour() {
		return bRetour;
	}

	public void setbRetour(BoutonMenue bRetour) {
		this.bRetour = bRetour;
	}

	public BoutonMenue getbGereEmprunt() {
		return bGereEmprunt;
	}

	public void setbGereEmprunt(BoutonMenue bGereEmprunt) {
		this.bGereEmprunt = bGereEmprunt;
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public Text getTitre() {
		return titre;
	}

	public void setTitre(Text titre) {
		this.titre = titre;
	}
}
