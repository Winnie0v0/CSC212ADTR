package edu.smith.cs.csc212.adtr.real;

import java.util.ArrayList;
import java.util.List;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.SetADT;

/**
 * Java Set Data Structure wrapped in our SetADT interface.
 *
 * @param <T> - the type of items in the set.
 */
public class SetFromList<T> extends SetADT<T> {
	/**
	 * The private Java set on the inside; does all the work.
	 */
	private List<T> inner = new ArrayList<T>();
	
	@Override
	public int size() {
		return inner.size();
	}

	@Override
	public void insert(T value) {
		if (!inner.contains(value)) {
			inner.add(value);
		}
	}

	@Override
	public boolean contains(T value) {
		return inner.contains(value);
	}

	@Override
	public void remove(T value) {
		inner.remove(value);		
	}

	@Override
	public ListADT<T> toList() {
		return new JavaList<>(new ArrayList<>(inner));
	}
}
