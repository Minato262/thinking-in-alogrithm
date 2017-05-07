package org.kay.com.collection;

/**
 * @param <E>
 */
public abstract class AbstractCollection<E> implements MyCollection<E> {

	@Override
	public abstract MyIterator iterator();

	@Override
	public abstract int size();

	@Override
	public void add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(int index) {

	}

	@Override
	public void insert(int index, E e) {

	}

	@Override
	public boolean contains(Object obj) {
		MyIterator<E> e = iterator();
		if (obj == null) {
			while (e.hasNext())
				if (e.next() == null)
					return true;
		}
		else {
			while (e.hasNext())
				if (obj.equals(e.next()))
					return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
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

	@Override
	public String toString() {
		return null;
	}
}
