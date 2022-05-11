package numbertheory;

import java.util.*;

/**
 * ujjwal.gupta
 *
 * @version $Id: DIVFACT_SPOJ.java, v 0.1 2022-05-10
 * Given a number, find the total number of divisors of the factorial of the number.
 *
 * Since the answer can be very large, print answer modulo 109+7.
 *
 * Input
 * The first line contains T, number of testcases.
 *
 * T lines follows each containing the number N.
 *
 * Output
 * Print T lines of output each containing the answer.
 */
public class DIVFACT_SPOJ {

    static long mod = 1000000007;
    static List<Integer> generatePrimes(boolean[] primeNums){

        primeNums[0] = primeNums[1] = false;
        // starting from 2
        for(int i=2; i*i <  primeNums.length; i++){
            if(primeNums[i]){
                // if ith index is prime
                //  for every elemnt starting from its square, as all previous elements will be marked false by someone else
                for(int j = i*i; j< primeNums.length; j = j+ i){
                    primeNums[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=0 ; i< primeNums.length; i++){
            if(primeNums[i])
                primes.add(i);
        }
        return primes;
    }

    static long findDIVFACT(long n, List<Integer> primes){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; primes.get(i) <= n ; i++){
            int counter = 1;
            int powerOfPrime = 0;
            while(n /(int)Math.pow(primes.get(i), counter) >= 1){
                powerOfPrime += (n /(long)Math.pow(primes.get(i), counter))% mod;
                counter++;
            }
            map.put(primes.get(i), powerOfPrime);
        }
        long divisors = 1;
        for(Integer k : map.keySet()){
            divisors = (divisors % mod )*((map.get(k) + 1 )%mod) % mod;
        }
        return divisors;
    }

    public static void main(String[] args) {
        boolean [] primeNums = new boolean[
                50005];
        // assuming all are prime : true means prime and false means composite
        Arrays.fill(primeNums, true);

        Scanner sc = new Scanner (System.in);
        int test = sc.nextInt();

        for(int i = 0 ; i< test; i++){
            int n = sc . nextInt();
            List<Integer> primes = generatePrimes( primeNums);
            System.out.println(findDIVFACT(n, primes));
        }
    }
}
