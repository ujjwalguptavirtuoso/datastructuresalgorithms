package codeforces;

import java.util.Scanner;

public class BitmasCirno {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int num = sc.nextInt();
            int copyOfNum = num;
            int rightposition = 1;
            int m = 1;

            if(num == 1){
                System.out.println(3);
                continue;
            }

            while ((num & m) == 0) {

                // left shift
                m = m << 1;
                rightposition++;
            }

            int leftPos = 0;

            while (copyOfNum > 0) {
                copyOfNum = copyOfNum >> 1;
                leftPos++;
            }
            if(leftPos > rightposition){
                System.out.println((int)Math.pow(2, rightposition -1 ));
        }else{
                System.out.println((int)Math.pow(2, rightposition - 1) + 1);
            }
        }
    }
}

