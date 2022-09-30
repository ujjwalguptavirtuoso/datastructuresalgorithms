

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int caseNo = t + 1;
            int n = sc.nextInt();
            if(n == 1){
                System.out.println("Case #" + caseNo + ": " + 1);
            }else{
                n = n - 1;
                int val = n / 5 + 1;
                System.out.println("Case #" + caseNo + ": " + val);
            }
        }
    }
}
