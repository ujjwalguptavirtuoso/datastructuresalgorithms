package leetcode;

import java.util.*;

class Tuple{
    String den;
    double val;

    Tuple(String den, double val){
        this.den = den;
        this.val = val;
    }
}

public class EvaluateDivision {

    double val = 1.0;
    boolean valFound = false;

    void dfs(String vertex, Map<String, List<Tuple>> adjMap, Set<String> visited, String target, double ansTillNow){
        if(valFound){
            return;
        }

        visited.add(vertex);
        if(target == vertex){
            val = ansTillNow;
            valFound = true;
            return;
        }

        for(Tuple tuple : adjMap.get(vertex)){
            if(!visited.contains(tuple.den)){
                dfs(tuple.den, adjMap, visited, target, ansTillNow * tuple.val);
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Tuple>> adjMap = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            if(adjMap.containsKey(num)){
                List<Tuple> list = adjMap.get(num);
                list.add(new Tuple(den, values[i]));
                adjMap.put(num, list);
            }else{
                List<Tuple> list = new ArrayList<>();
                list.add(new Tuple(den, values[i]));
                adjMap.put(num, list);
            }

            if(adjMap.containsKey(den)){
                List<Tuple> list = adjMap.get(den);
                list.add(new Tuple(num, (1.0000/values[i])));
                adjMap.put(den, list);
            }else{
                List<Tuple> list = new ArrayList<>();
                list.add(new Tuple(num, (1.0000/values[i])));
                adjMap.put(den, list);
            }
        }
        double arr[] = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            val = 1.0;
            valFound = false;
            String num = queries.get(i).get(0);
            String den = queries.get(i).get(1);
            if(adjMap.get(num) == null || adjMap.get(den) == null){
                arr[i] = -1.00000;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            dfs(num, adjMap, visited, den, 1.00000);
            if(valFound){
                arr[i] = val;
            }else{
                arr[i] = -1.00000;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>());
        equations.get(0).add("a");
        equations.get(0).add("b");
        equations.add(new ArrayList<>());
        equations.get(1).add("b");
        equations.get(1).add("c");

        double values[] = {2.0,3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>());
        queries.get(0).add("a");
        queries.get(0).add("c");
        queries.add(new ArrayList<>());
        queries.get(1).add("b");
        queries.get(1).add("a");
        queries.add(new ArrayList<>());
        queries.get(2).add("a");
        queries.get(2).add("e");
        queries.add(new ArrayList<>());
        queries.get(3).add("a");
        queries.get(3).add("a");
        queries.add(new ArrayList<>());
        queries.get(4).add("x");
        queries.get(4).add("x");

        EvaluateDivision obj = new EvaluateDivision();
        double[] ans =  obj.calcEquation(equations, values, queries);
        System.out.println(ans[0] + " " +ans[1]);


    }
}
