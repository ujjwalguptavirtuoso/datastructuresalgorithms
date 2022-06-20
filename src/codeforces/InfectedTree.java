package codeforces;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfectedTree {

       // List<List<Integer>> treeGraph;

      static int countNodesInSubgraph(List<List<Integer>> treeGraph, int u , boolean [] visited){
          List<Integer> list = treeGraph.get(u);
         if(list.size() == 0){
             return 1;
         }
         if(visited[u]){

         }
         int sum = 0;
         for(int v : list){
             visited[v] = true;
             sum += countNodesInSubgraph(treeGraph, v, visited);
         }

          return sum;
      }

       static void addEdge(int u, int v, List<List<Integer>> treeGraph){
           treeGraph.get(u).add(v);
       }


       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int arr[][] = new int [n][2];

            List<List<Integer>> treeGraph = new ArrayList<>();
            // 1 based indexing
            // 0 vertex list will be always empty
            for(int i=0; i< n + 1; i++){
                treeGraph.add(new ArrayList<>());
            }
            for(int i = 0; i < n;i++){
                int u = arr[i][0];
                int v = arr[i][1];
                addEdge(u, v, treeGraph);
            }


        }
    }
}

