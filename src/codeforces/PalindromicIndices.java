package codeforces;
import java.util.Scanner;

public class PalindromicIndices {

   /* static boolean checkPalindrome(String s){
        for(int i = 0 ; i < s.length()/2; i++){
            if(s.charAt(i)!= s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true ;
    }*/

    static int countIndices(String s) {
        int midIndex = s.length() / 2;
        int total = 1;
        int l = midIndex - 1;
        int r = midIndex + 1;
        while (l >= 0 || r < s.length()) {
            boolean leftFlag = false;
            boolean rightFlag = false;
            if (l>= 0 && s.charAt(l) == s.charAt(midIndex)) {
                l--;
                total++;
                leftFlag = true;
            }
            if (r< s.length() && s.charAt(r) == s.charAt(midIndex)) {
                r++;
                total++;
                rightFlag = true;
            }
            if(!(leftFlag || rightFlag)){
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            if (s.length() <= 2) {
                System.out.println(s.length());
            } else {
                System.out.println(countIndices(s));
            }
        }
    }
}
