package Biblio.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FenLogin extends Parent
{
    GridPane grid = new GridPane();
    Text scenetitle = new Text("      Connecte toi  !");
    Label userName = new Label("ID:");
    TextField userTextField = new TextField();
    Label pw = new Label("Password:");
    Button btn = new Button("Connection");
    HBox hbBtn = new HBox(10);
    final Text actiontarget = new Text();
    PasswordField pwBox = new PasswordField();
    
    public FenLogin()
    {
    	grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));

	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 2, 1);
	    grid.add(userName, 0, 1);
	    grid.add(userTextField, 1, 1);
	    grid.add(pw, 0, 2);
	    grid.add(pwBox, 1, 2);

	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        grid.add(actiontarget, 1, 6);
        
        this.getChildren().add(grid);
	}

	public Button getBtn() {
		return btn;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public Text getScenetitle() {
		return scenetitle;
	}

	public void setScenetitle(Text scenetitle) {
		this.scenetitle = scenetitle;
	}

	public Label getUserName() {
		return userName;
	}

	public void setUserName(Label userName) {
		this.userName = userName;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(TextField userTextField) {
		this.userTextField = userTextField;
	}

	public Label getPw() {
		return pw;
	}

	public void setPw(Label pw) {
		this.pw = pw;
	}

	public HBox getHbBtn() {
		return hbBtn;
	}

	public void setHbBtn(HBox hbBtn) {
		this.hbBtn = hbBtn;
	}

	public PasswordField getPwBox() {
		return pwBox;
	}

	public void setPwBox(PasswordField pwBox) {
		this.pwBox = pwBox;
	}

	public Text getActiontarget() {
		return actiontarget;
	}

	
    
}