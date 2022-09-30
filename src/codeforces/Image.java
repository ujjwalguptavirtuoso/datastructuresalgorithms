package codeforces;

import java.util.Scanner;


public class Image {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              String str1 = sc.next();
              char a = str1.charAt(0);
              char b = str1.charAt(1);

              String str2 = sc.next();
              char c = str2.charAt(0);
              char d = str2.charAt(1);

              if(a == b && b == c && c ==d){
                  System.out.println(0);
                  continue;
              }
              if( (a==b && b == c) || (a==c && c==d) || (a==b && b==d) || (b == c && c ==d)){
                  System.out.println(1);
                  continue;
              }
              if( (a== b && c==d) || (a==c && b==d) || (a==d && b ==c)){
                  System.out.println(1);
                  continue;
              }
              if(a== b || b==c || c==d || a==c || a==d || d == b){
                  System.out.println(2);
                  continue;
              }
              System.out.println(3);


        }
    }
}
