package com.modest.exam;

import java.util.Scanner;

import static com.modest.ds.sort.Sort.mergeSort;

/**
 * 输出每一轮的最小数
 *
 * 输入描述
 * 第一行两个数
 * 第二行n个数，表示数组元素
 * n    k
 *
 * 输出描述
 *
 * 每一次找到最小的非0元素
 * 输出最小的非0元素
 * 数组中的每个数减去最小的非0元素
 *
 * 执行k轮，若是一轮都找不到最小的非0元素，这一轮输出0
 *
 *
 * 解决思路：
 * 对数组进行排序
 * 遍历
 * @author modest
 * @date 2019/09/21
 */
public class MinNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] strings = s.split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);

        s = in.nextLine();
        strings = s.split(" ");
        int[] arr = new int[strings.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        mergeSort(arr, 0, arr.length-1);

        get(arr, k);
    }
    private static void get(int[] arr, int k) {
        int flag = 1;
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i] -count;
            while(k > 0) {
                if(arr[i] > 0) {
                    System.out.println(arr[i]);
                    count += arr[i];
                    arr[i] = 0;
                    k--;
                    flag = 0;
                } else {
                    break;
                }
            }
            if(k==0) {
                break;
            }
            if(flag == 1) {
                System.out.println(0);
                k--;
            }
        }
        while(k > 0) {
            System.out.println(0);
            k--;
        }
    }


}


//
//
//
