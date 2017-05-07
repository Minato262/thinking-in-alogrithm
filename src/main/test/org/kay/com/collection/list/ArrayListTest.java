package org.kay.com.collection.list;

import org.junit.Test;

import java.util.*;

/**
 * {@link ArrayList} Test.
 */
public class ArrayListTest {

	@Test
	public void test() {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);

		List<Integer> list2 = new ArrayList<>(list1);
		List<Integer> list3 = list1.subList(0, list1.size());
		list3.add(3);

		System.out.println("list1 == list2：" + list1.equals(list2));
		System.out.println("list1 == list3：" + list1.equals(list3));
	}
}
