package backtracking;

import java.util.LinkedList;
import java.util.Queue;

class MyPair{
    int x;
    int y;
    int r;

    MyPair(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

public class ShortestPathInGridWithObstacles {

    static int bfs(int row, int col, int [][] grid, int k){
        Queue<MyPair> q = new LinkedList<>();
        q.offer(new MyPair(0, 0, k));
        grid[0][0] = 2;
        int steps = 0;

        int x_dir[] = {-1, 0, 0, 1};
        int y_dir[] = {0, -1, 1, 0};

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                MyPair mp = q.poll();
                int x = mp.x;
                int y = mp.y;
                int r = mp.r;
                if(x == grid.length - 1 && y== grid[0].length - 1){
                    return steps;
                }

                for(int j = 0; j < 4; j++){
                    if(isValid(x + x_dir[j], y + y_dir[j], grid)){
                        if(grid[x + x_dir[j]][y + y_dir[j]] == 1 && r > 0){
                            r--;
                            grid[x + x_dir[j]][y + y_dir[j]] = 2;
                            q.offer(new MyPair(x + x_dir[j], y + y_dir[j], r));
                        }else if(grid[x + x_dir[j]][y + y_dir[j]] == 0){
                            grid[x + x_dir[j]][y + y_dir[j]] = 2;
                            q.offer(new MyPair(x + x_dir[j], y + y_dir[j], r));
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }


    static boolean isValid(int row, int col, int [][] grid){
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] != 0); }


    public static int shortestPath(int[][] grid, int k) {
        return bfs(0, 0, grid, k);
    }

    public static void main(String[] args) {
        int grid[][] = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int k = 1;
        System.out.println(shortestPath(grid, k));
    }
}
