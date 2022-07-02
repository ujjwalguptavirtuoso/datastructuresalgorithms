package codeforces;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PleasantPairs {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();
       // dq.getFirst()
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int n = sc.nextInt();
           int arr[] = new int[n + 1];
           for(int i= 1; i <=n; i++){
               arr[i] = sc.nextInt();
           }
           int count = 0;
           for(int i = 1; i < arr.length - 1; i++){
               for(int j = i + 1; j < arr.length; j++){
                   if((long) i + j == (long)(arr[i]*arr[j])){
                       count++;
                   }
               }
           }
            System.out.println(count);
        }
    }
}
