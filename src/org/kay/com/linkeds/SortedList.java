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
 * <p>SortedList</p>
 *
 * @author kay
 * @version 1.0
 */
public class SortedList {

    private class Note{
        private Object obj;
        private Note next = null;

        Note(Object obj){
            this.obj = obj;
        }
    }

    private Note first = null;

    private void insert(Object obj){
        Note data = new Note(obj);
        Note pre = null;
        Note cur = first;
        while(cur != null && (Integer.valueOf(data.obj.toString()).intValue() >
                Integer.valueOf(cur.obj.toString()).intValue())){
            pre = cur;
            cur = cur.next;
        }
        if(pre == null)
            first = data;
        else
            pre.next = data;
        data.next = cur;
    }

    private Object deleteFirst(){
        if(first == null){
            throw new RuntimeException("empty!");
        }

        Note temp = first;
        first = first.next;
        return temp.obj;
    }

    private void display(){
        if(first == null)
            System.out.println("empty");
        System.out.print("first -> last : ");
        Note cur = first;
        while(cur != null){
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args){
        SortedList sl = new SortedList();
        sl.insert(80);
        sl.insert(2);
        sl.insert(100);
        sl.display();
        System.out.println(sl.deleteFirst());

        sl.insert(33);
        sl.display();

        sl.insert(99);
        sl.display();
    }
}
