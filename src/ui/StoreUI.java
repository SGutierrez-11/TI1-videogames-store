package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Client;
import model.Game;
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
    
    @FXML
    private TableView<Game> AddGameTableView;

    @FXML
    private TableColumn<Game, String> codeColumn;

    @FXML
    private TableColumn<Game, Integer> priceColumn;

    @FXML
    private TableColumn<Game, Integer> quantityColumn;
    
    //**************** AddClient ********************
	
    @FXML
    private TextField clientIDTxT;

    @FXML
    private TableView<Game> ClientGamesTableView;

    @FXML
    private TableColumn<Game, String> clientGamesColumn;

    @FXML
    private ComboBox<String> clientGamesComboBox;

    //***************** Game Order **************
    @FXML
    private TableView<Client> gameOrderTableView;

    @FXML
    private TableColumn<Client, String> gameOrderClientColumn;

    @FXML
    private TableColumn<Client, String> gameOrderGameColumn;
    
    //************** Client Pay Pane **************
    
    @FXML
    private TableView<Client> gamePayOrderTableView;

    @FXML
    private TableColumn<Client, String> gamePayClientColumn;

    @FXML
    private TableColumn<Client, String> gamePayGameColumn;

    @FXML
    private TableColumn<Client, Integer> gamePayAmount;
    
    
	//public StoreUI() {
		
	//}
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
		 gameStore.setCurrentShelves(indicator);
		 
	    }
	 @FXML
	  public  void addGameToShelf(ActionEvent event) {
		 	
		 String code = gameCodeTxT.getText();
		 
		 int quantity = Integer.parseInt(gameQuantityTxT.getText());
		 
		 int price = Integer.parseInt(gamePriceTxT.getText());
		 
		 	if(gameCodeTxT.getText()!="" || gameQuantityTxT.getText()!=""||gamePriceTxT.getText()!=""         ) {
		 	
		 		gameStore.addGameToList(code, price, quantity);
		 		
		 		initializeAddGamesTableView();
		 		AddGameTableView.refresh();	
		 		
		 		}
		 	
	    }
	 public void initializeAddGamesTableView() {
		 
		 
		 	ObservableList<Game> observableList;
	    	observableList = FXCollections.observableArrayList(gameStore.getGames());
	    	AddGameTableView.setItems(observableList);
	    	
	    	codeColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("code"));
	    	priceColumn.setCellValueFactory(new PropertyValueFactory<Game,Integer>("price"));
	    	quantityColumn.setCellValueFactory(new PropertyValueFactory<Game,Integer>("quantity"));
	 }
	  @FXML
	   public void nextStep(ActionEvent event) throws IOException {

		  		gameStore.createHashTable();

		  		if(gameStore.getCurrentShelves()<gameStore.getShelvesQuantity()) {
		  		
		  			gameStore.setCurrentShelves(gameStore.getCurrentShelves()+1);
		  			gameCodeTxT.setText("");
		  			gamePriceTxT.setText("");
		  			gameQuantityTxT.setText("");
		  			
		  			numberIndicator.setText(""+gameStore.getCurrentShelves());
		  			
		  			AddGameTableView.refresh();
		  		
		  		}else {
		  			
		  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addClient.fxml"));
		  			fxmlLoader.setController(this);
		  	    	Parent menuPane = fxmlLoader.load();
		  	    	mainPane.getChildren().setAll(menuPane);
		  			gameStore.setGamesEmpty();
		  			initializeClientsTableview();
		  			initializeGamesCombobox();
		  			gameStore.setClientsCounted(gameStore.getClientsCounted()+1);
		  		}	
	    }
	  @FXML
	   public void addGameToClient(ActionEvent event) {

		String game = clientGamesComboBox.getValue();
		  
			gameStore.addGame(game);
			initializeClientsTableview();
			ClientGamesTableView.refresh();
		
		  	
	    }
	  @FXML
	  public void thirdStep(ActionEvent event) throws IOException {

		  String clientCode = clientIDTxT.getText();
		  gameStore.addClienteToQueue(clientCode);
		  
		  if(gameStore.getClientsCounted()<gameStore.getClientsAmount()) {
			  
			  clientIDTxT.setText("");
			  clientGamesComboBox.setAccessibleText("");
			  ClientGamesTableView.refresh();
			  gameStore.setClientsCounted(gameStore.getClientsCounted()+1);
			  
		  }else {
			 
			  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameOrderPane.fxml"));
	  			fxmlLoader.setController(this);
	  	    	Parent menuPane = fxmlLoader.load();
	  	    	mainPane.getChildren().setAll(menuPane);
	  			gameStore.setGamesEmpty(); 
	  			initializeGameOrderTableview();
	  			gameOrderTableView.refresh();
		  }
		  
	    }
	  
	  
	  
	  public void initializeGamesCombobox() {
		  
		  for(int i=0; i < gameStore.getAllGames().size();i++) {
			   String name = gameStore.getAllGames().get(i).getCode();
			   clientGamesComboBox.getItems().add(name);
		   }
	  }
	  public void initializeClientsTableview() {
		  
		  ObservableList<Game> observableList;
		  observableList = FXCollections.observableArrayList(gameStore.getGames());
		  ClientGamesTableView.setItems(observableList);
	  
		  clientGamesColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("code"));
	 }
	 public void initializeGameOrderTableview() {
		 
		 ObservableList<Client> observableList;
		 observableList = FXCollections.observableArrayList(gameStore.getClientsList());
		 gameOrderTableView.setItems(observableList);
	    	
	     gameOrderClientColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
	     gameOrderGameColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("allgames"));
		 gameOrderTableView.refresh();
		 
	 }
	 @FXML
	 public void forthStep(ActionEvent event) throws IOException {

		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clientExit.fxml"));
			fxmlLoader.setController(this);
	    	Parent menuPane = fxmlLoader.load();
	    	mainPane.getChildren().setAll(menuPane);
			gameStore.setGamesEmpty(); 
			gameStore.starThreads();
			initializeCustomerPayTableview();
			gamePayOrderTableView.refresh();
			
	 }
	 public void initializeCustomerPayTableview() {
		 
		 ObservableList<Client> observableList;
		 observableList = FXCollections.observableArrayList(gameStore.getFinalClient());
		 gamePayOrderTableView.setItems(observableList);
	    	
	     gamePayClientColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
	     gamePayGameColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("allGames"));
	     gamePayAmount.setCellValueFactory(new PropertyValueFactory<Client,Integer>("toPay"));
	     
	     gameOrderTableView.refresh();
		 
	 }
	 
	 
}
