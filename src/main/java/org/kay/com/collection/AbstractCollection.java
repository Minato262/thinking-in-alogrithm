package org.kay.com.collection;

/**
 *
 *
 * @param <E>
 */
public abstract class AbstractCollection<E> implements Collection<E> {

	@Override
	public abstract Iterator iterator();

	@Override
	public abstract int size();

	@Override
	public void add(E o) {

	}

	@Override
	public void remove(int index) {

	}

	@Override
	public void insert(int index, E o) {

	}

	@Override
	public boolean contains(Object obj) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}

	@Override
	public void remove() {

	}
}
