
package datastructures.graphs;

/**
 * @author ujjwal.gupta
 * @version $Id: NumberOfIslandsDFS.java, v 0.1 2022-04-23 09:31
 */

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 *Input: grid = [
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 *
 */


public class NumberOfIslandsDFS {


    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean [m][n];

        int count = 0;
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    // this method tells if any particular cell is safe to go
    public static boolean isSafe(char[][] grid, int row, int col, boolean[][] visited){
        return (row>=0 && row<grid.length
                && col>=0 && col<grid[0].length
                && (grid[row][col] == '1' && !visited[row][col]));
    }

    // DFS
    static void dfs(char[][] grid, int row, int col, boolean[][] visited){
        // initializing neighbour arrays
        int rowNbr [] = new int []{-1, 0, 0, 1};
        int colNbr[] = new int[] {0, -1, 1, 0};

        //mark current cell as visited
        visited[row][col] = true;

        // recur for all connected neighbours
        for(int k=0; k<4; k++){
            if(isSafe(grid, row + rowNbr[k], col + colNbr[k], visited)){
                dfs(grid, row + rowNbr[k], col + colNbr[k], visited );
            }
        }
    }


    public static void main(String[] args) {
        char grid[][] = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
                                          };

        System.out.println(numIslands(grid));
    }

}

/** Time Complexity O(row * col)
 */