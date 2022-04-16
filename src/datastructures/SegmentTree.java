package datastructures;

public class SegmentTree {

    public static void main (String []args){

        int arr[] = {1, 3, 5, 7, 9, 11};

        int n = arr.length;

        //if you n values in the original array
        //the max number of nodes in the segment tree array
        //cannot exceed 4*n

        int [] segmentArr = new int[4*n];
        buildSegmentTree(arr, segmentArr, 0 , n-1 , 0);
        for(int i = 0; i<= segmentArr.length - 1; i++){
            System.out.println(segmentArr[i]);
        }
        System.out.print(segmentArr + " ");
    }


    static void buildSegmentTree(int[] arr,int[] segmentArr, int start, int end, int pointer){
        // leaf node or base condition
        if(start == end){
            segmentArr[pointer] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        buildSegmentTree(arr, segmentArr, start, mid , 2 * pointer + 1);
        buildSegmentTree(arr, segmentArr, mid+1 , end, 2*pointer + 2);
        segmentArr[pointer] = segmentArr[2*pointer + 1] + segmentArr[2 * pointer + 2];
    }
}
