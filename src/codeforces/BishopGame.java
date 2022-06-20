package codeforces;
import java.util.Scanner;

public class BishopGame {


   static  boolean checkAdjacent(int i, int j, char[][] grid){
        return (grid[i-1][j-1] == '#' && grid[i-1][j+1] == '#' && grid[i +1][j-1] == '#' && grid[i+1][j+1] == '#');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            char[][] grid = new char[9][9];
            for(int i = 0; i < 8; i ++){
                String s = sc.next();
                char[] arr = s.toCharArray();
                for(int j = 0; j < 8; j++){
                    grid[i+1][j +1] = arr[j];
                }
            }

            boolean flag = false;
            for(int i = 2; i < 8; i++){
                for(int j = 2; j < 8; j++){
                    if(grid[i][j] == '#'){
                        if(checkAdjacent(i, j, grid)){
                            flag = true;
                            System.out.println(i + " " + j);
                            break;
                        }
                    }
                }
                if(flag){
                    break;
                }
            }
        }
    }
}
