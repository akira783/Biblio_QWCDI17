package Biblio.Controler;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import Biblio.JDBC.SQLQuery;
import Biblio.View.FenEnregistrerUnEmprunt;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EnregistrerUnEmprunt 
{
	private Stage stage = new Stage();
	private Group root = new Group();
	private Scene scene = new Scene(root, 300, 240);
	private FenEnregistrerUnEmprunt fenEmprunt = new FenEnregistrerUnEmprunt();
	private SQLQuery sqlq = new SQLQuery();
	
	public EnregistrerUnEmprunt()
	{
		gestionBouttons();
		
		root.getChildren().add(fenEmprunt);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gestionBouttons()
	{
		fenEmprunt.getbAnnuler().setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				stage.close();
			}
		});
		
		fenEmprunt.getbEnregistrer().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				
				
				System.out.println(timeStamp);
				
				String idLivre = fenEmprunt.getLivre().getText();
				String idAdherent = fenEmprunt.getAdherant().getText();
				System.out.println(idLivre);
				System.out.println(idAdherent);
				sqlq.setEmpruntEnCours(timeStamp, idLivre, idAdherent);
				
				
			}
		});
		
		fenEmprunt.getLivre().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
					
				}
			}
		});
	}
}
