package org.kay.com.sort;

/**
 * @author kay
 * @version 1.0
 */
public class SelectSort {
    private void sort(int[] data){
        for(int i = 0 ; i < data.length - 1 ; i++){
            int flag = i;
            for(int j = i + 1 ; j <= data.length - 1 ; j++){
                if(data[j] < data[flag]){
                    flag = j;
                }
            }
            int tmp = data[i];
            data[i] = data[flag];
            data[flag] = tmp;
        }
        this.display(data);
    }

    private void display(int[] data){
        for(int i : data){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        final int[] data = {6, 5, 4, 3, 2, 1};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(data);
    }
}
