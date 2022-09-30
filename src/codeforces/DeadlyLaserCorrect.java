package codeforces;

import java.util.Scanner;

public class DeadlyLaserCorrect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t<test;t++)

        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int d = sc.nextInt();
            //case I : diagnolly blocked the source
            if(sx - d <= 1 && sy - d <= 1){
                System.out.println(-1);
                continue;
            }
            //case 2 : diagnonally blocked the destination
            if(sx + d >=n && sy + d >= m){
                System.out.println(-1);
                continue;
            }
            //case 3 : horizontally blocked
            if(sx - d <= 1 && sx + d >= n){
                System.out.println(-1);
                continue;
            }
            //case 4 : vertically blocked
            if(sy- d <= 1 && sy + d >= m){
                System.out.println(-1);
                continue;
            }
            //possible scenario
            System.out.println(n + m - 2);
        }
    }
}

