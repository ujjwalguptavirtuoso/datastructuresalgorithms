package codeforces;

import java.util.Scanner;

public class Boredom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int maxEle = 0;
        for(int i = 0 ;i < n; i ++){
            arr[i] = sc.nextInt();
            maxEle = Math.max(arr[i], maxEle);
        }

        long nums[] = new long[maxEle + 1];
        for(int i = 0; i < arr.length; i++){
            nums[arr[i]] +=arr[i];
        }

        long dp[] = new long[maxEle + 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i <=maxEle; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        System.out.println(dp[maxEle]);
    }
}
