package codeforces;

import java.util.Scanner;

public class KthNotDivisible {

   static long binarySearchDivisor(long n, long k){
        long low = 1;
        long high = n*k;

        while(low <= high){
            long mid = low + (high - low)/2;
            long div = mid/n;
            long rem = mid%n;
            long numOfDivisiors = mid - div;
            if(numOfDivisiors > k){
                high = mid - 1;
            }else if(numOfDivisiors < k){
                low = mid + 1;
            }else{
                if(rem == 0){
                return mid - 1;}
                else{
                    return mid;}
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           long n = sc.nextLong();
           long k = sc.nextLong();
            System.out.println(binarySearchDivisor(n, k));
        }
   }
}
