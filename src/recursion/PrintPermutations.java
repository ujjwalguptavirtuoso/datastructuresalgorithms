package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * ujjwal.gupta
 * @version $Id: PrintPermutations.java, v 0.1 2022-05-02
 *
 * Given a string , Q1 - lets say "ABC" we have to print all the permutations , i.e ACB, ABC, BAC, BCA, CAB, CBA . (non - duplicate permutations).
 * Also write code for Q2 - printing duplicate permutations.
 */
public class PrintPermutations {

    //Approach 1 : Print all permutations duplicates also allowed , answer for Q2

    static void printPermutations(String s, String osf) {
        if (s.length() == osf.length()) {
            System.out.println(osf);
            return;
        }
        // char[] stringToChar = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            printPermutations(s, osf + s.charAt(i));
        }

    }

    static void printPermutations2(String s, String osf) {
        if (s.length() == 0) {
            System.out.println(osf);
            return;
        }

        Set<Character> set = new HashSet<>();  // set used to store duplicate characters in a string and we dont go the same path for duplicate characters , for eg AAC
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!set.contains(ch)) {
                String ros = s.substring(0, i) + s.substring(i + 1);
                set.add(ch);
                printPermutations2(ros, osf + ch);
            }
        }
    }

    public static void main(String[] args) {

        //  printPermutations("ABCD", "");

        printPermutations2("ABC", "");
        System.out.println();
        printPermutations2("AAC", "");

    }

}