package backtracking;

/**
 * ujjwal.gupta
 * @version $Id: RatInAMaze.java, v 0.1 2022-05-03
 */
public class RatInAMaze {


   static void printAllPaths(int [][] maze, boolean[][] visited, int i, int j , String osf){
       if(i<0 || i >= maze.length || j < 0 || j >= maze[0].length){
           return;
       }

        //base case
       if(i == maze.length-1 && j ==maze[0].length- 1){
            System.out.println(osf);
            return;
        }

        visited[i][j] = true;


        if(i+1 < maze.length && isValidNextStep(maze, visited, i+1, j)){
            int newi = i+1;
            printAllPaths(maze, visited, i+1, j, osf + ",[" +newi+ ","+ j + "]");
        }

        if(i-1 >= 0 && isValidNextStep(maze, visited, i-1, j)){
            int newi = i-1;
            printAllPaths(maze, visited, i-1, j, osf + ",[" +newi + ","+ j + "]");
        }

        if(j+1 < maze[0].length && isValidNextStep(maze, visited, i, j+1)){
            int newj = j + 1;
            printAllPaths(maze, visited, i, j+1, osf + ",[" +i + "," + newj + "]");
        }

        if(j-1 >= 0 && isValidNextStep(maze, visited, i, j-1)){
            int newj = j-1;
            printAllPaths(maze, visited, i, j-1, osf + ",[" +i + "," + newj + "]");
        }

       visited[i][j] = false;


    }


    static boolean isValidNextStep(int[][] maze, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length) {
            if (maze[i][j] != -1 && !visited[i][j]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int maze[][] = {  {0, 0 ,0 ,-1},
                          {0, 0, 0, -1},
                          {0, -1,0 ,0},
                          {0, -1, 0, 0}  };
        boolean[][] visited= new boolean[maze.length][maze[0].length];

        printAllPaths(maze, visited, 0, 0, "");

    }
}
