package model;

public class Catalog {

	private Game games[];
	
	public Catalog(Game[] games) {
		this.games = games;
	}
	
	
	public Game[] getGames() {
		return games;
	}

	public void setGames(Game[] games) {
		this.games = games;
	}
	
}
