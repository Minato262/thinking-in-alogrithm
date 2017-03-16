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
package org.kay.com.structure.list;

/**
 * My Array List.
 *
 * @param <E>
 * @author kay
 * @version v0.0.1
 */
public class MyArrayList<E> implements List<E> {

    private static int DEFAULT_SIZE = 10;  // array default size

    private Object[] elements;  // queue storage

    private int capacity;   // array pointer

    private int current;    // the current record

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException("Array size should not be less than 0!");
        }

        this.elements = new Object[size];
        this.capacity = size;
        this.current = 0;
    }

    private void confirmIndexOutOfBounds(int index) {
        if (index > capacity || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Array index out of range: " + index);
        }
    }

    private void confirmSize() {
        if (this.current == this.capacity) {
            this.capacity = this.capacity + DEFAULT_SIZE;
            Object[] newElements = new Object[this.capacity];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
            this.elements = newElements;
        }
    }

    @Override
    public E get(int index) {
        confirmIndexOutOfBounds(index);
        return (E) this.elements[index];
    }

    @Override
    public void add(E e) {
        confirmSize();
        this.elements[current] = e;
        this.current++;
    }

    @Override
    public void remove(int index) {
        confirmIndexOutOfBounds(index);
        for (int i = index; i < elements.length; i++) {
            if (i + 1 < elements.length) {
                this.elements[i] = this.elements[i + 1];
            }
        }
        this.current--;
    }

    @Override
    public void insert(int index, E e) {
        confirmIndexOutOfBounds(index);
        for (int i = 0; i < elements.length; i++) {
            if (i >= index && i + 2 < elements.length) {
                this.elements[i] = e;
                this.elements[i + 1] = this.elements[i + 2];
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
    public int size() {
        return this.current;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        this.elements = new Object[DEFAULT_SIZE];
    }

    public static void main(String[] args) {
        List<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("下标为3的元素为:" + list.get(3));
        System.out.println("数组size:" + list.size());

        list.remove(2);
        System.out.println("remove后的数组size:" + list.size());

        System.out.print("remove后的数组:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println("");

        list.insert(3, "gg");
        System.out.print("insert后的数组:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }
}
