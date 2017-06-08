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
package org.kay.com.alogrithc;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link HashMap} and {@link LinkedHashMap} Test。
 *
 * @author kay
 * @version v0.0.1
 */
public class ListTest {

	private static void println(Map<String, String> map) {
		for (Object obj : map.entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	@Test
	public void test() {
		Map<String, String> map = new HashMap<>();
		map.put("apple", "苹果");
		map.put("watermelon", "西瓜");
		map.put("banana", "香蕉");
		map.put("peach", "桃子");
		println(map);
	}

	@Test
	public void test1() {
		Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
		map.put("apple", "苹果");
		map.put("watermelon", "西瓜");
		map.put("banana", "香蕉");
		map.put("peach", "桃子");
		println(map);

		map.get("banana");
		map.get("apple");

		System.out.println();
		println(map);
	}
}
