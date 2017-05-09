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
package org.kay.com.collection;

/**
 * Abstract Collection.
 *
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
