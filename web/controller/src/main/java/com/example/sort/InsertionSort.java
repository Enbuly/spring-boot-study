package com.example.sort;

/**
 * 插入排序
 *
 * @author lazy cat
 * @since 2020-02-22
 **/
public class InsertionSort {

    private static int[] sort(int[] a) {

        int j;

        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int p = 1; p < a.length; p++) {

            //记录要插入的数据
            int tmp = a[p];

            //从已经排序的序列最右边的开始比较，找到比其小的数
            for (j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }

            //存在比其小的数，插入
            a[j] = tmp;
        }
        return a;
    }

    public static void main(String[] args) {

        //插入排序
        int[] a1 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("插入排序");
        int[] b1 = InsertionSort.sort(a1);
        for (int i : b1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("插入排序结束!");

    }
}
