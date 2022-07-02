package codeforces;

import java.util.Scanner;

public class RisingSand {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int [] arr = new int[n];
            for(int i = 0 ;i < n; i++){
                arr[i] = sc.nextInt();
            }

            int count =  0;
            for(int i = 1; i < arr.length - 1; i ++){
                if(arr[i] > (arr[i-1] + arr[i+1])){
                    count++;
                }
            }


        }
    }
}
