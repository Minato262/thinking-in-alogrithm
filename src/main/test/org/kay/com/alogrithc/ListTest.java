package org.kay.com.alogrithc;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListTest {

	@Test
	public void test() {
		Map<String, String> map = new HashMap<>();
		map.put("apple", "苹果");
		map.put("watermelon", "西瓜");
		map.put("banana", "香蕉");
		map.put("peach", "桃子");

		map.get("banana");
		map.get("apple");

		for (Object obj : map.entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	@Test
	public void test1() {
		Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
		map.put("apple", "苹果");
		map.put("watermelon", "西瓜");
		map.put("banana", "香蕉");
		map.put("peach", "桃子");

		for (Object obj : map.entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
