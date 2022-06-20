

import java.util.Scanner;

public class SumOfOddIntegers {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             long n = sc.nextLong();
             long k = sc.nextLong();

             if(n%2 != k%2){
                 System.out.println("NO");
                 continue;
             }

             if(k * k > n){
                 System.out.println("NO");
             }else{
                 System.out.println("YES");
             }
        }
    }
}
