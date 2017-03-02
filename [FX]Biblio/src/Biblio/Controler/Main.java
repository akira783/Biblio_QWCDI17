package Biblio.Controler;
	
import Biblio.View.MenueBibliothecaire;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		
		MenueBibliothecaire  mb = new MenueBibliothecaire();
		
		root.getChildren().add(mb);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
