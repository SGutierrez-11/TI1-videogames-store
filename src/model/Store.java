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
	
	private LinkedList<GameStoreThread> cashier;
	
	int shelvesCounted;
	
	int clientsCounted;
	
	public Store() {
		
	}
	
	public Store(int shelvesToCreate, int cashierAmount, int clientsAmount) {
	
		shelvesQuantity = shelvesToCreate;
		
		shelves = new HashTable[shelvesToCreate];
		
		//createHashTables(shelvesToCreate);
		
		clientsQueue = new Queue<Client>();
		
		GameStoreThread firstThread = new GameStoreThread(this, 20);
		cashier = new LinkedList<GameStoreThread>(firstThread);
		createCashiers(shelvesToCreate,1, cashier);
		
		this.clientsAmount =  clientsAmount;
		
		shelvesCounted = 0;
		clientsCounted = 0;
		
		games = new ArrayList<Game>();
		
		allGames = new ArrayList<Game>();
		
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
	public Catalog turnGamesArrayListInCatalog() {
		
		Stack<Game> tmpStack = new Stack();
		
		ArrayList<Game> tmp = getGames(); 
		
		for(int i=0; i < tmp.size();i++) {
			
			tmpStack.push(tmp.get(i));
			
		}
		Catalog clientCatolog = new Catalog(tmpStack);
		return clientCatolog;
	}
	
	
	public void addClienteToQueue(String code) {
		//Primero crear metodo que convierta de arraylist a stack y este en catalogo catologo
		//luego ordernar catologo
		//tercero guardar catologo en el stack games
		//cuarto convertir el stack games en catologo y setearlo al cliente
		//quinto añadir cliente al queue
		
		Client clientToAdd = new Client(code);
		//*********************
		Stack<Game> ordered = new Stack<>();
		for (int i = 0; i < shelves.length; i++) {
			for (int j = 0; j < games.size(); j++) {
				ArrayList<Game> gamesInShelf = new ArrayList<>();
				if (shelves[i].contains(games.get(j).getCode())) 
					gamesInShelf.add(games.get(j));
			}
			//Falta agregar al stack en el orden necesario
		}
		
		
		
		//*************************
		Catalog tmp = new Catalog(ordered);
		
		clientToAdd.setGames(tmp);
		clientsQueue.add(clientToAdd);
		setGamesEmpty();
		
	}
	public void createCashiers(int amountToCreate, int amountCreated,LinkedList<GameStoreThread> c) {
		
		if(amountToCreate > amountCreated) {
		
			GameStoreThread tmpThread = new GameStoreThread(this,10);
			LinkedList<GameStoreThread> tmpGameLinkedList = new LinkedList<GameStoreThread>(tmpThread);
			c.setNext(tmpGameLinkedList);
			createCashiers(amountToCreate, amountCreated+1, tmpGameLinkedList);
			
			
		}else {
			return;
			
		}
	}
	public String payClient() {
		
		Stack<Game> stackToPay = new Stack<Game>();
			
			Client tmp = clientsQueue.remove();
			
			String line = "";
			
			String line2 = "";
			
			int amountToPlay = 0;
			
			for(int i=0; i < tmp.getGames().getGames().size();i++) {
			
			Game tmpGame = tmp.getGames().getGames().peek();
			
			 amountToPlay += tmpGame.getPrice();
			 
			 stackToPay.push(tmpGame);
			 line2 += tmpGame.getCode() + " ";
			}
			line = ""+amountToPlay;
			String line3 = line + "\t" + line2;
			return line3;
			
		
		
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
	
}
