package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SingleSourceShortestPathBFS {

    static List<List<Integer>> graph = new ArrayList<>(6);

    static void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

   static  void singleSourceShortestPath(int src, int destination, int n){
        boolean [] visited = new boolean[n];
        int [] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        int [] distance = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : graph.get(node)){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour] = true;
                    parent[neighbour] = node;
                    distance[neighbour] = distance[node] + 1;
                }
            }
        }
        int temp = destination;
        List<Integer> result = new ArrayList<>();
        //because parent of source is -1;
        while(temp!= -1){
            result.add(temp);
            temp = parent[temp];
        }
        Collections.reverse(result);
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        for(int i = 0; i < 6; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(0, 1);
        addEdge(5, 2);
        addEdge(0,2);
        addEdge(3, 4);
        addEdge(1, 4);
        addEdge(2, 4);
      //  addEdge(2, 5);
        singleSourceShortestPath(0, 3, 6);
    }
}
