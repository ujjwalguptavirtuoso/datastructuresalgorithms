package codeforces;

import java.util.Scanner;

public class MirrorGrid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              int matrix[][] = new int[n][n];
              for(int i = 0 ; i < n; i ++){
                  for(int j = 0; j < n ; j ++){
                       matrix[i][j] = sc.nextInt();
                  }
              }
              int count = 0;
              int end = -1;
              if(n%2 == 0){
                end = n/2;
              }else{
                end = n/2 + 1;
              }
              for(int i = 0; i < end; i++){
                  for(int j = 0; j < end; j++){
                     if(matrix[i][j] != matrix[n - i - 1][j]){
                         matrix[n - i - 1][j] = matrix[i][j];
                         count++;
                     }
                     if(matrix[i][j]!= matrix[i][n - 1 - j]){
                         matrix[i][n - 1 - j] = matrix[i][j];
                         count++;
                     }
                  }
              }
              int start = -1;
              if(n%2 == 0){
                  start = n/2;
              }else{
                  start = n/2 + 1;
              }
              for(int i = start; i < n; i++){
                  for(int j = start; j < n; j++){
                      if(matrix[i][j] != matrix[n - i - 1][j]){
                          matrix[i][j] =  matrix[n - i - 1][j] ;
                          count++;
                      }
                  }
              }

            System.out.println(count);
        }
    }
}
