package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Promo {

    static List<Integer> kLargest = new ArrayList<>();

    static int findRandomPivot(int arr[], int start, int end)
    {
        int n = end - start + 1;
        // Selecting the random pivot index
        int pivotInd = (int) ((Math.random()*1000000)%n);
        int temp = arr[end];
        arr[end] = arr[start+pivotInd];
        arr[start+pivotInd] = temp;
        int pivot = arr[end];
        //initialising pivoting point to start index
        pivotInd = start;
        for (int i = start; i < end; i++) {

            // If an element is lesser than pivot, swap it.
            if (arr[i] <= pivot) {
                int temp1 = arr[i];
                arr[i]= arr[pivotInd];
                arr[pivotInd] = temp1;

                // Incrementing pivotIndex for further
                // swapping.
                pivotInd++;
            }
        }

        // Lastly swapping or the
        // correct position of pivot
        int tep = arr[pivotInd];
        arr[pivotInd] =  arr[end];
        arr[end] = tep;
        return pivotInd;
    }

    static void SmallestLargest(int a[], int low, int high, int k,
                                int n)
    {
        if (low == high)
            return;
        else {
            int pivotIndex = findRandomPivot(a, low, high);

            if (k == pivotIndex) {
                for (int i = (n - pivotIndex); i < n; i++)
                    kLargest.add(a[i]);
            }

            else if (k < pivotIndex)
                SmallestLargest(a, low, pivotIndex - 1, k, n);

            else if (k > pivotIndex)
                SmallestLargest(a, pivotIndex + 1, high, k, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int prices[] = new int[n];
        for(int i= 0;i < n; i ++) {
            prices[i] = sc.nextInt();
        }
       // Arrays.sort(prices);
        for(int i = 0; i < q; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            kLargest.clear();
            SmallestLargest(prices, 0, n-1, x, n);
            /* PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int price : prices){
                pq.offer(price);
                if(pq.size() > x){
                    pq.poll();
                }
            }*/
          /*  int startIndex = n - x;
            int endIndex = n- x + y;
            int sum = 0;
            for(int j = startIndex; j < endIndex; j++){
                sum = sum + prices[j];
            }*/
            int sum = 0;
            for(int j = kLargest.size() - 1; j > kLargest.size() - y; j--){
                sum = sum + kLargest.get(j);
            }


           /* while(y > 0){
                sum = sum + pq.poll();
                y--;
            }*/
            System.out.println(sum);
        }
    }
}
