package datastructures.graphs;

import java.util.*;

public class MinCostToReachBottom {


    int nextNode(int row, int col, int dir, int n, int m){
        if(dir==1){
            //left
            col--;
        }
        if(dir==2){
            //right
            col++;
        }if(dir==3){
            //up
            row--;
        }
        if(dir == 4){
            //down
            row++;
        }
        if( (row >=0 && col>=0 && row< n && col < m)){
            return -1;
        }else{
            return n * row+ col;
        }
    }


    int zeroOneBFS(List<List<Pair>> graph, int src, int dest, int n, int m){
        int [] distance= new int[n * m];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Deque<Integer> deque = new LinkedList<>();
       // deque.
        distance[src] = 0;
        deque.offer(src);
        while(!deque.isEmpty()){
            int node = deque.pollFirst();
            for(Pair neighbour : graph.get(node)){

            }
        }
        return -1;
    }



    int minCost(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        List<List<Pair>> graph = new ArrayList<>(n*m);
        for(int i= 0 ; i < n; i ++){
            for(int j = 0; j < m; j++){
                int nodeValue = i*n + j;
                for(int d=1; d<=4; d++){
                  int next = nextNode(i, j, d, n, m);
                  if(d == grid[i][j]){
                      graph.get(nodeValue).add(nodeValue, new Pair(next, 0));
                  }else{
                      graph.get(nodeValue).add(nodeValue, new Pair(next, 1));
                  }
                }
            }
        }
        return -1;
    }
}
