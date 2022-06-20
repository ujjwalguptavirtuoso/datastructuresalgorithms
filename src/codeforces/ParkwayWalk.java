

import java.util.Scanner;

public class ParkwayWalk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int sum = 0;
            for(int i= 0; i < n; i ++) {
                sum = sum + sc.nextInt();
            }
            if(sum -m < 0) {
                System.out.println(0);
            }else{
                System.out.println(sum - m);
            }
        }

    }
}
