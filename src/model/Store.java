package model;


import java.util.ArrayList;

import collections.HashTable;
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import thread.GameStoreThread;

public class Store {

	private int shelvesQuantity;
	
	public int getShelvesQuantity() {
		return shelvesQuantity;
	}

	public void setShelvesQuantity(int shelvesQuantity) {
		this.shelvesQuantity = shelvesQuantity;
	}

	public int getClientsAmount() {
		return clientsAmount;
	}

	public void setClientsAmount(int clientsAmount) {
		this.clientsAmount = clientsAmount;
	}
	private int clientsAmount;
	
	private HashTable<Game>[] shelves;
	
	private Queue<Client> clientsQueue;
	
	//private ArrayList<Game>[] gamesLinked;
	
	private ArrayList<Game> games;
	
	private ArrayList<Game> allGames;
	
	private Queue<GameStoreThread> cashier;
	
	private ArrayList<Client> finalCustomerList;
	
	private ArrayList<Client> toShowClients;
	
	int shelvesCounted;
	
	int clientsCounted;
	
	public ArrayList<Client> getToShowClients() {
		return toShowClients;
	}

	public void setToShowClients(ArrayList<Client> toShowClients) {
		this.toShowClients = toShowClients;
	}

	public Store() {
		
	}
	
	public Store(int shelvesToCreate, int cashierAmount, int clientsAmount) {
	
		shelvesQuantity = shelvesToCreate;
		
		shelves = new HashTable[shelvesToCreate];
		
		//createHashTables(shelvesToCreate);
		
		clientsQueue = new Queue<Client>();
		
		//GameStoreThread firstThread = new GameStoreThread(this);
		cashier = new Queue<GameStoreThread>();
		createCashiers(cashierAmount);
		
		this.clientsAmount =  clientsAmount;
		
		shelvesCounted = 0;
		clientsCounted = 0;
		
		games = new ArrayList<Game>();
		
		allGames = new ArrayList<Game>();
		
		finalCustomerList = new ArrayList<Client>();
		
		toShowClients = new ArrayList<Client>();
		
		//gamesLinked = new ArrayList[shelvesToCreate];
	}
	public void addGameToList(String code, int price, int quantity) {
		
		Game tmpGame = new Game(code, price, quantity);
		/*
		if(gamesLinked[shelvesCounted]==null) {
			System.out.println("Aqui tambien hay problemas");
		}	
		gamesLinked[shelvesCounted].add(tmpGame);
		*/
		games.add(tmpGame);
		allGames.add(tmpGame);
	}
	public void addGame(String code) {
		
		
		
		for(int i=0; i < allGames.size();i++) {
		
			//System.out.println("Entra al For");
			//System.out.println("El allGames.getCode es:" + allGames.get(i).getCode());
			if(allGames.get(i).getCode()==code) {
			
				//System.out.println("El juego se esta añadiendo");
				games.add(allGames.get(i));
				
			}else {
				
				//System.out.println("Entro al else");
			}
		}
	}
	
	/*
	public void createShelves(String game,int price, int quantity) {
		
		Game gameToAdd = new Game(game,price,quantity);
		if(shelves[getCurrentShelves()-1]==null) {
			System.out.println("La Hashtable se esta creando mal");
		}
		
		shelves[(getCurrentShelves()-1)].insert(game, gameToAdd);
		System.out.println("Codigo: " + gameToAdd.getCode() + " Precio: " + gameToAdd.getPrice()+ " cantidad: " + gameToAdd.getQuantity());
		
		
	}
	*/
	public void createHashTable() {
	
		ArrayList<Game> newTmp = getGames();
		
		HashTable<Game> tmp = new HashTable<>(newTmp.size());
		
		for(int i=0; i < newTmp.size();i++) {
			
			tmp.insert(newTmp.get(i).getCode(), newTmp.get(i));
			
		}
		shelves[getCurrentShelves()-1]=tmp;
		setGamesEmpty();
	}
	/*
	public HashTable<Game>[] createHashTables(int toCreate) {
		
		HashTable<Game>[] tables = new HashTable [toCreate];
		
		for(int i=0; i < toCreate;i++) {
			
			//HashTable<Game> tmp = new HashTable<Game>();
			//tables[i] = tmp;
		}
		return tables;
<<<<<<< HEAD
	}
	public void addClienteToQueue(String info) {	
=======
>>>>>>> 6a880e081c2c6882ba73513b267e582b35eca8f1
		
	}
	*/
	
	/*
	public Catalog turnGamesArrayListInCatalog() {
		
		Stack<Game> tmpStack = new Stack<Game>();
		
		ArrayList<Game> tmp = getGames(); 
		
		for(int i=0; i < tmp.size();i++) {
			
			tmpStack.push(tmp.get(i));
			
		}
		Catalog clientCatolog = new Catalog(tmpStack);
		return clientCatolog;
	}
	*/
	
