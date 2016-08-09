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
 * <p>Shell Sort</p>
 *
 * @author kay
 * @version 1.0
 */
public class ShellSort {

    private int[] data;

    public ShellSort(int[] data){
        this.data = data;
    }

    private void sort(){
        int num = data.length;
        int h = 1;
        while(h * 3 + 1 < num)
            h = h * 3 + 1;

        while(h > 0){
            System.out.println(h);
            for(int i = h ; i < data.length ; i++){
                int tmp = data[i];
                int insertPoint = i;
                while(insertPoint - h >= 0 && data[insertPoint-h] > tmp){
                    data[insertPoint] = data[insertPoint-h];
                    insertPoint -= h;
                }
                data[insertPoint] = tmp;
            }
            h = (h - 1)/3;
        }
    }

    private void display(){
        for(int i = 0 ; i < data.length ; i++){
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        final int[] data = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};

        ShellSort ss = new ShellSort(data);
        ss.sort();
        ss.display();
    }
}
