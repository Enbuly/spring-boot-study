package com.example.sort;

/**
 * 快速排序
 *
 * @author lazy cat
 * @since 2020-02-24
 */
public class QuickSort {

    private static int[] sort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int pivot = arr[low];
        while (l < h) {
            while (l < h && arr[h] >= pivot)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while (l < h && arr[l] <= pivot)
                l++;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
        return arr;
    }

    public static void main(String[] args) {

        int[] a6 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("快速排序算法");
        int[] b6 = QuickSort.sort(a6, 0, 8);
        for (int i : b6) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("快速排序算法结束!");
    }
}
