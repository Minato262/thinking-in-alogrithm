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
 * <p></p>
 *
 * @author kay
 * @version 1.0
 */
public class LinkedList {

    private class Data{
        private Object obj;
        private Data next = null;

        Data(Object obj){
            this.obj = obj;
        }
    }

    private Data first;

    public void insertFirst(Object obj){
        Data data = new Data(obj);
        data.next = first;
        first = data;
    }

    public Object deleteFirst() {
        if(first == null){
            throw new RuntimeException("empty!");
        }

        Data temp = first;
        first = first.next;
        return temp.obj;
    }

    public Object find(Object obj){
        if(first == null){
            throw new RuntimeException("LinkedList is empty!");
        }

        Data cur = first;
        while(cur != null){
            if(cur.obj.equals(obj)){
                return cur.obj;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(Object obj){
        if(first == null){
            throw new RuntimeException("LinkedList is empty!");
        }

        if(first.obj.equals(obj)){
            first = first.next;
        }else{
            Data pre = first;
            Data cur = first.next;
            while(cur != null){
                if(cur.obj.equals(obj)){
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        if(first == null){
            System.out.println("empty");
        }

        Data cur = first;
        while(cur != null){
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(4);
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.display();

        linkedList.deleteFirst();
        linkedList.display();

        linkedList.remove(3);
        linkedList.display();

        System.out.println(linkedList.find(1));
        System.out.println(linkedList.find(4));
    }
}
