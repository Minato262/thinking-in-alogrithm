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

    private static int    DEfAULT_CAPACITY = 16;
    private static double A                = (Math.pow(5, 0.5) - 1) / 2;

    private transient int capacity;
    private transient int size = 0;

    private transient Node<K, V>[] nodes;

    public MyHashMap() {
        this(DEfAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
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

    private static class Node<K, V> {
        private final K          key;
        private       V          value;
        private       Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final void setValue(V value) {
            this.value = value;
        }

        public final Node<K, V> getNext() {
            return next;
        }

        public final void setNext(Node<K, V> next) {
            this.next = next;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
