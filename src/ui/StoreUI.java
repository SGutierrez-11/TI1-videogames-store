package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Store;

public class StoreUI {

	
	@FXML
    private TextField shelvesAmount;

    @FXML
    private TextField clientsQuantity;

    @FXML
    private TextField cashiersQuantity;

    @FXML
    private BorderPane mainPane;
    
	private Store gameStore;
	
	
	public StoreUI() {
		
		
	}
	public StoreUI(Store gameStore){
		
		this.gameStore = gameStore;	
	}
	public void setStore(Store gameStore) {
	this.gameStore = gameStore;
	}
	public Store getGameStore() {
		return gameStore;
	}
	 @FXML
	 public void loadAddGame(ActionEvent event) throws IOException {

		 int cashiers = Integer.parseInt(cashiersQuantity.getAccessibleText());
		 
		 int clients = Integer.parseInt(clientsQuantity.getAccessibleText());
		 
		 int shelves = Integer.parseInt(shelvesAmount.getAccessibleText());
		 
		 
		 setStore(new Store(shelves, cashiers, clients));
		 
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addGame.fxml"));
		 fxmlLoader.setController(this);
		 Parent addGamePane = fxmlLoader.load();
		 mainPane.getChildren().setAll(addGamePane);
	    }

}
