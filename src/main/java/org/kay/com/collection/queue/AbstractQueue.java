package org.kay.com.collection.queue;

import org.kay.com.collection.AbstractCollection;
import org.kay.com.collection.Iterator;

/**
 *
 *
 * @param <E>
 */
public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
