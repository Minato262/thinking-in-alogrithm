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

    private transient Node<E> first;
    private transient Node<E> last;
    private int size;
    private int modCount = 0;

    MyLinkedList() {
        init();
    }

    public void clear() {
        init();
    }

    private void init() {
        first = new Node<>(null, null, null);
        last = new Node<>(null, first, null);
        first.next = last;
        size = 0;
        modCount++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(E x) {
        add(size(), x);
    }

    @Override
    public void add(int index, E e) {
        addBefore(getNode(index, 0, size()), e);
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public E set(int index, E newVal) {
        Node<E> p = getNode(index);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    @Override
    public void remove(int index) {
        Node<E> p = getNode(index);
        remove(p);
    }

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        size++;
        modCount++;
    }

    private E remove(Node<E> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        modCount++;
        return p.data;
    }

    private Node<E> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    private Node<E> getNode(int index, int lower, int upper) {
        Node<E> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size() >> 1) {
            p = first.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        else {
            p = last;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
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
        private Node<E> current = first.next;
        private int expectedModCount = modCount;
        private boolean isRemove = false;

        @Override
        public boolean hasNext() {
            return current != last;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E e = current.data;
            current = current.next;
            isRemove = true;
            return e;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!isRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            isRemove = false;
        }
    }

}
