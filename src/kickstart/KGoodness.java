

import java.util.Scanner;

public class KGoodness {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
              int n = sc.nextInt();
              int k = sc.nextInt();
              String s = sc.next();
              int currentGoodness = 0;
              for(int i = 1; i <= n/2; i++){
                  if(s.charAt(i - 1) != s.charAt(n - i)){
                      currentGoodness +=1;
                  }
              }
              int stepsNeeded = Math.max(0, k - currentGoodness);
              int caseId = t + 1;
              System.out.println("Case #" + caseId + ": " + stepsNeeded);
        }
    }
}
