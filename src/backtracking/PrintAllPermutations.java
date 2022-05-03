package backtracking;

/**
 * ujjwal.gupta
 * @version $Id: PrintAllPermutations.java, v 0.1 2022-05-03 13:01
 */
public class PrintAllPermutations {

    static void printPermutations(String s, int j){
        if(j == s.length() - 1){
            System.out.println(s);
            return;
        }
        for(int i = j; i<s.length(); i++){
            s = swap(s, i , j);
            printPermutations(s, j+1);
            s= swap(s, i , j);

        }
    }

    private static String swap(String s, int i, int j) {
        char [] charA = s.toCharArray();
        char temp = charA[i];
        charA[i] = charA[j];
        charA[j] = temp;

        return String.valueOf(charA);
    }


    public static void main(String[] args) {
           printPermutations("ABC", 0);
    }
}
