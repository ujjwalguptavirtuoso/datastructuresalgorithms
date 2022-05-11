package backtracking;

/**
 * ujjwal.gupta
 *
 * @version $Id: SudokuSolver.java, v 0.1 2022-05-11
 */
public class SudokuSolver {

    // we are creating auxillary array for storing whether we have placed an element in row
    // will create and auxillary array for storing whether we have placed an element in col
    // we will create an auxillary array for storing whether we have placed an element in box

    int row_aux[][] = new int [9][10];
    int col_aux[][] = new int [9][10];
    int box_aux[][] = new int [9][10]; // 10 for 1 based indexing

    boolean isSodokuSolved = false;

  //  int[][] board = new int [9][9];

  //  char[][] board = new char[9][9];




    void helper(char[][] board , int row, int col){
        if(board[row][col] == '.') {
        for(int d = 1 ; d <=9 ; d++){
               if(isValidPlacement(d, row, col)){
                   addDigit(board, d, row, col);
                   if(row == 8 && col == 8){
                       isSodokuSolved = true;
                   }else{
                       if(col == 8){
                           helper(board, row+1, 0);
                       }else{
                           helper(board ,row, col+1);
                       }
                   }
                   if(!isSodokuSolved) removeDigit(board, d, row, col);
               }
          }
        }else{
            if(row == 8 && col == 8){
                isSodokuSolved = true;
            }else{
                if(col>8){
                    helper(board,row+1, 0);
                }else{
                    helper(board, row, col+1);
                }
            }
        }
    }


    void addDigit(char[][] board ,int d, int row, int col){
        int i = ( row / 3 ) * 3 + col/3 ; // 3R + C
        row_aux[row][d] = 1;
        col_aux[col][d] = 1;
        box_aux[i][d] = 1;
        board[row][col] = (char)('0' + d);
    }

    void removeDigit(char[][] board ,int d, int row, int col){
        int i = ( row / 3 ) * 3 + col/3 ; // 3R + C
        row_aux[row][d] = 0;
        col_aux[col][d] = 0;
        box_aux[i][d] = 0;
        board[row][col] = '.';
    }

    boolean isValidPlacement(int digit, int row, int col){

        int i = ( row / 3 ) * 3 + col/3 ; // 3R + C
        return row_aux[row][digit] + col_aux[col][digit] + box_aux[i][digit] == 0 ;

    }


    public static void main(String[] args) {

    }
}
