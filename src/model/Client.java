package model;

public class Client {

	private String id;
	
	private Catalog games;
	
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
	
	
	
}
