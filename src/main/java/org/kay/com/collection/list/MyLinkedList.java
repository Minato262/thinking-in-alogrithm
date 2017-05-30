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

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * My Linked List.
 *
 * @param <E>
 * @author kay
 * @version v0.0.1
 */
public class MyLinkedList<E> extends AbstractList<E> implements MyList<E> {

    private transient Node<E> beginMarker;
    private transient Node<E> endMarker;
    private int theSize;
    private int modCount = 0;

    public MyLinkedList() {
        init();
    }

    public void clear() {
        init();
    }

    private void init() {
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(E x) {
        add(size(), x);
    }

    public void add(int idx, E x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public E get(int idx) {
        return getNode(idx).data;
    }

    public E set(int index, E newVal) {
        Node<E> p = getNode(index);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public void remove(int idx) {
        remove(getNode(idx));
    }

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private E remove(Node<E> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;

        return p.data;
    }

    private Node<E> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<E> getNode(int idx, int lower, int upper) {
        Node<E> p;

        if (idx < lower || idx > upper)
            throw new IndexOutOfBoundsException();

        if (idx < size() >> 1) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++)
                p = p.next;
        }
        else {
            p = endMarker;
            for (int i = size(); i > idx; i--)
                p = p.prev;
        }
        return p;
    }

    public MyIterator<E> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E d, Node<E> p, Node<E> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private class LinkedListIterator implements MyIterator<E> {
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public E next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();

            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

}
