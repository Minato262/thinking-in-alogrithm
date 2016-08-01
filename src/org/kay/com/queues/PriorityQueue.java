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
package org.kay.com.queues;

/**
 * <p>Priority Queue</p>
 *
 * @author kay
 * @version 1.0
 */
public class PriorityQueue {

    private int[] data;
    private int size;

    public PriorityQueue(int size){
        data = new int[size];
        this.size = 0;
    }

    private void push(int toInsert) {
        if(size == data.length){
            throw new RuntimeException("Queue is full!");
        }

        if(size == 0){
            data[0] = toInsert;
        }else{
            int i = size -1;
            for( ; i >= 0 ; i--){
                if(data[i] < toInsert){
                    data[i + 1] = data[i];
                }else{
                    break;
                }
            }
            data[i+1] = toInsert;
        }
        size++;
    }

    private int pop(){
        if(this.size == 0)
            throw new RuntimeException("Queue is empty!");
        return data[--size];
    }

    private int peek(){
        if(this.size == 0)
            throw new RuntimeException("Queue is empty!");
        return data[size - 1];
    }

    private int size(){
        return this.size;
    }

    private boolean isEmpty(){
        return (size == 0);
    }

    private boolean isFull(){
        return (size == data.length);
    }
}
