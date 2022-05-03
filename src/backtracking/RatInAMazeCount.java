package backtracking;

import java.util.Scanner;

/**
 * ujjwal.gupta
 * @version $Id: RatInAMazeCount.java, v 0.1 2022-05-03 16:39
 */
public class RatInAMazeCount {

    static int totalPaths = 0;
    static boolean isSafe(int n, int i, int j ,boolean[][] visited){
        return (i >= 0 && j>= 0 && i<n && j < n && !visited[i][j]);
    }


     static void helper(int i, int j, int n, int[][] maze ,boolean[][] visited){
        if(!isSafe(n ,i, j , visited)){
            return;                           // pruning of solution
        }

        if(i == n-1 && j == n-1){
            totalPaths++;    // base case when reaching the destination
            return;
        }

        visited[i][j] = true;
        if(i-1>= 0 && maze[i-1][j] == 0){           // up
            helper(i-1, j, n, maze, visited);
        }
        if(i+1 < n && maze[i+1][j] == 0){            // down
            helper(i+1, j, n, maze, visited);
        }
        if(j-1>= 0 && maze[i][j-1] == 0){            // left
            helper(i, j-1, n, maze, visited);
        }
        if(j+1< n && maze[i][j+1] == 0){              // right
            helper(i, j+1, n, maze, visited);
        }

        visited[i][j] = false;
    }

     static int countPathsViaBacktracking(int[][] maze){
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        helper(0, 0, n, maze, visited);

        return totalPaths;
    }

    public static void main(String[] args) {

        /*int maze[][] = {{0, 0, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0},
                        {1, 0, 1, 1, 0, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0},
                        {1, 1, 1, 1, 0, 0, 0}};*/

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int [][] maze = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println(countPathsViaBacktracking(maze));
    }
}







