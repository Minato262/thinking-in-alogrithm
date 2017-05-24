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
package org.kay.com.collection.map;

import org.junit.Test;

import static java.lang.System.out;

/**
 * {@link MyHashMap} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyHashMapTest {

	@Test
	public void test() {
		MyMap<String, String> map = new MyHashMap<>();
		map.put("001", "James");
		map.put("002", "Antony");
		map.put("003", "Bosh");
		map.put("004", "Wade");
		map.put("004", "WestBrook");
		out.println(map + "\n" + map.size() + "\n" + map.get("004") + "\n");

		map.insert("005", "test1");
		map.remove("003");
		out.println(map + "\n" + map.size() + "\n" + map.get("004") + "\n" + map.isEmpty());
	}

	@Test
	public void test1() {
		MyMap<String, String> map = new MyHashMap<>();
		map.put(null, "");
	}

	@Test
	public void test2() {
		MyMap<String, String> map = new MyHashMap<>();
		map.put("001", null);
		out.println(map);

		map.put("002", null);
		out.println(map);
	}

	@Test
	public void test3() {
		MyMap<String, String> map = new MyHashMap<>();
		map.put("", "");
		out.println(map.get(""));
	}
}
