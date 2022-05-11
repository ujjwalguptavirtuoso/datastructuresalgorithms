package sorting;

/**
 * ujjwal.gupta
 *
 * @version $Id: InsertionSort.java, v 0.1 2022-05-11
 */
public class InsertionSort {

    static void insertionSort(int [] nums){
        for(int i =1 ; i< nums.length; i++){
            for(int j = i-1 ; j >=0; j--){
                if(nums[j+1] < nums[j]){
                    //swap
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    /********************START  HERE*****************/
    static void insertionSortLearned(int [] nums){

    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 4, 2 ,7, 6, 3, 0 , -1};
        insertionSort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");}
    }
}
