package com.example.sort;

/**
 * 希尔排序
 *
 * @author lazy cat
 * @since 2020-02-24
 */
public class ShellSort {

    //希尔排序
    private static int[] sort(int[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                for (j = i; j >= gap && tmp - a[j - gap] < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("希尔排序");
        int[] b = ShellSort.sort(a);
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("希尔排序结束!");
    }
}
