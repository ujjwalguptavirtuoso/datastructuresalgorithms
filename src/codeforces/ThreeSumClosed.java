

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSumClosed {

    public static boolean threeSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 2; i++){
                boolean flag = true;
                int sum =  target - nums[i];
                int low = i + 1;               // two pointers
                int high = nums.length - 1 ;   // two pointers
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        return true;
                    }
                    if(nums[low] + nums[high] < sum){

                        low++;

                    }else{
                        high-- ;
                    }
                }
        }
       return false;
    }

    void threeSum(int low, int high){

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int n= sc.nextInt();
           int [] arr = new int[n];
           for(int i = 0 ; i < n; i ++){
               arr[i] = sc.nextInt();
           }
           boolean flag = false;
            Arrays.sort(arr);
           for(int l = 0 ; l <arr.length; l++){
               if(threeSum(arr, arr[l])){
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
