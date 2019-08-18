package com.modest.ds.utils;

/**
 * description
 *
 * @author modest
 * @date 2019/08/18
 */
public class CommonUtils {
    /**
     * 交换数组中的两个数
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
}
