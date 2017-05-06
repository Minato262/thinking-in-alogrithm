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

import static java.lang.System.out;

/**
 * {@link MyArrayList} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyArrayListTest {

	private MyList<String> init() {
		MyList<String> list = new MyArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		return list;
	}

	private void print(MyList list, String message) {
		out.printf(message);
		for (int i = 0; i < list.size(); i++) {
			out.printf(list.get(i) + ",");
		}
	}

	@Test
	public void getBoundsTest() {
		MyList<String> list = init();
		out.printf("get:" + list.get(3));
	}

	@Test
	public void removeBoundsTest() {
		MyList<String> list = init();
		list.remove(2);
		print(list, "remove size:" + list.size() + "\n" + "remove:");
	}

	@Test
	public void removeTest() {
		MyList<String> list = init();
		list.remove("a");
		print(list, "remove size:" + list.size() + "\n" + "remove:");
	}

	@Test
	public void insertBoundsTest() {
		MyList<String> list = init();
		list.insert(3, "gg");
		print(list, "insert:");
	}
}
