package org.kay.com.sorts;

/**
 * @author kay
 * @version 1.0
 */
public class MergeSort {

    private static void sort(int[] A, int[] B, int[] C){
        int a = 0;
        int b = 0;
        int c = 0;
        while(a < A.length && b < B.length){
            if(A[a] < B[b])
                C[c++] = A[a++];
            else
                C[c++] = B[b++];
        }
        while(a < A.length)
            C[c++] = A[a++];
        while(b < B.length)
            C[c++] = B[b++];

        display(C);
    }

    private static void display(int[] data){
        for(int i : data){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        final int[] A = {2,6,7};
        final int[] B = {1,3,4,5,8,9,10};
        final int[] C = new int[10];
        sort(A, B, C);
    }
}
