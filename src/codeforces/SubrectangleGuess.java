

import java.util.Scanner;

public class SubrectangleGuess {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int max = Integer.MIN_VALUE;
            int [][] matrix = new int[x][y];
            int max_i = 0;
            int max_j = 0;
            for(int i = 0; i <x; i ++){
                for(int j = 0; j<y; j++){
                    matrix[i][j] = sc.nextInt();
                   if(matrix[i][j] > max){
                       max = matrix[i][j];
                       max_i = i;
                       max_j = j;
                   }
                }
            }
            int h = Math.max(Math.abs(max_i - 0) + 1, Math.abs(max_i - x));
            int w = Math.max(Math.abs(max_j - 0) + 1, Math.abs(max_j - y));
            System.out.println(h * w);
        }
    }
}
