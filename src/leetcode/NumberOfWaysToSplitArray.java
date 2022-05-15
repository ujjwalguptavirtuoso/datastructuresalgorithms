package leetcode;

/**
 * ujjwal.gupta
 *
 * @version $Id: NumberOfWaysToSplitArray.java, v 0.1 2022-05-14
 */
public class NumberOfWaysToSplitArray {

    public static int waysToSplitArray(int[] nums) {
        int [] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int result = 0;
        for(int i = 0; i < prefixSum.length -1; i++){
            if(prefixSum[i] >= (prefixSum[prefixSum.length - 1] - prefixSum[i])){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};
        System.out.println(waysToSplitArray(nums));
    }
}
