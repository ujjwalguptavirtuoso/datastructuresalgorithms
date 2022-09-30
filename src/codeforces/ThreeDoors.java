

import java.util.Scanner;

public class ThreeDoors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();
             int a = sc.nextInt();
             int b = sc.nextInt();
             int c = sc.nextInt();

             if(n == 1){
                 if( (a == 3 && c == 2) || (a == 2 && b == 3)){
                     System.out.println("YES");
                 }else{
                     System.out.println("NO");
                 }
             }else if(n == 2){
                  if( (b == 1 && a == 3) || (b == 3 && c == 1)){
                     System.out.println("YES");
                 }else{
                     System.out.println("NO");
                 }
             }else if(n == 3){
                 if( (c == 1 && a == 2) || (c == 2 && b == 1)){
                     System.out.println("YES");
                 }else{
                     System.out.println("NO");
                 }
             }
        }
    }
}
