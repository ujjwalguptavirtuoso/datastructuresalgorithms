package codeforces;

import java.util.*;

public class SameDifferences{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int n =sc.nextInt();
           int arr[] = new int [n];
           for(int i = 0; i  < n; i++){
               arr[i] = sc.nextInt();
           }
          Map<Integer, ArrayList<Integer>> map = new HashMap<>();
           for(int i = 0; i < arr.length; i++){
               if(map.containsKey(arr[i] - i)){
                   ArrayList<Integer> tempList = map.get(arr[i] - i);
                   tempList.add(i);
                   map.put(arr[i] - i, tempList);
               }else{
                   ArrayList<Integer> tempList = new ArrayList<>();
                   tempList.add(i);
                   map.put(arr[i]-i, tempList);
               }
           }
           long count = 0;
           for(Integer key : map.keySet()){
               List<Integer> tempList = map.get(key);
               int k = tempList.size();
               count += ((long)k * (long)(k - 1))/2;       // to add combinations possible for each key basically k * (k-1) / 2
           }
            System.out.println(count);
        }
    }
}
