package model;

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
	public String getAllGames() {
		
		String games = "";
		
		Catalog tmpCatalog = getGames();
		
		while(tmpCatalog.getGames().empty()==false) {
		
			System.out.println(games + "Paso por aqui");
			Game tmpGame = tmpCatalog.getGames().pop();
			
			if(tmpGame.getCode()=="") {
				
			}else {
			games+= tmpGame.getCode() + ", "; 
			}
			
		}	
		allGames = games;
		return allGames;
	}

	public void setAllGames(String allGames) {
		this.allGames = allGames;
	}
	
	
	
}
