package Biblio.Controler;


	
import Biblio.View.FenMenuBibliothecaire;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import Biblio.View.Login;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		
		MenuBibliothecaire  mb = new MenuBibliothecaire();

		
		//root.getChildren().add(mb);
		
	
	//	Login l = new Login();
		
//		l.start(primaryStage);
		
	}	
	public static void main(String[] args) {
		launch(args);
	}
}
