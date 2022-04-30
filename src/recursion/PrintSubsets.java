package recursion;

/**
 * @author ujjwal.gupta
 * @version $Id: PrintSubsets.java, v 0.1 2022-05-01 01:03
 */
public class PrintSubsets {

    static void printSubset(int [] arr, int n, int i, String osf){
        // base case
        if(i == n){
            System.out.println("["+ osf + "]");
            return;
        }
        // when we chose a element to be included
        printSubset(arr, n , i + 1, osf + String.valueOf(arr[i]));

        //when we choose an element to not be included
        printSubset(arr, n, i+1, osf);

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubset(arr, arr.length, 0, "");
    }
}
