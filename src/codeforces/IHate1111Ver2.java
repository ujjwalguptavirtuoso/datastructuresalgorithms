

import java.util.Scanner;

public class IHate1111Ver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
         for(int t = 0; t < test; t++){
             long n = sc.nextLong();
             boolean flag = false;
             while(n > 0){
                 if(n % 11 == 0 || n%111 == 0){
                     System.out.println("YES");
                     flag = true;
                     break;
                 }
                 n = n-111;
             }
             if(!flag) {
                 System.out.println("NO");
             }
         }
    }
}