	public void addClienteToQueue(String code) {
		System.out.println("Entra al add");
		Client clientToAdd = new Client(code);
		//*********************
		Stack<Game> ordered = new Stack<>();
		for (int i = 0; i < shelves.length; i++) {
			System.out.println("Entra al primer for");
			ArrayList<Game> gamesInShelf = new ArrayList<>();
			for (int j = 0; j < games.size(); j++) {
				System.out.println("Entra al segundo for");
				if (shelves[i].contains(games.get(j).getCode())) {
					System.out.println("Paso del if");
					gamesInShelf.add(games.get(j));
				}
			}
			//Bubble Sort
			for (int j = 0; j < gamesInShelf.size(); j++) {
				for (int k = 0; k < gamesInShelf.size()-j-1; k++) {
					if (shelves[i].hash(gamesInShelf.get(j).getCode())>shelves[i].hash(gamesInShelf.get(j+1).getCode())) {
						Game temp = gamesInShelf.get(j);
						gamesInShelf.set(j, gamesInShelf.get(j+1));
						gamesInShelf.set(j+1, temp);
					}
				}
			}
			for (int j = 0; j < gamesInShelf.size(); j++) {
				ordered.push(gamesInShelf.get(j));
				System.out.println("Hash: "+shelves[i].hash(gamesInShelf.get(j).getCode()));
			}
		}
		Catalog tmp = new Catalog(ordered);
		System.out.println("Catalog size: " + tmp.getGames().size());
		clientToAdd.setGames(tmp);
		clientsQueue.add(clientToAdd);
		//System.out.println("Me quiero matar: " + clientsQueue.peek().getGames().getGames().size());
		toShowClients.add(clientToAdd);
		setGamesEmpty();
	}
	public void createCashiers(int amountCreated) {
		/*
		if(amountToCreate > amountCreated) {
		
			GameStoreThread tmpThread = new GameStoreThread(this);
			LinkedList<GameStoreThread> tmpGameLinkedList = new LinkedList<GameStoreThread>(tmpThread);
			c.setNext(tmpGameLinkedList);
			createCashiers(amountToCreate, amountCreated+1, tmpGameLinkedList);
			
			
		}else {
			return;
			
		}
		*/
		for(int i=0; i < amountCreated;i++) {
			
			GameStoreThread tmp = new GameStoreThread(this);
			cashier.add(tmp);
			
		}
		
	}
	public void payClient() throws InterruptedException {	
		
			Stack<Game> stackToPay = new Stack<Game>();
			
			Client tmp = clientsQueue.remove();
			//System.out.println(clientsQueue.peek().getGames().getGames().size());
			
			
			String line2 = "";
			
			int amountToPlay = 0;
			
			System.out.println(" Tamanio: " + tmp.getGames().getGames().size() );
			for(int i=0; i < tmp.getGames().getGames().size();i++) {
			
			System.out.println("Entra al for del hilo");	
				
			Game tmpGame = tmp.getGames().getGames().pop();
			
			Thread.sleep(3000);
			
			amountToPlay += tmpGame.getPrice();
			 
			
			
			 stackToPay.push(tmpGame);
			 line2 += tmpGame.getCode() + " ";
			}
			tmp.setToPay(amountToPlay);
			tmp.setAllGames(line2);
			finalCustomerList.add(tmp);
			System.out.println(tmp.getId());
			System.out.println("Se ejecuto el hilo 1");
	}
	
	public int getCurrentShelves() {
		return shelvesCounted;
	}
	public void setCurrentShelves(int shelvesCounted) {
		this.shelvesCounted = shelvesCounted;
	}

	public int getClientsCounted() {
		return clientsCounted;
	}

	public void setClientsCounted(int clientsCounted) {
		this.clientsCounted = clientsCounted;
	}
	
	public ArrayList<Game> getGames(){
		return games;
	}
	public void setGames(ArrayList<Game> games) {
		
		this.games = games;
	}
	public void setGamesEmpty() {
		
		ArrayList<Game> newGames = new ArrayList<Game>();
		setGames(newGames);
		
	}
	public ArrayList<Game> getAllGames(){
		return allGames;
	}
	/*
	public ArrayList<Client> getClientsList(){
		
		ArrayList<Client> tmpClients = new ArrayList<>();
		
		Queue<Client> clients = clientsQueue;
		
		
		while(clients.isEmpty()==false) {
		
			System.out.println("Entra al while");
			Client toRemove = clients.remove();
			System.out.println("Se añade el cliente: " + toRemove.getId() + " Con juegos: " + toRemove.getAllGames());
			tmpClients.add(toRemove);
			
		}
		 System.out.println("Size "+tmpClients.size());
		return tmpClients;
	}
	 */
	public Queue<Client> getClientsQueue() {
		return clientsQueue;
	}

	public void setClientsQueue(Queue<Client> clientsQueue) {
		this.clientsQueue = clientsQueue;
	}
	public ArrayList<Client> getFinalClient(){
		return finalCustomerList;
	}
	public void starThreads() {
		
		/*
		GameStoreThread tmp = cashier.getObject();
		tmp.run();
		
		
		while(cashier.getNext()!=null) {
			
			tmp = cashier.getNext().getObject();
			tmp.run();
			
			
		}
		*/
		
		while(cashier.isEmpty()==false) {
			
			GameStoreThread tmp = cashier.remove();
			tmp.run();
		}
		
		
	}
}
