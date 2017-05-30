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

import org.kay.com.collection.AbstractCollection;

/**
 * Abstract List.
 *
 * @param <E>
 */
public abstract class AbstractList<E> extends AbstractCollection<E> implements MyList<E> {

    @Override
    public void add(int index, E e) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E newVal) {
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

    @Override
    public int size() {
        return 0;
    }
}
