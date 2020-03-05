package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.SetFromMap;

public class SetFormMapTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new SetFromMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsertOnce() {
		SetADT<String> one = new SetFromMap<>();
		one.insert("A");
		assertEquals(one.size(), 1);
	}
	
	@Test
	public void testRepeatInsert() {
		SetADT<String> more = new SetFromMap<>();
		more.insert("A");
		more.insert("A");
		more.insert("B");
		assertEquals(more.size(), 2);
	}
	
	// this is the code that JJ wrote in class
	@Test
	public void testRepeatInsertJJ() {
		SetADT<String> ab = new SetFromMap<>();
		ab.insert("A");
		ab.insert("A");
		ab.insert("B");
		
		SetADT<String> expected = new SetFromMap<>();
		expected.insert("A");
		expected.insert("B");
		assertEquals(ab, expected);
	}
	
	@Test
	public void testContains() {
		SetADT<String> con = new SetFromMap<>();
		con.insert("A");
		assertTrue(con.contains("A"));
	}
	
	@Test
	public void testNotContains() {
		SetADT<String> notCon = new SetFromMap<>();
		assertFalse(notCon.contains("A"));
	}
	
	@Test
	public void testRemove() {
		SetADT<String> rem = new SetFromMap<>();
		rem.insert("A");
		rem.remove("A");
		assertFalse(rem.contains("A"));
	}
	
	@Test
	public void testNotRemove() {
		SetADT<String> notRem = new SetFromMap<>();
		notRem.insert("B");
		notRem.remove("A");
		assertFalse(notRem.contains("A"));
	}

	
}
