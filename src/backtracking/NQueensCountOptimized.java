/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package backtracking;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: NQueensCountOptimized.java, v 0.1 2022-05-05 19:23 wb-ujjwalgup584692 Exp $$
 */
// Given n*n board, find and display number of ways to place n non attacking Queens on the board
public class NQueensCountOptimized {




    static int totalCount = 0;
    BitSet column = new BitSet(100);
    BitSet left_dia = new BitSet(100);
    BitSet right_dia = new BitSet(100);


    void countNQueens(int n, int curr_row){

        if(curr_row == n){
            totalCount++;
            return;
        }

        for(int i=0; i<n; i++){
            if(!column.get(i) && !right_dia.get(i+curr_row) && !left_dia.get(curr_row - i +  (n - 1))){
                column.set(i, true);
                right_dia.set(i+curr_row, true);
                left_dia.set(curr_row - i + (n - 1), true);
                countNQueens(n, curr_row  + 1);
                column.set(i, false);
                right_dia.set(i+curr_row, false);
                left_dia.set(curr_row - i + (n - 1), false);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        NQueensCountOptimized obj = new NQueensCountOptimized();

        obj.countNQueens(n, 0);

        System.out.print(totalCount);

    }

}
