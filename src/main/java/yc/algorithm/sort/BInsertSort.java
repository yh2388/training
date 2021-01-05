package yc.algorithm.sort;

import java.util.Arrays;

/**
 * 折半插入排序 （稳定）
 *
 * 最好情况：O(N) 平均/最坏情况：O(N^2) 其中折半查找为O(logN)
 */
public class BInsertSort {

    static void sort(int[] arr) {
        int i,j;

        for (i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            // 前面的序列已经是排好序的，因此只需要通过折半查找，找到具体要插入的位置即可
            int low = 0, high = i-1, mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] > tmp) {
                    high = high - 1;
                } else {
                    low = low + 1;
                }
            }
            // 将大于该元素的元素向后移动
            for (j = i-1; j>=0 && j > high; j--) {
                arr[j+1] = arr[j];
            }
            // 上面的循环中，已将所有大于需要插入的元素的元素向后移动了一位，一次arr[j+1]表示的是插入元素的正确位置
            arr[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,5,12,34,6,7,4,3,7,128,9,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
