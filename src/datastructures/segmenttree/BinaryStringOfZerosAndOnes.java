package datastructures.segmenttree;

public class BinaryStringOfZerosAndOnes {

    /*
    Given a binary string of 0s and 1s
    Support two queries
    Query 1 : given two indices , return modulus 3 of the string between the given indices
    Query 2 : given an index, flip the bit of the string if and only if it is zero.
     */

    public static void main(String[] args) {

    String binaryString = "10010";

    int length = binaryString.length();

    char[] charArray = binaryString.toCharArray();

    String[] segmentArr = new String[4 * length];
    buildSegmentTree(segmentArr, charArray, 0, charArray.length - 1, 0);

    for(int i=0; i<segmentArr.length; i++){
        System.out.print(segmentArr[i] + "  ");
    }

    int modThreeResult = modulusThree(rangeQuery(segmentArr, 1,3,0,charArray.length - 1, 0));
    System.out.println();
    System.out.println(modThreeResult);
    }

    static void buildSegmentTree(String[] segmentArr, char[] charArray, int s, int e, int stIdx){
        // leaf node or base condition
        if(s == e){
            segmentArr[stIdx] = String.valueOf(charArray[s]);
            return;
        }

        int mid = ( s + e )/2;
        buildSegmentTree(segmentArr, charArray, s, mid, 2*stIdx + 1);
        buildSegmentTree(segmentArr, charArray, mid+1, e, 2*stIdx + 2);
        segmentArr[stIdx] = segmentArr[2* stIdx + 1] + segmentArr[2 * stIdx + 2];
    }


    static String rangeQuery(String[] segmentArr, int qs, int qe, int s, int e, int stIdx){
        // complete overlap
        if(qs<= s && qe >=e){
            return segmentArr[stIdx];
        }
        //no overlap
        if(qs > e || qe < s){
            return null;
        }

        int mid = (s + e)/2;
        return rangeQuery(segmentArr, qs, qe, s, mid, 2 * stIdx + 1)!=null ? rangeQuery(segmentArr, qs, qe, s, mid, 2 * stIdx + 1) : ""
                + rangeQuery(segmentArr, qs, qe, mid+1, e, 2* stIdx + 2)!=null ?  rangeQuery(segmentArr, qs, qe, mid+1, e, 2* stIdx + 2) : "" ;
    }

    static int modulusThree(String binaryString){
        return (Integer.parseInt(binaryString, 2)) % 3;
    }


}
