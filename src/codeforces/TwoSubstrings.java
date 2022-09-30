package codeforces;

import java.util.Scanner;


public class TwoSubstrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean flagAB = false;
        boolean flagBA = false;
        for(int i = 0; i < s.length() - 1; i++){
            if(!flagAB && s.charAt(i) == 'A' && s.charAt(i+1) == 'B'){
                flagAB = true;
                for(int j = i+2; j < s.length() - 1; j++){
                    if(s.charAt(j) == 'B' && s.charAt(j + 1) == 'A'){
                        System.out.println("YES");
                        return;
                    }
                }
            }

            if(!flagBA && s.charAt(i) == 'B' && s.charAt(i+1) == 'A'){
                flagBA = true;
                for(int j = i+2; j < s.length() - 1; j++){
                    if(s.charAt(j) == 'A' && s.charAt(j + 1) == 'B'){
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }
}


