package dynamicprogramming.atcoder;

import java.util.Scanner;

public class VacationHousePaint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int matrix[][] = new int[n][3];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < 3; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int max_hap [][] = new int[n][3];
        for(int i = 0; i < 3; i ++){
            max_hap[0][i] = matrix[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    max_hap[i][j] = matrix[i][j] + Math.max(max_hap[i-1][1], max_hap[i-1][2]);
                }else if(j == 1){
                    max_hap[i][j] = matrix[i][j] + Math.max(max_hap[i-1][0], max_hap[i-1][2]);
                }else{
                    max_hap[i][j] = matrix[i][j] + Math.max(max_hap[i-1][0], max_hap[i-1][1]);
                }
            }
        }
        int maxHapiness = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i ++){
            maxHapiness = Math.max(maxHapiness, max_hap[n-1][i]);
        }
        System.out.println(maxHapiness);
    }
}
