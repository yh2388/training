package yc.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序 （不稳定）
 * 选取任意一个元素作为枢轴，定义两个指针low, high
 *
 * 最坏时间复杂度：O(N^2), 平均时间复杂度：O(NlogN)
 *
 * 1. low从左向右移动，high从右向左移动，并且high先移动 TODO：为什么要先移动high
 * 2. high移动过程中，遇到小于枢轴的数，则停止；low开始移动，遇到大于枢轴的数后停止，此时，如果low与high未相遇，则交换这两个数
 * 3. 交换完毕后，继续移动，同样是high先移动，重复2中的步骤，如果low与high相遇，则表示完成了该次“探测”
 * 4. 相遇点即枢轴数的正确排序位置，将枢轴数归位
 * 5. 以当前枢轴数将数组划分未两部分，分别继续上述操作
 */
public class QuickSort {

    static void sort(int[] arr, int low, int high) {
        if(low > high) {
            return;
        }

        int i,j,t;
        i = low;
        j = high;

        int tmp = arr[low];

        while (i != j) {
            while (j>i && arr[j] >= tmp) {
                j--;
            }

            while (i<j && arr[i] <= tmp) {
                i++;
            }

            // 交换两边的数
            if (i<j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // 归位中枢数
        arr[low] = arr[i];
        arr[i] = tmp;

        sort(arr, low, i -1);
        sort(arr, i+1, high);
    }

    public static void main(String[] args) {
        int[] arr = {5,12,34,6,7,4,3,7,128,9,4};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
