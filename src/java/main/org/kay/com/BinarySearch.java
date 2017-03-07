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
package org.kay.com;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * <P>The sample Java program that we started with, shown on the facing page,is
 * based on the famous, effective, and widely used binary'search algorithm.<P/>
 *
 * @author kay
 * @version 1.0
 */
public class BinarySearch {

    private static int rankOne(int key, int[] srcArray) {
        // Array must be sorted.
        int low  = 0;
        int high = srcArray.length - 1;
        int mid;
        while (low <= high) { // Key is in a[low..high] or not present.
            mid = low + (high - low) / 2;

            if (key < srcArray[mid])
                high = mid - 1;
            else if (key > srcArray[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private static int rankTwo(int key, int[] srcArray) {
        // Array must be sorted.
        for (int i = 0; i < srcArray.length; i++) {
            if (key == srcArray[i]) {
                return i;
            }
        }
        return -1;
    }

    private static void print(int[] array, String warn) {
        out.println(warn);
        for (int anArray : array) {
            out.print(anArray + " ");
        }
        out.println();
    }

    public static void main(String[] args) {
        final int[] binaryArray = {1, 2, 5, 4, 3, 7, 7, 6, 8, 7, 8, 9, 10};
        final int   binaryKey   = 8;    // Read key, print if not in binaryArray.

        print(new int[]{binaryKey}, "The value of the key: ");

        Arrays.sort(binaryArray);
        print(binaryArray, "A sorted array of int values:");
        print(new int[]{rankOne(binaryKey, binaryArray)}, "The value of the rank: ");
        print(new int[]{rankTwo(binaryKey, binaryArray)}, "The value of the rank: ");
    }
}
