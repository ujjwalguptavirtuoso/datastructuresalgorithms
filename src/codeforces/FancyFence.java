package codeforces;

import java.util.Scanner;

public class FancyFence {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
           int x = sc.nextInt();
           if(x >=60 && (360 % (180 - x)) == 0){
               System.out.println("YES");
           }else{
               System.out.println("NO");
           }
        }
    }
}
