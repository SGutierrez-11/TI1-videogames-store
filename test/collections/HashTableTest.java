package collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Game;
import model.Store;

public class HashTableTest {
	
	private HashTable<Game> hash;
	private Game game;
	
	public void setupStage1() {
		
	}
	
	public void setupStage2() {
		
		hash = new HashTable<>(1);
		game = new Game("123", 1000, 5);
		hash.insert(game.getCode(), game);
	}
	
	@Test
	public void testGetSize_1() {
		setupStage1();
		
		HashTable<Game> ht = new HashTable<>(0);
		
		assertEquals(ht.getSize(),0);
		
	}
	
	@Test
	public void testGetSize_2() {
		setupStage2();
		
		assertEquals(hash.getSize(),1);
		
	}
	
	@Test
	public void testIsFull_1() {
		setupStage1();
		HashTable<Game> ht = new HashTable<>(1);
		assertFalse(ht.isFull());	
	}
	
	@Test
	public void testIsFull_2() {
		setupStage2();
		
		assertTrue(hash.isFull());	
	}
	
	@Test
	public void testIsEmpty_1() {
		setupStage1();
		HashTable<Game> ht = new HashTable<>(1);
		assertTrue(ht.isEmpty());	
	}
	
	@Test
	public void testIsEmpty_2() {
		setupStage2();
		assertFalse(hash.isEmpty());	
	}
	
	
	@Test
	public void testContains_1() {
		setupStage1();
		HashTable<Game> ht = new HashTable<>(1);
		assertTrue(ht.contains("123"));	
	}
	
	@Test
	public void testContains_2() {
		setupStage2();
		assertFalse(hash.contains("123"));	
	}
	
	@Test
	public void testHash_1() {
		setupStage1();
		HashTable<Game> ht = new HashTable<>(1);
		assertEquals(ht.hash("123"),0);
	}
	
	@Test
	public void testHash_2() {
		setupStage2();		
		assertEquals(hash.hash("123"),0);
	}
	
	@Test
	public void testInsert_1() {
		setupStage1();
		HashTable<Game> ht = new HashTable<>(1);
		assertEquals(ht.getSize(),0);
		assertTrue(ht.isEmpty());
	}
	
	@Test
	public void testInsert_2() {
		setupStage2();
		assertEquals(hash.getSize(),1);
		assertFalse(hash.isEmpty());
	}
	
	@Test
	public void testInsert_3() {
		setupStage2();
		Game gm = new Game("231", 400, 3);
		hash.insert(gm.getCode(), gm);
		
		assertEquals(hash.getSize(),1);
		assertEquals(hash.get("231"),null);
		assertFalse(hash.isEmpty());
	}
	
	@Test
	public void testGet_1() {
		setupStage1();
		HashTable<Game> ht = new HashTable<>(1);
		assertEquals(ht.get("123"), null);
	}
	
	
	
}
