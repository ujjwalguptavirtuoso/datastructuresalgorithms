package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

class WeightedNode{
    int u;
    int wt;

    WeightedNode(int u, int wt){
        this.u = u;
        this.wt = wt;
    }
}

public class CheapestFlightWithinKStops {

       static  int dfs(List<List<WeightedNode>> graph, int vertex, int stops, int dst, int [][]dp){
            if(stops < 0){
                return Integer.MAX_VALUE;
            }

            if(vertex == dst){
                return 0;
            }

            if(dp[vertex][stops] != -1){
                return dp[vertex][stops];
            }

            int ans = Integer.MAX_VALUE;
            for(WeightedNode wn : graph.get(vertex)){

                int nextStateAns = dfs(graph, wn.u, stops - 1, dst, dp);

                if(nextStateAns != Integer.MAX_VALUE){
                    ans  = Math.min(ans, wn.wt + nextStateAns);
                }
            }
            return dp[vertex][stops] = ans;
        }

         public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<WeightedNode>> graph = new ArrayList<>();
            for(int i = 0; i < n; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0 ;i < flights.length; i++){
                graph.get(flights[i][0]).add(new WeightedNode(flights[i][1], flights[i][2]));
            }
            int[][] dp = new int[n][k + 1];
            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j < dp[0].length; j++){
                    dp[i][j] = -1;
                }
            }

            int val = dfs(graph, src, k , dst, dp);
            // System.out.println(val);

            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j < dp[0].length; j++){
                    System.out.print(dp[i][j] + ",");
                }
                System.out.println();
            }
            return  val == Integer.MAX_VALUE ? -1 : val;
        }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));

    }
}
