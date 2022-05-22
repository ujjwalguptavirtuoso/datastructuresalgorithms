package datastructures.graphs;
import java.util.*;
public class GraphS {

    static List<List<Pair>> graph = new ArrayList<>(5);
  // we want to have adjacency list of Pair as pair will show both vetrex and weight
   static void addEdge(int v, int u, boolean isBiDir, int wt ){

       graph.get(u).add(new Pair(v, wt));
        if(isBiDir){

            graph.get(v).add(new Pair(u, wt));
        }
    }

   static void display(){
       for(int i = 0 ;  i < graph.size(); i++){
           for( Pair p : graph.get(i)){
               System.out.print ( "vertex:" + i +", vertex: " + p.vertex + ", weight:" + p.weight+ "||");
           }
           System.out.println();
       }
   }

  static void bfs(int src, int vertices){
       Queue<Integer> q = new LinkedList();
       boolean [] visited = new boolean[vertices];

       q.offer(src);
       visited[src] = true;
       while(!q.isEmpty()){
           int temp = q.poll();
           System.out.println(temp);
           List<Pair> list =  graph.get(temp);
           for(Pair p : list){
              if(!visited[p.vertex]){
                  q.offer(p.vertex);
                  visited[p.vertex] = true;
              }
          }
       }
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edges = sc.nextInt();

        while(edges!=0){
            int V = 5;
            for (int i = 0; i < V; i++)
                graph.add(new ArrayList<Pair>());
           int v = sc.nextInt();
           int u = sc.nextInt();
           int wt = sc.nextInt();
           edges --;

           addEdge(v, u, true, wt);
           //display();
        }
        bfs(1, 5);


    }

}
