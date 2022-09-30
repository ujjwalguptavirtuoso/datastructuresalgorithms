package dynamicprogramming;

public class StringPalindrom {

    static boolean palindrome(String s, int i ,int j, int ops){
        if(i >= j){
            return true;
        }

        boolean val1 = false;
        boolean val2 = false;

        if(s.charAt(i) == s.charAt(j)){
            val1 = palindrome(s, i+1, j-1, ops);
        }else if(ops == 0){
            val2 = palindrome(s, i+1, j, ops + 1) || palindrome(s, i, j-1, ops + 1) || palindrome(s, i + 1, j - 1, ops + 1);
        }
        return val1 || val2;
    }

    public static void main(String[] args) {
        String s = "YAARP";
        System.out.println(palindrome(s, 0, s.length() - 1, 0));
    }
}
