package thread;

import ui.StoreUI;

public class GameStoreThread2 extends Thread{
	
	private StoreUI ui;
	
	public GameStoreThread2(StoreUI ui) {
		this.ui = ui;
	}
	@Override
	public void run() {
			
		System.out.println("Entral al hilo 2");

				ui.initializeCustomerPayTableview();
			
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}	
	
}
