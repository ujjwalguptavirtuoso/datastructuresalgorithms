package codeforces;

import java.util.Scanner;

public class FedorNewGame {

    static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            count = count + (n&1);
            n = n>>1;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();;
        int k = sc.nextInt();
        int [] arr = new int[m + 1];

        for(int i = 0 ; i < arr.length; i ++){
            arr[i] = sc.nextInt();
        }

        int fedor = arr[arr.length - 1];
        int ans = 0;
        for(int i = 0; i < arr.length- 1; i++){
            int temp_xor = fedor ^ arr[i];
            int setBits = countSetBits(temp_xor);
            if(setBits <= k){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
