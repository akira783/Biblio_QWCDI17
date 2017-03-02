package Biblio.View;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class MenueBibliothecaire extends Parent 
{
	public MenueBibliothecaire()
	{
		BoutonMenue bEmprunter = new BoutonMenue("Faire un Emprunt");
		BoutonMenue bRetour = new BoutonMenue("");
		BoutonMenue bGereEmprunt = new BoutonMenue("Emprunter");
		GridPane grid = new GridPane();
		
		grid.add(bEmprunter, 0, 0);
		grid.add(bRetour, 0, 1);
		grid.add(bGereEmprunt, 0, 2);
		
		this.getChildren().add(grid);
	}
}
