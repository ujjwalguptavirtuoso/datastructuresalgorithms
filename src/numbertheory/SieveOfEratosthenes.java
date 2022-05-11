package numbertheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * ujjwal.gupta
 *
 * @version $Id: SieveOfEratosthenes.java, v 0.1 2022-05-10
 */
public class SieveOfEratosthenes {

    BitSet bitSet = new BitSet(7);

    static List<Integer> generatePrimes( boolean[] primeNums){

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

    public static void main(String[] args) {
        boolean [] primeNums = new boolean[
                50005];
        // assuming all are prime : true means prime and false means composite
        Arrays.fill(primeNums, true);

        System.out.println(generatePrimes( primeNums).toString());
    }


}
