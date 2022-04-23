package datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ujjwal.gupta
 * @version $Id: NoOfIslandsBFS.java, v 0.1 2022-04-23 13:29
 */
public class NoOfIslandsBFS {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static boolean isSafe(int [][] matrix, boolean [][] visited, int i, int j){

        int total_rows = matrix.length;
        int total_column = matrix[0].length;

        return (i>=0 && i<total_rows && j>=0 && j<total_column && (matrix[i][j]== 1 && !visited[i][j]));
    }

    static void bfs(int [][] matrix, boolean [][] visited, int si, int sj){

        //initializing neighbour array

        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Simple BFS first step, we enqueue
        // source and mark it as visited
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(si, sj));
        visited[si][sj] = true;

        // Next step of BFS. We take out
        // items one by one from queue and
        // enqueue their univisited adjacent
        while(!q.isEmpty()){

            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();


            for(int k=0; k<8; k++){
                if(isSafe(matrix, visited, i + row[k], j + col[k])){
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Pair(i + row[k], j + col[k]));
                }
            }
        }

    }


    // This function returns number islands (connected
    // components) in a graph. It simply works as
   // BFS for disconnected graph and returns count
    // of BFS calls.

   static int countIslands(int[][] matrix){

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean [][] visited = new boolean[rows][columns];

        int result = 0;

        for(int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    bfs(matrix, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 0, 1, 0, 1 } };


        System.out.println(countIslands(mat));
    }
}
