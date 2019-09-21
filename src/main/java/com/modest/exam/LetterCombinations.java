package com.modest.exam;

/**
 *
 * leetcode 17 电话号码的字母组合
 *
 * @author modest
 * @date 2019/09/16
 */

import java.util.*;

public class LetterCombinations{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str= in.nextLine();

        solve(str);

    }


    public static void solve(String str) {
        String[] strings = new String[] {"","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        String string = "";

        int[] arr = new int[str.length()];


        for(int i=0; i<str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }


        get(arr, 0, strings, list, string);

        StringBuilder sb = new StringBuilder("[");
        int i;
        for(i=0; i<list.size()-1; i++) {
            sb.append(list.get(i)+", ");
        }
        sb.append(list.get(list.size() -1)+"]");
        System.out.println(sb.toString());
    }

    /**
     *
     * @param arr 输入的2-9的整数数组
     * @param i 计数，初始值为 0
     * @param strings 数字对应的字符串数组
     * @param list 用于保存组合的字符串
     * @param string 组合的字符串
     */
    private static void get(int[] arr, int i, String[] strings, List<String> list, String string) {
        if(i == arr.length) {
            list.add(string);
            return;
        }

        for(int j=0; j<strings[arr[i]].length(); j++) {
            string = string + strings[arr[i]].charAt(j);
            get(arr, i+1, strings, list, string);
            string = string.substring(0, string.length()-1);
        }
    }


}

