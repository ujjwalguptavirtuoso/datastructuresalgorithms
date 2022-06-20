package dynamicprogramming;

import java.util.Scanner;

public class DiceCombinations {

     static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long dp[] = new long [n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <=n; i ++){
            for(int j = 1; j <=6; j++){
                if(i-j < 0){
                    continue;
                }
                dp[i] = (dp[i]%MOD + dp[i-j]%MOD)%MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
