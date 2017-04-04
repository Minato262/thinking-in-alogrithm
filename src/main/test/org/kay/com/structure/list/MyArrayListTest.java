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

    private List<String> init(){
        List<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        return list;
    }

    private void printList(List list, String message){
        out.printf(message);
        for (int i = 0; i < list.size(); i++) {
            out.printf(list.get(i) + ",");
        }
    }

    @Test
    public void getBoundsTest() {
        List<String> list = init();
        out.printf("get:" + list.get(3));
    }

    @Test
    public void removeBoundsTest() {
        List<String> list = init();
        list.remove(2);
        printList(list, "remove size:" +
                                 list.size() +
                                 "\n" +
                                 "remove:");
    }

    @Test
    public void removeTest() {
        List<String> list = init();
        list.remove("a");
        printList(list,"remove size:" +
                                list.size() +
                                "\n" +
                                "remove:");
    }

    @Test
    public void insertBoundsTest(){
        List<String> list = init();
        list.insert(3, "gg");
        printList(list, "insert:");
    }
}
