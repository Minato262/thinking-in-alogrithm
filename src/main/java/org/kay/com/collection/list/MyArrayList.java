/*
 * Copyright 2017-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kay.com.collection.list;

import org.kay.com.collection.MyIterator;

/**
 * My Array List.
 *
 * @param <E>
 * @author kay
 * @version v0.0.1
 */
public class MyArrayList<E> extends AbstractList<E> implements MyList<E> {

	/* array default size */
	private static final int DEFAULT_SIZE = 10;

	/* object array */
	private transient Object[] elements;

	/* array pointer */
	private int capacity;

	/* the current record */
	private int current;

	public MyArrayList() {
		this(DEFAULT_SIZE);
	}

	private MyArrayList(int size) {
		if (size < 0) {
			throw new ArrayIndexOutOfBoundsException("Array size should not be less than 0!");
		}
		this.capacity = size;
		clear();
	}

	private void index() {
		if (this.current == this.capacity) {
			this.capacity = this.capacity + DEFAULT_SIZE;
			Object[] newElements = new Object[this.capacity];
			System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
			this.elements = newElements;
		}
	}

	@Override
	public E get(int index) {
		if (index > capacity || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Array index out of range: " + index);
		}
		return (E) this.elements[index];
	}

	@Override
	public E previous() {
		return null;
	}

	@Override
	public void add(E e) {
		index();
		this.elements[current] = e;
		this.current++;
	}

	@Override
	public boolean remove(E e) {
		for (int i = 0; i < elements.length; i++) {
			if (this.elements[i].equals(e)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void remove() {
		remove(size() - 1);
	}

	@Override
	public void remove(int index) {
		if (index > capacity || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Array index out of range: " + index);
		}

		for (int i = index; i < elements.length; i++) {
			if (i + 1 < elements.length) {
				this.elements[i] = this.elements[i + 1];
			}
		}
		this.current--;
	}

	@Override
	public void insert(int index, E e) {
		if (index > capacity || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Array index out of range: " + index);
		}

		for (int i = 0; i < elements.length; i++) {
			if (i == index && i + 2 < elements.length) {
				this.elements[i + 1] = this.elements[i];
				this.elements[i] = e;
			}
		}
		this.current++;
	}

	@Override
	public boolean contains(Object obj) {
		for (Object element : elements) {
			if (element.equals(obj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E next() {
		return null;
	}

	@Override
	public int size() {
		return this.current;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size(); i++)
			elements[i] = null;
		this.current = 0;
	}

	@Override
	public MyIterator<E> iterator() {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

}
