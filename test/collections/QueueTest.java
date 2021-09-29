package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import model.Catalog;
import model.Client;
import model.Game;

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
	public void testAdd_1() {
		setupStage1();
		Client cl = new Client("1551");
		Queue<Client> q = new Queue<>();
		Stack<Game> st = new Stack<>();
		Game gm = new Game("123", 100, 2);
		Game gm1 = new Game("222", 23, 4);
		Game gm2 = new Game("314", 123, 3);
		
		st.push(gm);
		st.push(gm1);
		st.push(gm2);
		
		Catalog ct = new Catalog(st);
		
		cl.setGames(ct);	
		q.add(cl);
		
		assertFalse(q.isEmpty());
		assertEquals(q.peek().getGames().getGames().size(), st.size());
		
	}
	
	@Test
	public void testAdd_2() {
		setupStage2();
		
		assertEquals(queue.peek(), client);
		assertNotNull(queue);
	}
	
	@Test
	public void testRemove_1() {
		setupStage1();
		Queue<Client> q = new Queue<>();
		assertEquals(q.remove(), null);
	}
	
	@Test
	public void testRemove_2() {
		setupStage2();
		assertEquals(queue.remove(), client);
	}
	
	@Test
	public void testPeek_1() {
		setupStage1();
		Queue<Client> q = new Queue<>();
		q.add(null);
		assertEquals(q.peek(), null);
	}
	
	@Test
	public void testPeek_2() {
		setupStage2();
		assertEquals(queue.peek(), client);
	}
}
