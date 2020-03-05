package edu.smith.cs.csc212.adtr.real;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.SetADT;

/**
 * Java Set Data Structure wrapped in our SetADT interface.
 *
 * @param <T> - the type of items in the set.
 * @param <K> - the key in the map.
 */
public class SetFromMap<K,T> extends SetADT<T> {
	/**
	 * The private Java hashmap that does all the work.
	 */
	private LinkedHashMap<Integer,T> inner = new LinkedHashMap<Integer,T>();
	
	private Integer keyInSet = new Integer(0);

	@Override
	public int size() {
		return inner.size();
	}

	@Override
	public void insert(T value) {
		if (!inner.containsValue(value)) {
			inner.put(this.keyInSet, value);
		}
		keyInSet += 1;
	}

	@Override
	public boolean contains(T value) {
		return inner.containsValue(value);
	}

	@Override
	public void remove(T value) {
		for (Entry<Integer, T> entry: inner.entrySet()) {
			if (value == entry.getValue()) {
				inner.remove(entry.getKey());
			}
		}
	}

	@Override
	public ListADT<T> toList() {
		ListADT<T> JL = new JavaList<>();
		for (T entry: inner.values()) {
			JL.addBack(entry);
		}
		return JL;
	}
}
