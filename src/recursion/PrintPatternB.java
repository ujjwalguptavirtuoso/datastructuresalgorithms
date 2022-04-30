package recursion;

/**
 * @author ujjwal.gupta
 * @version $Id: PrintPatternB.java, v 0.1 2022-05-01
 */
public class PrintPatternB {

    /**
     *
     *
     * n = 4  *
     *        **
     *        ***
     *        ****
     }    */

    static void printPattern(int n, int i){
        if(n == 0){
            return;
        }
        if(i>=0){
            System.out.print('*');
            printPattern(n, i-1);
        }else{
            System.out.println();
            printPattern(n-1, n - i+1);
        }

    }

    public static void main(String[] args) {

    }
}
