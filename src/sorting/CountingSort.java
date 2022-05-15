package sorting;

/**
 * ujjwal.gupta
 *
 * @version $Id: CountingSort.java, v 0.1 2022-05-12
 */
public class CountingSort {

   //static int output[];

   // for positive integers
    // we have to do axis shift for sorting for negative integers
    static void countingSort(int [] nums){
       int maxInNums = Integer.MIN_VALUE;
       int minInNums = Integer.MAX_VALUE;
       for(int i = 0; i<nums.length; i++){
           if(nums[i] > maxInNums){
               maxInNums = nums[i];
           }
           if(nums[i] < minInNums){
               minInNums = nums[i];
           }
       }

       int buckets[] = new int[maxInNums + 1];
       for(int i = 0; i< nums.length; i++){
           buckets[nums[i]]++;
       }

       for(int j = 1; j< buckets.length; j++){
           buckets[j] += buckets[j-1];
       }

       int[] output = new int [nums.length];
       for(int i = nums.length - 1; i>=0 ; i--){
           output[buckets[nums[i]] - 1 ] = nums[i];
           buckets[nums[i]]-- ;
       }

       for(int i= 0 ;i < output.length; i++){
           nums[i] = output[i];
       }
   }



    public static void main(String[] args) {
        int [] arr = {1, 3, 4, 2 ,7, 6, 3, 0, 56 };
        countingSort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");}
    }
}
