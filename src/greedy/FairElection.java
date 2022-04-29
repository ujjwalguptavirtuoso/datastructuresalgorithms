package greedy;

import java.util.*;

/**
 * @author ujjwal.gupta
 * @version $Id: FairElection.java, v 0.1 2022-04-29
 */
public class FairElection {


    static int noOfSwaps(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        Arrays.sort(a);
        Arrays.sort(b);
        //  Collections.reverse(b);
        int[] reverseB = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            reverseB[i] = b[b.length - i - 1];
        }
        int j = 0;
        int count = 0;
        while (j < m && j < n) {
            if (getSum(a) > getSum(reverseB)) {
                return count;
            }
            int temp = reverseB[j];
            reverseB[j] = a[j];
            a[j] = temp;
            j++;
            count++;
        }
        return getSum(a) > getSum(reverseB) ? count : -1 ;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> totalArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //int arrayA[] = new int [a];
            //int arrayB[] = new int [b];
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                int c = sc.nextInt();
                listA.add(j, c);
            }
            for (int k = 0; k < b; k++) {
                int d = sc.nextInt();
                listB.add(k, d);

            }
            totalArr.add(listA);
            totalArr.add(listB);
        }
        for (int i = 0; i < totalArr.size(); i += 2) {
            System.out.println(noOfSwaps(getPrimitiveArray(totalArr.get(i)), getPrimitiveArray(totalArr.get(i + 1))));
        }

    }

    static int[] getPrimitiveArray(List<Integer> arr) {
        int[] newArr = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            newArr[i] = arr.get(i);
        }
        return newArr;
    }

    static int getSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

}