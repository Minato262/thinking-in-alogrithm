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
