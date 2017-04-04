package org.kay.com.structure.list;

import org.kay.com.structure.Iterator;

/**
 * My Linked List.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyLinkedList<E> implements List<E> {

    private transient Node<E> begin;

    private transient Node<E> end;

    private transient int current;

    private transient int capacity;

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
    public Iterator<E> iterator() {
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

    private class NodeIterator implements Iterator<E> {

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

        private E data;

        private Node<E> prev;

        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

}
