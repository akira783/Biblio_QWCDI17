package Biblio.View;

import com.sun.javafx.geom.Rectangle;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BoutonMenue extends Parent
{
	Button button = new Button();
	public BoutonMenue(String text)
	{
	
		button.setText(text);
		button.setPrefSize(300, 50);
		this.getChildren().add(button);
	}
	
	public Button getbutton()
	{
		return button;
	}
}
