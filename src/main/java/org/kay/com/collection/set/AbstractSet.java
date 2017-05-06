package org.kay.com.collection.set;

import org.kay.com.collection.AbstractCollection;
import org.kay.com.collection.MyIterator;

/**
 *
 * @param <E>
 */
public class AbstractSet<E> extends AbstractCollection<E> implements MySet<E> {

	@Override
	public MyIterator iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
