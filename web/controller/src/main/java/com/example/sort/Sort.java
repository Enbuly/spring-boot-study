package com.example.sort;

/**
 * 排序算法
 *
 * @author zhangzhenyan
 * @since 2019-10-09
 */
public class Sort {

    //插入排序
    private static int[] insertSort(int[] a) {

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

    //希尔排序
    private static int[] shellSort(int[] a) {
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

    //堆排序的调整部分
    private static void HeapAdjust(int[] array, int i, int nLength) {
        int nChild;
        int nTemp;
        for (; 2 * i + 1 < nLength; i = nChild) {
            //子结点的位置=2*（父结点位置）+1
            nChild = 2 * i + 1;
            //得到子结点中较大的结点
            if (nChild < nLength - 1 && array[nChild + 1] > array[nChild])
                ++nChild;
            //如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
            if (array[i] < array[nChild]) {
                nTemp = array[i];
                array[i] = array[nChild];
                array[nChild] = nTemp;
            } else break; //否则退出循环
        }
    }

    //堆排序
    private static int[] HeapSort(int[] array, int length) {
        int i;
        //调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
        //length/2-1是最后一个非叶节点，此处"/"为整除
        for (i = length / 2 - 1; i >= 0; --i)
            HeapAdjust(array, i, length);
        //从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = length - 1; i > 0; --i) {
            //把第一个元素和当前的最后一个元素交换，
            //保证当前的最后一个位置的元素都是在现在的这个序列之中最大的
            int ittemp = array[i];
            array[i] = array[0];
            array[0] = ittemp;
            //不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            HeapAdjust(array, 0, i);
        }
        return array;
    }

    //快速排序
    private static int[] sort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];
        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while (l < h && arr[l] <= povit)
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

    //简单选择排序
    private static int[] SimpleChoiceSort(int[] a) {
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

    //冒泡排序
    private static int[] bubble_sort(int[] a) {
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

    //归并排序算法
    private static int[] mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSortt(a, tmpArray, 0, a.length - 1);
        return a;
    }

    //递归部分
    private static void mergeSortt(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSortt(a, tmpArray, left, center);
            mergeSortt(a, tmpArray, center + 1, right);
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

    //测试排序的主方法
    public static void main(String[] args) {
        //冒泡排序
        int[] a = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("冒泡排序");
        int[] b = Sort.bubble_sort(a);
        for (int i : b) {
            System.out.print(i + ", ");
        }
        System.out.println("冒泡排序结束!");

        //插入排序
        int[] a1 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("插入排序");
        int[] b1 = Sort.insertSort(a1);
        for (int i : b1) {
            System.out.print(i + ", ");
        }
        System.out.println("插入排序结束!");

        //希尔排序
        int[] a2 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("希尔排序");
        int[] b2 = Sort.shellSort(a2);
        for (int i : b2) {
            System.out.print(i + ", ");
        }
        System.out.println("希尔排序结束!");

        //堆排序
        int[] a3 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("堆排序");
        int[] b3 = Sort.HeapSort(a3, 9);
        for (int i : b3) {
            System.out.print(i + ", ");
        }
        System.out.println("堆排序结束!");

        //堆排序2
        int[] aa = {6, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("堆排序");
        int[] bb = Sort.HeapSort(aa, 8);
        for (int i : bb) {
            System.out.print(i + ", ");
        }
        System.out.println("堆排序结束!");

        //简单选择排序
        int[] a4 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("简单选择排序");
        int[] b4 = Sort.SimpleChoiceSort(a4);
        for (int i : b4) {
            System.out.print(i + ", ");
        }
        System.out.println("简单选择排序结束!");

        //归并排序算法
        int[] a5 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("归并排序算法");
        int[] b5 = Sort.mergeSort(a5);
        for (int i : b5) {
            System.out.print(i + ", ");
        }
        System.out.println("归并排序算法结束!");

        //快速排序
        int[] a6 = {6, 9, 7, 4, 5, 8, 3, 2, 1};
        System.out.println("快速排序算法");
        int[] b6 = Sort.sort(a6, 0, 8);
        for (int i : b6) {
            System.out.print(i + ", ");
        }
        System.out.println("快速排序算法结束!");
    }
}
