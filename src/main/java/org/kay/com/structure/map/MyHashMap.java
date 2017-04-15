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
package org.kay.com.structure.map;

import java.util.Objects;

/**
 * My Hash Map.
 *
 * @param <K> Key.
 * @param <V> Value.
 */
public class MyHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double HASH_RANDOM = (Math.pow(5, 0.5) - 1) / 2;

    private transient int capacity;
    private transient int size = 0;

    private transient Node<K, V>[] nodes;

    MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    private MyHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity can not be negative or zero!");
        }

        int temp = 1;
        while (temp < capacity) {
            temp <<= 2;
        }
        this.capacity = temp;
        nodes = new Node[this.capacity];
    }

    private int index(K key) {
        int hashCode = key.hashCode();
        double temp = hashCode * HASH_RANDOM;
        double digit = temp - Math.floor(temp);
        return (int) Math.floor(digit * capacity);
    }

    @Override
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key must be not null!");
        }

        int position = index(key);
        Node<K, V> node = new Node<>(key, value);
        if (nodes[position] != null) {
            node.setNext(nodes[position]);
        }

        nodes[position] = node;
        size++;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key must be not null!");
        }

        int position = index(key);
        Node<K, V> node = nodes[position];
        while (node != null) {
            if (node.getKey().equals(key)) {
                node.value = value;
                return;
            }
            node = node.getNext();
        }

        Node<K, V> newNode = new Node<>(key, value);
        if (nodes[position] != null) {
            newNode.setNext(nodes[position]);
        }

        nodes[position] = newNode;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must be not null!");
        }

        int position = index(key);
        Node<K, V> node = nodes[position];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must be not null!");
        }

        int position = index(key);
        Node<K, V> node = nodes[position];
        if (node == null) {
            return;
        }

        if (node.getKey().equals(key)) {
            nodes[position] = node.getNext();
            size--;
        }

        while (node.getNext() != null) {
            if (node.getNext().getKey().equals(key)) {
                node.setNext(node.getNext().getNext());
                size--;
                break;
            }
            node = node.getNext();
        }
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
    public String toString() {
        StringBuilder builder = new StringBuilder().append("{");
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = nodes[i];
            while (node != null) {
                builder.append(node.getKey()).append(":").append(node.getValue()).append(", ");
                node = node.getNext();
            }
        }

        if (builder.length() > 1) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.append("}").toString();
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        final K getKey() {
            return this.key;
        }

        final V getValue() {
            return this.value;
        }

        final void setNext(Node<K, V> next) {
            this.next = next;
        }

        final Node<K, V> getNext() {
            return this.next;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

}
