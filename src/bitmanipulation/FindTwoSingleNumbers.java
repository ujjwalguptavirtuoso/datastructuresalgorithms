package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * ujjwal.gupta
 *
 * @version $Id: FindTwoSingleNumbers.java, v 0.1 2022-05-15
 *
 * /**
 * Given an array where all numbers occur twice except two numbers, find those two numbers.
 */
public class FindTwoSingleNumbers {

    static List<Integer> findTwoSingle(int [] nums){
        int xor = nums[0];
        for(int i =1; i < nums.length; i ++){
            xor ^= nums[i];
        }
        int bitNum = getABitIndex(xor);
        List<Integer> firstNumSet = new ArrayList<>();
        List<Integer> secondNumSet = new ArrayList<>();
        int mask = 1 << bitNum;
        for(int j = 0; j < nums.length; j++){
            if((nums[j] & mask) != 0){
                firstNumSet.add(nums[j]);
            }else{
                secondNumSet.add(nums[j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int num1 = 0;
        int num2 = 0;
        for(int i = 0 ; i < firstNumSet.size(); i++){
            num1 = num1 ^ firstNumSet.get(i);
        }
        for(int i = 0 ; i < secondNumSet.size(); i++){
            num2 = num2 ^ secondNumSet.get(i);
        }
        ans.add(num1);
        ans.add(num2);

        return ans;
    }

    static int getABitIndex(int xor){
        int i = 0;
        while(true){
          int mask = 1 << i;
          if((xor & mask) !=0){
              break;
          }
          i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int arr [] = {1, 1, 2, 2, 3, 3, 4, 5, 4, 7, 8, 8, 7, 9};
        System.out.println(findTwoSingle(arr).toString());
    }
}
