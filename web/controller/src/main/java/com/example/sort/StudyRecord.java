package com.example.sort;

/**
 * 排序算法练习
 *
 * @author lazy cat
 * @since 2020-02-24
 */
public class StudyRecord {

    //bubble sort
    private static int[] bubbleSort(int[] a) {

        int i, j, temp;
        for (i = 0; i < a.length - 1; i++) {
            for (j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    //insertion sort
    private static int[] insertionSort(int[] a) {

        int i, j, temp;
        for (i = 1; i < a.length; i++) {
            temp = a[i];
            for (j = i; j > 0 && temp > a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
        return a;
    }

    //selection sort
    private static int[] selectionSort(int[] a) {

        int i, j, k;
        for (i = 0; i < a.length; i++) {
            k = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 1, 3, 7, 5, 4, 6, 8, 9};
        int[] result = StudyRecord.bubbleSort(arr1);
        print(result);

        int[] arr2 = {2, 1, 3, 7, 5, 4, 6, 8, 9};
        int[] result2 = StudyRecord.insertionSort(arr2);
        print(result2);

        int[] arr3 = {2, 1, 3, 7, 5, 4, 6, 8, 9};
        int[] result3 = StudyRecord.selectionSort(arr3);
        print(result3);
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println("over!");
    }
}
