

import java.util.Scanner;

public class MathematicalCircus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(k% 2 == 1){
                System.out.println("YES");
                 for(int i = 1; i <= n - 1; i+=2){
                     int val = i+1;
                    System.out.println(i + " " + val);
                 }
             }else if(k % 4 == 0){
                System.out.println("NO");
            }else if(k % 2 == 0 && k% 4!= 0){
                System.out.println("YES");
                for(int i = 2; i<= n; i+=2){
                    int val = i -1;
                    if(i%4 == 0){
                        System.out.println(val + " " + i);
                    }else{
                        System.out.println(i + " " + val);
                    }
                }
            }
        }
    }
}
