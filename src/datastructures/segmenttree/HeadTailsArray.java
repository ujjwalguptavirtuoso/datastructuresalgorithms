package datastructures.segmenttree;

public class HeadTailsArray {

    public static void main(String[] args) {

        char arr[] = {'H', 'T', 'H', 'T' , 'T', 'H'};

        int n = arr.length;

        System.out.println();

        int segmentArr[] = new int[4 * n];

        buildSegmentTree(segmentArr, arr, 0, n-1, 0);
        for(int i =0; i<= segmentArr.length - 1; i++){
        System.out.print( segmentArr[i] + " ");
        }
        int count =  countHeadsQuery(segmentArr, 0,3, 0 ,n-1, 0);
        int count1 =  countHeadsQuery(segmentArr, 0,5, 0 ,n-1, 0);
        System.out.println();
        System.out.println(count);
        System.out.println(count1);
        System.out.println();

        flip (segmentArr, 1, 0 , n-1, 0);

        for(int i =0; i<= segmentArr.length - 1; i++){
            System.out.print( segmentArr[i] + " ");
        }

    }

    /**
     *
     * @param segmentArr segmentTreeArray
     * @param arr inputArray
     * @param s start
     * @param e end
     * @param stIdx index of segment tree array
     */
    private static void buildSegmentTree(int [] segmentArr, char [] arr, int s, int e, int stIdx){
        if(s==e) {
            if (arr[s] == 'H') {
                segmentArr[stIdx] = 1;
                return;
            } else {
                segmentArr[stIdx] = 0;
                return;
            }
        }
            int mid = (s + e)/2;
            buildSegmentTree(segmentArr, arr, s, mid, 2 * stIdx + 1);
            buildSegmentTree(segmentArr, arr, mid + 1, e, 2 * stIdx + 2);
            segmentArr[stIdx] = segmentArr[2*stIdx + 1] + segmentArr[2*stIdx + 2];
        }


    /**
     *
     * @param segmentArr segment tree array
     * @param qs query start
     * @param qe query end
     * @param s starting index of input array
     * @param e end index of input array
     * @param stIdx index of segment tree
     * @return
     */
    private static int countHeadsQuery(int []segmentArr, int qs, int qe, int s, int e, int stIdx){
        // complete overlap
        if(qs <= s && qe >=e){
            return segmentArr[stIdx];
        }
        //no overlap
        if(qs > e || qe < s){
            return 0;
        }
        int mid = (s + e)/2;
        return countHeadsQuery(segmentArr, qs, qe, s, mid, 2* stIdx + 1)
                + countHeadsQuery(segmentArr, qs, qe, mid+1, e, 2*stIdx + 2);
    }


    /**
     *
     * @param segmentArr segment tree array
     * @param index index to be flipped
     * @param s start of input array
     * @param e end of input array
     * @param stIdx index of segment tree array
     */
    private static void flip(int[] segmentArr, int index, int s, int e, int stIdx){
        // index to be flipped is not present in input array
        if(index > e || index < s){
            return;
        }
        // reached leaf node or base condition
        if(s == e){
            if(segmentArr[stIdx] == 0){
                segmentArr[stIdx] = 1;
                return;
            }
            else{
                segmentArr[stIdx] = 0;
                return;
            }
        }

        int mid = (s + e)/2;
        if(index > mid){
            flip(segmentArr, index, mid+1, e, 2 *stIdx + 2);
        }else{
          flip(segmentArr, index, s, mid, 2*stIdx + 1);
        }
        segmentArr[stIdx] = segmentArr[2 * stIdx + 1] + segmentArr[ 2 * stIdx + 2];
    }



}
