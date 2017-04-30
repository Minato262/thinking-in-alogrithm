package org.kay.com.collection.set;

import org.kay.com.collection.AbstractCollection;
import org.kay.com.collection.Iterator;

/**
 *
 * @param <E>
 */
public class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
