package collections;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.Game;
import model.Store;

public class StackTest {
	
	private Stack<Game> stack;
	private Game game;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		stack = new Stack<>();
		game = new Game("123", 1000, 5);
		stack.push(game);
	}
	
	
	@Test
	public void testEmpty_1() {
		setupStage1();
		
		Stack<Game> st = new Stack<>();
		
		assertTrue(st.empty());
	}
	
	@Test
	public void testEmpty_2() {
		setupStage2();
		assertFalse(stack.empty());
	}
	
	@Test
	public void testPeek() {
		setupStage1();
		Stack<Game> st = new Stack<>();
		assertEquals(st.peek(),null);
	}
	
	@Test
	public void testPeek2() {
		setupStage2();
		
		assertEquals(stack.peek(), game);
	}
	
	@Test
	public void testPush() {
		setupStage1();
		Stack<Game> st = new Stack<>();
		assertEquals(st.size(), 0);
		assertTrue(st.empty());
	}
	
	@Test
	public void testPush2() {
		setupStage2(); 
		assertEquals(stack.size(), 1);
		assertFalse(stack.empty());
	}
	
	@Test
	public void testPop() {
		setupStage1();
		Stack<Game> st = new Stack<>();
		assertEquals(st.pop(), null);
	}
	
	@Test
	public void testPop2() {
		setupStage2();
		assertEquals(stack.pop(), game);
	}
	
	@Test
	public void testSize() {
		setupStage1();
		Stack<Game> st = new Stack<>();
		assertEquals(st.size(), 0);
	}

	@Test
	public void testSize2() {
		setupStage2();
		assertEquals(stack.size(), 1);
	}
}
