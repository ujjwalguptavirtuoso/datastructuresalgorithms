

import java.util.Scanner;

public class ThirdThreeNumberProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n =sc.nextInt();
            if(n%2 == 1){
                System.out.println(-1);
            }else{
                System.out.println(n/2 + " " + n/2 + " " + "0");
            }
        }
    }
}
