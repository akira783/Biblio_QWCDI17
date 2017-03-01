package application.View;

import java.util.Date;
import application.Main;
import application.Models.Client;
import application.Models.Emprunt;
import application.Models.Livre;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MainFrame extends Parent
{
	static ObservableList<Livre> listLivrefx =  FXCollections.observableArrayList();
	static ObservableList<Client> listClientfx =  FXCollections.observableArrayList();
	static ObservableList<Emprunt> listEmpruntfx =  FXCollections.observableArrayList();
	int 	key = 1;
	IntegerProperty widhtScene = new SimpleIntegerProperty();
	IntegerProperty heightScene = new SimpleIntegerProperty();
	

	
	public MainFrame()
	{
		
	}
	
	public MainFrame(Stage stage)
	{
		Livre livre = new Livre(0, 100, "livre", null, null, "fantastique", true, false, new Date());
		Livre livre1 = new Livre(1, 100, "livre1", null, null, "fantastique", true, false, new Date());
		Livre livre2 = new Livre(2, 100, "livre2", null, null, "fantastique", true, false, new Date());
		Livre livre3 = new Livre(3, 100, "livre3", null, null, "fantastique", true, false, new Date());
		
		Client client1 = new Client(1, "liaqat", "waleed",21,new Date(), 1, new Date(), null, null);
		Client client2 = new Client(2, "liaqat", "waleed",21,new Date(), 2, new Date(), null, null);
		Client client3 = new Client(3, "liaqat", "waleed",21,new Date(), 3, new Date(), null, null);
		Client client4 = new Client(4, "liaqat", "waleed",21,new Date(), 4, new Date(), null, null);
		
		Emprunt emprunt1 = new Emprunt(1, client1, livre, new Date(), new Date());
		Emprunt emprunt2 = new Emprunt(2, client2, livre1, new Date(), new Date());
		Emprunt emprunt3 = new Emprunt(3, client3, livre2, new Date(), new Date());
		Emprunt emprunt4 = new Emprunt(4, client4, livre3, new Date(), new Date());
		
		ListView<Livre> listLivre = new ListView<>();
		ListView<Client> listClient= new ListView<>();
		ListView<Emprunt> listEmprunt = new ListView<>();
		
		TextFlow tfLivre = new TextFlow();
		TextFlow tfClient = new TextFlow();
		TextFlow tfEmprunt = new TextFlow();
		
		
		Image image = new Image(Main.class.getResourceAsStream("images/livre.png"));
		Image image1 = new Image(Main.class.getResourceAsStream("images/addclient.png"));
		Image image2 = new Image(Main.class.getResourceAsStream("images/addemprunt.png"));
		ImageView imageView = new ImageView(image);
		ImageView imageView1 = new ImageView(image1);
		ImageView imageView2 = new ImageView(image2);
				
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		imageView.setLayoutX(10);
		imageView.setLayoutY(10);

		imageView1.setFitHeight(60);
		imageView1.setFitWidth(60);
		imageView1.setLayoutX(80);
		imageView1.setLayoutY(10);
		
		imageView2.setFitHeight(60);
		imageView2.setFitWidth(60);
		imageView2.setLayoutX(150);
		imageView2.setLayoutY(10);
		
		
		imageView.setOnMouseClicked(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent event)
					{
						Stage stage2 = new Stage();
						Group addLivre = new Group();
						Scene scene = new Scene(addLivre, 500, 400);
						AddLivre al = new AddLivre(stage2);
						
						addLivre.getChildren().add(al);
						stage2.setScene(scene);
						stage2.show();
						listLivre.setItems(listLivrefx);
						
					}
				});
		
		imageView1.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				Stage stageClient = new Stage();
				Group addClient = new Group();
				Scene sceneClient = new Scene(addClient, 500, 400);
				AddClient al = new AddClient(stageClient);
				
				addClient.getChildren().add(al);
				stageClient.setScene(sceneClient);
				stageClient.show();
				listLivre.setItems(listLivrefx);
			}
		});

		listClientfx.add(client1);
		listClientfx.add(client2);
		listClientfx.add(client3);
		listClientfx.add(client4);
		
		imageView2.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				Stage stageEmprunt = new Stage();
				Group addClient = new Group();
				Scene sceneClient = new Scene(addClient, 550, 400);
				AddEmprunt al = new AddEmprunt(listClientfx, listLivrefx, stageEmprunt);
				
				addClient.getChildren().add(al);
				sceneClient.getStylesheets().add("Viper.css");
				stageEmprunt.setScene(sceneClient);
				stageEmprunt.show();
				listLivre.setItems(listLivrefx);
			}
		});

		
		listLivrefx.add(livre);
		listLivrefx.add(livre1);
		listLivrefx.add(livre2);
		listLivrefx.add(livre3);
		
		listEmpruntfx.add(emprunt1);
		listEmpruntfx.add(emprunt2);
		listEmpruntfx.add(emprunt3);
		listEmpruntfx.add(emprunt4);
		
		listLivrefx.sort(null);
		listClientfx.sort(null);
		listEmpruntfx.sort(null);
		
		Text id = new Text();
		Text titre = new Text();
		Text edition = new Text();
		Text dateParution = new Text();
		Text type = new Text();
		Text nbPage = new Text();
		Text categorie = new Text();
		
		listLivre.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
	        public void handle(MouseEvent event) 
	        {
	            id.setText(" " + listLivre.getSelectionModel().getSelectedItem().getIdLivre());
	            titre.setText(" " + listLivre.getSelectionModel().getSelectedItem().getTitre());
	            edition.setText(" " + listLivre.getSelectionModel().getSelectedItem().getEdition());
	            dateParution.setText(" " + listLivre.getSelectionModel().getSelectedItem().getDateDeParution());
	            type.setText(" " + listLivre.getSelectionModel().getSelectedItem().getType());
	            nbPage.setText(" " + listLivre.getSelectionModel().getSelectedItem().getNbPage());
	            categorie.setText(" " + listLivre.getSelectionModel().getSelectedItem().getCategorie());
	        }
		});
		
		listLivre.setOnKeyReleased(new EventHandler<KeyEvent>()
				{		
					@Override
					public void handle(KeyEvent event)
					{
			            id.setText(" " + listLivre.getSelectionModel().getSelectedItem().getIdLivre());
			            titre.setText(" " + listLivre.getSelectionModel().getSelectedItem().getTitre());
			            edition.setText(" " + listLivre.getSelectionModel().getSelectedItem().getEdition());
			            dateParution.setText(" " + listLivre.getSelectionModel().getSelectedItem().getDateDeParution());
			            type.setText(" " + listLivre.getSelectionModel().getSelectedItem().getType());
			            nbPage.setText(" " + listLivre.getSelectionModel().getSelectedItem().getNbPage());
			            categorie.setText(" " + listLivre.getSelectionModel().getSelectedItem().getCategorie());
					}
				});
		Text idpersonne = new Text();
		Text nom = new Text();
		Text prenom = new Text();
		Text datenaissance = new Text();
		Text age = new Text();
		Text idclient = new Text();
		listClient.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
	        public void handle(MouseEvent event) 
	        {
	            idpersonne.setText(" " + listClient.getSelectionModel().getSelectedItem().getIdPersonne());
	            nom.setText(" " + listClient.getSelectionModel().getSelectedItem().getNom());
	            prenom.setText(" " + listClient.getSelectionModel().getSelectedItem().getPrenom());
	            datenaissance.setText(" " + listClient.getSelectionModel().getSelectedItem().getDateDeNaissance());
	            age.setText(" " + listClient.getSelectionModel().getSelectedItem().getAge());
	            idclient.setText(" " + listClient.getSelectionModel().getSelectedItem().getIdClient());
	        }
		});
		
		listClient.setOnKeyReleased(new EventHandler<KeyEvent>()
				{		
					@Override
					public void handle(KeyEvent event)
					{
			            idpersonne.setText(" " + listClient.getSelectionModel().getSelectedItem().getIdPersonne());
			            nom.setText(" " + listClient.getSelectionModel().getSelectedItem().getNom());
			            prenom.setText(" " + listClient.getSelectionModel().getSelectedItem().getPrenom());
			            datenaissance.setText(" " + listClient.getSelectionModel().getSelectedItem().getDateDeNaissance());
			            age.setText(" " + listClient.getSelectionModel().getSelectedItem().getAge());
			            idclient.setText(" " + listClient.getSelectionModel().getSelectedItem().getIdClient());
					}
				});
		Text	idEmprunt = new Text();
		Text	client = new Text();
		Text	livree = new Text();
		Text	dateEmprunt = new Text();
		Text	dateRendue = new Text();
		
		listEmprunt.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
	        public void handle(MouseEvent event) 
	        {
	            idEmprunt.setText(" " + listEmprunt.getSelectionModel().getSelectedItem().getIdEmpreint());
	            client.setText(" " + listEmprunt.getSelectionModel().getSelectedItem().getClient());
	            livree.setText(" " + listEmprunt.getSelectionModel().getSelectedItem().getLivre());
	            dateEmprunt.setText(" " + listEmprunt.getSelectionModel().getSelectedItem().getDateEmpreint());
	            dateRendue.setText(" " + listEmprunt.getSelectionModel().getSelectedItem().getDateRendue());
	        }
		});
		
		listEmprunt.setOnKeyReleased(new EventHandler<KeyEvent>()
				{		
					@Override
					public void handle(KeyEvent event)
					{
			            idpersonne.setText(" " + listClient.getSelectionModel().getSelectedItem().getIdPersonne());
			            nom.setText(" " + listClient.getSelectionModel().getSelectedItem().getNom());
			            prenom.setText(" " + listClient.getSelectionModel().getSelectedItem().getPrenom());
			            datenaissance.setText(" " + listClient.getSelectionModel().getSelectedItem().getDateDeNaissance());
			            age.setText(" " + listClient.getSelectionModel().getSelectedItem().getAge());
			            idclient.setText(" " + listClient.getSelectionModel().getSelectedItem().getIdClient());
					}
				});
		
		
		tfLivre.getChildren().addAll(
				new Text("ID : "), id, 
				new Text("\n\nTitre : "), titre, 
				new Text("\n\nEdition : "), edition, 
				new Text("\n\nDate de parution : "), dateParution, 
				new Text("\n\nType : "), type, 
				new Text("\n\nNombre de pages: "), nbPage,
				new Text("\n\nCategorie : "), categorie);
		tfLivre.setLayoutX(300);
		tfLivre.setLayoutY(130);
		
		tfClient.getChildren().addAll(
				new Text("IDpersonne : "), idpersonne, 
				new Text("\n\nNom : "), nom, 
				new Text("\n\nPrenom : "), prenom, 
				new Text("\n\nDate de naissance : "), datenaissance, 
				new Text("\n\nage : "), age, 
				new Text("\n\nId client : "), idclient);
		tfClient.setLayoutX(300);
		tfClient.setLayoutY(130);
		
		
		tfEmprunt.getChildren().addAll(
				new Text("IDEmprunt : "), idEmprunt, 
				new Text("\n\nClient : "), client, 
				new Text("\n\nLivre : "), livree, 
				new Text("\n\nDate d'emprunt : "), dateEmprunt, 
				new Text("\n\nDate de retour : "), dateRendue);
		tfEmprunt.setLayoutX(300);
		tfEmprunt.setLayoutY(130);
		
		listLivre.setLayoutX(5);
		listLivre.setLayoutY(110);
		listLivre.setPrefSize(250, 485);
		
		listClient.setLayoutX(5);
		listClient.setLayoutY(110);
		listClient.setPrefSize(250, 485);
		
		listEmprunt.setLayoutX(5);
		listEmprunt.setLayoutY(110);
		listEmprunt.setPrefSize(250, 485);

		listLivre.setItems(listLivrefx);
		listClient.setItems(listClientfx);
		listEmprunt.setItems(listEmpruntfx);
		
		SplitPane banniere = new SplitPane();
		SplitPane list = new SplitPane();
		SplitPane detail = new SplitPane();
		
		widhtScene.bind(stage.getScene().widthProperty());
		heightScene.bind(stage.getScene().heightProperty());
		
		banniere.setVisible(true);
		banniere.setLayoutX(5);
		banniere.setLayoutY(5);
		banniere.setPrefSize(widhtScene.doubleValue(), 70);
		banniere.maxWidthProperty().bind(stage.getScene().widthProperty());

		list.setVisible(true);
		list.setLayoutX(5);
		list.setLayoutY(110);
		list.setPrefSize(250, 485);
		
		detail.setVisible(true);
		detail.setLayoutX(260);
		detail.setLayoutY(80);
		detail.setPrefSize(540, 518);
		
		Tab tabLivre = new Tab("Livre");
		Tab tabEmprunt = new Tab("Emprunt");
		Tab tabClient = new Tab("Client");
		
		tabLivre.setContent(listLivre);
		tabClient.setContent(listClient);
		tabEmprunt.setContent(listEmprunt);
		
		tabLivre.setClosable(false);
		tabEmprunt.setClosable(false);	
		tabClient.setClosable(false);
		
		TabPane tab1 = new TabPane();
		tab1.autosize();
		
		tab1.getTabs().add(tabLivre);
		tab1.getTabs().add(tabClient);
		tab1.getTabs().add(tabEmprunt);
		
		tab1.setLayoutX(5);
		tab1.setLayoutY(80);
		tab1.setVisible(true);
		tab1.setMaxSize(1000, 1000);
		
		tfLivre.setVisible(true);
		tfEmprunt.setVisible(false);
		tfClient.setVisible(false);

		banniere.setPrefSize(widhtScene.doubleValue(), (heightScene.doubleValue() / 100 * 20 - 5));
		detail.setPrefSize((widhtScene.doubleValue() / 100 * 80) - 10, (heightScene.doubleValue() / 100 * 80));
		tab1.setPrefSize((widhtScene.doubleValue() / 100 * 20), (heightScene.doubleValue() / 100 * 80));
		tab1.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 10);
		detail.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 10);
		tfLivre.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 30);
		detail.setLayoutX(widhtScene.doubleValue() - (widhtScene.doubleValue() / 100 * 80) + 10);
		tfLivre.setLayoutX(detail.getLayoutX() + 50);
		banniere.setLayoutY(10);
		
		stage.getScene().widthProperty().addListener(new ChangeListener<Number>(){
			@Override 
			public void changed(ObservableValue<? extends Number> observable,
			            Number oldValue, Number newValue){
				banniere.setPrefSize(widhtScene.doubleValue(), (heightScene.doubleValue() / 100 * 20 - 5));
				detail.setPrefSize((widhtScene.doubleValue() / 100 * 80) - 10, (heightScene.doubleValue() / 100 * 80));
				tab1.setPrefSize((widhtScene.doubleValue() / 100 * 20), (heightScene.doubleValue() / 100 * 80));
				tab1.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 10);
				detail.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 10);
				tfLivre.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 30);
				detail.setLayoutX(widhtScene.doubleValue() - (widhtScene.doubleValue() / 100 * 80) + 10);
				tfLivre.setLayoutX(detail.getLayoutX() + 50);
				banniere.setLayoutY(10);
					
					System.out.println("height = " + stage.getScene().getHeight());
					System.out.println("width = " + stage.getScene().getWidth());
