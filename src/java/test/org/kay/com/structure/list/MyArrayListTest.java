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
package org.kay.com.structure.list;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;

/**
 * {@link MyArrayList} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyArrayListTest {

    @Test
    public void IndexOutOfBoundsTest() {
        List<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        out.println("下标为3的元素为:" + list.get(3));
        out.println("数组size:" + list.size());

        list.remove(2);
        out.println("remove后的数组size:" + list.size());

        out.print("remove后的数组:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
        out.println("");

        list.insert(3, "gg");
        out.print("insert后的数组:");
        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i) + ",");
        }
    }
}
