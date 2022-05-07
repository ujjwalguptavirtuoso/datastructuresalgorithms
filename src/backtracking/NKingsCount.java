
package backtracking;

import java.util.Scanner;

/**
 *
 * @version $Id: NKingsCount.java, v 0.1 2022-05-06
 *
 * 	Number of ways to place n nonattacking kings on an n X n board.
 */
public class NKingsCount {

    static int totalCount = 0;

    static void display(boolean [][] grid, int n){
        for(int i=0 ; i<n; i++){
            System.out.print("[ ");
            for(int j=0; j<n; j++){
                if(grid[i][j])
                    System.out.print("Ki ");
                else
                    System.out.print(". ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    static void countNKings(int n, boolean [][] visited, int curr_row, int curr_col, int count){

        if(count == n){
            totalCount++;
            display(visited, n);
            return;
        }

        for(int i = curr_row; i<n; i++){
            for(int j = (i == curr_row)? curr_col : 0 ; j<n; j++){
                if(isItSafe(i, j, visited, n)){
                    visited[i][j] = true;
                    countNKings(n, visited, i, j+2 , count+1);
                    visited[i][j] = false;
                }
            }
        }
    }



    static boolean isItSafe(int i, int j, boolean[][] visited, int n){

        // check for previous possible kings placed

        if(i-1 >=0 && j-1 >=0 && visited[i-1][j-1]){
            return false;
        }
        if(i-1 >=0 && j+1 <n && visited[i-1][j+1]){
            return false;
        }
        if(i-1 >=0 && visited[i-1][j]){
            return false;
        }
        if(j-1 >=0 && visited[i][j-1]){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] visited = new boolean [n][n];

        countNKings(n, visited, 0, 0, 0);
        System.out.println(totalCount);
    }
}
