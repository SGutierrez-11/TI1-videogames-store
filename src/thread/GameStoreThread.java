package thread;

import model.Store;

public class GameStoreThread extends Thread{

	private Store gameStore;
	
	public GameStoreThread(Store gameStore) {
		
		this.gameStore = gameStore;
		
	}
	@Override
	public void run() {
		try {
			while(gameStore.getClientsQueue().isEmpty()==false) {
				
				System.out.println("Entral al hilo 1");
				gameStore.payClient();
				
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
	}	
}
