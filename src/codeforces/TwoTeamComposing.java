package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoTeamComposing {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n =sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                int temp = sc.nextInt();
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp)+ 1);
                }else{
                    map.put(temp, 1);
                }
            }

            int maxFreq = Integer.MIN_VALUE;
            for(Integer key : map.keySet()){
               maxFreq = Math.max(map.get(key), maxFreq);
            }
            int otherSize = map.size() - 1;

            if(maxFreq < otherSize){
                System.out.println(maxFreq);
            }
            else if(maxFreq == otherSize + 1){
                System.out.println(otherSize);
            }else if(maxFreq == otherSize){
                System.out.println(otherSize);
            }else{
                System.out.println(otherSize + 1);
            }
        }
    }
}
