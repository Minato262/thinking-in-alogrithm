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
 * <p>Single Linked</p>
 *
 * @author kay
 * @version 1.0
 */
public class SingleLinked {

    private class Note{
        private Object obj;
        private Note next = null;

        Note(Object obj){
            this.obj = obj;
        }
    }

    private Note first;

    private void insert(Object obj){
        Note note = new Note(obj);
        note.next = first;
        first = note;
    }

    private Object delete() {
        if(first == null){
            throw new RuntimeException("SingleLinked is empty!");
        }

        Note temp = first;
        first = first.next;
        return temp.obj;
    }

    private Object find(Object obj){
        if(first == null){
            throw new RuntimeException("SingleLinked is empty!");
        }

        Note cur = first;
        while(cur != null){
            if(cur.obj.equals(obj)){
                return cur.obj;
            }
            cur = cur.next;
        }
        return null;
    }

    private void remove(Object obj){
        if(first == null){
            throw new RuntimeException("SingleLinked is empty!");
        }

        if(first.obj.equals(obj)){
            first = first.next;
        }else{
            Note pre = first;
            Note cur = first.next;
            while(cur != null){
                if(cur.obj.equals(obj)){
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    private boolean isEmpty(){
        return (first == null);
    }

    private void display(){
        if(first == null){
            System.out.println("SingleLinked is empty");
        }

        Note cur = first;
        while(cur != null){
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.insert(4);
        singleLinked.insert(3);
        singleLinked.insert(2);
        singleLinked.insert(1);
        singleLinked.display();

        singleLinked.delete();
        singleLinked.display();

        singleLinked.remove(3);
        singleLinked.display();
        System.out.println(singleLinked.find(1));
        System.out.println(singleLinked.find(4));
    }
}