package recursion;

/**
 * ujjwal.gupta
 * @version $Id: ReverseAString.java, v 0.1 2022-04-29
 */
public class ReverseAString {

    public static void reverseString(char[] s) {
        reverse(s, 0);
    }

    static void reverse(char[] s, int i){
        // base case
        if(i == (s.length/2)){
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
            return;
        }
        // recursive assumption
        reverse(s, i + 1);
        // self work
        char temp1 = s[i];
        s[i] = s[s.length - i - 1];
        s[s.length - i - 1] = temp1;
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
}
