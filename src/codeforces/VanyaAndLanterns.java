package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class VanyaAndLanterns {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int startD = arr[0] - 0;
        int endD = l - arr[arr.length - 1];

        int maxDistance = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i ++){
            maxDistance = Math.max(maxDistance, arr[i] - arr[i-1]);
        }

        double ans = Math.max( ((double)maxDistance/2),  Math.max((double)startD, (double) endD));
       // ans = Math.round(ans * 1000000000) / 1000000000.0;
        System.out.println(String.format("%.10f", ans));
    }
}
