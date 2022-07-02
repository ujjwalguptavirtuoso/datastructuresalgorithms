package dynamicprogramming.atcoder;

import java.util.Scanner;

public class Knapsack1 {

    static long knapsack(int [] wts, int [] vals, int n, int W, long[][]dp){

        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        if(wts[n-1] <= W){
              dp[n][W] = Math.max(( vals[n-1] + knapsack(wts, vals, n-1, W-wts[n-1], dp) ), knapsack(wts, vals, n-1, W, dp));
        }else{
            dp[n][W] = knapsack(wts, vals, n-1, W, dp);
        }

        return dp[n][W];
  }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int W = sc.nextInt();
        int weights[] = new int[N];
        int values[] = new int[N];
        for(int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        long dp[][] = new long[N + 1][W+1];
        for(int i = 1; i <=N; i++){
            for(int j = 1; j<=W; j++){
                dp[i][j] = -1;
            }
        }
        long maxProfit = knapsack(weights, values, N, W, dp);
        System.out.println(maxProfit);

}

}
