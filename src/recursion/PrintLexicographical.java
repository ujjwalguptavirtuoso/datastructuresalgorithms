package recursion;

/**
 * ujjwal.gupta
 * @version $Id: PrintLexicographical.java, v 0.1 2022-05-02
 *
 * Given a number n, print all whole numbers from 0 to n in lexicograhical manner.
 * A - 0
 * B - 1
 * C - 2
 * D - 3
 * E - 4
 * F - 5
 * G - 6
 * H - 7
 * I - 8
 * J - 9
 * Lets say n = 1000
 * print like in dictionary eg, A- 0, AA - 00 (not valid as 0 = 00 ) , B - 1 , BA - 10 , BAA - 100, BAAA - 1000 , BAB - 101 , BAC - 102 ....
 */
public class PrintLexicographical {

    //APPROACH 1 : with osf

    static void printLexicographically(int n ,  String osf){
        //base case
        if(Integer.valueOf(osf) > n){
            return;
        }
        // self work
        if(Integer.valueOf(osf) <= n) {
            System.out.println(osf + ", ");
        }
        //recursive assumption
        for(int i = Integer.valueOf(osf) == 0 ? 1 : 0 ; i<10; i++){ // --> IMPORTANT i is starting from 1 if osf value = 0 , else starting from 0 to print numbers like 10, 20, 100, 1000
            printLexicographically(n, osf + i);
        }
    }


    //APPROACH 2 : with  i and j --> Very cool approach

    static void printLexico( int n, int i){
        if(i>n){
            return;
        }
        System.out.println(i);
        for(int j = i == 0 ? 1 : 0 ; j < 10; j++){
            printLexico(n, 10*i + j);
        }
    }



    public static void main(String[] args) {
       int n = 100;
       printLexicographically(n, "0");

       printLexico(100, 0);
    }
}
