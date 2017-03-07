package Biblio.View;

import javafx.scene.Parent;
import javafx.scene.control.Button;

public class BoutonMenue extends Parent
{
	static int x = 2;
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
