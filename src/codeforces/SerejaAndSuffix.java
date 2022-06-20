package codeforces;

import java.util.HashSet;
import java.util.Scanner;

public class SerejaAndSuffix {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int q = sc.nextInt();
       int arr[] = new int[n];
       for(int i = 0;i < n ; i++){
           arr[i] = sc.nextInt();
       }
       //pre-compute using hashset
        int [] distinct = new int[arr.length];
        HashSet<Integer> set = new HashSet<>();
       for(int i = distinct.length-1; i>=0; i--){
           set.add(arr[i]);
           distinct[i] = set.size();
       }

       for(int i = 0; i < q;i ++){
           int q_i = sc.nextInt();
           System.out.println(distinct[q_i - 1]);
       }

    }
}
