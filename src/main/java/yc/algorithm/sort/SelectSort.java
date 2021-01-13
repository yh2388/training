package yc.algorithm.sort;

import java.util.Arrays;

/**
 * 直接选择排序 （不稳定）
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第二步，直到所有元素均排序完毕。
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
