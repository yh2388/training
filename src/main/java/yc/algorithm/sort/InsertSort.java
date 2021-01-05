package yc.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序 （稳定）
 *
 * 最好情况：O(N) 平均/最坏情况：O(N^2)
 * 将未排序的子序列插入到已排序的子序列中的正确位置
 */
public class InsertSort {

    static void sort(int[] arr) {
        int i,j;
        for (i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            // 当前需要做插入的元素，与其前面已经排好序的元素集作比较，以确定最终要插入的位置。j>=0表示前面还有元素
            for (j = i-1; j>=0 && tmp < arr[j]; j--) {
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
