/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package recursion;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: PrintNumbers.java, v 0.1 2022-04-28 15:51 wb-ujjwalgup584692 Exp $$
 */
public class PrintNumbers {

    static void print(int n){
        if(n == 1){
            System.out.println(n);
            return;}
        System.out.println(n);
        print(n-1);
        System.out.println(n);
        return;
    }

    public static void main(String[] args) {
        int n = 5;
        print(5);
    }
}
