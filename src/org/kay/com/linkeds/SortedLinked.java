/*
 * Copyright 2016-2016 the original author or authors.
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
package org.kay.com.linkeds;

/**
 * <p>Sorted Linked</p>
 *
 * @author kay
 * @version 1.0
 */
public class SortedLinked {

    private class Note {
        Object obj;
        Note next = null;

        Note(Object obj) {
            this.obj = obj;
        }
    }

    private Note first;

    private void insert(Object obj) {
        if (obj == null) {
            throw new NullPointerException("obj cannot be null!");
        }

        Note note = new Note(obj);
        Note pre = null;
        Note cur = first;
        while (cur != null && (Integer.valueOf(note.obj.toString()).intValue() >
                Integer.valueOf(cur.obj.toString()).intValue())) {
            pre = cur;
            cur = cur.next;
        }

        if (pre == null)
            first = note;
        else
            pre.next = note;
        note.next = cur;
    }

    private Object delete() {
        if (first == null) {
            throw new NullPointerException("SortedLinked is empty!");
        }

        Note temp = first;
        first = first.next;
        return temp.obj;
    }

    private void display() {
        if (first == null) {
            System.out.println("SortedLinked is empty!");
        }

        System.out.print("first -> last : ");
        Note cur = first;
        while (cur != null) {
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedLinked linked = new SortedLinked();
        linked.insert(80);
        linked.insert(2);
        linked.insert(100);
        linked.display();
        System.out.println(linked.delete());

        linked.insert(33);
        linked.display();

        linked.insert(99);
        linked.display();
    }
}
