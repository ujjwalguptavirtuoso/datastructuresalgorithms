package codechef;

import java.util.Scanner;

/**
 * ujjwal.gupta
 *
 * @version $Id: ChefAndEid.java, v 0.1 2022-05-14
 */
public class ChefAndEid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int [] buckets = new int[1000001];
            int n = sc.nextInt();
            for(int k = 0; k< n; k++){
                int x  = sc.nextInt();
                buckets[x]++;
            }

            int result[] = new int[n];
            int length = 0;
            for(int j = 0 ; j < buckets.length; j ++){
                while(buckets[j] > 0 && length < n) {
                    result[length] = j;
                    length++;
                    buckets[j]--;
                }
                if(length == n){
                    break;
                }
            }
            int minDiff = Integer.MAX_VALUE;
            for(int a = 1; a < n; a ++){
                if(result[a] - result[a-1] < minDiff){
                    minDiff = result[a] - result[a-1];
                }
            }
           System.out.println(minDiff);
        }

    }
}
