

import java.util.Scanner;

public class WoefulPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int n = sc.nextInt();
           if(n %2 == 0){
               for(int i = 1; i <= n; i++){
                   if(i%2 == 1){
                       System.out.print(i + 1 + " ");
                   }else{
                       System.out.print(i - 1 + " ");
                   }
               }
           }else{
               System.out.print(1 + " ");
               for(int i = 2; i <=n; i++){
                   if(i%2 == 0){
                       System.out.print(i + 1 + " ");
                   }else{
                       System.out.print(i - 1 + " ");
                   }
               }
           }
            System.out.println();
        }
    }
}
