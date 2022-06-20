package codeforces;

import java.util.Scanner;

public class ZeroPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int x = sc.nextInt();
             int y = sc.nextInt();
             int matrix[][] = new int[x][y];
             for(int i = 0; i < x; i ++){
                 for(int j = 0; j < y; j++){
                     matrix[i][j] = sc.nextInt();
                 }
             }

             int dp_max [][] = new int[x][y];
             int dp_min[][] = new int[x][y];

             if((x+y)%2 == 0){
                 System.out.println("NO");
                 continue;
             }

             dp_max[0][0] = dp_min[0][0] = matrix[0][0];

             for(int i = 0; i < x; i++){
                 for(int j = 0; j < y ; j ++){
                     if(i == 0 && j == 0){
                         continue;
                     }else if(i == 0){
                         dp_max[i][j] = dp_max[i][j-1] + matrix[i][j];
                         dp_min[i][j] = dp_min[i][j-1] + matrix[i][j];
                     }else if(j == 0){
                         dp_max[i][j] = dp_max[i-1][j] + matrix[i][j];
                         dp_min[i][j] = dp_min[i-1][j] + matrix[i][j];
                     }else{
                         dp_max[i][j] =  matrix[i][j] + Math.max(dp_max[i-1][j] , dp_max[i][j-1]);
                         dp_min[i][j] =  matrix[i][j] + Math.min(dp_min[i-1][j], dp_min[i][j-1]);
                     }
                 }
             }

            // if max and min range is covering 0
            if(dp_min[x-1][y-1] <= 0 && dp_max[x-1][y-1] >= 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
