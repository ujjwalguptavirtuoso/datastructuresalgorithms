package leetcode;

/**
 * ujjwal.gupta
 *
 * @version $Id: BeautyKString.java, v 0.1 2022-05-14
 */
public class BeautyKString {
    public static int divisorSubstrings(int num, int k) {
        String numString = String.valueOf(num);
        int ans = 0;
        // List<String> subStrings = new ArrayList<>();
        for(int i = 0 ; i < numString.length() - k + 1; i ++){
            String s = numString.substring(i, i+k);
            Integer val = Integer.valueOf(s);
            if(val == 0){
                continue;
            }
            if(num % val == 0){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 240;
        int k = 2;
        System.out.println(divisorSubstrings(num, k));
    }
}
