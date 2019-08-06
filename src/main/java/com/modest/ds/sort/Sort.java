package com.modest.ds.sort;

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


}
