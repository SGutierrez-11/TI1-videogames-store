package model;

import java.util.Hashtable;

import collections.Queue;

public class Store {

	private int shelvesQuantity;
	
	private Hashtable[] shelves;
	
	private Queue<Client> clientsQueue;
	
	public Store(int shelvesToCreate) {
	
		shelvesQuantity = shelvesToCreate;
		
		shelves = createHashTables(shelvesToCreate);
		
		clientsQueue = new Queue<Client>();
	}
	
	public void createShelves(String game, int position) {
		
		String[] values = game.split(" ");
		Game gameToAdd = new Game(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]));
		shelves[position].put(values[0], gameToAdd);
		System.out.println("Codigo: " + gameToAdd.getCode() + " Precio: " + gameToAdd.getPrice()+ " cantidad: " + gameToAdd.getQuantity());
		
		
	}
	
	public Hashtable[] createHashTables(int toCreate) {
		
		Hashtable[] tables = new Hashtable[toCreate];
		
		for(int i=0; i < toCreate;i++) {
			
			Hashtable tmp = new Hashtable<>();
			tables[i] = tmp;
		}
		return tables;
	}
	public void addClienteToQueue(String id,String [] games) {
		
	}
}
