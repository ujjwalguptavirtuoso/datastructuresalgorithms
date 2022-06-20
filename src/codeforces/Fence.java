package codeforces;

import java.util.Scanner;

public class Fence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int prefixSum[] = new int [n + 1];
        for(int i = 1; i < prefixSum.length; i ++){
            prefixSum[i] = arr[i-1] + prefixSum[i-1];
        }

        int minSum = Integer.MAX_VALUE;
        int i = 0;
        int j = i + w;
        int index = 0;
        while(j < prefixSum.length){
            int tempSum = prefixSum[j] - prefixSum[i];
            if(tempSum < minSum){
                minSum = tempSum;
                index = i + 1;
            }
            i++;
            j++;
        }
        System.out.println(index);
    }
}
