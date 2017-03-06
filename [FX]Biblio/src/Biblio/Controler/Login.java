package Biblio.Controler;

import Biblio.JDBC.SQLQuery;
import Biblio.View.FenLogin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login 
{
	Stage stage = new Stage();
	Group root = new Group();
	Scene scene = new Scene(root, 300, 275);
	
	public Login()
	{
		FenLogin login = new FenLogin();
		
		
        login.getBtn().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
           	 SQLQuery f = new SQLQuery();
           	 boolean ack = f.checkLog(login.getUserTextField().getText(), login.getPwBox().getText());
           	 if(ack){

                    MenuBibliothecaire mb = new MenuBibliothecaire();
                    stage.close();
           	 }
           	 
           	 else{
           		 login.getActiontarget().setFill(Color.RED);
                    login.getActiontarget().setText("Connection Refusée :(");
           	 }
           	 
            }
        });

		root.getChildren().add(login);
		stage.setTitle("Login");    
		stage.setScene(scene);
        stage.show();
	}
}
