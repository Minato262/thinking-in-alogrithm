package org.kay.com.collection.map;

/**
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractMap<K, V> implements MyMap<K, V> {

	@Override
	public void insert(K key, V value) {

	}

	@Override
	public void put(K key, V value) {

	}

	@Override
	public void remove(K key) {

	}

	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
