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
import org.kay.com.collection.MyIterator;

/**
 * {@link MyLinkedList} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyLinkedListTest {

    @Test
    public void test() {
        MyLinkedList<String> linked = new MyLinkedList<>();
        linked.add("www.");
        linked.add("bw");
        linked.add(".com");
        linked.add("s");
        linked.remove(3);
        linked.add(".cn");

        System.out.println(linked.get(2));
        System.out.println(linked.set(1, "hello"));

        MyIterator<String> iterator = linked.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item);
        }
    }
}
