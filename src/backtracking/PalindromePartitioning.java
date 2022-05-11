package backtracking;
import java.util.*;

/**
 * ujjwal.gupta
 *
 * @version $Id: PalindromePartitioning.java, v 0.1 2022-05-08
 *
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 */
public class PalindromePartitioning {

    static List<List<String>> ans = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        partitionAndCheck(list, s, 0);
        return ans;
    }

    static void partitionAndCheck(List<String> list,String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<String>(list));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(checkPalindrome(s.substring(start, end+1))){
                list.add(s.substring(start, end+1));
                partitionAndCheck(list, s, end + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean checkPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        for(int i=0; i<= (s.length()-1)/2 ; i++){
            if(s.charAt(i) != s.charAt(s.length() - i -1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       String s = "aaabb";
       List<List<String>> ans = partition(s);
       for(int i = 0; i<ans.size(); i++){
           System.out.println(ans.get(i).toString());
       }

    }
}
