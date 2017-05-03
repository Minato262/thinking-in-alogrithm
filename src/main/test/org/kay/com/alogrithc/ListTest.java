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
