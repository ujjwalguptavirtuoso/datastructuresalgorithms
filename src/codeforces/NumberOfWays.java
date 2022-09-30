package codeforces;

import java.util.Scanner;

public class NumberOfWays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] =  new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int prefixSum[] = new int[n + 1];
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }



    }
}
