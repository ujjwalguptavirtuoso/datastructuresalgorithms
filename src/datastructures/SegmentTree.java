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
            System.out.print(segmentArr[i] + " ");
        }
        System.out.println();
        int rangeSum1 = rangeSumQuery(0, 5, 0, 3, segmentArr, 0);
        System.out.println(rangeSum1 + " ");
        update(0 ,5, 1, 5, segmentArr, 0);
         int rangeSum2 = rangeSumQuery(0, 5, 0, 3, segmentArr, 0);
        System.out.println(rangeSum2 + " ");
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

    /**
     *
     * @param ss start of input array
     * @param se end of input array
     * @param qs start of query index
     * @param qe end of query index
     * @param segmentArr segmentTree array
     * @param pointer pointer in segmentTree
     * @return
     */
    static int rangeSumQuery(int ss, int se, int qs, int qe, int[] segmentArr, int pointer){
        //complete overlap
        if(qs <= ss && qe >= se){
            return segmentArr[pointer];
        }
        // no overlap
        if(qs > se || qe < ss){
            return 0;
        }
        int mid = (ss + se) / 2 ;
        return rangeSumQuery(ss, mid, qs, qe, segmentArr,2 * pointer + 1)
                + rangeSumQuery(mid+1, se, qs, qe, segmentArr,2 * pointer + 2);

    }

    /**
     *
     * @param ss start of input array
     * @param se end of input array
     * @param index index to be updated in input array
     * @param value value to be updated
     * @param segmentArr segmentTree array
     * @param pointer pointer in segmentTree
     * @return
     */
    static void update(int ss, int se, int index, int value, int [] segmentArr, int pointer){
        if(index < ss || index > se ){
            return;
        }
        if(ss == se){
            segmentArr[pointer] = value;
            return;
        }
        int mid = (ss + se)/2;
        if(index > mid){
            update(mid+1, se, index,value,segmentArr, 2 * pointer + 2);
        }else{
        update(ss, mid, index, value, segmentArr, 2*pointer + 1);
        }
        segmentArr[pointer] = segmentArr[2 * pointer + 1] + segmentArr[2 *pointer + 2];
    }
}
