package codeforces;

import java.util.Scanner;

public class AA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while(a > 0

                    && b>0){
                sb.append('0');
                a--;
                sb.append('1');
                b--;
            }

            while(a>0){
                sb.append('0');
                a--;
            }
            while (b>0){
                sb.append('1');
                b--;
            }
            System.out.println(sb.toString());
        }
    }
}
