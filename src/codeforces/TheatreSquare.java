package  codeforces;
import java.util.Scanner;

public class TheatreSquare {

    static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
              int m = sc.nextInt();
              int a = sc.nextInt();


        if (n <= a && m <= a) {
            System.out.println(1);
        } else if (n <= a && m > a) {
            long tiles = 0;
            if (m % a == 0) {
                tiles += m / a;
            } else {
                tiles += m / a + 1;
            }
            System.out.println(tiles);
        } else if (n > a && m <= a) {
            long tiles = 0;
            if (n % a == 0) {
                tiles += n / a;
            } else {
                tiles += n / a + 1;
            }
            System.out.println(tiles);
        } else {
            long totalTiles = 1;
            if (n % a == 0) {
                totalTiles *= n / a;
            } else {
                totalTiles *= (n / a + 1);
            }

            if (m % a == 0) {
                totalTiles *= m / a;
            } else {
                totalTiles *= (m / a + 1);
            }

            System.out.println(totalTiles);
        }

    }

}
