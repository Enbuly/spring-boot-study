package com.example.sort;

/**
 * 归并排序
 *
 * @author lazy cat
 * @since 2020-02-24
 **/
public class MergeSort {

    //归并排序算法
    private static int[] sort(int[] a) {
        int[] tmpArray = new int[a.length];
        recursion(a, tmpArray, 0, a.length - 1);
        return a;
    }

    //递归部分
    private static void recursion(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            recursion(a, tmpArray, left, center);
            recursion(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    //合并部分
    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int i = leftPos, j = rightPos;
        int num = rightEnd - leftPos + 1;
        for (int k = leftPos; k <= rightEnd; k++) {
            if (i > rightPos) {
                tmpArray[k] = a[j++];
            } else if (j > rightEnd) {
                tmpArray[k] = a[i++];
            } else if (a[i] <= (a[j])) {
                tmpArray[k] = a[i++];
            } else {
                tmpArray[k] = a[j++];
            }
        }
        for (int r = 0; r < num; r++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {

        int[] a5 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("归并排序算法");
        int[] b5 = MergeSort.sort(a5);
        for (int i : b5) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("归并排序算法结束!");
    }

}
