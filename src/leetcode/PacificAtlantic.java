package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

    boolean atlantic = false;
    boolean pacific = false;
    int count = 0;
    void dfs(int [][] heights, int row, int col, boolean[][] visited){

        if(row == 0 || col == 0){
            pacific = true;
        }
        if(row == heights.length - 1 || col == heights[0].length - 1){
            atlantic = true;
        }
        System.out.println(count);
        visited[row][col] = true;
        if( row - 1 >= 0 && !visited[row-1][col] && heights[row-1][col] <= heights[row][col]){
            dfs(heights, row-1, col, visited);
        }
        if(row + 1 < heights.length && !visited[row+1][col] && heights[row+1][col] <= heights[row][col]){
            dfs(heights, row+1, col, visited);
        }
        if( col - 1 >= 0 && !visited[row][col - 1] && heights[row][col - 1] <= heights[row][col]){
            dfs(heights, row, col - 1, visited);
        }
        if( col + 1 < heights[0].length && !visited[row][col + 1] && heights[row][col+1] <= heights[row][col]){
            dfs(heights, row, col+1, visited);
        }
    }

    void  resetValuesVisited(boolean[][] visited){
        for(int i = 0; i < visited.length ;i++){
            for(int j = 0; j< visited[0].length; j++){
                visited[i][j] = false;
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        for(int i = 0; i < heights.length ;i++){
            for(int j = 0; j< heights[0].length; j++){

                atlantic = false;
                pacific = false;
                dfs(heights, i, j, visited);
                resetValuesVisited(visited);
                if(atlantic && pacific){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] heights = {{2, 1}, {1, 2}};
        PacificAtlantic obj = new PacificAtlantic();
        List<List<Integer>> ans =  obj.pacificAtlantic(heights);
        System.out.println(ans.toString());
    }
}
