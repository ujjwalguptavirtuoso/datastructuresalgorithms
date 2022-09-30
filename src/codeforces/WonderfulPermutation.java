

import java.util.Scanner;

public class WonderfulPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();
             int k = sc.nextInt();
             int arr[] = new int[n];
             for(int i= 0; i < arr.length; i ++){
                 arr[i] = sc.nextInt();
             }
             int swaps = 0;
             for(int i = k ; i < arr.length; i++){
                 if(arr[i] <= k){
                     swaps++;
                 }
             }
            System.out.println(swaps);
        }
    }
}
