package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    static int maxProfit = Integer.MIN_VALUE;

    static void solve(int [] nums, Map<Integer, Integer> map, int profit, int index){
        if(index == nums.length){
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        HashMap<Integer, Integer> tempMap = new HashMap<>();

        //choosing to avoid
        solve(nums, map, profit, index + 1);

        //choosing to pick
        if(map.get(nums[index]) > 0){


                if(map.containsKey(nums[index] + 1)){
                    tempMap.put(nums[index] + 1, map.get(nums[index] + 1));
                    map.put(nums[index] + 1, 0);
                }
                if(map.containsKey(nums[index] - 1)){
                    tempMap.put(nums[index] - 1, map.get(nums[index] - 1));
                    map.put(nums[index] - 1, 0);
                }

                int earnings =  map.get(nums[index]) * nums[index];
                tempMap.put(nums[index], map.get(nums[index]));
                map.put(nums[index], 0);

            //recur
            solve(nums, map, profit + earnings, index + 1);
            //undo step backtracking
            for(Integer tempi : tempMap.keySet()){
                map.put(tempi, tempMap.get(tempi));
                tempMap.put(tempi, 0);
            }
        }
    }


    static public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        //generated frequency hashmap
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }

        solve(nums, map, 0, 0);
        return maxProfit;

    }

    public static void main(String[] args) {
        int nums[] = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }
}