;
				}
			});
		
		stage.getScene().heightProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				banniere.setPrefSize(widhtScene.doubleValue(), (heightScene.doubleValue() / 100 * 20) - 5);
				banniere.setLayoutY(10);
				detail.setPrefSize((widhtScene.doubleValue() / 100 * 80) - 10, (heightScene.doubleValue() / 100 * 80));
				tab1.setPrefSize((widhtScene.doubleValue() / 100 * 20), (heightScene.doubleValue() / 100 * 80));
				tab1.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 10);
				detail.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 10);
				tfLivre.setLayoutY(heightScene.doubleValue() - (heightScene.doubleValue() / 100 * 80) + 30);
				detail.setLayoutX(widhtScene.doubleValue() - (widhtScene.doubleValue() / 100 * 80) + 10);
				tfLivre.setLayoutX(detail.getLayoutX() + 50);
				
			}
		} 
		);

		tabClient.setOnSelectionChanged(new EventHandler<Event>()
		{
			@Override
			public void handle(Event event)
			{
				tfLivre.setVisible(false);
				tfEmprunt.setVisible(false);
				tfClient.setVisible(true);
				key = 2;
			}
		});
		
		tabLivre.setOnSelectionChanged(new EventHandler<Event>()
		{
			@Override
			public void handle(Event event)
			{
				tfLivre.setVisible(true);
				tfEmprunt.setVisible(false);
				tfClient.setVisible(false);
				key = 1;
			}
		});
		
		tabEmprunt.setOnSelectionChanged(new EventHandler<Event>()
		{
			@Override
			public void handle(Event event)
			{
				tfLivre.setVisible(false);
				tfEmprunt.setVisible(true);
				tfClient.setVisible(false);
				key = 3;
			}
		});
		
		
		Image imgrecherche = new Image(Main.class.getResourceAsStream("images/recherche4.png"));
		ImageView imgVrecherche = new ImageView();
		imgVrecherche.setImage(imgrecherche);
		
		imgVrecherche.setLayoutX(613);
		imgVrecherche.setLayoutY(45);
		imgVrecherche.setFitHeight(25);
		imgVrecherche.setFitWidth(25);
		
		TextField recherche = new TextField();
		
		recherche.setLayoutX(640);
		recherche.setLayoutY(45);
		
		recherche.setOnKeyPressed(new EventHandler<KeyEvent>()
			{
				@Override
				public void handle(KeyEvent event)
				{
					if (key == 1)
					{
						listLivrefx = filtreLivre(listLivrefx);
					}
					else if (key == 2)
					{
						listClientfx = filtreClient(listClientfx);
					}
					else
					{
						listEmpruntfx = filtreEmprunt(listEmpruntfx);
					}
				}
			});
		
		this.getChildren().add(banniere);
		this.getChildren().add(detail);
		this.getChildren().add(imageView);
		this.getChildren().add(imageView1);
		this.getChildren().add(imageView2);
		this.getChildren().add(tab1);
		this.getChildren().add(tfLivre);
		this.getChildren().add(tfClient);
		this.getChildren().add(tfEmprunt);
		this.getChildren().add(recherche);
		this.getChildren().add(imgVrecherche);

	}					
	
	public void addLivreList(Livre livre)
	{
		listLivrefx.add(livre);
	}
	
	public void addClientList(Client client)
	{
		listClientfx.add(client);
	}
	public void addEmpruntList(Emprunt emprunt)
	{
		listEmpruntfx.add(emprunt);
	}
	
	public ObservableList<Livre> filtreLivre(ObservableList<Livre> list)
	{
		return list;
	}
	public ObservableList<Emprunt> filtreEmprunt(ObservableList<Emprunt> list)
	{
		return list;
	}
	public ObservableList<Client> filtreClient(ObservableList<Client> list)
	{
		return list;
	}
}
