package org.kay.com.collection.list;

import org.junit.Test;

import java.util.*;

/**
 *
 */
public class ArrayListTest {

	@Test
	public void test() {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);

		//通过构造函数新建一个包含list1的列表 list2
		List<Integer> list2 = new ArrayList<>(list1);

		//通过subList生成一个与list1一样的列表 list3
		List<Integer> list3 = list1.subList(0, list1.size());

		//修改list3
		list3.add(3);

		System.out.println("list1 == list2：" + list1.equals(list2));
		System.out.println("list1 == list3：" + list1.equals(list3));
	}
}
