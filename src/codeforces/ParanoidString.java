

import java.util.Scanner;

public class ParanoidString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();
             String str = sc.next();
             char[] arr = str.toCharArray();
             long count = 0;
             for(int i = arr.length - 1; i >=1; i--){
                 if(arr[i] != arr[i-1]){
                     count += i + 1;
                 }else{
                     count++; // if equal also then that sole index will contribute to the answer
                 }
             }
             count++; // for one length string at index 0.
            System.out.println(count);
        }
    }
}
