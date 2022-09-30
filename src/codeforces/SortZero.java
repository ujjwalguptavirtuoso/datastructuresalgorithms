

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SortZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0 ; i < arr.length; i++){
                arr[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            int ops = 0;
            int lastIndex = -1;
            for(int i = arr.length - 2; i >=0 ; i--){
                if(arr[i] > arr[i + 1] ){
                    lastIndex = i;
                    break;
               }
            }
            if(lastIndex == -1){
                    System.out.println(0);
                    continue;
                }
            for(int i = 0 ; i <= lastIndex; i++){
                set.add(arr[i]);
            }
            for(int i = lastIndex + 1; i< arr.length; i++){
                if(set.contains(arr[i])){
                    lastIndex = i;
                }
            }

            for(int i = lastIndex; i>=0; i--){
                if(!set.contains(arr[i])){
                    set.add(arr[i]);
                }
            }

            System.out.println(set.size());
        }
    }
}
