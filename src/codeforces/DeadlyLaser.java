

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeadlyLaser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
             int n = sc.nextInt();
             int m = sc.nextInt();
             int sx = sc.nextInt();
             int sy = sc.nextInt();
             int d = sc.nextInt();

             if(Math.abs(n - sx) + Math.abs(m-sy) <= d){
                 System.out.println(-1);
                 continue;
             }

             int matrix[][] = new int[n + 1][m + 1];
             boolean visited[][] = new boolean[n + 1][m + 1];
             Queue<MyPair> q = new LinkedList<>();
             int ans = -1;
             int x_dir[] = {-1, 0, 0, 1};
             int y_dir[] = {0, -1, 1, 0};
             q.offer(new MyPair(1, 1));
             visited[1][1] = true;
             int steps = 0;
             boolean breakFlag = false;
             while(!q.isEmpty()){
                 int qSize = q.size();
                 for(int i = 0; i < qSize; i++){
                     MyPair mp = q.poll();
                     int x = mp.x;
                     int y = mp.y;
                     if(x == n && y == m){
                         ans = steps;
                         breakFlag = true;
                         break;
                     }
                     for(int k = 0; k < 4; k++){
                         if(isValid(visited, x + x_dir[k], y + y_dir[k], matrix)){
                             if(Math.abs(x + x_dir[k] - sx) + Math.abs(y + y_dir[k] - sy) > d){ // laser condition
                                 q.offer(new MyPair(x + x_dir[k], y + y_dir[k]));
                                 visited[x + x_dir[k]][y + y_dir[k]] = true;
                             }
                         }
                     }
                 }
                 steps++;
                 if(breakFlag){
                     break;
                 }
             }
            System.out.println(ans);
        }
    }

    static boolean isValid(boolean [][] visited, int row, int col, int [][] matrix){
        return (row > 0 && col > 0 && row < matrix.length && col < matrix[0].length && !visited[row][col]);
    }
}

class MyPair{
    int x;
    int y;

    MyPair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
