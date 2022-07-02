package codeforces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SimilarPairs {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int numberOfEven = 0;
            int numberOfOdd = 0;
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i< n; i++) {
                int num = sc.nextInt();
                set.add(num);
                if (num % 2 == 0) {
                    numberOfEven++;
                } else {
                    numberOfOdd++;
                }
            }
            if(numberOfEven %2 ==0 && numberOfOdd%2 == 0){
                System.out.println("YES");
                continue;
            }
            boolean flag = false;
            for(Integer i : set){
                if(set.contains(i - 1) || set.contains(i+1)){
                   flag = true;
                   break;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
