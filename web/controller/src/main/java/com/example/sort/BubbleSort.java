package com.example.sort;

/**
 * 冒泡排序
 *
 * @author lazy cat
 * @since 2020-02-22
 **/
public class BubbleSort {

    private static int[] sort(int[] a) {
        int i, j, temp;
        for (j = 0; j < a.length - 1; j++)
            for (i = 0; i < a.length - 1 - j; i++) {
                if (a[i] < a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("冒泡排序");
        int[] b = BubbleSort.sort(a);
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("冒泡排序结束!");
    }
}
