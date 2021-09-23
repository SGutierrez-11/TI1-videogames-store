package model;

public class Game {

	private String code;
	
	private int price;
	
	private int quantity;
	
	public Game(String code, int price, int quantity) {
		
		this.code = code;
		
		this.price = price;
		
		this.quantity = quantity;
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
