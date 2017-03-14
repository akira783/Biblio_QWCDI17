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
				enregistrer();
			}
		});
		
		fenEmprunt.getLivre().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) 
			{
				if (event.getCode().equals(KeyCode.ENTER))
				{
					String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());								
					System.out.println(timeStamp);				
					String idLivre = fenEmprunt.getLivre().getText();
					String idAdherent = fenEmprunt.getAdherant().getText();
					System.out.println(idLivre);
					System.out.println(idAdherent);
					System.out.println(sqlq.checkStatusExemplaire(Integer.parseInt(idLivre)));
					if(sqlq.checkStatusExemplaire(Integer.parseInt(idLivre)).equals("DISPONIBLE")){
						sqlq.setEmpruntEnCours(timeStamp, idLivre, idAdherent);
						sqlq.setStatusExemplaire(0,Integer.parseInt(idLivre));
					}
					else System.out.println("Livre INDISPONIBLE");
					enregistrer();
				
				}
			}
			
		});
	}
	public void enregistrer(){
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());								
						
		String idLivre = fenEmprunt.getLivre().getText();
		String idAdherent = fenEmprunt.getAdherant().getText();
		System.out.println("idLivre : " + idLivre);
		System.out.println("idAdhérent : " + idAdherent);
		System.out.println("Statut du livre : "+sqlq.checkStatusExemplaire(Integer.parseInt(idLivre)));
		
		System.out.println(sqlq.getNbEmprunt(Integer.parseInt(idAdherent)));
		System.out.println(sqlq.isLate(Integer.parseInt(idAdherent)));
		
		
		
		
		if(sqlq.isLate(Integer.parseInt(idAdherent))){			
			System.out.println("L'utilisateur a un livre en retard !");	
			fenEmprunt.setConfirm("L'utilisateur a un livre en retard !",0);
		}
		
		else if (sqlq.getNbEmprunt(Integer.parseInt(idAdherent))>=3){
			fenEmprunt.setConfirm("L'utilisateur a trop de livre !",0);
			System.out.println("L'utilisateur a déja emprunté 3 livres");
		}
	
		else if(!sqlq.checkStatusExemplaire(Integer.parseInt(idLivre)).equals("DISPONIBLE")) {
			System.out.println("Livre INDISPONIBLE");
			fenEmprunt.setConfirm("Livre INDISPONIBLE",0);
		}
		
		
		else{			
				sqlq.setEmpruntEnCours(timeStamp,idAdherent,idLivre);
				sqlq.setStatusExemplaire(0,Integer.parseInt(idLivre));
				fenEmprunt.setConfirm("ok",1);
			}
		
}
}
