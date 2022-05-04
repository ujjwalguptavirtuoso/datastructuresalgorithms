/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package backtracking;

import java.util.Scanner;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: NQueensCount.java, v 0.1 2022-05-04 02:26 wb-ujjwalgup584692 Exp $$
 */
public class NQueensCount {

    static int totalCount = 0;
    static void countNQueens(boolean[][] grid, int curr_row, int n){
        if(curr_row == n){
            totalCount++;
            return;
        }

        for(int i=0; i<n; i++){
             if(isSafe(curr_row, i, grid, n)){

                 grid[curr_row][i] = true;
                 countNQueens(grid, curr_row + 1, n);
                 grid[curr_row][i] = false;


             }
        }

    }

    static boolean isSafe(int row, int col, boolean[][] grid, int n){

        for(int i= row -1 ; i >=0; i--){                            // check full column above the element you ar at.
            if(grid[i][col] == true) return false;
        }
        /*for(int j= col -1 ; j >=0; j--){
            if(grid[col][j] == true) return false;
        }*/
        for(int i = row - 1, j = col - 1; i>=0 && j>=0 ; i--, j--){   // left diagnol upper
            if(grid[i][j] == true) return false;

        }
        for(int i = row - 1, j = col + 1; i>=0 && j<n ; i--, j++){   // right diagnol upper
            if(grid[i][j] == true) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] grid = new boolean [n][n];

        countNQueens(grid, 0, n);
        System.out.println(totalCount);


    }
}
