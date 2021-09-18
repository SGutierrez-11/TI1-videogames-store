package model;

import java.util.Hashtable;

public class Store {

	private int shelvesQuantity;
	
	private Hashtable[] shelves;
	
	public Store(int shelvesToCreate) {
	
		shelvesQuantity = shelvesToCreate;
		
		shelves = createHashTables(shelvesToCreate);
	}
	
	public void createShelves(String [] games, int position) {
		
		
		
		for(int i=0; i < games.length;i++) {
		
		String [] parts = games[0].split(" ");
			
		Game game = new Game(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
			
		shelves[position].put(parts[0], game);
		
		}
	}
	
	public Hashtable[] createHashTables(int toCreate) {
		
		Hashtable[] tables = new Hashtable[toCreate];
		
		for(int i=0; i < toCreate;i++) {
			
			Hashtable tmp = new Hashtable<>();
			tables[i] = tmp;
		}
		return tables;
	}
}
