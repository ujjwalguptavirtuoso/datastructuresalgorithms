package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class LISorReverseLIS {


   static int minOfLISOrReverseLIS(List<Integer> nums){
       int maxFor = 0;
       int maxRev = 0;
       for(int i = 0 ; i < nums.size()-1; i++){
           if(nums.get(i) < nums.get(i+1)){
               maxFor++;
           }
       }
       Collections.reverse(nums);
       for(int i = 0 ; i < nums.size()-1; i++){
           if(nums.get(i) < nums.get(i+1)){
               maxRev++;
           }
       }
       return Math.min(maxFor, maxRev);
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int [] nums = new int[n];
            for(int i=0; i < n; i ++){
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int midOfSecondHalf = nums.length/2 + (nums.length - nums.length/2) / 2;
            int k = 0;
            for(int j = nums.length/2 ; j < midOfSecondHalf; j++){
                int temp = nums[j];
                nums[j] = nums[nums.length - k - 1];
                nums[nums.length - k - 1] = temp;
                k++;
            }
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            System.out.println( minOfLISOrReverseLIS(list));
        }

    }
}
