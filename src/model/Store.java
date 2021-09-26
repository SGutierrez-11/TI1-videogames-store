package model;


import java.util.ArrayList;

import collections.HashTable;
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import thread.GameStoreThread;

public class Store {

	private int shelvesQuantity;
	
	private int clientsAmount;
	
	private HashTable<Game>[] shelves;
	
	private Queue<Client> clientsQueue;
	
	private ArrayList<Game>[] gamesLinked;
	
	private ArrayList<Game> games;
	
	private LinkedList<GameStoreThread> cashier;
	
	int shelvesCounted;
	
	int clientsCounted;
	
	public Store() {
		
	}
	
	public Store(int shelvesToCreate, int cashierAmount, int clientsAmount) {
	
		shelvesQuantity = shelvesToCreate;
		
		shelves = new HashTable[shelvesToCreate];
		
		createHashTables(shelvesToCreate);
		
		clientsQueue = new Queue<Client>();
		
		GameStoreThread firstThread = new GameStoreThread(this, 20);
		cashier = new LinkedList<GameStoreThread>(firstThread);
		createCashiers(shelvesToCreate,1, cashier);
		
		this.clientsAmount =  clientsAmount;
		
		shelvesCounted = 0;
		clientsCounted = 0;
		
		gamesLinked = new ArrayList[shelvesToCreate];
	}
	public void addGameToList(String code, int price, int quantity) {
		
		Game tmpGame = new Game(code, price, quantity);
		
		gamesLinked[shelvesCounted].add(tmpGame);
		
		
	}
	
	public void createShelves(String game,int price, int quantity) {
		
		Game gameToAdd = new Game(game,price,quantity);
		shelves[getCurrentShelves()].insert(game, gameToAdd);
		System.out.println("Codigo: " + gameToAdd.getCode() + " Precio: " + gameToAdd.getPrice()+ " cantidad: " + gameToAdd.getQuantity());
		
		
	}
	
	public HashTable<Game>[] createHashTables(int toCreate) {
		
		HashTable<Game>[] tables = new HashTable [toCreate];
		
		for(int i=0; i < toCreate;i++) {
			
			//HashTable<Game> tmp = new HashTable<Game>();
			//tables[i] = tmp;
		}
		return tables;
		
	}
	public Catolog turnGamesArrayListInCatalog() {
		
		Stack<Game> tmpStack = new Stack();
		
		
	}
	
	
	public void addClienteToQueue(String code) {
		
		
		//Primero crear metodo que convierta de arraylist a stack y este en catalogo catologo
		//luego ordernar catologo
		//tercero guardar catologo en el stack games
		//cuarto convertir el stack games en catologo y setearlo al cliente
		//quinto añadir cliente al queue
		
		Catalog clientCatolog = new Catalog(games);
		Client clientToAdd = new Client(id);
		
		
		Stack<Game> games = new Stack<Game>();
		
		
		
		clientToAdd.setGames(clientCatolog);
		clientsQueue.add(clientToAdd);
		
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
	
	
	
	
	
}
