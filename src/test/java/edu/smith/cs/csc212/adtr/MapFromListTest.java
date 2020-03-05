package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.MapFromList;

public class MapFromListTest {
	
	// You might want this; if you're using Map<String, Integer> anywhere...
	// JUnit has an assertEquals(Object, Object) and an assertEquals(int, int).
	// When you give it assertEquals(Integer, int) it doesn't know which to use (but both would be OK!)
	// This method gets around that by forcing the (int, int) version.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new MapFromList<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testPut() {
		MapADT<String, String> p = new MapFromList<>();
		p.put("A", "apple");
		assertEquals(p.size(), 1);
		p.put("B", "banana");
		assertEquals(p.size(), 2);
		p.put("A", "apple pie");
		assertEquals(p.size(), 2);	
	}
	
	@Test
	public void testContainsString() {
		MapADT<String, String> cons = new MapFromList<>();
		cons.put("A", "apple");
		cons.put("B", "banana");
		assertEquals(cons.get("A"), "apple");
		assertEquals(cons.get("B"), "banana");
		cons.put("A", "apple pie");
		assertEquals(cons.get("A"), "apple pie");
		assertEquals(cons.get("B"), "banana");
		assertEquals(cons.get("C"), null);
		
	}
	
	@Test
	public void testContainsInteger() {
		MapADT<String, Integer> coni = new MapFromList<>();
		coni.put("A", 1);
		coni.put("B", 2);
		assertIntEq(coni.get("A"), 1);
		assertIntEq(coni.get("B"), 2);
		coni.put("A", 2);
		assertIntEq(coni.get("A"), 2);
		assertIntEq(coni.get("B"), 2);	
	}
	
	@Test
	public void testRemoveMore() {
		MapADT<String, String> rem = new MapFromList<>();
		rem.put("A", "apple");
		rem.remove("A");
		assertEquals(rem.size(), 0);
		assertEquals(rem.get("A"), null);
		rem.put("A", "apple pie");
		rem.remove("B");
		assertEquals(rem.size(), 1);
		assertEquals(rem.get("A"), "apple pie");
		assertEquals(rem.remove("A"), "apple pie");
		assertEquals(rem.size(), 0);
		assertEquals(rem.get("A"), null);
	}
	
}
