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
		
		
		Store gameStore = new Store(shelves,cashier);
		
		for(int i=0;i < shelves;i++) {
			
			String line = sc.nextLine();
			String [] values = line.split(" ");
			
			for(int j=0; j < Integer.parseInt(values[1]);j++) {
				
				String gameInfo = sc.nextLine();
				gameStore.createShelves(gameInfo, i);
				
				
				
			}
			
		}
		int clientsAmount = sc.nextInt();
		sc.nextLine();
		for(int i=0; i < clientsAmount;i++) {
			
			String clientData = sc.nextLine();
			gameStore.addClienteToQueue(clientData);
			
		}
		
	}
	
	
}
