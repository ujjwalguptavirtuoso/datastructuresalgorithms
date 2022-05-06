package backtracking;

import java.util.Scanner;

/**
 * ujjwal.gupta
 * @version $Id: NKnights.java, v 0.1 2022-05-05
 */
// Given n*n board, find and display number of ways to place n non attacking Knights on the board
public class NKnights {

    static int totalCount = 0;

    static void display(boolean [][] grid, int n){
        for(int i=0 ; i<n; i++){
            System.out.print("[ ");
            for(int j=0; j<n; j++){
                if(grid[i][j])
                System.out.print("K ");
                else
                    System.out.print(". ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    static void countNKnights(int n, boolean [][] visited, int curr_row, int curr_col, int count){

       if(count == n){
           totalCount++;
           display(visited, n);
           return;
       }

       for(int i = curr_row; i<n; i++){
           for(int j = (i == curr_row)? curr_col : 0 ; j<n; j++){
               if(isItSafe(i, j, visited, n)){
                   visited[i][j] = true;
                   countNKnights(n, visited, i, j+1 , count+1);
                   visited[i][j] = false;
               }
           }
       }
    }



    static boolean isItSafe(int i, int j, boolean[][] visited, int n){
        /*int xdir [] = {-2, -2, -1, -1};  // moves of knight by these two arrays
        int ydir [] = {-1, 1, 2, -2};

        if(!(i >=0 && j >=0 && i<n && j<n && !visited[i][j])){     // check if cell is out of matrix
            return false;
        }

        if( i >=0 && j >=0 && i<n && j<n && !visited[i][j]){  // if cell is in matrix, it is not surrounded by any knight in attackable position
            for(int k=0; k<4; k++){
                if(visited[i+xdir[k]][j+ydir[k]])
                    return false;
            }
        }
        return true*/;

        if(i-2 >=0 && j-1 >=0 && visited[i-2][j-1]){
            return false;
        }
        if(i-1 >=0 && j-2 >=0 && visited[i-1][j-2]){
            return false;
        }
        if(i-1 >=0 && j+2 <n && visited[i-1][j+2]){
            return false;
        }
        if(i-2 >=0 && j+1 < n && visited[i-2][j+1]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] visited = new boolean [n][n];

        countNKnights(n, visited, 0, 0, 0);
        System.out.println(totalCount);
    }
}
