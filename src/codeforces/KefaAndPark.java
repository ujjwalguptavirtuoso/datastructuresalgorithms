package codeforces;

import java.util.*;

public class KefaAndPark {

    static int count = 0;
    static void dfs(List<List<Integer>> graph, int vertex, Set<Integer> visited, int catScore, int m, int [] catArr){
         visited.add(vertex);

         //consecutive logic
         if(catArr[vertex] == 1){
              catScore++;
          }else if(catArr[vertex] == 0){
             catScore = 0;
          }

          if(catScore > m){
              return;
          }
          if(graph.get(vertex).size() == 1 && vertex!=1){
              count++;
              return;
          }
         for(Integer u : graph.get(vertex)){
              if(!visited.contains(u)){
                  dfs(graph, u, visited, catScore,m, catArr);
              }
         }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] catArr = new int[n + 1];
        for(int i= 1; i <= n ; i++){
            catArr[i] = sc.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n- 1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(graph, 1, visited, 0, m, catArr);
        System.out.println(count);
    }
}
