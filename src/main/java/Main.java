import java.util.Scanner;

/**
 * 二维矩阵求最大子数组
 * @author zimodest
 */
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());


        int[][] arr = new int[n][n];

        int max = -128;
        int tempMax = -128;


        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                tempMax += arr[i][j];

                if (tempMax < 0) {
                    tempMax = tempMax > arr[i][j] ? tempMax : arr[i][j];
                }
            }

            max = max > tempMax ? max : tempMax;
        }

        System.out.println(max);
    }
}


