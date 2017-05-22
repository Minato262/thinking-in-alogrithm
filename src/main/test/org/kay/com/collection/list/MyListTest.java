package org.kay.com.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
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
        long time = System.currentTimeMillis();
        for (int i = 100; i < DEFAULT_SIZE; i++) {
            list.add(5000, i);
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
}
