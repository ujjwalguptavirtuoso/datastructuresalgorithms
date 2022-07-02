package dynamicprogramming.atcoder;

import java.util.Scanner;

public class  Frog2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int K = sc.nextInt();
        int heights[]= new int[N];
        for(int i =0; i < heights.length; i++){
            heights[i] = sc.nextInt();
        }
        int dp[] = new int[N];
       // dp[0] = 0;
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        for(int i = 2; i <N; i ++){
            int minCost = Integer.MAX_VALUE;
            for(int j = 1; j <=K; j++) {
                if(i-j >=0){
               // dp[i] = Math.min(Math.abs(heights[i] - heights[i - 2]) + dp[i - 2], Math.abs(heights[i] - heights[i - 1]) + dp[i - 1]);
                    minCost = Math.min(minCost, Math.abs(heights[i] - heights[i-j]) + dp[i-j]);
                }
            }
            dp[i]= minCost;
        }
        System.out.println(dp[N - 1]);
    }
}
