package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

// Wow, this class really needs some comments...
public class Challenges {

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
	
	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String i: left) {
			if (right.contains(i)) {
				output.insert(i);
				}
		}
		
		return output;
	}
	
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
