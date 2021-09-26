package model;


import collections.HashTable;
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import thread.GameStoreThread;

public class Store {

	private int shelvesQuantity;
	
	private HashTable<Game>[] shelves;
	
	private Queue<Client> clientsQueue;
	
	private LinkedList<GameStoreThread> cashier;
	
	public Store(int shelvesToCreate, int cashierAmount) {
	
		shelvesQuantity = shelvesToCreate;
		
		shelves = new HashTable[shelvesToCreate];
		
		createHashTables(shelvesToCreate);
		
		clientsQueue = new Queue<Client>();
		
		GameStoreThread firstThread = new GameStoreThread(this, 20);
		cashier = new LinkedList<GameStoreThread>(firstThread);
		createCashiers(shelvesToCreate,1, cashier);
		
	}
	
	public void createShelves(String game, int position) {
		
		String[] values = game.split(" ");
		Game gameToAdd = new Game(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]));
		shelves[position].insert(values[0], gameToAdd);
		System.out.println("Codigo: " + gameToAdd.getCode() + " Precio: " + gameToAdd.getPrice()+ " cantidad: " + gameToAdd.getQuantity());
		
		
	}
	
	public HashTable<Game>[] createHashTables(int toCreate) {
		
		HashTable<Game>[] tables = new HashTable [toCreate];
		
		for(int i=0; i < toCreate;i++) {
			
			HashTable<Game> tmp = new HashTable<Game>();
			tables[i] = tmp;
		}
		return tables;
		
	}
	public void addClienteToQueue(String info) {
		
		String[]data = info.split(" ");
		
		String id = data[0];
		
		Stack<Game> games = new Stack();
		
		for(int i=0; i < shelves.length;i++) {
			
			if((shelves[i].get(data[1])!=null)) {
				
				Game tmp = (Game) shelves[i].get(data[1]);
				System.out.println("Juego encontrado: " + tmp.getCode() + " Y debia ser: " + data[1]);
				
				if(tmp.getQuantity()>=1) { //Ordenar juegos
					games.push(tmp);
					System.out.println(games.peek().getCode() + " Entro correctamente");
				}
			}
		}
		Catalog clientCatolog = new Catalog(games);
		Client clientToAdd = new Client(id);
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
	public void payClient() {
		
		Stack<Game> stackToPay = new Stack<Game>();
		
		if(clientsQueue.isEmpty()==false) {
			
			Client tmp = clientsQueue.remove();
			
			int amountToPlay = 0;
			
			for()
			
			Game tmpGame = tmp.getGames().getGames().peek();
			
			amountToPlay +=
			
		}
		
		
	}
}
