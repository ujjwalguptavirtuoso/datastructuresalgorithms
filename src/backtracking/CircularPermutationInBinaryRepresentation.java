package backtracking;
import java.util.*;

/**
 * ujjwal.gupta
 *
 * @version $Id: CircularPermutationInBinaryRepresentation.java, v 0.1 2022-05-07
 */
public class CircularPermutationInBinaryRepresentation {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        String binaryStartString = makeValidStartString(n, start);
        char[] charArrayStartString = binaryStartString.toCharArray();
        permutations(ans, charArrayStartString, n, 0);
        return ans;
    }

    void permutations(List<Integer> ans, char[] charArrayStartString , int n, int j){
        if(j == n){
            int num = Integer.parseInt(String.valueOf(charArrayStartString), 2);
            ans.add(num);
            return;
        }


        //not flipping scenario
        permutations(ans, charArrayStartString, n, j+1);

        // every bit has two options either to flip or not to flip
        // this step flipping it and taking it recursively ahead.
        //and then backtracking
        flip(charArrayStartString, j, n);
        permutations(ans, charArrayStartString, n, j+1);
        flip(charArrayStartString, j, n);

    }

    void flip(char[] arr, int i, int n){
        if(i< n && arr[i] == '0'){
            arr[i] = '1';
            return ;}
         if(i< n && arr[i] == '1'){
            arr[i] = '0';
            return;}

    }


    String makeValidStartString(int n, int start){
        String binaryStringOfStart = Integer.toBinaryString(start);
        if(binaryStringOfStart.length() == n)
            return binaryStringOfStart;

        int diff =  n - binaryStringOfStart.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<diff; i++){
            sb.append("0");
        }
        return sb.toString() + binaryStringOfStart;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        CircularPermutationInBinaryRepresentation obj = new CircularPermutationInBinaryRepresentation();
        List<Integer> ans = obj.circularPermutation(n, start);
        System.out.print(ans.toString());
    }


}
