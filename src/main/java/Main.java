//import java.util.Scanner;
//
///**
// * 二维矩阵求最大子数组
// * @author zimodest
// */
//public class Main{
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int y = in.nextInt();
//        int n = in.nextInt();
//
//        int[][] arr = new int[x+1][y+1];
//        int index = 0;
//        while(index < n) {
//            arr[in.nextInt()][in.nextInt()] = 1;
//        }
//        getMinStep(x, y, arr);
//    }
//
//
//
//    public static int getMinStep(int x, int y, int[][] arr) {
//
//        int[][] temp = new int[x+1][y+1];
//        for(int i=0; i<x; i++) {
//
//            for(int j=0; j<y; j++) {
//
//            }
//        }
//
//
//        return temp[x][y];
//    }
//}
//
//

import java.util.*;



public class Main{
    public static void main(String[] args) {
        int a = 12;
        System.out.println(Integer.toBinaryString(a));
        int b = 10;
        System.out.println(a ^ b);
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String ts = in.nextLine();
//        int t = Integer.parseInt(ts);
//        while((t--) > 0) {
//            String ns = in.nextLine();
//            int n = Integer.parseInt(ns);
//            String s = in.nextLine();
//            System.out.println(get(s, n));
//        }
//    }
//
//    public static String get(String s, int n) {
//        if(s.length() < 11) {
//            return "NO";
//        }
//        if(!s.contains("8")) {
//           return "NO";
//        }
//        int a = s.indexOf("8");
//        int num = s.length()-1-a+1;
//        if(num >= 11) {
//            return "YES";
//        }
//        return "NO";
//    }
//}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String s = in.nextLine();
//        String[] strings = s.split(" ");
//        int n = Integer.parseInt(strings[0]);
//        int k = Integer.parseInt(strings[1]);
//
//        s = in.nextLine();
//        strings = s.split(" ");
//        int[] arr = new int[strings.length];
//        for(int i=0; i<arr.length; i++) {
//            arr[i] = Integer.parseInt(strings[i]);
//        }
//
//        mergeSort(arr, 0, arr.length-1);
//
//        get(arr, k);
//    }
//    private static void get(int[] arr, int k) {
//        int flag = 1;
//        int count = 0;
//        for(int i=0; i<arr.length; i++) {
//            arr[i] = arr[i] -count;
//            while(k > 0) {
//                if(arr[i] > 0) {
//                    System.out.println(arr[i]);
//                    count += arr[i];
//                    arr[i] = arr[i]-arr[i];
//                    k--;
//                    flag = 0;
//                } else {
//                    break;
//                }
//            }
//            if(k==0) {
//                break;
//            }
//            if(flag == 1) {
//                System.out.println(0);
//                k--;
//            }
//        }
//        while(k > 0) {
//            System.out.println(0);
//            k--;
//        }
//    }
//
//






//    private static void get(int[] arr, int k) {
//        int count = k;
//        int min = 0;
//        int flag = 1;
//        while (k > 0) {
//
//            min = arr[0];
//
//            for (int i = 0; i < arr.length; i++) {
//
//                if (arr[i] != 0 && arr[i] < min) {
//                    min = arr[i];
//                }
//
//                if(arr[i] != 0) {
//                    arr[i] = arr[i] -1;
//                    flag = 0;
//                }
//
//            }
//
//            if (flag == 1) {
//                System.out.println(0);
//            } else {
//                flag = 1;
//                System.out.println(min);
//            }
//
//            k--;
//        }
//
//    }
//}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String ts = in.nextLine();
//        int t = Integer.parseInt(ts);
//
//        while((t--) > 0) {
//            String ns = in.nextLine();
//            int n = Integer.parseInt(ns);
//            String s = in.nextLine();
//            System.out.println(get(s, n));
//        }
//    }
//
//
//    public static String get(String s, int n) {
//        if(s.length() < 11) {
//            return "NO";
//        }
//
//        int a = s.indexOf("8");
//        System.out.println(a);
//
//        int num = s.length()-1-a+1;
//        if(s.length()-1-a +1 >= 11) {
//            return "YES";
//        }
//        return null;
//    }
//}

//
//    public static String get(String str) {
//
//        if(str.startsWith(".") || str.startsWith(":") || str.endsWith(".") || str.endsWith(":")) {
//            return "Neither";
//        }
//        String[] strings = str.split("\\.");
//
//        if(strings.length == 4) {
//            int i = 1;
//
//            for(int j=0; j<4; j++) {
//                int num;
//                num= Integer.parseInt(strings[j]);
//
//                if(num < 0 || num > 255) {
//                    return "Neither";
//                }
//
//
//            }
//            return "IPv4";
//
//        } else {
//            strings = str.split(":");
//
//            if(strings.length == 8) {
//                for(int j=0; j<8; j++) {
//                    int num = strings[j].length();
//
//                    if(strings[j] == null || num > 4 || num == 0) {
//                        return "Neither";
//                    }
//                }
//                return "IPv6";
//            }
//        }
//
//        return "Neither";
//    }