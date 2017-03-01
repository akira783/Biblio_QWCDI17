package application.View;

import java.time.LocalDate;
import java.util.Date;

import application.Models.Client;
import application.Models.Emprunt;
import application.Models.Livre;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddEmprunt extends MainFrame
{
	public AddEmprunt(ObservableList<Client> listClientfx, ObservableList<Livre> listLivrefx, Stage stage)
	{
		Text 		text = new Text();
		GridPane 	grid = new GridPane();
		ChoiceBox<Client> cb = new ChoiceBox<>();
		ChoiceBox<Livre> cb1 = new ChoiceBox<>();
		Date 		dateEmprunt = new Date();
		Date 		dateRetour = new Date();
		DatePicker	dp = new DatePicker();
		DatePicker	dp1 = new DatePicker();
		TextField	idEmprunt = new TextField();
		Button 		bAppliquer = new Button();
		Button 		bCancel = new Button();
		Button 		bOk = new Button();
		bAppliquer.setText("Applique");
		bCancel.setText("Cancel");
		bOk.setText("Ok");
		
		text.setFont(Font.font(25));
		text.setText("Ajout d'un Emprunt");
		text.setLayoutX(150);
		text.setLayoutY(30);
		

		grid.add(new Text("id Emprunt : "), 0, 0);
		grid.add(new Text("Client : "), 0, 1);
		grid.add(new Text("Livre : "), 0, 2);
		grid.add(new Text("Date d'emprunt : "), 0, 3);
		grid.add(new Text("Date de retour : "), 0, 4);
		
		grid.add(idEmprunt, 1, 0);
		grid.add(cb, 1, 1);
		grid.add(cb1, 1, 2);
		grid.add(dp, 1, 3);
		grid.add(dp1, 1, 4);
		grid.add(bAppliquer, 2, 7);
		grid.add(bCancel, 3, 7);
		grid.add(bOk, 4, 7);
		
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setLayoutX(50);
		grid.setLayoutY(100);
	
		cb.setItems(listClientfx);
		cb.setLayoutX(100);
		cb.setLayoutY(60);
		
		cb1.setItems(listLivrefx);
		cb1.setLayoutX(100);
		cb1.setLayoutY(90);
		
		dp.setLayoutX(100);
		dp.setLayoutY(120);

		dp1.setLayoutX(100);
		dp1.setLayoutY(150);
		

		bCancel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				stage.close();
			}	
		});
		
		bOk.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				LocalDate lDate;
				LocalDate lDate1;
				
				lDate =  dp.getValue();
				dateEmprunt.setDate(lDate.getDayOfMonth());
				dateEmprunt.setMonth(lDate.getMonthValue());
				dateEmprunt.setYear(lDate.getYear());
				
				lDate1 =  dp1.getValue();
				dateRetour.setDate(lDate1.getDayOfMonth());
				dateRetour.setMonth(lDate1.getMonthValue());
				dateRetour.setYear(lDate1.getYear());

				Emprunt emprunt = new application.Models.Emprunt(Integer.parseInt(idEmprunt.getText()), cb.getValue(), cb1.getValue(), dateEmprunt, dateRetour);
				addEmpruntList(emprunt);
				MainFrame mf = new MainFrame();
				stage.close();
			}	
		});
		
		bAppliquer.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				LocalDate lDate;
				LocalDate lDate1;
				
				lDate =  dp.getValue();
				dateEmprunt.setDate(lDate.getDayOfMonth());
				dateEmprunt.setMonth(lDate.getMonthValue());
				dateEmprunt.setYear(lDate.getYear());
				
				lDate1 =  dp1.getValue();
				dateRetour.setDate(lDate1.getDayOfMonth());
				dateRetour.setMonth(lDate1.getMonthValue());
				dateRetour.setYear(lDate1.getYear());

				Emprunt emprunt = new application.Models.Emprunt(Integer.parseInt(idEmprunt.getText()), cb.getValue(), cb1.getValue(), dateEmprunt, dateRetour);
				addEmpruntList(emprunt);
				MainFrame mf = new MainFrame();
			}	
		});
		
		this.getChildren().add(text);
		this.getChildren().add(grid);
		
	}
}
