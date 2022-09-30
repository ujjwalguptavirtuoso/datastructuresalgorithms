package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfLIS {

    public static int findNumberOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        TreeMap<Integer, Integer> lisCountMap = new TreeMap<Integer, Integer>();
        dp[0] = 1;
        lisCountMap.put(1, nums.length);
        for(int i = 1 ; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    int temp = dp[j]  + 1;
                    //lisCountMap.put(temp, lisCountMap.getOrDefault(lisCountMap.get(temp), 0) + 1);
                    if(lisCountMap.containsKey(temp)){
                        lisCountMap.put(temp, lisCountMap.get(temp) + 1);
                    }else{
                        lisCountMap.put(temp, 1);
                    }
                    dp[i] = Math.max(dp[i], temp);
                }
            }
        }

        return lisCountMap.get(lisCountMap.lastKey());
    }

    public static void main(String[] args) {
        int nums[] = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }


}
