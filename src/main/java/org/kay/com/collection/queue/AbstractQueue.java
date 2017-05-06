package org.kay.com.collection.queue;

import org.kay.com.collection.AbstractCollection;
import org.kay.com.collection.MyIterator;

/**
 *
 *
 * @param <E>
 */
public abstract class AbstractQueue<E> extends AbstractCollection<E> implements MyQueue<E> {

	@Override
	public MyIterator iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
