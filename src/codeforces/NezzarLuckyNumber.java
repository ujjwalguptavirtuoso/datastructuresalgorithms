package codeforces;

import java.util.Scanner;

public class NezzarLuckyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
          int n = sc.nextInt();
          int d = sc.nextInt();
          for(int i = 0; i < n; i++){
              int num = sc.nextInt();
              if(num/10 == 0){
                  System.out.println("NO");
              }else{
                  int newNum = num - d;
                  if(newNum%10 == d){
                      System.out.println("YES");
                  }else{
                      System.out.println("NO");
                  }
              }
          }
        }
    }
}
