package codeforces;

import java.util.Scanner;

public class KdivisibleSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int n = sc.nextInt();
           int k = sc.nextInt();
           if(k%n == 0){
               System.out.println(k/n);
               continue;
           }
           else{
               int originalK = k;
              if(k < n){
                  k = n;
                  if( k%originalK != 0){
                      k = k + (originalK - k%originalK);
                  }
              }
              int rem = k%n;
               if(rem == 0){
                   System.out.println(k/n);
               }else{
                   System.out.println(k/n + 1);
               }
           }
        }
    }
}
