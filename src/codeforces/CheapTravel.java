package codeforces;

import java.util.Scanner;

public class CheapTravel {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = Math.min(a,b);
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.min( dp[i-1] + a, dp[Math.max(0, i-m)] + b);
        }

        System.out.println(dp[dp.length - 1]);

    }
}
