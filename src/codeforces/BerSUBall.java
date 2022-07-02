package codeforces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BerSUBall {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i= 0; i < n; i ++){
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        int m = sc.nextInt();
        int arr2[] = new int[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m ; i++){
            arr2[i] = sc.nextInt();
            if(map.containsKey(arr2[i])){
                map.put(arr2[i], map.get(arr2[i])+1);
            }else{
                map.put(arr2[i], 1);
            }
        }
        int totalPairs = 0;
        for(int i = 0; i < arr1.length; i++){
            if(map.get(arr1[i] - 1)!= null && map.get(arr1[i] - 1) > 0 ){
                totalPairs++;
                map.put(arr1[i] - 1, map.get(arr1[i] - 1) - 1);
                continue;
            }else if(map.get(arr1[i])!= null && map.get(arr1[i]) > 0 ){
                totalPairs++;
                map.put(arr1[i], map.get(arr1[i]) - 1);
                continue;
            }else if(map.get(arr1[i] + 1)!= null && map.get(arr1[i] + 1) > 0 ){
                totalPairs++;
                map.put(arr1[i] + 1, map.get(arr1[i] + 1) - 1);
                continue;
            }
        }
        System.out.println(totalPairs);
    }
}
