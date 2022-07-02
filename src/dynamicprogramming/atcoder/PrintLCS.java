package dynamicprogramming.atcoder;

import java.util.Scanner;

public class PrintLCS {

    static int populateLCSMatrix(String s1, String s2, int m, int n, int[][] dp){
        if(m == 0 || n == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            dp[m][n] = 1 + populateLCSMatrix(s1, s2, m-1, n-1, dp);
        }else{
            dp[m][n] = Math.max(populateLCSMatrix(s1, s2, m-1, n, dp), populateLCSMatrix(s1, s2, m,n-1, dp));
        }
        return dp[m][n];
    }

    static String printLCS(String s1, String s2, int[][] dp){
        StringBuilder sb = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while(i > 0 && j> 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i][j-1] > dp[i-1][j]){
                j--;
            }else{
                i--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 =sc.next();
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        // populating lcs matrix for futher use
        populateLCSMatrix(s1, s2, s1.length(), s2.length(), dp);
        //printing lcs from the matrix
        String lcsPrint = printLCS(s1, s2, dp);

        System.out.println(lcsPrint);
    }
}
