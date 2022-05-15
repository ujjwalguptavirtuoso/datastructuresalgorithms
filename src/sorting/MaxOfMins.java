package sorting;
import java.util.*;

/**
 * ujjwal.gupta
 *
 * @version $Id: MaxOfMins.java, v 0.1 2022-05-13
 */
public class MaxOfMins {

    static int fillAndFindMaxOfMin (int [] bucket, int nums[], int min){
        int result[] = new int[nums.length];
        int length = 0;
        int max_of_mins_sum = 0;

        for(int i = 0; i< bucket.length; i++){
            while(bucket[i] > 0 && length < nums.length){
                if(min < 0){
                result[length] = i + min;
                }
                length++ ;
                bucket[i]-- ;
            }
        }
        for(int i = 0; i< result.length; i+=2){
            max_of_mins_sum +=result[i];
        }
        return max_of_mins_sum;
    }

    public static int arrayPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_of_mins_sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        if(min < 0){
            int[] bucket = new int [max - min + 1];
            for(int i = 0; i < nums.length; i++){
                bucket[nums[i] - min]++;
            }

            max_of_mins_sum = fillAndFindMaxOfMin (bucket, nums, min);

        }
        else{
            int[] bucket = new int[max + 1];
            for(int i = 0; i< nums.length; i++){
                bucket[nums[i]]++;
            }
            max_of_mins_sum = fillAndFindMaxOfMin (bucket, nums, min);
        }
        return  max_of_mins_sum;
    }



    public static void main(String[] args) {
       int arr[] =  {6,2,6,5,1,2, -3, -4, -5, -3};
        System.out.println(arrayPairSum(arr));
    }
}
