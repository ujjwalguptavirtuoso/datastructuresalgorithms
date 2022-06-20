package leetcode;

public class CountSubArrays {
    public static long countSubarrays(int[] nums, long k) {
        long count = 0;
        long prefixSum[] = new long[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            prefixSum[i] = (long)prefixSum[i- 1] + (long)nums[i-1];
        }

        for(int i=0 ; i < prefixSum.length; i ++){
            int low = i;
            int high = prefixSum.length - 1;
            while(low < high){
                int mid = low+ (high - low)/2;
                long sum = prefixSum[mid] - prefixSum[i];
                long length = mid - i;
                if(length == 0){
                    low = mid + 1;
                    continue;
                }
                if(sum * length < k){
                    low = mid;
                }else{
                    high = mid - 1;
                }
            }
            count += low - i;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {2,1,4,3,5};
        int k = 10;
        countSubarrays(nums, k);
    }
}
