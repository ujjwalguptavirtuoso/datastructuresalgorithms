package codeforces;

import java.util.Scanner;

public class AndSorting {


    static boolean possibleToSort(int[] nums, int x) {
          for(int i = 0; i < nums.length; i ++){
              for(int j = i + 1; j < nums.length; j++){
                  if((nums[i] & nums[j]) == x){
                      swap(nums, i, j);
                  }
              }
          }
          for(int k = 1 ; k < nums.length; k++){
              if(nums[k-1] > nums[k]){
                  return false;
              }
          }
          return true;
    }

    static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int max = Integer.MIN_VALUE;
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            for (int k = 0; k < n; k++) {
                if (possibleToSort(nums, k)) {
                    max = Math.max(max, k);
                }
            }
            System.out.println(max);
        }
    }
}