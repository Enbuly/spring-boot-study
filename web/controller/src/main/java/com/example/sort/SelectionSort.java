package com.example.sort;

/**
 * 选择排序
 *
 * @author lazy cat
 * @since 2020-02-22
 **/
public class SelectionSort {

    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[k] > a[j])
                    k = j;
            }
            if (k != i) {
                int t = a[i];
                a[i] = a[k];
                a[k] = t;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a4 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("简单选择排序");
        int[] b4 = SelectionSort.sort(a4);
        for (int i : b4) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("简单选择排序结束!");
    }
}
