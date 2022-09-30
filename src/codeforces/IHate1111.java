package codeforces;

import java.util.Scanner;

public class IHate1111 {

   static int knapsack(int [] coins, int [] weights, int coins_length, int n, int[][] dp){
           if(n == 0 && coins_length == 0){
               return 0;
           }

          if(n == 0){
              return 1;
          }
          if(coins_length == 0){
              return 0;
          }


          if(dp[coins_length][n] != -1){
              return dp[coins_length][n];
          }

          if(coins[coins_length - 1] > n){
              dp[coins_length][n] = knapsack(coins, weights, coins_length - 1, n, dp);
          }else{
              dp[coins_length][n] = knapsack(coins, weights, coins_length - 1, n, dp) | knapsack(coins, weights, coins_length, n -coins[coins_length - 1], dp);
          }
          return dp[coins_length][n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int coins[] = {11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int dp[][] = new int[coins.length + 1][n + 1];
            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j < dp[0].length; j++){
                    dp[i][j] = -1;
                }
            }
            int weights[] = new int[n + 1];
            for(int i = 0; i < weights.length; i++){
                weights[i] = i;
            }
            int ans = knapsack(coins, weights, coins.length, n, dp);
            if(ans == 1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
