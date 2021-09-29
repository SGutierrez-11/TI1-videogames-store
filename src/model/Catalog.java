package model;

import collections.Stack;

public class Catalog {

	private Stack<Game> games;
	
	public Catalog(Stack<Game> games) {
		this.games = games;
	}
	
	
	public Stack<Game> getGames() {
		return games;
	}

	public void setGames(Stack<Game> games) {
		this.games = games;
	}
	
}
