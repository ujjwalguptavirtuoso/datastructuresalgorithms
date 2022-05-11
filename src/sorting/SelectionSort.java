package sorting;

/**
 * ujjwal.gupta
 *
 * @version $Id: SelectionSort.java, v 0.1 2022-05-11
 */
public class SelectionSort{


    // self implemented ////////////

    static void selectionSort(int [] arr){
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            int index = i;
            for(int j = i; j<arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }

    // more cleaner solution
    ///////////////////////////////////////////////// starts here
    static void selectionSortLearned(int [] arr){
        for(int i = 0; i<arr.length; i++){
            int min_index = findMinIndex(arr, i);
            if(i!= min_index) swap(arr, min_index, i);
        }
    }

    static int findMinIndex(int [] arr, int i){
        int min_index = i;
        while(i < arr.length){
            if(arr[i] < arr[min_index]){
                min_index = i;
            }
            i++;
        }
        return min_index;
    }



    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    ///////////////////////////////////////// ends here

    public static void main(String[] args) {
        int [] arr = {1, 3, 4, 2 ,7, 6, 3, 0 };
        //selectionSort(arr);
        selectionSortLearned(arr);
        for(int i = 0; i<arr.length; i++){
        System.out.print(arr[i] + " ");}
    }
}


