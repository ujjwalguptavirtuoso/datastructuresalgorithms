package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ujjwal.gupta
 * @version $Id: PrintAllSubsetsBacktracking.java, v 0.1 2022-05-03
 */
public class PrintAllSubsetsBacktracking {

    static void printSubset(int [] arr, int n, int i, List<Integer> list){
        // base case
        if(i == n){
            System.out.println(list.toString());
            return;
        }
        // when we chose a element to be included
        list.add(arr[i]);
        printSubset(arr, n , i + 1, list);
        list.remove(list.size() - 1); // back to original state for backtracking

        //when we choose an element to not be included
        printSubset(arr, n, i+1, list);

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        printSubset(arr, arr.length, 0, list);
    }


}

