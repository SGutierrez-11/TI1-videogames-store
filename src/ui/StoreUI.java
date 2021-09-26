package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Store;

public class StoreUI {

	//*********** FirstPane ***********
	
	@FXML
    private TextField shelvesAmount;

    @FXML
    private TextField clientsQuantity;

    @FXML
    private TextField cashiersQuantity;

    @FXML
    private BorderPane mainPane;
    
	private Store gameStore;
	
	//************** GameCreationPane **********
	
	@FXML
    private BorderPane mainPaneGameCreation;

    @FXML
    private Label numberIndicator;

    @FXML
    private TextField gameCodeTxT;

    @FXML
    private TextField gamePriceTxT;

    @FXML
    private TextField gameQuantityTxT;
	
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

		 int cashiers = Integer.parseInt(cashiersQuantity.getText());
		 
		 int clients = Integer.parseInt(clientsQuantity.getText());
		 
		 int shelves = Integer.parseInt(shelvesAmount.getText());
		 
		 Store gameStoreNew = new Store(shelves, cashiers, clients);
		 
		 setStore(gameStoreNew);
		 
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addGame.fxml"));
		 fxmlLoader.setController(this);
		 Parent addGamePane = fxmlLoader.load();
		 mainPane.getChildren().setAll(addGamePane);
		 int indicator = gameStore.getCurrentShelves()+1;
		 numberIndicator.setText(""+indicator);
		 gameStore.setClientsCounted(indicator);
		 
	    }
	 @FXML
	  public  void addGameToShelf(ActionEvent event) {
		 	
		 String code = gameCodeTxT.getText();
		 
		 int quantity = Integer.parseInt(gameQuantityTxT.getText());
		 
		 int price = Integer.parseInt(gamePriceTxT.getText());
		 
	    }

}
