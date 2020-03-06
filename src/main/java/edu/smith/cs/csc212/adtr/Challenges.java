package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

/**
 * This class include three method - union, intersection, and wordCount.
 * @author macbookpro
 *
 */
public class Challenges {

	/**
	 * Union find what the left and right set have in total.
	 * @param left - The left set.
	 * @param right - The right set.
	 * @return what the left and right set have in total.
	 */
	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String i: left) {
			output.insert(i);
		}
		for (String j: right) {
			output.insert(j);
		}
		return output;
	}
	
	/**
	 * Intersection find what the left and right set both have.
	 * @param left - The left set.
	 * @param right - The right set.
	 * @return what the left and right set both have.
	 */
	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String i: left) {
			if (right.contains(i)) {
				output.insert(i);
				}
		}
		
		return output;
	}
	
	/**
	 * wordCount find how many times did each letter appear in a list and stores them into a map.
	 * @param words - a list of string that contains letter you want to count.
	 * @return a map that stores the number of time each word appear in the list.
	 */
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		for (String i: words) {
			if (output.get(i) == null) {
				output.put(i, 1);
			}
			else {
				int oneMore = output.get(i)+1;
				output.put(i, oneMore);
			}
		}
		return output;
	}
}
