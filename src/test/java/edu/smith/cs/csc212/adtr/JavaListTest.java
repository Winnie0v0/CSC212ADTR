package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}
	
	@Test
	public void testAddIndex() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addBack("0");
		data.addBack("1");
		data.addBack("2");
		data.addBack("3");
		Assert.assertEquals(4, data.size());
		data.addIndex(4, "4");
		Assert.assertEquals("4", data.getIndex(4));
		Assert.assertEquals(5, data.size());
		data.addIndex(0, "-1");
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals(6, data.size());	
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testAddToBack() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addBack("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("-2");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("-2", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("-2");
		Assert.assertEquals(5, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("-2", data.getIndex(3));
		Assert.assertEquals("-2", data.getIndex(4));
		Assert.assertEquals(false, data.isEmpty());
	}

	@Test
	public void testRemoveBack() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("c", data.getIndex(data.size()-1));
	}
	
	@Test
	public void testRemoveIndext() {
		ListADT<String> data = makeFullList();
		Assert.assertEquals("a", data.removeIndex(0));
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("b", data.getIndex(0));
		Assert.assertEquals("d", data.removeIndex(2));
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("c", data.getIndex(data.size()-1));
	}
	
	
	@Test
	public void testRemoveFront() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("b", data.getIndex(0));
	}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	@Test
	public void testSetIndex() {
		ListADT<String> data = makeFullList();
		data.setIndex(0, "z");
		Assert.assertEquals(4, data.size());
		Assert.assertEquals("z", data.getIndex(0));
		Assert.assertEquals("b", data.getIndex(1));
		data.setIndex(3, "a");
		Assert.assertEquals("a", data.getIndex(3));
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
