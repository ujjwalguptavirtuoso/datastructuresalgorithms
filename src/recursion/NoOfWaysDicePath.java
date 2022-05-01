package recursion;

/**
 * ujjwal.gupta
 * @version $Id: NoOfWaysDicePath.java, v 0.1 2022-05-01
 */

/**
 * Given n cells arranged in a linear fashion. You are at 0th cell, you throw a dice and can jump acc to output of throw(1,2,3,4,5,6) from current cell to next cell.
 * Print all possible paths to reach n-1th cell.
 *
 * For example for an array of size 10, reach all possible paths to reach 9th index from 0th index following above strategy.
 */
public class NoOfWaysDicePath {

    static int  count = 0;
    static void printPathsForDiceThrow(int [] arr, int i, int n , String osf){
        //base case, if i exceeds target index
        if(i> n-1){
            return;
        }
        //base case, if i equals target index
        if(i==n-1){
            System.out.println(osf);
            count++;
            return;
        }
        //recursive assumption ==> i+1, i+2, ....... i+6.
        //self work ==> appending movement in output so far(eg. osf + "2", for 2 steps taken).

        // if dice output is 1
        printPathsForDiceThrow(arr, i + 1, n, osf + "1");
        // if dice output is 2
        printPathsForDiceThrow(arr, i + 2, n, osf + "2");
        // if dice output is 3
        printPathsForDiceThrow(arr, i + 3, n, osf + "3");
        // if dice output is 4
        printPathsForDiceThrow(arr, i + 4, n, osf + "4");
        // if dice output is 5
        printPathsForDiceThrow(arr, i + 5, n, osf + "5");
        // if dice output is 6
        printPathsForDiceThrow(arr, i + 6, n, osf + "6");

    }

    public static void main(String[] args) {

        int arr[] = new int[10];
        printPathsForDiceThrow(arr, 0, arr.length, "");
        System.out.println("Total Paths = " + count);
    }
}
