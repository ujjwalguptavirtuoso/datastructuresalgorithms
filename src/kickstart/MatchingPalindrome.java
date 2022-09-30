package kickstart;

import java.util.Scanner;
import java.util.*;

public class MatchingPalindrome {


    static boolean isPalindrome(String s, int i  ,int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int caseNo = t + 1;
            int n = sc.nextInt();
            String s = sc.next();
            int startIndex = -1;
            int endIndex = -1;
            for(int i = 1; i < s.length(); i++){
                if(isPalindrome(s, i, s.length() - 1)){
                    //endIndex = s.length() - 1;
                    if(isPalindrome(s, 0, i - 1)){
                        endIndex = i-1;
                        startIndex = 0;
                        break;
                    }

                }
            }
           /* TreeSet<Integer> set = new TreeSet<>();
             int num =  set.ceiling(1);*/
            Observer observer;

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            if(s.length() == 1){
                sb.append(s.charAt(0));
            }
            else if(startIndex != -1){
                String temp = s.substring(0, endIndex + 1);
                sb.append(temp);
            }else if(startIndex == -1){
                sb.append(s);
            }
            System.out.println("Case #" + caseNo + ": " + sb.toString());
        }
    }
}
