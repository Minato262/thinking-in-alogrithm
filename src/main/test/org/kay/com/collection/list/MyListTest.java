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

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link MyList} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyListTest {
    private static List<Integer> array = new ArrayList<>();
    private static List<Integer> linked = new LinkedList<>();

    private static final int DEFAULT_SIZE = 10000;

    private static long getTime(List<Integer> list) {
        final long time = System.currentTimeMillis();
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }
        }
        return System.currentTimeMillis() - time;
    }

    private static long insertTime(List<Integer> list) {
        final long time = System.currentTimeMillis();
        for (int i = 100; i < DEFAULT_SIZE; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - time;
    }

    @Test
    public void test() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            array.add(i);
            linked.add(i);
        }

        System.out.println("array time:" + getTime(array));
        System.out.println("linked time:" + getTime(linked));
        System.out.println("array insert time:" + insertTime(array));
        System.out.println("linked insert time:" + insertTime(linked));
    }

    @Test
    public void test1() {
        linked.add(1);
        linked.add(2);
        linked.add(3);
    }
}
