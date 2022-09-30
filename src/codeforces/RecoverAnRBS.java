

import java.util.Scanner;
import java.util.Stack;

public class RecoverAnRBS {

   static int ways = 0;

    static void findWaysToRecover(String s, int index, Stack<Character> st){
        if(ways > 1){
            return ;
        }
        if(index == s.length() && st.isEmpty()){
            ways++;
            return;
        }

        if(index == s.length() && !st.isEmpty()){
            return;
        }
        if(s.charAt(index) == '('){
            st.push('(');
            findWaysToRecover(s, index + 1, st);
        }else if(s.charAt(index) == ')'){
            if(st.isEmpty()){
                return;
            }else if(st.peek() == '('){
                st.pop();
                findWaysToRecover(s, index + 1, st);
            }
        }else if(s.charAt(index) == '?'){
            //consider like '('
            st.push('(');
            findWaysToRecover(s, index + 1, st);
            if(!st.isEmpty()){
                st.pop();
            }
            //consider like ')'
            if(st.isEmpty()){
                return;
            }else if(st.peek() == '('){
                st.pop();
                findWaysToRecover(s, index + 1, st);
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              String input = sc.next();
              ways = 0;
              findWaysToRecover(input, 0, new Stack<>());
              if(ways == 1){
                  System.out.println("YES");
              }else{
                  System.out.println("NO");
              }
        }
    }
}
