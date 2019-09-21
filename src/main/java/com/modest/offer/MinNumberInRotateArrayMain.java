package com.modest.offer;

/**
 * description
 *
 * @author modest
 * @date 2019/09/16
 */
public class MinNumberInRotateArrayMain {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,2, 1,1};
        System.out.println(minNumberInRotateArray(arr));
    }

    public static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int i = 0, j = array.length-1;
        int mid = 0;
        while(i<j) {
            mid = i + (j - i) / 2;
            if(array[mid] > array[mid+1] && array[mid] > array[mid-1]) {
                return array[mid+1];
            }

            if(array[mid] < array[mid+1] && array[mid] < array[mid-1]) {
                return array[mid];
            }

            if(array[mid] > array[i] && array[mid] > array[j]) {
                i = mid + 1;
            }

            if(array[mid] < array[i] && array[mid] < array[j]) {
                j = mid - 1;
            }
        }

        return array[0];
    }


    public static int method(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
