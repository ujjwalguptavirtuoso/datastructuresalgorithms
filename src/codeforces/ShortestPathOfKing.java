package codeforces;

import java.util.*;

class QueueNode{
    int xcor;
    int ycor;
    String direction;
    int steps;

    QueueNode(int x, int y, String dir, int steps){
        this.direction = dir;
        this.xcor = x;
        this.ycor = y;
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "xcor=" + xcor +
                ", ycor=" + ycor +
                ", direction='" + direction + '\'' +
                ", steps=" + steps +
                '}';
    }
}
class DirTrip{
    int xdir;
    int ydir;
    String dir;

    public DirTrip(int xdir, int ydir, String dir) {
        this.xdir = xdir;
        this.ydir = ydir;
        this.dir = dir;
    }
}

public class ShortestPathOfKing {


   static  List<DirTrip> generateDirTriplet(){
        List<DirTrip> dirTripList = new ArrayList<>();
        dirTripList.add(new DirTrip(-1, 0, "L"));
        dirTripList.add(new DirTrip(1, 0, "R"));
        dirTripList.add(new DirTrip(0, 1, "U"));
        dirTripList.add(new DirTrip(0, -1, "D"));
        dirTripList.add(new DirTrip(1, 1, "RD"));
        dirTripList.add(new DirTrip(-1, -1, "LU"));
        dirTripList.add(new DirTrip(1, -1, "RU"));
        dirTripList.add(new DirTrip(-1, 1, "LD"));

        return dirTripList;

    }

    static List<QueueNode> bfs(int sourceRow, int sourceCol, int destRow, int destCol, boolean[][] visited){
        Queue<QueueNode> q = new LinkedList<>();
        visited[sourceRow][sourceCol] = true;
        List<DirTrip> dirTripList = generateDirTriplet();
        q.offer(new QueueNode(sourceRow, sourceCol, "NA", 0));
        List<QueueNode> queueNodes = new ArrayList<>();


        while(!q.isEmpty()){
            QueueNode qPoll = q.poll();
            int x = qPoll.xcor;
            int y = qPoll.ycor;
            int steps = qPoll.steps;
            if(x == destRow && y == destCol){
                  break;
            }

            for(int k =0; k < dirTripList.size() ; k++){
                int currStep = steps + 1;
                DirTrip dirTrip = dirTripList.get(k);
                if(safeToMove(x + dirTrip.xdir , y + dirTrip.ydir, visited)){
                       visited[x + dirTrip.xdir][y + dirTrip.ydir] = true;
                       q.offer(new QueueNode(x + dirTrip.xdir, y + dirTrip.ydir, dirTrip.dir, currStep));
                       queueNodes.add(new QueueNode(x + dirTrip.xdir, y + dirTrip.ydir, dirTrip.dir, currStep));
                }
            }
        }
        return queueNodes;
    }

    static boolean safeToMove(int row, int col, boolean [][]visited){
       return (row>= 0 && row < 8 && col >=0 && col < 8 && !visited[row][col]);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int sourceRow = 8 - Character.getNumericValue(str1.charAt(1));
        int sourceCol = (int)(str1.charAt(0) - 'a');

        int destRow =  8 - Character.getNumericValue(str2.charAt(1));
        int destCol = (int)(str2.charAt(0) - 'a');

        /**
         * main working code
         */
        int steps = Math.max(Math.abs(sourceRow - destRow), Math.abs(sourceCol-destCol));
        System.out.println(steps);
        while(sourceRow!=destRow || sourceCol!=destCol){
            if(sourceCol < destCol){
                System.out.print("R");
                sourceCol++;
            }else if(sourceCol > destCol){
                System.out.print("L");
                sourceCol--;
            }
            if(sourceRow < destRow){
                System.out.print("D");
                sourceRow++;
            }else if(sourceRow > destRow){
                System.out.print("U");
                sourceRow--;
            }
            System.out.println();
        }

        /*System.out.println(sourceRow + " " + sourceCol + " " + destRow + " " + destCol);

        boolean[][] visited = new boolean[8][8];

        List<QueueNode> list = bfs(sourceRow, sourceCol, destRow, destCol, visited);
        for(QueueNode q : list){
            System.out.println(q.toString());
        }*/


    }
}
