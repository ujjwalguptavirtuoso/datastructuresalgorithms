package codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  ujjwal.gupta
 * @version $Id: DoubledDistances.java, v 0.1 2022-05-01 21:39
 */
public class DoubledDistances {

    static String checkDoubledDistancesCases(int [] arr){
        String ans = "No";
        for(int i = 1; i < arr.length-1; i++){
            if(arr[i] - arr[i-1] != 2 * (arr[i+1] - arr[i]) && arr[i+1] - arr[i] != 2 * (arr[i] - arr[i-1])){
                ans = "No";
                break;
            }
            ans = "Yes";
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int i=0; i< testCases; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j = 0; j<n ; j ++){
                int a = sc.nextInt();
                arr[j] = a;
            }

            Arrays.sort(arr);
            String ans =  checkDoubledDistancesCases(arr);
            System.out.println(ans);
        }
    }

}
