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
 * <p>Double Linked</p>
 *
 * @author kay
 * @version 1.0
 */
public class DoubleLinked {

    private class Note{
        Object obj;
        Note next = null;

        Note(Object obj){
            this.obj = obj;
        }
    }

    private Note first;
    private Note last;

    private void insertFirst(Object obj){
        Note note = new Note(obj);
        if(first == null){
            last = note;
        }
        note.next = first;
        first = note;
    }

    private void insertLast(Object obj){
        Note note = new Note(obj);
        if(first == null){
            first = note;
        }else{
            last.next = note;
        }
        last = note;
    }

    private Object deleteFirst(){
        if(first == null){
            throw new NullPointerException("DoubleLinked is empty!");
        }

        Note temp = first;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp.obj;
    }

    private void deleteLast(){
        if(first == null){
            throw new NullPointerException("DoubleLinked is empty!");
        }

        if(first.next == null){
            first = null;
            last = null;
        }else{
            Note temp = first;
            while(temp.next != null){
                if(temp.next == last){
                    last = temp;
                    last.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    private void display(){
        if(first == null){
            System.out.println("DoubleLinked is empty!");
        }

        Note cur = first;
        while(cur != null){
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        DoubleLinked linked = new DoubleLinked();
        linked.insertFirst(2);
        linked.insertFirst(1);
        linked.display();

        linked.insertLast(3);
        linked.display();

        linked.deleteFirst();
        linked.display();

        linked.deleteLast();
        linked.display();
    }
}
