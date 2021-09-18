package ui;

import java.util.Scanner;

import model.Store;

public class Main {

	
		
	private static Scanner sc;

	public static void main(String[]args) {
		

		
		sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		sc.nextLine();
		
		int cashier = sc.nextInt();
		sc.nextLine();
		
		int shelves = sc.nextInt();
		sc.nextLine();
		
		
		Store gameStore = new Store(shelves);
		
		for(int i=0;i < shelves;i++) {
			
			String line = sc.nextLine();
			String[] pos = line.split(" ");
			int gamesQuantity = Integer.parseInt(pos[1]);
			String games = "";
			for(int j=0;j<gamesQuantity;j++) {
				
				games+= sc.nextLine() + " ";
				
			}
			gameStore.createShelves(games, i);
				
			
		}
		int clientsAmount = sc.nextInt();
		sc.nextLine();
		
	}
	
	
}
