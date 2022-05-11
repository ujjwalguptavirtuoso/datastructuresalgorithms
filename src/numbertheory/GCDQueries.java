package numbertheory;

import java.util.Scanner;

/**
 * ujjwal.gupta
 *
 * @version $Id: GCDQueries.java, v 0.1 2022-05-07
 */
public class GCDQueries {

    static long gcd(long a, long b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    static long[] generateLeftPrefixArray(long[] numsArray){
     int length = numsArray.length;
     long gcd = numsArray[0];
     long[] leftSuffixArray = new long[length];
     leftSuffixArray[0] = numsArray[0];
     for(int i = 1 ; i<length; i++){
          gcd = gcd(gcd, numsArray[i]);
          leftSuffixArray[i] = gcd;
      }

     return leftSuffixArray;
    }


    static long[] generateRightSuffixArray(long[] numsArray){
        int length = numsArray.length;
        long gcd = numsArray[length-1];
        long[] rightSuffixArray = new long[length];
        rightSuffixArray[length-1] = numsArray[length-1];
        for(int i = length - 2 ; i>=0; i--){
            gcd = gcd(gcd, numsArray[i]);
            rightSuffixArray[i] = gcd;
        }

        return rightSuffixArray;
    }

    static long findGCDofSubArray(long[] numsArr, int l, int r){
        int length = numsArr.length;
        long[] leftSuffix = generateLeftPrefixArray(numsArr);
        long[] rightSuffix = generateRightSuffixArray(numsArr);

        l = l -1 ; // zero based indexing
        r = r - 1 ; // zero based indexing
        long leftGCD = 0;
        long rightGCD = 0;
        if (l - 1 >= 0) {
            leftGCD = leftSuffix[l - 1];
        }
        if (r + 1 < length) {
            rightGCD = rightSuffix[r+1];
        }

        if(leftGCD == 0){
            return rightGCD;
        }
        if(rightGCD == 0){
            return leftGCD;
        }

        return gcd(leftGCD, rightGCD);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i=0; i<test; i++){
            int n = sc.nextInt();
            int q = sc.nextInt();
            long [] arr = new long[n];
            for(int j= 0; j<n; j++){
                long a = sc.nextLong();
                arr[j] = a;
            }
            for(int k =0 ;k < q; k++){
                int l = sc.nextInt();
                int r = sc.nextInt();

                System.out.println(findGCDofSubArray(arr, l, r));

            }
        }
    }
}
