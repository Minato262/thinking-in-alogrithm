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

    /* 数组默认长度 */
    private static final int DEFAULT_SIZE = 10;

    /* 数组 */
    private transient Object[] elements;

    /* 数组指针 */
    private int capacity;

    /* 当前记录 */
    private int current;

    /**
     * 默认构造器。
     */
    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * 设置数组长度的构造器。
     *
     * @param size 设置数组长度
     */
    private MyArrayList(int size) {
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException("Array size should not be less than 0!");
        }
        this.capacity = size;
        clear();
    }

    /**
     * 移动游标，调整数据组，对应长度。
     */
    private void index() {
        if (this.current == this.capacity) {
            this.capacity = this.capacity + DEFAULT_SIZE;
            Object[] newElements = new Object[this.capacity];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
            this.elements = newElements;
        }
    }

    /**
     * 根据游标获取数据组数据。
     *
     * @param index 游标
     * @return 数据组游标对应的数据
     */
    @Override
    public E get(int index) {
        if (index > capacity || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Array index out of range: " + index);
        }
        return (E) this.elements[index];
    }

    /**
     * 为数组添加数据。
     *
     * @param e 需要添加的数据
     */
    @Override
    public void add(E e) {
        index();
        this.elements[current] = e;
        this.current++;
    }

    /**
     * 根据需要移除的数据，移除数据组内对应数据。
     *
     * @param e 需要移除的数据
     * @return 是否移除成功
     */
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

    /**
     * 移除数据组内最后一位数据。
     */
    @Override
    public void remove() {
        remove(size() - 1);
    }

    /**
     * 根据数组清单，移除数据组内数据。
     *
     * @param index 游标
     */
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

    /**
     * 按照游标新增对象。
     *
     * @param index 游标
     * @param e 新增对象
     */
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

    /**
     * 判断是否包含对象。
     *
     * @param obj 对象
     * @return 是否包含
     */
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

    /**
     * 数组尺寸。
     *
     * @return 数组尺寸
     */
    @Override
    public int size() {
        return this.current;
    }

    /**
     * 数组是否为空。
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 清除。
     */
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
