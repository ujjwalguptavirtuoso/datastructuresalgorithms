package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class AllDistinct {

    static int count [] = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            Arrays.fill(count, 0);
            int n = sc.nextInt();
            int arr[] = new int[n];
            int duplicates = 0;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                if(count[arr[i]] > 0){
                    duplicates++;
                }
                count[arr[i]]++;
            }
            if(duplicates!=0 && duplicates%2 ==0){
                System.out.println(n - duplicates);
            }else if(duplicates!=0 && duplicates%2 !=0){
                System.out.println(n - duplicates - 1);
            }
            else if(duplicates == 0){
                System.out.println(n);
            }
        }
    }
}
