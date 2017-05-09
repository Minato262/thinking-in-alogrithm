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
 * My Linked List.
 *
 * @param <E>
 * @author kay
 * @version v0.0.1
 */
public class MyLinkedList<E> extends AbstractList<E> implements MyList<E> {

    private transient Node<E> start;

    private transient Node<E> end;

    private int current;

    private int capacity;

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E previous() {
        return null;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public void remove() {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void insert(int index, E e) {

    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }

    @Override
    public int size() {
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public MyIterator<E> iterator() {
        return new NodeIterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    private class NodeIterator implements MyIterator<E> {

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
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

}
