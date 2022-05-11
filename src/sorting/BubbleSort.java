package sorting;

/**
 * ujjwal.gupta
 *
 * @version $Id: BubbleSort.java, v 0.1 2022-05-11
 */
public class BubbleSort {

    static void bubbleSort(int [] nums){
        for(int i = nums.length-1; i>= 0; i--){
            int maxInRange = nums[i];
            int maxIndex = i;
            for(int j = 0; j <=i; j++){
                if(nums[j] > maxInRange){
                    maxInRange = nums[j];
                    maxIndex = j;
                }

            }
            int temp = nums[i];
            nums[i] = maxInRange;
            nums[maxIndex] = temp;
        }
    }

    static void actualBubbleSort(int[] nums){
        // till nums.length - 1 because we are swapping and checking j and j +1
        for(int i = 0; i < nums.length-1 ; i++){
            boolean isSorted = false; // for oprimization
            // we are reducing size to nums.length - 1 - i, as we are progressing and bubbling up
            for(int j = 0 ; j < nums.length - i - 1 ; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j+1);
                    isSorted = true;
                }
            }
            // if in any run of i loop we do not do any swap it means array is sorted and we can return.
            if(!isSorted){
                return;
            }
        }
    }

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 4, 2 ,7, 6, 3, 0 , -1};
        //bubbleSort(arr);
        actualBubbleSort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");}
    }
}
