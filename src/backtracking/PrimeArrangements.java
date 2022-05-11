package backtracking;
import java.util.*;

/**
 * ujjwal.gupta
 *
 * @version $Id: PrimeArrangements.java, v 0.1 2022-05-10
 */
public class PrimeArrangements {

    static int ans = 0;
    public static int numPrimeArrangements(int n) {

        List<Integer> primes = generatePrimes(n);
        int [] numsPerm = new int [n];
        for(int i = 0; i< n; i++){
            numsPerm[i] = i+1;
        }
        validPermutations(primes, 0, n, numsPerm);
        return ans;
    }

    static void  validPermutations(List<Integer> primes, int j, int n, int [] numsPerm){

        if(j == n){
            ans++;
            return;
        }

        for(int i = j; i < n ; i++){
            swap(numsPerm, i , j);
            if((primes.contains(numsPerm[j]) && primes.contains(j+1)) || (!primes.contains(numsPerm[j]) && !primes.contains(j+1))){
                validPermutations(primes, j+1, n, numsPerm);
            }
            swap(numsPerm, i, j);
        }
    }

    static void swap(int[] numsPerm, int i, int j){
        int temp = numsPerm[i];
        numsPerm[i] = numsPerm[j];
        numsPerm[j] = temp;
    }



    static List<Integer> generatePrimes(int n){
        boolean[] arr = new boolean[n+1];
        arr[0] = arr[1] = true;
        //taking false as prime
        for(int i=2; i*i < arr.length ; i++){
            if(arr[i] == false){
                for(int j = i*i ; j < arr.length; j = j + i){
                    arr[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] == false){
                primes.add(i);}
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 100;
       System.out.println(numPrimeArrangements(n));
    }
}
