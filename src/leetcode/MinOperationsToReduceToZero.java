package leetcode;

public class MinOperationsToReduceToZero {

    static int solve(int i, int j, int nums[], int x, int [][] dp){
        if(x == 0){
            return 0;
        }

        if(j > i){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        if(x - nums[i] >=0){
            int val1 = solve(i + 1, j, nums, x - nums[i], dp);
            if(val1 != Integer.MAX_VALUE){
                ans1 = 1 + val1;
            }
        }
        if(x - nums[j] >= 0){
            int val2 = solve(i, j - 1, nums, x - nums[j], dp);
            if(val2!= Integer.MAX_VALUE){
                ans2 = 1 + val2;
            }
        }

        return dp[i][j] = Math.min(ans1, ans2);
    }

    public static int minOperations(int[] nums, int x) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int i = 0;i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int val = solve(0, nums.length - 1, nums, x, dp);
        return  val == Integer.MAX_VALUE ? -1 : val;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,4,2,3};
        int x = 5;

        System.out.println(minOperations(arr, x));
    }
}
