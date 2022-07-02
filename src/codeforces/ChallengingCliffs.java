package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengingCliffs {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n= sc.nextInt();
            int arr[] = new int[n];
            for(int i= 0 ; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int minGap = Integer.MAX_VALUE;
            int first = -1;
            int second = -1;
            for(int i= 0 ; i <arr.length - 1; i++){
                if(arr[i+1]- arr[i] < minGap){
                    minGap = arr[i+1] - arr[i];
                    first = i;
                    second = i + 1;
                }
            }

            int result[] = new int[n];
            result[0] = arr[first];
            result[n-1] = arr[second];

            int i = 1;
            int index_s = second + 1;
            while(index_s < arr.length){
                result[i] = arr[index_s];
                index_s++;
                i++;
            }
            int index_f = 0;
            while(i < result.length - 1){
                result[i] = arr[index_f];
                index_f++;
                i++;
            }

            for(int k= 0; k < result.length; k++){
                System.out.println(result[k] + " ");
            }
        }
    }
}
