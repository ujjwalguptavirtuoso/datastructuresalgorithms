package backtracking;
import  java.util.*;
/**
 * ujjwal.gupta
 *
 * @version $Id: CombinationsSum2.java, v 0.1 2022-05-08
 */
public class CombinationsSum2 {

    static List<List<Integer>> ans = new ArrayList<>();

    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum = 0;
        List<Integer> currList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        combinationsForSum(candidates, sum, target, currList, 0);
        return ans;

    }

    static void combinationsForSum(int [] candidates, int sum
            , int target, List<Integer> currList, int start){
        if(sum > target){
            return;
        }
        if(sum == target){
                ans.add(new ArrayList<>(currList));
                return;
        }

        for(int i=start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i-1])
                continue;

            currList.add(candidates[i]);
            combinationsForSum( candidates, sum + candidates[i], target, currList, i+1);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] candidates = {2,5,2,1,2};
        int target = 5;
        Arrays.sort(candidates);

        combinationSum2(candidates, target);
        for(int i = 0; i<ans.size(); i++){
            System.out.println(ans.get(i).toString());
        }
    }
}
