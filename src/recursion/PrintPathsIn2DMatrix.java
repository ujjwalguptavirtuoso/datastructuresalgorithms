/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package recursion;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: PrintPathsIn2DMatrix.java, v 0.1 2022-05-01 01:57 wb-ujjwalgup584692 Exp $$
 */

/**
 * Given a n*m matrix, print all the paths from starting 0,0(top left) cell to n-1, m-1(bottom right)  cell, if it is only possible to go down , right or diaganolly
 */

public class PrintPathsIn2DMatrix {



    static int count = 0;

    static void  printPathsin2DMatrix(int [][] grid, int i, int j, String osf){
        // if i or j goes beyond m or n then we have to stop recursing
        if((i > grid.length - 1) || (j > grid[0].length - 1)){
            return;
        }
        // base case when we have found the destination
        if((i == grid.length - 1) && (j == grid[0].length - 1)){
            System.out.println(osf);
            count++;
            return;
        }

        printPathsin2DMatrix(grid, i + 1, j, osf + "DOWN" + " "); // finding all paths from one cell down recursively
        printPathsin2DMatrix(grid,  i, j + 1, osf + "RIGHT"+ " "); // finding all paths from one cell right recursively
        printPathsin2DMatrix(grid, i+1, j+1, osf + "DIA" + " "); // finding all paths from diagnol cell recursively
    }

    public static void main(String[] args) {
        int n = 3;
        int m =3;
        int[][] grid = new int[n][m];t 
        printPathsin2DMatrix(grid, 0, 0, "");
        System.out.println("Total Paths = " + count);
    }
}
