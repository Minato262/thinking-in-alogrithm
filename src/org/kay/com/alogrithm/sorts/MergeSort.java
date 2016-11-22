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
package org.kay.com.alogrithm.sorts;

/**
 * <p>Merge Sort</p>
 *
 * @author kay
 * @version 1.0
 */
public class MergeSort {

    private static void sort(int[] A, int[] B, int[] C) {
        int a = 0, b = 0, c = 0;
        while (a < A.length && b < B.length) {
            if (A[a] < B[b])
                C[c++] = A[a++];
            else
                C[c++] = B[b++];
        }
        while (a < A.length) {
            C[c++] = A[a++];
        }
        while (b < B.length) {
            C[c++] = B[b++];
        }

        display(C);
    }

    private static void display(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        final int[] A = {2, 6, 7};
        final int[] B = {1, 3, 4, 5, 8, 9, 10};
        final int[] C = new int[10];
        sort(A, B, C);
    }
}
