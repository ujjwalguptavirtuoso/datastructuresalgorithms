package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ujjwal.gupta
 * @version $Id: PlaceKnightsOnGrid.java, v 0.1 2022-05-04
 */
public class PlaceKnightsOnGrid {

    void display(int [][] grid, int n){
        for(int i=0 ; i<n; i++){
            System.out.print("[ ");
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }



    void knightTour(int n , int[][] grid, boolean[][] visited, int i, int j, int count){
        if(count == n * n - 1){
            grid[i][j] = count;
            display(grid, n);
            return ;
        }

        int xdir [] = {-2, -2, -1, -1, 1, 1, 2, 2};  // moves of knight by these two arrays
        int ydir [] = {-1, 1, 2, -2, 2, -2, -1, 1};

        visited[i][j]= true;
        grid[i][j] = count;
        for(int k = 0; k<8; k++){
            if(isItSafe(i + xdir[k], j + ydir[k], visited, n)){
                knightTour(n, grid, visited, i + xdir[k], j + ydir[k], count+1);
            }
        }
        visited[i][j] = false;
        grid[i][j] = -1;
    }

    boolean isItSafe(int row, int col, boolean [][] visited, int n){
        return (row >=0 && col >=0 && row < n && col < n && !visited[row][col]) ;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PlaceKnightsOnGrid obj = new PlaceKnightsOnGrid();
        int [][] grid = new int [n][n];
        boolean [][] visited = new boolean[n][n];

        // initializing complete grid with -1;
        for(int i=0; i<n ;i++){
            Arrays.fill(grid[i], -1);
        }
       // obj.display(grid, n);
        obj.knightTour(n, grid, visited, 0, 0, 0);

    }



}
