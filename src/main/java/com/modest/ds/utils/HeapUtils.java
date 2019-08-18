package com.modest.ds.utils;

/**
 * description
 *
 * @author modest
 * @date 2019/08/18
 */
public class HeapUtils {
    public static void heapAdjustDown(int[] arr, int root, int length) {
        int cur = root;
        int maxChild = 0;

        while(cur < length) {
            //计算根节点的左节点下标
            int left = 2 * cur + 1;
            //计算根节点的右节点下标
            int right = 2 * cur + 2;

            //如果left 越界，没有子节点，不需要调整
            if(left >= length) {
                break;
            }

            //到这，有左节点，可能有右节点

            //right 不越界的，既有右节点，又有左节点
            if(right < length) {
                //到这，既有右节点，又有左节点
                maxChild = arr[left] >= arr[right] ? left : right;

                if(arr[cur] > arr[maxChild]) {
                    break;
                }

                swap(arr, maxChild, cur);
                cur = maxChild;
            } else {
                //只有左节点
                if(arr[left] <= arr[cur]) {
                    break;
                }

                swap(arr, left, cur) ;
                cur = left;
            }
        }
    }

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
