package backtracking;

import java.util.*;

/**
 * ujjwal.gupta
 * @version $Id: GenerateParantheses.java, v 0.1 2022-05-07
 */
public class GenerateParantheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, new StringBuilder(), 0, 0, n);
        return ans;

    }

    // awesome approach for bracket problems
    void backtracking(List<String> ans, StringBuilder curr, int opening, int closing, int n){
        if( curr.length() == 2 * n){
            ans.add(curr.toString());
            return;
        }

        if(opening < n){
            curr.append("(");
            backtracking(ans, curr, opening + 1, closing, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(closing < opening){
            curr.append(")");
            backtracking(ans, curr, opening, closing + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

     // this also works
    boolean checkValidCombination(String str){
        Stack<Character> st = new Stack<>();
        char[] charArray = str.toCharArray();

        for(int i=0; i<charArray.length; i++){
            if(charArray[i] == '('){
                st.push(charArray[i]);
            }
            else if(charArray[i] == ')'){
                if(st.isEmpty()){
                    return false;
                }
                char temp = st.pop();
                if(temp != '(')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        GenerateParantheses obj = new GenerateParantheses();
        List<String> ans = obj.generateParenthesis(n);
        System.out.println(ans.toString());
    }
}
