package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BuildPermutation {

   static  int findMaxPossibleSquare(int maxPossible){
        int i = 0;
        while(i * i <= maxPossible){
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();
             int result[] = new int[n];
             int maxPossible = 2 * (n - 1);

             int maxSquareInt = findMaxPossibleSquare(maxPossible);

           //  Set<Integer> used = new HashSet<>();
             for(int i = result.length - 1; i>=0; i--){
                     if(maxSquareInt * maxSquareInt - i > n - 1){
                         maxSquareInt-=2;
                     }
                     result[i] = maxSquareInt * maxSquareInt - i;
             }
            for (int i = 0; i< result.length; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
