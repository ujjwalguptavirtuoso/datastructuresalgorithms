

import java.util.Scanner;

public class Two01Sequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int a = sc.nextInt();
             int b = sc.nextInt();
             String s1 = sc.next();
             String s2 = sc.next();
             if(s2.length() > s1.length()){
                 System.out.println("NO");
             }else{
                 int k = s1.length() - 1;
                 int l = s2.length() - 1;
                 boolean notPossible = false;
                 while(l != 0){
                     if(s1.charAt(k) != s2.charAt(l)){
                         System.out.println("NO");
                         notPossible = true;
                         break;
                     }
                     k--;
                     l--;
                 }
                 if(notPossible) continue;
                 boolean printed = false;
                 while(k >=0){
                     if(s1.charAt(k) == s2.charAt(0)){
                         System.out.println("YES");
                         printed = true;
                         break;
                     }
                     k--;
                 }
                 if(!printed) System.out.println("NO");
             }
        }
    }
}
