package com.modest.ds.sort;

import com.modest.ds.utils.Order;

import java.util.Stack;

/**
 * description
 *
 * @author modest
 * @date 2019/08/01
 */
public class Sort {

    /**
     * 插入排序
     * 时间复杂度
     * 平均
     * @param arr 排序数组
     */
    public static void insertSort(int[] arr) {

        //遍历有序部分
        for(int i=0; i<arr.length-1; i++) {

            //从无序部分的第一个元素u开始，向前遍历
            for(int j=i+1; j>0 ;j--) {
                //在循环遍历之间，不能修改遍历条件
                if(arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void insertSort1(int[] arr) {
        int j;
        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            for(j = i-1; j>=0; j--) {
                if(arr[j] > key) {
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = key;
        }
    }

    /**
     * 选择排序
     * @param arr 排序数组
     */
    public static void selectSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int min = i;
            int j;
            for( j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }


    public static void shellSort(int[]  arr) {

        int k = arr.length;

        int a = k;
        do {
            //每组元素个数
            k = k / 3 + 1;

            for (int m = 0; m < k; m++) {

                for (int i = k; i < a; i += k) {

                    int j;
                    int key = arr[i];

                    for (j = i - k; j >= 0; j -= k) {
                        if (arr[j] > key) {
                            arr[j + k] = arr[j];
                        } else {
                            break;
                        }
                    }
                    arr[j + k] = key;
                }
            }

        } while (k != 1);

    }


    /**
     * 非递归的快速排序
     * @param arr 要排序数组
     */
    public static void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        //用于保存要排序子数组的左右下标
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(right);
        stack.push(left);

        while (!stack.empty()) {

            int i = stack.peek();
            stack.pop();
            int j = stack.peek();
            stack.pop();
            int midIndex = qSort(arr,i,j);

            //每一趟快排结束后，将符合条件的两个左右下标按先右后左的顺序插入栈
            if (midIndex+1 < j) {
                stack.push(j);
                stack.push(midIndex+1);
            }

            if (i<midIndex-1) {
                stack.push(midIndex - 1);
                stack.push(i);
            }
        }

    }

    /**
     * 一趟快速排序
     * @param arr 要排序数组
     * @param left 左下标
     * @param right 右下标
     * @return key值对应的下标
     */
    private static int qSort(int[] arr, int left, int right) {

        if(left >= right) {
            return -1;
        }

        int key = arr[left];
        int i = left;
        int j = right;
        while(i < j) {
            while (arr[j] >= key && i <j) {
                j--;
            }

            while(arr[i] <= key && i<j) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;

        return i;
    }



    public static void quickSort(int[] arr, int left, int right) {

        int key = arr[left];
        int i = left;
        int j = right;
        while(i < j) {
            while (arr[j] >= key && i <j) {
                j--;
            }
            while(arr[i] <= key && i<j) {
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr, left, j);

        if (left<i-1) {
            quickSort(arr,left,i-1);
        }

        if (i+1 < right) {
            quickSort(arr,i+1,right);
        }

    }

    /**
     * 交换整形数组中的两个数
     * @param arr  要交换的数组
     * @param i 交换的下标
     * @param j 交换的下标
     */
    private static void swap(int[] arr, int i, int j) {
        //两个数相同时，直接返回，因为使用异或运算，两个数相同时，异或运算结果为0，两个数会变成0，无法交换
        if(arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];

        arr[j] = arr[i] ^ arr[j];

        arr[i] = arr[i] ^ arr[j];
    }

    public static void bubbleSort(int[] arr) {
        for(int i =0; i<arr.length; i++) {
            for(int j=1; j<arr.length - i; j++) {
                if(arr[j-1] > arr[j]) {
                    swap(arr,j-1,j);
                }
            }
        }
    }

}
