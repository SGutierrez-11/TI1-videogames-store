package thread;

import model.Store;

public class GameStoreThread extends Thread{

	private Store gameStore;
	
	private long sleepTime;
	
	public GameStoreThread(Store gameStore,long sleepTime) {
		
		this.gameStore = gameStore;
		this.sleepTime = sleepTime;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
	}	
}
