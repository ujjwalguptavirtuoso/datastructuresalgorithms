package codeforces;
import java.util.Scanner;

public class BinaryDeque {

   // static int min = Integer.MAX_VALUE;

    static int findMin(int sum, int s, int [] arr, int i, int j, int ops, int dp[][]){
        if(s == sum){
            return dp[i][j] = ops;
        }
        if(i > j){
            return -1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

         dp[i][j] = Math.min( findMin(sum - arr[i],s, arr, i+1, j, ops+ 1, dp), findMin(sum - arr[j],s, arr, i, j - 1, ops+ 1, dp));
         return dp[i][j];
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();;
             int s = sc.nextInt();
             int [] arr = new int[n];
             int sum = 0;
             for(int i = 0; i < n; i ++){
                 arr[i] = sc.nextInt();
                 sum += arr[i];
             }
          //   min = Integer.MAX_VALUE;
             int dp[][] = new int [n][n];
             for(int i = 0; i < n; i ++){
                 for(int j = 0; j < n; j++){
                     dp[i][j] = -1;
                 }
             }
             findMin(sum, s, arr, 0, n-1, 0, dp);
             System.out.println(dp[0][arr.length - 1]);
        }
    }
}
