package application;
	
import application.View.MainFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		Stage window = new Stage();
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid,1300,650);

		window.setScene(scene);
		MainFrame mf = new MainFrame(window);
			
		grid.getChildren().add(mf);
		scene.getStylesheets().add("Viper.css");
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}