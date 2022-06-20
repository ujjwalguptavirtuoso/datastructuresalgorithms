package codeforces;

import java.util.Scanner;

public class Marathon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int count = 0;
             int a = sc.nextInt();
             int b = sc.nextInt();
             int c = sc.nextInt();
             int d = sc.nextInt();

             if(b>a) count++;
             if(c>a) count++;
             if(d>a) count++;
            System.out.println(count);
        }
    }
}
