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
 * <p>Insert Sort</p>
 *
 * @author kay
 * @version 1.0
 */
public class InsertSort {

    private static void sort(int[] data) {
        for (int i = 1, tmp, insertPoint; i < data.length; i++) {
            tmp = data[i];
            insertPoint = i;
            while (insertPoint > 0 && data[insertPoint - 1] > tmp) {
                data[insertPoint] = data[insertPoint - 1];
                insertPoint -= 1;
            }
            if (insertPoint < i) {
                data[insertPoint] = tmp;
            }
        }

        display(data);
    }

    private static void display(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        final int[] data = {1, 2, 3, 6, 5, 4};
        sort(data);
    }
}
