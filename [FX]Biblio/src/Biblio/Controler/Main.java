package Biblio.Controler;
	
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
		
		Text	text = new Text("Bibliotheque");
		System.out.println("hello cul");
		text.setLayoutX(0);
		text.setLayoutY(0);
		text.resize(100, 100);
		
		root.getChildren().add(text);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
