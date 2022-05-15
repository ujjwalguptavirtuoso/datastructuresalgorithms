package codechef;
import java.util.*;
/**
 * ujjwal.gupta
 *
 * @version $Id: TurboSort.java, v 0.1 2022-05-14
 */
public class TurboSort {




    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] buckets = new int[1000001];
        for(int i = 0; i < t; i++){
           int n = sc.nextInt();
           buckets[n]++;
       }
        int result[] = new int[t];
        int length = 0;
        for(int i = 0 ; i < buckets.length; i ++){
            while(buckets[i] > 0 && length < t) {
                result[length] = i;
                length++;
                buckets[i]--;
            }
        }
        for(int i = 0; i < result.length; i++){
        System.out.println(result[i]);
        }
    }
}
