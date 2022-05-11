package numbertheory;

import java.util.*;


/**
 * ujjwal.gupta
 *
 * @version $Id: HardestGCDProblem.java, v 0.1 2022-05-07
 */
public class HardestGCDProblem {

   static long gcd(long a, long b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    List<Long> findFactorsOfGCD(long gcd){
        List<Long> list= new ArrayList<>();
       for(long i=1; i*i <=gcd ; i++){
           if(gcd % i == 0){
               list.add(i);
               list.add(gcd/i);
           }
       }
       return list;
    }

    static  String checkModifyPossibility(long[] arr, long k, int n){
        long prevGCD = gcd(arr[0], arr[1]);
        long gcdTillNow= 0;
        for(int i=2; i<n; i++){
            gcdTillNow = gcd(prevGCD, arr[i]);
            prevGCD = gcdTillNow;
        }

        if(gcdTillNow <= k){
            return "YES" ;
        }

        return "NO";
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();


        for(int i=0; i<test; i++){
            int  n = sc.nextInt();
            long k = sc.nextInt();
            long arr[] = new long[n];
            for(int j = 0; j<n; j++){
                long a = sc.nextInt();
                arr[j] = a;
            }

            System.out.println(checkModifyPossibility(arr, k, n));
        }
    }



}
