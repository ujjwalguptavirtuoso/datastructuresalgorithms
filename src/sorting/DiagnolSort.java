package sorting;
import java.util.*;
/**
 * ujjwal.gupta
 *
 * @version $Id: DiagnolSort.java, v 0.1 2022-05-13
 */
public class DiagnolSort {

    public static int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        // sorting all the upper half diagnols
        for(int j = cols - 1; j >=0; j--){
            int i=0;
            int k = j;
            int numOfElementsInList = 0;
            List<Integer> list = new ArrayList<>();
            while(i < rows &&  k < cols){
                list.add(mat[i][k]);
                i++;
                k++;
                numOfElementsInList++;
            }
            Collections.sort(list);
            i = 0; k = j;
            int l = 0;
            while(i < rows && k < cols && l< numOfElementsInList){
                mat[i][k] = list.get(l);
                i++;
                k++;
                l++;
            }
        }


        for(int i = 1; i <rows; i++){
            int j = 0;
            int k = i;
            int numOfElementsInList = 0;
            List<Integer> list = new ArrayList<>();
            while(k < rows && j < cols){
                list.add(mat[k][j]);
                j++;
                k++;
                numOfElementsInList++;
            }
            Collections.sort(list);
            j = 0; k = i;
            int l = 0;
            while(k < rows && j < cols && l < numOfElementsInList){
                mat[k][j] = list.get(l);
                j++;
                k++;
                l++;
            }
        }

        return mat;

    }

    public static void main(String[] args) {
        int [][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        int [] [] result = diagonalSort(mat);
        for(int i = 0 ; i < result.length; i++){
        System.out.println(result[i]);
        }
    }
}
