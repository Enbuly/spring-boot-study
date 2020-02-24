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
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int num = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] - a[rightPos] <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }
        for (int i = 0; i < num; i++, rightEnd--) {
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
