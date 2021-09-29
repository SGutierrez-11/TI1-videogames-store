package collections;

import org.junit.jupiter.api.Test;

import model.Client;

public class QueueTest {
	
	private Queue<Client> queue;
	private Client client;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		queue = new Queue<>();
		client = new Client("1006426560");
		queue.add(client);
	}
	
	@Test
	public void testAdd() {
		
	}
	
	
}
