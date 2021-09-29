package model;

import collections.Stack;

public class Client {

	private String id;
	
	private Catalog games;
	
	private String allGames;
	
	private int toPay;
	
	public Client(String id) {
		
		this.id = id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Catalog getGames() {
		return games;
	}

	public void setGames(Catalog games) {
		this.games = games;
	}

	public int getToPay() {
		return toPay;
	}

	public void setToPay(int toPay) {
		this.toPay = toPay;
	}
	public String getAllGames() throws CloneNotSupportedException {
		
		String games = "";
		
		Stack<Game> tmpStack = new Stack<Game>();
		Stack<Game> tmpStack2 = new Stack<Game>();
		

		Catalog tmpCatalog = new Catalog(getGames().getGames());

		
		//Catalog tmpCatalog = getGames();
		
		while(getGames().getGames().empty()==false) {
		
			//System.out.println(games + "Paso por aqui");
			Game tmpGame =getGames().getGames().pop();
			tmpStack.push(tmpGame);
			
			if(tmpGame.getCode()=="") {
				
			}else {
			games+= tmpGame.getCode() + ", "; 
			System.out.println("Games: " + games);
			}
			
		}
		while(tmpStack.isEmpty()==false) {
			
			Game tmpGame2 = tmpStack.pop();
			tmpStack2.push(tmpGame2);
			
		}
		allGames = games;
		getGames().setGames(tmpStack2);
		return allGames;
	}

	public void setAllGames(String allGames) {
		this.allGames = allGames;
	}
	
	
	
}
