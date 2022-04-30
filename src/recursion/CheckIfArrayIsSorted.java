package recursion;

/**
 * ujjwal.gupta
 * @version $Id: CheckIfArrayIsSorted.java, v 0.1 2022-05-01
 */
public class CheckIfArrayIsSorted {

    static boolean ifSorted( int[] arr ,int start, int end){

        if (start == end) {
            return true;
        }
        boolean isSorted = ifSorted(arr, start + 1, end);
        if (!isSorted) {
            return false;
        } else {
            return arr[start] < arr[start + 1];
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 7, 9};
        System.out.println(ifSorted(arr, 0, arr.length - 1));
    }
}
