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
package org.kay.com.structure.map;

import org.junit.jupiter.api.Test;

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
        Map<String, String> map = new MyHashMap<>();
        map.put("001", "James");
        map.put("002", "Antony");
        map.put("003", "Bosh");
        map.put("004", "Wade");
        map.put("004", "WestBrook");
        out.println(map);
        out.println(map.size());
        out.println(map.get("004") + "\n");

        map.insert("005", "test");
        map.remove("003");
        out.println(map);
        out.println(map.size());
        out.println(map.get("004"));
        out.println(map.isEmpty());
    }

    @Test
    public void test1() {
        Map<String, String> map = new MyHashMap<>();
        map.put(null, "");
    }

    @Test
    public void test2() {
        Map<String, String> map = new MyHashMap<>();
        map.put("001", null);
        out.println(map);

        map.put("002", null);
        out.println(map);
    }
}
