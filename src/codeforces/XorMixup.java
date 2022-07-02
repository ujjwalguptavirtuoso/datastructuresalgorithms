

import java.util.Scanner;

public class XorMixup {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n =sc.nextInt();
            int arr[] = new int[n];
            int xorval = 0;
            for(int i = 0 ; i < n ; i ++){
                arr[i] = sc.nextInt();
                xorval = xorval^arr[i];
            }
            int ans = 0;
            for(int i= 0;i < n;i ++){
                if((xorval ^ arr[i]) == arr[i]){
                    ans = arr[i];
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
