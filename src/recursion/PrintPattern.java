/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package recursion;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: PrintPattern.java, v 0.1 2022-04-28 23:19 wb-ujjwalgup584692 Exp $$
 */
public class PrintPattern {

    /**
     *
     *
     * n = 4  ****
     *        ***
     *        **
     *        *
}    */

    // partially with loop and partially with recursion
    static void printPattern(int n){
        if(n == 0 )
            return;
        for(int i = 0; i<n; i++){
            System.out.print('*');
        }
        System.out.println();
        //print new row with recursion
        printPattern(n-1);
    }


    //complete with recursion
    static void printRecursivePattern(int n , int i){
        if(n == 0)
            return ;
        if(i<n){
            // print column
            System.out.print('*'); // self work
            printRecursivePattern(n, i+1);  // case based recusive assumption
        }else{
            // we will change the row
            System.out.println(); // self work
            printRecursivePattern(n-1, 0); // case based recusive assumption
        }

    }

    //complete with recursion
    static void printRecursivePatternReverse(int n , int i){
        if(n == 0)
            return ;
        if(i>=0 && i<n){
            // print column
            System.out.print('*'); // self work
            printRecursivePattern(i, i-1);  // case based recusive assumption
        }else{
            // we will change the row
            System.out.println(); // self work
            printRecursivePattern(n-1, 0); // case based recusive assumption
        }

    }



    public static void main(String[] args) {
        printPattern(4);

        System.out.println();

        printRecursivePattern(5, 0);
    }



}