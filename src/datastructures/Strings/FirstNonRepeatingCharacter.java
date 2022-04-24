package datastructures.Strings;

/**
 * @author ujjwal.gupta
 * @version $Id: FirstNonRepeatingCharacter.java, v 0.1 2022-04-24 10:31
 */

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 */
public class FirstNonRepeatingCharacter {


    public static int firstUniqChar(String s) {

        int[] alphabets = new int[26];

        for(int i = 0; i< s.length(); i++){
            alphabets[s.charAt(i) - 'a']++;
        }

        for(int j = 0; j<s.length(); j++){
            if(alphabets[s.charAt(j) - 'a'] == 1)
                return j;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "ujjwal";
        String s4 = "aabb";

        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));
        System.out.println(firstUniqChar(s3));
        System.out.println(firstUniqChar(s4));
    }
}
