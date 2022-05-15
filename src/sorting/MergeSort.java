package sorting;

/**
 * ujjwal.gupta
 *
 * @version $Id: MergeSort.java, v 0.1 2022-05-12
 */
public class MergeSort {

    static void merge (int [] arr, int start , int end){
       int mid = start + (end-start)/2;
       int i = start;
       int j = mid + 1;
       int [] result = new int [end - start + 1];
       int k = 0;
       while( i <= mid && j <= end){
           if(arr[i] < arr[j]){
                result[k] = arr[i];
                k ++;
                i++;
           }else{
               result[k] = arr[j];
               k++;
               j++;
           }
       }
       while(i<= mid){
           result[k] = arr[i];
           k++;
           i++;
       }
       while(j <= end){
           result[k] = arr[j];
           k++;
           j++;
       }

       int x =0;
       for(int a =start; a <=end; a++){
           arr[a] = result[x];
           x++;
       }
   }

    static void mergeSort(int [] nums, int start, int end){
       if(start >= end){
           return;
       }
        int mid = start + (end-start)/2;

       mergeSort(nums, start, mid);
       mergeSort(nums, mid+1, end);
       merge(nums, start, end);
   }

    public static void main(String[] args) {
        int [] arr = {1, 3, 4, 2 ,7, 6, 3, 0, -1, 56 };
        mergeSort(arr, 0, arr.length-1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");}
    }
}
