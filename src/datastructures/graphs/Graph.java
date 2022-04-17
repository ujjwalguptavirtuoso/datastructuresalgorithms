package datastructures.graphs;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    private class Vertex {
        Map<String, Integer> nghbrs = new HashMap<>();
    }

    private HashMap<String, Vertex> vertices = new HashMap<>();

    public void addVertex (String vname){
        Vertex vx = new Vertex();
        vertices.put(vname, vx);
    }

    public void addEdges (String vname1, String vname2, int cost){
        Vertex vx1 = vertices.get(vname1);
        Vertex vx2 = vertices.get(vname2);

        if(vx1 == null || vx2 == null || vx1.nghbrs.containsKey(vname2)){
            return;
        }
        vx1.nghbrs.put(vname2, cost);
        vx2.nghbrs.put(vname1, cost);
    }

    public void display(){
        System.out.println("--------------");
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        for(String key : keys){
            Vertex vtx = vertices.get(key);
            String str = key + " --> " + vtx.nghbrs;
            System.out.println(str);
        }
        System.out.println("--------------");
    }

   private class Pair {
        String name;
        Vertex vtx;

        // processed so far
       String psf;

   }

    public void dft(){

    }
}
