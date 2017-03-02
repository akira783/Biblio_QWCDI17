package Biblio.View;

import com.sun.javafx.geom.Rectangle;

import javafx.scene.Parent;
import javafx.scene.control.Button;

public class BoutonMenue extends Parent
{
	public BoutonMenue(String text)
	{
		Button button = new Button(text);
	
		this.getChildren().add(button);
	}
}
