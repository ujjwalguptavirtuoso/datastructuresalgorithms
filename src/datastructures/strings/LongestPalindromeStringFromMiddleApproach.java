package datastructures.strings;

/**
 * @author ujjwal.gupta
 * @version $Id: LongestPalindromeStringFromMiddleApproach.java, v 0.1 2022-04-24
 */

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromeStringFromMiddleApproach {

    public static String longestPalindrome(String s) {
        if(s == null || s.length()<0)
            return "";

        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++){
            int len1 = expandFromMiddle(s, i ,i); // "racecar" case ; when there is no matching for "e" on either side
            int len2 = expandFromMiddle(s, i, i+1); // "aabbaa" case ; when there is matching characters on both sides if we start from middle "b" and "b"
            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }


    public static int expandFromMiddle(String s, int left, int right){
        if(s == null || left>right)
            return 0;

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1; // -1 because we are decrementing left and incrementing right in last iteration of while loop also
                                 // for "racecar" in final step of while loop left = -1, right = 7, so right - left - 1 = 7
    }

    public static void main(String[] args) {

        String s1 = "racecar";
        String s2 = "aabbaa";
        String s3 = "daddy";

        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));
    }
}
