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
package org.kay.com.alogrithm.stacks;

/**
 * <p>Stack</p>
 *
 * @author kay
 * @version 1.0
 */
public class Stack {

    private int top = -1;
    private Object[] objs;

    private Stack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity:" + capacity);
        }

        objs = new Object[capacity];
    }

    private void push(Object obj) {
        if (top == objs.length - 1) {
            throw new StackOverflowError("Stack is full!");
        }

        objs[++top] = obj;
    }

    private Object pop() {
        if (top == -1) {
            throw new NullPointerException("Stack is empty!");
        }

        return objs[top--];
    }

    private void display() {
        System.out.print("bottom -> top: | ");
        for (int i = 0; i <= top; i++) {
            System.out.print(objs[i] + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        stack.display();

        System.out.println(stack.pop());
        stack.display();

        stack.push(99);
        stack.display();

        stack.push(99);
    }
}
