package codeforces;

import java.util.Scanner;

public class LukeIsAFoodie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();
             int x = sc.nextInt();
             int arr[] = new int[n];
             for(int i = 0; i < n; i++){
                 arr[i] = sc.nextInt();
             }
             int ans = 0;
             int max = arr[0];
             int min = arr[0];
             for(int i = 1 ;i < arr.length; i ++){
                 if(Math.abs(arr[i] - max) > 2*x || Math.abs(arr[i] - min) > 2*x){
                     max = arr[i];
                     min = arr[i];
                     ans++;
                 }
                 max = Math.max(arr[i], max);
                 min = Math.min(arr[i], min);
             }
            System.out.println(ans);
        }
    }
}
