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
package org.kay.com.sorts;

/**
 * <p>Select Sort</p>
 *
 * @author kay
 * @version 1.0
 */
public class SelectSort {

    private static void sort(int[] data) {
        int flag;
        int tmp;
        for (int i = 0; i < data.length - 1; i++) {
            flag = i;
            for (int j = i + 1; j <= data.length - 1; j++) {
                if (data[j] < data[flag]) {
                    flag = j;
                }
            }
            tmp = data[i];
            data[i] = data[flag];
            data[flag] = tmp;
        }

        display(data);
    }

    private static void display(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        final int[] data = {6, 5, 4, 3, 2, 1};
        sort(data);
    }
}
