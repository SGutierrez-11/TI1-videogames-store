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
		
		
		Catalog tmpCatalog = getGames();
		
		while(tmpCatalog.getGames().empty()==false) {
		
			System.out.println(games + "Paso por aqui");
			Game tmpGame = tmpCatalog.getGames().pop();
			tmpStack.push(tmpGame);
			
			if(tmpGame.getCode()=="") {
				
			}else {
			games+= tmpGame.getCode() + ", "; 
			}
			
		}
		while(tmpStack.isEmpty()==false) {
			
			Game tmpGame2 = tmpStack.pop();
			tmpStack2.push(tmpGame2);
			
		}
		getGames().setGames(tmpStack2);
		allGames = games;
		return allGames;
	}

	public void setAllGames(String allGames) {
		this.allGames = allGames;
	}
	
	
	
}
