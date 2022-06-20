package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {

   static  int numberOfElementsSmallerThanGiven(int q_i, int [] arr){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(q_i < arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(low < arr.length && arr[low] == q_i){
            return low + 1;
        }else{
            return low;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int [n];
        for(int i = 0; i < n; i++){
             arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int q = sc.nextInt();
        for(int i = 0; i < q; i ++){
            int q_i = sc.nextInt();
            System.out.println(numberOfElementsSmallerThanGiven(q_i, arr));
        }
    }
}
