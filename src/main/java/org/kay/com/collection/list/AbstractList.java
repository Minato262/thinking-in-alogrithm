package org.kay.com.collection.list;

import org.kay.com.collection.AbstractCollection;

/**
 *
 * @param <E>
 */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E previous() {
		return null;
	}

	@Override
	public boolean remove(E e) {
		return false;
	}
}
