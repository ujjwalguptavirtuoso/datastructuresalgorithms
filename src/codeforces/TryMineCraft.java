

import java.util.Scanner;

public class TryMineCraft {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }

        int [] forward = new int[n];
        int [] backward = new int[n];

        for(int i = 1; i < forward.length; i++){
            forward[i] = forward[i - 1] + (arr[i] < arr[i-1] ? arr[i-1] - arr[i] : 0);
        }

        for(int j = backward.length - 2; j>=0;j --){
            backward[j] = backward[j + 1] + (arr[j + 1] > arr[j] ? arr[j + 1] - arr[j] : 0);
        }

        for(int k = 0; k < q; k++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a < b){
                System.out.println(forward[b - 1] - forward[a - 1]);
            }else{
                System.out.println(backward[b - 1] - backward[a- 1]);
            }
        }
    }
}
