package backtracking;
import java.util.*;

/**
 * ujjwal.gupta
 *
 * @version $Id: LetterCombinationsOfPhoneNumber.java, v 0.1 2022-05-11
 */
public class LetterCombinationsOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        dfs(ans, map, digits, 0, "");
        return ans;

    }

    static void dfs(List<String> ans, Map<Character, String> map , String digits, int j, String osf){
        if( osf.length() == digits.length()){
            ans.add(osf);
        }
        for(int i = j ; i< digits.length(); i++){
            String s = map.get(digits.charAt(i));
            for(int k = 0; k < s.length(); k++){
                dfs(ans, map, digits, i+1, osf + s.charAt(k));
            }
        }
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> ans = letterCombinations(str);
        for(int i = 0 ; i< ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
