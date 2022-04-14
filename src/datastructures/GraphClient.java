package datastructures;

public class GraphClient {
    public static void main (String[] args){
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdges("A", "B", 1);
        graph.addEdges("B", "C", 2);
        graph.addEdges("A", "C", 4);
        graph.addEdges("C", "D", 6);
        graph.addEdges("D", "E", 5);
        graph.addEdges("C", "F", 1);
        graph.addEdges("E", "F", 3);

        graph.display();


    }
}
