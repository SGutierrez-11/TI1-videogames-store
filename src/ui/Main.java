package ui;

//import java.io.IOException;
//import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import model.Store;
import model.Store;

public class Main extends Application{

	private Store gameStore;
	
	private StoreUI gameStoreUI;
	
	public Main() {
		
		gameStore = new Store();
		gameStoreUI = new StoreUI(gameStore);
	}
	
	
	public static void main(String[]args) {
	/*	

		
		sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		sc.nextLine();
		
		int cashier = sc.nextInt();
		sc.nextLine();
		
		int shelves = sc.nextInt();
		sc.nextLine();
		
		
		Store gameStore = new Store(shelves,cashier);
		
		for(int i=0;i < shelves;i++) {
			
			String line = sc.nextLine();
			String [] values = line.split(" ");
			
			for(int j=0; j < Integer.parseInt(values[1]);j++) {
				
				String gameInfo = sc.nextLine();
				gameStore.createShelves(gameInfo, i);
				
				
				
			}
			
		}
		int clientsAmount = sc.nextInt();
		sc.nextLine();
		for(int i=0; i < clientsAmount;i++) {
			
			String clientData = sc.nextLine();
			gameStore.addClienteToQueue(clientData);
			
		}
		
	}
	
	*/
		launch(args);
	}	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FirstPane.fxml"));
		fxmlLoader.setController(gameStoreUI);
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Game Store");
		primaryStage.show();
		
		
	}
		
	
	
}
