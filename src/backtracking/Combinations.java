package backtracking;
import java.util.*;
/**
 * ujjwal.gupta
 *
 * @version $Id: Combinations.java, v 0.1 2022-05-09
 */
public class Combinations {

    static public List<List<Integer>> combine(int n, int k) {
        boolean [] combineArray = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfsCombinations(ans, combineArray, currList, k, 0);
        return ans;
    }

    static void dfsCombinations(List<List<Integer>> ans, boolean [] combineArray, List<Integer> currList, int k, int j){
        if(currList.size() == k){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int i = j; i < combineArray.length ; i++){
            if(i < combineArray.length &&  combineArray[i] == false){
                combineArray[i] = true;
                currList.add(i+1);
                dfsCombinations(ans, combineArray, currList, k, i+1);
                currList.remove(currList.size() - 1);
                combineArray[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<List<Integer>> ans =  combine(n, k);
        for(int i = 0; i<ans.size(); i++){
            System.out.println(ans.get(i).toString());
        }
    }
}
