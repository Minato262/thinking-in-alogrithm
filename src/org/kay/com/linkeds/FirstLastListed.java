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
 * <p>First Last Listed</p>
 *
 * @author kay
 * @version 1.0
 */
public class FirstLastListed {

    private class Note{
        private Object obj;
        private Note next = null;

        Note(Object obj){
            this.obj = obj;
        }
    }

    private Note first = null;
    private Note last = null;

    private void insertFirst(Object obj){
        Note note = new Note(obj);
        if(first == null) last = note;
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
            throw new RuntimeException("FirstLastListed is empty!");
        }

        Note temp = first;
        if(first.next == null) last = null;
        first = first.next;
        return temp.obj;
    }

    private void deleteLast(){
        if(first == null){
            throw new RuntimeException("FirstLastListed is empty!");
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
            System.out.println("empty");
        }

        Note cur = first;
        while(cur != null){
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args){
        FirstLastListed firstLastList = new FirstLastListed();
        firstLastList.insertFirst(2);
        firstLastList.insertFirst(1);
        firstLastList.display();

        firstLastList.insertLast(3);
        firstLastList.display();

        firstLastList.deleteFirst();
        firstLastList.display();

        firstLastList.deleteLast();
        firstLastList.display();
    }
}
