package yc.algorithm.sort;

import java.util.Arrays;

/**
 * 直接选择排序 （不稳定）
 *
 * 最坏情况：O(N^2)
 */
public class SelectSort {

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[min]) {
                    min=j;
                }
            }
            if(min!=i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,5,12,34,6,7,4,3,7,128,9,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
