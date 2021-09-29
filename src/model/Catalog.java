package model;

import collections.Stack;

public class Catalog implements Cloneable{

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
	@Override
	public Catalog clone() throws CloneNotSupportedException {
		
		return (Catalog) super.clone();
		
	}
	
}
