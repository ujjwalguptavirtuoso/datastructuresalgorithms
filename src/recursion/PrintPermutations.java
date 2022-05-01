package recursion;

/**
 * ujjwal.gupta
 * @version $Id: PrintPermutations.java, v 0.1 2022-05-02
 *
 * Given a string , Q1 - lets say "ABC" we have to print all the permutations , i.e ACB, ABC, BAC, BCA, CAB, CBA . (non - duplicate permutations).
 * Also write code for Q2 - printing duplicate permutations.
 */
public class PrintPermutations {

    //Approach 1 : Print all permutations duplicates also allowed , answer for Q2

    static void printPermutations(String s, String osf){
        if(s.length() == osf.length()){
            System.out.println(osf);
            return;
        }
       // char[] stringToChar = s.toCharArray();
        for(int i=0; i < s.length(); i++){
            printPermutations(s, osf + s.charAt(i));
        }

    }

    //Approach 2: Print permutations but not duplicates, answer for Q1

    static void printPermutations2(String s, String osf){
        if(s.length() == 0){
            System.out.println(osf);
            return;
        }
        for(int i=0; i<s.length(); i++) {
            printPermutations2(s.substring(0, i) + s.substring(i+1), osf + s.charAt(i));
        }
    }

    public static void main(String[] args) {

         printPermutations("ABCD", "");

         printPermutations2("ABCD", "");

    }
}
