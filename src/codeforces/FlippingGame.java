package codeforces;

import java.util.Scanner;

public class FlippingGame {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int nums[] = new int[test];
        int countOfOne = 0;
        for(int t = 0; t < test; t++) {
            nums[t] = sc.nextInt();
            if(nums[t] == 1){
                countOfOne++;
            }
        }
        if(countOfOne == test){
            System.out.println(0);
        }else {
            int index_i = 0;
            int index_j = 0;
            int i = 0;
            int j = 0;
            int maxLength = 0;
            while (j < nums.length) {
                if (nums[j] == 0) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        index_i = i;
                        index_j = j;
                    }
                    j++;
                } else {
                    while (i <= j) {
                        i++;
                    }
                    j++;
                }
            }
            int numOfOnes = 0;
            while (index_i >= 0 && index_j < nums.length) {
                if (index_i - 1 >= 0 && nums[index_i - 1] == 1 && index_j + 1 < nums.length && nums[index_j + 1] == 1) {
                    index_i--;
                    index_j++;
                } else if (index_i - 1 >= 0 && nums[index_i - 1] == 1) {
                    index_i--;
                } else if (index_j + 1 < nums.length && nums[index_j + 1] == 1) {
                    index_j++;
                } else {
                    break;
                }
            }
            numOfOnes = index_j - index_i + 1;
            System.out.println(numOfOnes);
        }
    }
}
