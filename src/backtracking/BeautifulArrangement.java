package backtracking;

/**
 * ujjwal.gupta
 *
 * @version $Id: BeautifulArrangement.java, v 0.1 2022-05-09
 *
 * Q. Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 * // this can be also done by a boolean visited array , then we just have to mark visited true/false and do not have to swap.
 */
public class BeautifulArrangement {

   static int ans = 0;

    static  public int countArrangement(int n) {
        int[] nums = new int [n];
        for(int i=0; i< n ; i++){
            nums[i] = i+1;
        }
        countDfs(nums, n, 0);
        return ans;
    }


    static void countDfs(int [] nums, int n, int j){
        if(j == n){
            ans++;
            return ;
        }
        for(int i=j; i< n; i++){
            swap(nums, i, j);
            if(checkIsValid(nums[i] , i+1)){
                countDfs(nums, n, j+1);
            }
            swap(nums, i, j);
        }
    }


    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static boolean checkIsValid(int i, int j){
        return (i%j == 0 || j%i == 0) ;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countArrangement(n));
    }
}
